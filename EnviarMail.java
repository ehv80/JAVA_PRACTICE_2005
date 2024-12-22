/* 
 * Aprovechando lo aprendido, vamos a implementar un pequeño cliente de correo para mandar e-mails.
 */

//package conexion; //comentado para evitar error en tiempo de ejecución paquete y clase no encontrado

import java.io.*;
import java.net.*;
import java.util.*;

public class EnviarMail {
    /*
     * Métodos de la clase EnviarMail
     */
    public void send(BufferedReader in, BufferedWriter out, String s) {
        try {
            out.write(s + "\n");
            out.flush();
            s = in.readLine();
        } catch (Exception ex) {
            System.err.println("Error al ejecutar el método send!");
            System.err.println("Detalle del error: " + ex.getMessage());
            System.err.println("Detalle de la pila de llamadas: ");
            ex.printStackTrace();
        }
    }

    public void send(BufferedWriter out, String s) {
        try {
            out.write(s + "\n");
            out.flush();
        } catch (Exception ex) {
            System.err.println("Error al ejecutar el método send!");
            System.err.println("Detalle del error: " + ex.getMessage());
            System.err.println("Detalle de la pila de llamadas: ");
            ex.printStackTrace();
        }
    }

    /* Constructor con parámetros */
    public EnviarMail(String mail, String asunto, String mensaje) {
        try {
            /*
             * Abrimos el socket en la IP donde está nuestro servidor de correo, en
             * el puerto 25 (comunmente de smtp)
             */
            Socket s = new Socket("192.168.1.4", 25);
            /*
             * Establece los canales de entrada y salida
             */
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream(), "8859_1"));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(s.getOutputStream(), "8859_1"));
            for (int i = 0; i < 1; i++) {
                send(in, out, "Hello nadie");
                /*
                 * El correo llega como si hubiera sido enviado de la dirección
                 * alguien@unaEmpresa.com
                 * por ejemplo ezequiel.villanueva@gmail.com
                 */
                send(in, out, "MAIL FROM: ezequiel.villanueva@gmail.com");
                /*
                 * Dirección del destinatario
                 */
                send(in, out, "RCPT TO: " + mail);
                send(in, out, "DATA");
                send(out, "Date: 13/08/2048");
                send(out, "Subject: " + asunto);
                send(out, "From: Alguien");
                send(out, "\n");
                send(out, mensaje);
                send(out, "\n.\n");
            }
            send(in, out, "QUIT");
            s.close();
        } catch (Exception ex) {
            System.err.println("Error al enviar e-mail!");
            System.err.println("Detalle del error: " + ex.getMessage());
            System.err.println("Detalle de la pila de llamadas: ");
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        EnviarMail em = new EnviarMail("ezequiel.villanueva@gmail.com", "Email de Prueba",
                "Hola Ezequiel, cómo estás? Éste es un email de prueba enviado a través de un cliente de correo implementado en Java. Saludos..!");
        System.out.println("Revisa tu casilla de email..!");
        System.out.println("FIN!");
    }
}