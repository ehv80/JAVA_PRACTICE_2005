/*
 * Nuestro Primer Servidor
 * Ahora que ya aprendimos lo necesario de IP, vamos a hacer un pequeño servidor
 * usando la clase
 * ServerSocket. Éste va a escuchar en el puerto 5566 (ya que en nuestra
 * computadora este puerto está libre).
 * El método accept() de la clase ServerSocket provoca que el servidor quede
 * bloqueado
 * esperando llamadas para atender (Figura 2)
 * Servidor __________________________________ Cliente
 * ServerSocket(puerto) ______________________ Socket(host, puerto)
 * accept()
 * InputStream <-----------------------------> OutputStream
 * OutputStream <-----------------------------> InputStream
 * close() ____________________________________ close()
 * Figura 2. Estructura de la comunicación entre sockets.
 */

import java.io.*;
import java.net.*;

public class Servidor {
    InputStreamReader isr;
    OutputStreamWriter osw;

    /* Constructor por defecto */
    public Servidor() {
        try {
            System.out.println("Creando servidor en el puerto 5566 ...");
            ServerSocket servidor = new ServerSocket(5566);
            System.out.println("Esperando llamadas ...");
            /*
             * Tenemos que crear un Socket partiendo del Servidor para atender a las
             * llamadas
             */
            Socket s = servidor.accept();
            /*
             * Creamos el canal de entrada
             */
            isr = new InputStreamReader(s.getInputStream());
            /*
             * Creamos el canal de salida
             */
            osw = new OutputStreamWriter(s.getOutputStream());
        } catch (IOException ex) {
            System.err.println("No se puede escuchar en el puerto 5566");
            System.err.println("Detalle del error: " + ex.getMessage());
            System.err.println("Detalle de la pila de llamadas: ");
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Servidor();
    }
}
/*
 * Si todo va bien, después de la ejecución debemos ver la siguiente salida en
 * pantalla:
 * 
 * Creando servidor en el puerto 5566 ...
 * Esperando llamadas ...
 * 
 * Note que el programa no termina, queda bloqueado esperando a recibir
 * llamadas.
 */
/*
 * Como vemos, el canal de comunicación ya está establecido, ahora debemos
 * definir
 * los canales de entrada y salida de cada programa; es decir que tendremos
 * cuatro canales
 * dos para el cliente y dos para el Servidor. Para establecer los canales
 * usaremos las clases
 * InputStreamReader para entrada y OutputStreamWriter para salida.
 * Vamos a agregar los objetos a nuestro código. Quedará para el Servidor:
 */