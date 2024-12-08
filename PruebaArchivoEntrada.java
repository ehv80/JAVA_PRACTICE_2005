/* Ahora que tenemos un archivo_salida.txt generado, usaremos FileInputStream
 * para abrirlo, leerlo y mostrarlo por pantalla.
 */

//package pruebas; //comentado porque da error en tiempo de ejecución paquete y clase no encontrados
import java.io.*;

public class PruebaArchivoEntrada {
    /* Constructor por defecto */
    public PruebaArchivoEntrada() {
        /* Declaramos la variable miArchivo de tipo FileInputStream */
        FileInputStream miArchivo;
        /*
         * Creamos el array de byte para almacenar la información que leemos desde el
         * archivo
         */
        byte linea[] = new byte[230]; // un arreglo de 230 bytes
        /* Intentamos capturar IOException */
        try {
            /*
             * Abrimos el archivo a través del constructor de la clase
             * FileInputStream(String nombreArchivo)
             */
            miArchivo = new FileInputStream(
                    "E:\\Users\\ehv80\\Documentos\\Programacion_en_Lenguaje_Java\\JAVA_PRACTICE_2005\\archivo_salida.txt");
            while (miArchivo.read(linea) == 0) // lee una línea del archivo_salida.txt en cada iteración del bucle while
            {
                /*
                 * Debo convertir el byte[] a String para que la información leída del archivo
                 * sea entendible para nosotros
                 */
                System.out.println(new String(linea));
                // muestra en pantalla la línea leída desde el archivo como un String
            }
            System.out.println("No hay más líneas de texto en archivo_salida.txt y se cierra!");
            miArchivo.close(); // cierra el archivo_salida.txt
        } catch (IOException ex) {
            /*
             * Tanto el constructor como los métodos write() y close() lanzan una excepción
             * de tipo IOException que debemos capturar
             */
            System.out.println("Error por IOExcepction capturada: " + ex.getMessage());
            System.out.println("Detalle de la pila de llamadas: ");
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new PruebaArchivoEntrada();
    }
}