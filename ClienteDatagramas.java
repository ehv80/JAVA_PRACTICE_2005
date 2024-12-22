/* 
 * Ahora el código del cliente de Datagramas es:
 */

import java.net.*;
import java.io.*;
//import sun.net.*; //comentado porque ya no existe en JDK 23

public class ClienteDatagramas {
    /* Constructor por defecto */
    public ClienteDatagramas() throws Exception {
        int longitud = 100;
        byte buffer[] = new byte[100];
        /*
         * Abrimos la conexión para recibir peticiones en el puerto 4321
         */
        DatagramSocket socket = new DatagramSocket(4321);
        /*
         * Intentamos obtener la dirección IP del Host
         */
        InetAddress IP = InetAddress.getByName("LILANDRAX");
        /*
         * Enviamos una petición para ver si el servidor responde
         */
        socket.send(new DatagramPacket(buffer, buffer.length, IP, 4322));
        /*
         * Creamos un DatagramPacket para recibir el paquete UDP
         */
        DatagramPacket paquete = new DatagramPacket(buffer, longitud);
        socket.receive(paquete);
        /*
         * Imprimimos los datos del paquete obtenido
         */
        String datos = new String(paquete.getData());
        System.out.println("Fecha y hora del Servidor: " + datos);
        System.out.println("El tamaño del paquete recibido en el puerto " + paquete.getPort() + " es "
                + paquete.getLength() + " bytes");
        /*
         * Finalmente cerramos la conexión
         */
        socket.close();
    }

    public static void main(String[] args) {
        try {
            new ClienteDatagramas();
        } catch (Exception ex) {
            System.err.println("Error al ejecutar ClienteDatagramas!");
            System.out.println("Detalles del error: " + ex.getMessage());
            System.out.println("Detalles de la pila de llamadas: ");
            ex.printStackTrace();
        }
    }
}