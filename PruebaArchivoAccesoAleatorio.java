/* Todos los Streams mencionados hasta este momento son de acceso secuencial.
 * Para que sea un poco más claro, esto significa que estos datos deben ser leídos
 * exactamente en el orden en que fueron escritos.
 * Aunque éstos son útiles para la mayoría de los programas, a veces se necesitan archivos de acceso aleatorio
 * que permiten acceder a sus contenidos en forma no secuencial, o sea, en forma aleatoria.
 * La clase RandomAccesFile implementa en java.io un archivo de acceso aleatorio, que puede ser usada tanto
 * para lectura como para escritura de bytes; además, soporta el concepto de puntero que indica la posición
 * actual dentro del archivo. El puntero es un entero que empieza en cero (principio del archivo) y se mide en bytes.
 * Ahora debemos tener en cuenta los conceptos de BOF (Begin Of File, en castellano: principio del archivo) y
 * EOF (End Of File, en castellano: Fin del Archivo). Sirven para saber en qué posición del archivo estamos, es decir,
 * si nuestro puntero apunta a BOF, estamos en el comienzo del archivo, y al final cuando apunte a EOF.
 * Por otro lado, debemos saber que, para abrir un archivo con RandomAccesFile, aparte del nombre del archivo,
 * debemos indicar el modo, ya que usamos el mismo objeto para leer y escribir. Los modos posibles son
 *      r   Archivo de sólo lectura
 *      rw  Archivo de lectura y escritura
 *      w   Archivo de sólo escritura
 * Lectura y Escritura de Archivos usando RandomAccesFile:
 * Como ya sabemos manejar archivos, vamos a hacer una clase PruebaArchivoAccesoAleatorio
 * con los métodos más comunes, es decir, abrir, grabar, leer y cerrar. Todas estas operaciones
 * ya las hicimos con los archivos secuenciales, ahora veamos cómo se maneja en particular la clase RandomAccesFile.
 */
//package pruebas; //comentado porque da error en tiempo de ejecución paquete y clase no encontrados

import java.io.*;

public class PruebaArchivoAccesoAleatorio {
    /*
     * Declaro la variable archivo como atributo de clase para que sea visible desde
     * todos los métodos
     */
    RandomAccessFile archivo;

    /*
     * Constructor con nombreDeArchivo pasado como parámetro se encargará de abrir
     * el archivo
     */
    public PruebaArchivoAccesoAleatorio(String nombreArchivo) {
        /* Intentamos capturar IOException */
        try {
            /* Abrimos el archivo con el modo rw (lectura y escritura) */
            this.archivo = new RandomAccessFile(nombreArchivo, "rw");
        } catch (IOException ex) {
            /* Ahora sí puedo informar el error con más precisión */
            System.err.println("Error al abrir el archivo de acceso aleatorio en modo lectura y escritura!");
            System.err.println("IOException capturada: " + ex.getMessage());
            System.err.println("Detalle de la pila de llamadas: ");
            ex.printStackTrace();
        }
    }

    /* Método cerrar simplemente cierrar el archivo */
    public void cerrar() {
        /* Intentamos capturar IOException */
        try {
            this.archivo.close();
        } catch (IOException ex) {
            /* Ahora sí puedo informar el error con más precisión */
            System.err.println("Error al cerrar el archivo de acceso aleatorio!");
            System.err.println("IOException capturada: " + ex.getMessage());
            System.err.println("Detalle de la pila de llamadas: ");
            ex.printStackTrace();
        }
    }

    /* Método leer. Usando el método readLine() leo una línea del archivo */
    public String leer() {
        String cadena = new String();
        /* Intentamos capturar IOException */
        try {
            cadena = this.archivo.readLine();
        } catch (IOException ex) {
            /* Ahora sí puedo informar el error con más precisión */
            System.err.println("Error al leer una línea desde el archivo de acceso aleatorio!");
            System.err.println("IOException capturada: " + ex.getMessage());
            System.err.println("Detalle de la pila de llamadas: ");
            ex.printStackTrace();
        } finally {
            return (cadena);
        }
    }

    /* Método grabar. Grabo una línea a través del método writeBytes */
    public void grabar(String cadena) {
        /* Intentamos capturar IOException */
        try {
            this.archivo.writeBytes(cadena + "\n");
        } catch (IOException ex) {
            /* Ahora sí puedo informar el error con más precisión */
            System.err.println("Error al grabar una línea hacia el archivo de acceso aleatorio!");
            System.err.println("IOException capturada: " + ex.getMessage());
            System.err.println("Detalle de la pila de llamadas: ");
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        PruebaArchivoAccesoAleatorio archivo = new PruebaArchivoAccesoAleatorio(
                "E:\\Users\\ehv80\\Documentos\\Programacion_en_Lenguaje_Java\\JAVA_PRACTICE_2005\\archivo_acceso_aleatorio.txt");
        archivo.grabar("Hola");
        archivo.grabar("a");
        archivo.grabar("todos");
        archivo.cerrar();
        /* Ahora lo abrimos y lo leemos completo y lo cerramos */
        archivo = new PruebaArchivoAccesoAleatorio(
                "E:\\Users\\ehv80\\Documentos\\Programacion_en_Lenguaje_Java\\JAVA_PRACTICE_2005\\archivo_acceso_aleatorio.txt");
        String linea = archivo.leer();
        /* Cuando no haya más para leer, línea será igual a null */
        while (linea != null) {
            System.out.println(linea);
            linea = archivo.leer();
        }
        System.out.println("Llegamos al \"EOF\" Fin del archivo y se cierra!");
        archivo.cerrar();
    }
}