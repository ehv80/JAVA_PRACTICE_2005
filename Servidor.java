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
            while (true) {
                /*
                 * Creamos el canal de entrada
                 */
                isr = new InputStreamReader(s.getInputStream());
                /*
                 * Creamos el canal de salida
                 */
                osw = new OutputStreamWriter(s.getOutputStream());
                /*
                 * Creamos un arreglo para recibir las peticiones
                 */
                char[] mensaje = new char[256];
                /*
                 * Leemos del canal de entrada
                 */
                isr.read(mensaje, 0, 255);
                /*
                 * De acuerdo con el mensaje recibido, escribimos lo que corresponda
                 * en el canal de salida
                 */
                String msg = new String(mensaje).trim();
                if (msg.compareTo("Hola") == 0) {
                    osw.write("Hola!!!");
                    osw.flush();
                } else if (msg.compareTo("¿Cómo estás?") == 0) {
                    osw.write("Bien");
                    osw.flush();
                } else if (msg.compareTo("Chau, hasta luego...") == 0) {
                    osw.write("Chau... Nos vemos.");
                    osw.flush();
                } else if (msg.compareTo("Ya puede terminar") == 0) {
                    osw.write("Gracias");
                    osw.flush();
                    System.out.println("Me dijeron que puedo terminar...");
                    break;
                }
            }
            /*
             * Muy importante cerrar los canales de entrada y salida y el ServerSocket
             */
            isr.close();
            osw.close();
            servidor.close();

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
/*
 * Ahora si, nuestros programas están listos para comunicarse, pero debemos
 * definir cómo van a hacerlo, en otras palabras, cómo se van a entender.
 * Para esto es que tenemos que crear un protocolo de comunicación.
 * Nuestro primer protocolo
 * Como vimos, para que nuestros programas se comuniquen, debemos proveer un
 * protocolo. A los efectos de simplificar el ejemplo, vamos a definir una
 * charla
 * entre los dos programas. Es decir que el protocolo será el siguiente:
 * 
 * Mensaje _____________________________ Respuesta
 * Hola ________________________________ Hola!!!
 * ¿Cómo estás? ________________________ Bien
 * Chau, hasta luego... ________________ Chau... Nos vemos.
 * Ya puede terminar ___________________ Gracias
 * Tabla 1. Diálogo simulado entre los dos programas
 * 
 * Una vez que tenemos definido el protocolo, vamos a agregar el código
 * correspondiente
 * a nuestro programa.
 * Notemos en este punto que cada vez que nuestro Servidor atendía una llamada,
 * terminaba; así
 * que una primera modificación será agregar el código del Servidor en un ciclo
 * para que no corte hasta que reciba el mensaje de salida
 * El código del Servidor es, entonces el siguiente:
 */