/*
 * DATAGRAMAS
 * HAsta ahora estudiamos sockets sobre el protocolo TCP. Pero Java también provee
 * un conjunto de clases para comunicarse sobre el protocolo UDP. Estas clases son
 * DatagramSocket y DatagramPacket.
 *
 * - DatagramSocket: es la más simple; lo único que hacemos es enviar los datos a 
 * través del DatagramSocket, utilizando los métodos de envío y recepción apropiados.
 * 
 * - DatagramPacket: un DatagramSocket envía y recibe los paquetes, mientras que un
 * DatagramPacket contiene la información relevante. Cuando queremos recibir un datagrama,
 * tenemos que situarlo en algún sitio, que suele ser un buffer o array de bytes. Y cuando 
 * preparamos un datagrama para enviar, el DatagramPacket no sólo debe tener la información,
 * sino también la dirección IP y el número de puerto de destino, que puede coincidir con un puerto TCP.
 * 
 * A modo de ejemplo, vamos a hacer un servidor que envíe la fecha y la hora de la pc en 
 * milisegundos a petición. Entonces el código del servidor será:
 */

import java.net.*;
import java.io.*;
import java.util.*;
import sun.net.*;

public class ServidorDatagramas {
    /*
     * Para no complicar el ejemplo, lanzaremos todas las excepciones hacia arriba
     */
    /* Constructor por defecto */
    public ServidorDatagramas() throws Exception {
        /*
         * Declaramos los paquetes de envío y recepción
         */
        DatagramPacket paqueteEnvio, paqueteRecepcion;
        /*
         * Declaramos el Buffer
         */
        byte buffer[] = new byte[100];
        /*
         * Instanciamos la cadena que vamos a enviar
         */
        String cadena = new Date(System.currentTimeMillis()).toString();
        /*
         * Intentamos obtener la IP del Host
         */
        InetAddress IP = InetAddress.getByName("LILANDRAX");
        /*
         * Instanciamos el servidor para escucar en el puerto 4322
         */
        DatagramSocket socket = new DatagramSocket(4322);
        /*
         * Creamos un paquete de solicitud en el cliente y nos quedamos esperando a sus
         * peticiones
         */
        paqueteRecepcion = new DatagramPacket(buffer, cadena.length());
        socket.receive(paqueteRecepcion);
        /*
         * Creamos el paquete para enviar al cliente
         */
        buffer = cadena.getBytes();
        socket.send(new DatagramPacket(buffer, cadena.length(), IP, 4321));
        /*
         * Finalmente cerramos el socket
         */
        socket.close();
    }

    public static void main(String[] args) {
        try {
            new ServidorDatagramas();
        } catch (Exception ex) {
            System.err.println("Error al ejecutar el Servidor de Datagramas!");
            System.err.println("Detalles del error: " + ex.getMessage());
            System.err.println("Detalle de la pila de llamdas: ");
            ex.printStackTrace();
        }
    }
}