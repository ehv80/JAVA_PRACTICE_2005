/*
 * Analizando un poco, vimos que la clase RandomAccesFile es de acceso
 * aleatorio; sin embargo,
 * grabamos y leímos el archivo en forma secuencial. No usamos los métodos que
 * nos brindan la ventaja de acceso aleatorio.
 * Supongamos que tenemos un archivo con datos de alumnos con el siguiente
 * formato
 * Nombre del campo Tipo de Dato Longitud
 * Legajo Numérico 5
 * Nombre Caracter 10
 * Promedio Numérico 5
 * En total tenemos 20 caracteres, y como cada caracter ocupa un byte, entonces
 * tenemos 20 bytes.
 * A este conjunto de datos se lo llama registro. Sabemos que el archivo tiene
 * alumnos del 1 al 10.
 * El total del archivo debería ser 200 bytes (10 registros x 20 bytes cada
 * registro), tal como se ve en la Figura 8.
 * Lo que vamos a hacer es mostrar los datos del alumno que está en el registro
 * 5.
 * Creamos el archivo_acceso_aleatorio_2.txt con el siguiente contenido de ejemplo:
 *  00001Ismael    6    
 *  00002Raúl      7    
 *  00003Lucrecia  8    
 *  00004Ricardo   9    
 *  00005Eusebio   5    
 *  00006Brenda    6    
 *  00007Elena     7    
 *  00008Ezequiel  8    
 *  00009Hector    9    
 * 00010Ismael    10   
 *
 */

//package pruebas; //comentado porque da error en tiempo de ejecución Paquete y Clase no encontrados

import java.io.*;

public class PruebaArchivoAccesoAleatorio2 {
    /* Creamos un array de bytes de 20 porque sabemos el tamaño del registro */
    byte registro[] = new byte[20];
    RandomAccessFile archivo;

    /* Constructor por defecto */
    public PruebaArchivoAccesoAleatorio2() throws Exception {
        /* Abrimos el archivo_acceso_aleatorio_2.txt con el modo r (sólo lectura) */
        try {
            RandomAccessFile archivo = new RandomAccessFile(
                    "E:\\Users\\ehv80\\Documentos\\Programacion_en_Lenguaje_Java\\JAVA_PRACTICE_2005\\archivo_acceso_aleatorio_2.txt",
                    "r");
            /*
             * Para leer el alumno de la posición 5 hacemos 5 x 20 = 100
             * entonces tenemos que ir a esa posición usando el método seek()
             */
            archivo.seek(100);
            /* Leo el registro */
            archivo.read(registro);
            /* Muestro el registro en pantalla */
            System.out.println(new String(registro));
            /*
             * El método getFilePinter() nos dice donde quedó el puntero después del seek y
             * la lectura
             */
            System.out.println(archivo.getFilePointer());
            System.out.println("Quinto registro del archivo_acceso_aleatorio_2.txt leído y se cierra el archivo!");
            /* Cerramos el archivo */
            archivo.close();

        } catch (FileNotFoundException ex) {
            System.err.println("Error al abrir el archivo_Acceso_aleatorio_2.txt en módo solo lectura!");
            System.err.println("Detalles de la FileNotFoundException capturada: " + ex.getMessage());
            System.err.println("Detalles de la pila de llamadas: ");
            ex.printStackTrace();
        } finally {
            System.out.println("FIN!");
        }
    }

    public static void main(String[] args) {
        try {
            new PruebaArchivoAccesoAleatorio2();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}