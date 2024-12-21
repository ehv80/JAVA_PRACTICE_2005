/*
 * Ahora vamos a escribir el código del cliente. En este punto hay que recordar que es fundamental
 * que el puerto sea conocido por el cliente, de lo contrario, no se va a lograr la conexión.
 */

import java.io.*;
import java.net.*;

public class Cliente {
    /* Constructor por defecto */
    public Cliente() {
        try {
            /*
             * Creamos el socket de cliente para que se conecte a la dirección dónde está
             * ejecutando el servidor
             * al puerto 5566
             */
            Socket cliente = new Socket("192.168.1.4", 5566);

        } catch (IOException ex) {
            System.err.println("No se pudo establecer la conexión con el Servidor 192.168.1.4 en el puerto 5566 !");

            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Cliente();
    }
}