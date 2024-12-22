/*
 * Ahora vamos a escribir el código del cliente. En este punto hay que recordar que es fundamental
 * que el puerto sea conocido por el cliente, de lo contrario, no se va a lograr la conexión.
 */

import java.io.*;
import java.net.*;

public class Cliente {
    InputStreamReader isr;
    OutputStreamWriter osw;

    /* Métodos de la Clase Cliente */
    public void mensaje(String s) throws IOException {
        System.out.println("Cliente dijo: " + s);
        /*
         * Escribimos el mensaje en el canal de salida
         */
        osw.write(s);
        osw.flush();
    }

    public String respuesta() throws IOException {
        /*
         * Creamos el arreglo para recibir las respuestas
         */
        char[] respuesta = new char[256];
        /*
         * Leemos el mensaje del canal de entrada
         */
        isr.read(respuesta, 0, 255);
        return (new String(respuesta).trim());
    }

    /* Constructor por defecto */
    public Cliente() {
        try {
            /*
             * Creamos el socket de cliente para que se conecte a la dirección dónde está
             * ejecutando el servidor
             * al puerto 5566
             */
            Socket cliente = new Socket("192.168.1.4", 5566);
            /*
             * Creamos el canal de entrada
             */
            isr = new InputStreamReader(cliente.getInputStream());
            /*
             * Creamos el canal de salida
             */
            osw = new OutputStreamWriter(cliente.getOutputStream());
            /*
             * Enviamos los mensajes a través del método mensaje() y leemos la respuesta a
             * través del método respuesta()
             */
            this.mensaje("Hola");
            System.out.println("Servidor respondió: " + this.respuesta());
            this.mensaje("Cómo estás?");
            System.out.println("Servidor respondió: " + this.respuesta());
            this.mensaje("Chau, hasta luego...");
            System.out.println("Servidor respondió: " + this.respuesta());
            this.mensaje("Ya puede terminar");
            System.out.println("Servidor respondió: " + this.respuesta());
            isr.close();
            osw.close();
            cliente.close();
        } catch (IOException ex) {
            System.err.println("No se pudo establecer la conexión con el Servidor 192.168.1.4 en el puerto 5566 !");
            System.err.println("Detalle del error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Cliente();
    }
}
/*
 * Ahora modificamos el código del cliente
 */