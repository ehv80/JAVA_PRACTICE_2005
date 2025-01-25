/* 
 * Este objeto será el encargado de administrar las peticiones
 * que lleguen al servidor a través de un vector del paquete java.util
 */
/* 
 * Comentado para evitar errores en tiempo de ejecución
 * paquete y clase no encontrados
 */
//package chat;

import java.net.*;
import java.io.*;
import java.util.*;

/*
 * Note que la clase hereda de Threads, es decir que será
 * implementada como un hilo
 */
public class ManejarPeticiones extends Thread
{
    /*
     * Definimos un socket y los buffers de entrada y salida para
     * la comunicación 
     */
    protected Socket socket = null;
    protected DataInputStream entrada = null;
    protected DataOutputStream salida = null;

    /* Creamos el Vector para administrar las peticiones,
     * éste será static ya que queremos un solo vector con
     * todos los clientes
     */
    protected static Vector vManejadores = new Vector();

    /* 
     * El constructor recibe el socket de cliente que pidió conexión
     */
    public ManejarPeticiones(Socket socket) throws IOException 
    {
        /*
         * A través del socket creamos los buffer de entrada y salida 
         */
        this.socket = socket;
        entrada = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        salida = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
    }
    /*
     * El método que sobreescribe toString mostrará la dirección de I.P. del cliente
     * y el nombre del host 
     */
    public String toString()
    {
        if(socket!=null)
        {
            return (socket.getInetAddress().getHostAddress() + " - " + socket.getInetAddress().getHostName());
        }
        return ("No se pudo obtener información del cliente...");
    }

    /*
     * El método broadcast lo usaremos para enviar mensajes a TODOS los clientes
     */
    protected static void broadcast(String message)
    {
        synchronized(vManejadores)
        {
            /* Recorremos el vector de clientes */
            Enumeration e = vManejadores.elements();
            while(e.hasMoreElements())
            {
                /* Tomamos de a un cliente */
                ManejarPeticiones c = (ManejarPeticiones) e.nextElement();
                try
                {
                    synchronized(c.salida)
                    {
                        /* y le enviamos el mensaje */
                        c.salida.writeUTF(message);
                    }
                    c.salida.flush();
                }
                catch(IOException ex)
                {
                    System.err.println("Error al enviar el mensaje al cliente...!");
                    System.err.println("Detalles del error: " + ex.getMessage());
                    System.err.println("Detalles de la pila de llamadas: ");
                    ex.printStackTrace();
                }
            }
        }
    }
    /* Método run */
    public void run()
    {
        /* Tomamos el nombre del cliente */
        String nombre = socket.getInetAddress().toString();
        try
        {
            /* Le comunicamos al resto de los clientes que el usuario 
             * se unió al grupo 
             */
            broadcast("\n" + nombre + " se unió al grupo.");
            vManejadores.addElement(this);
            /* Una vez agregado al Vector en al ciclo */
            while(true)
            {
                String msg = entrada.readUTF();
                broadcast(nombre + " : " + msg);
            }
        }
        catch(IOException ex)
        {
            /* En caso de haber un error sacamos al cliente
             * del Vector e informamos al resto que se retiró del grupo 
             */
            vManejadores.removeElement(this);
            broadcast("\n" + nombre + " se retiró del grupo.");
            /* Finalmente cerramos el socket */
            try 
            {
                socket.close();
            }
            catch(IOException exc)
            {
                exc.printStackTrace();
            }
        }
    }
}