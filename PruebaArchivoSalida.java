/* El caso más común en que necesitaremos usar streams será el de archivos. Para esto,
 * en Java encontramos las clases FileOutputStream, FileInputStreams, FileReader y FileWriter.
 * Comenzaremos por FileOutputStream, el cual, como su nombre lo indica, crea un flujo de datos 
 * de salida a un archivo.
 */
//package pruebas; //comentado por que da error en tiempo de ejecución clase y paquete no encontrado

import java.io.*;

public class PruebaArchivoSalida {
    /* Constructor por defecto */
    public PruebaArchivoSalida() {
        /* Declaramos la variable miArchivo de tipo FileOutputStream */
        FileOutputStream miArchivo;
        /* Declaramos el String para grabar en el archivo */
        String dato = new String();
        /* Intentamos gestionar Excepciones */
        try {
            /*
             * Creamos el archivo a través del constructor de la clase
             * FileOutputStream(String nombreArchivo)
             */
            miArchivo = new FileOutputStream(
                    "E:\\Users\\ehv80\\Documentos\\Programacion_en_Lenguaje_Java\\JAVA_PRACTICE_2005\\archivo_salida.txt");
            dato = "Esta es la primera línea de información que vamos a grabar en archivo_salida.txt\n";
            /*
             * Recuerde que el método write() espera un array de bytes, así que usamos el
             * método getBytes() de String para obtener esto
             */
            miArchivo.write(dato.getBytes());
            /* Vamos a grabar 20 líneas más mediante un bucle for */
            for (int i = 0; i < 20; i++) {
                /*
                 * Grabo el número de línea correspondiente
                 * Agrego al final la secuencia de escape \n para que no grabe todo seguido
                 */
                dato = "Línea (" + (i + 1) + ") \n";// es más uno porque ya hay una primera línea
                miArchivo.write(dato.getBytes());
            }
            /* Una vez terminada la escritura en el archivo_salida.txt lo cerramos */
            miArchivo.close();
        } catch (IOException ex) {
            /*
             * Tanto el constructor como los métodos write() y close() lanzan una excepción
             * de tipo IOException que debemos capturar
             */
            System.out.println("Error por IOException capturada: " + ex.getMessage());
            System.out.println("Detalles de la Pila de llamadas: ");
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new PruebaArchivoSalida();
    }
}