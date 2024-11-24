/* Veamos un ejemplo que produce una excepción, pero no vamos a capturarla con un catch, 
 * para analizar un poco la salida de error de Java 
 */
// Vamos a crear un paquete de pruebas
package pruebas;

/* Importamos java.util.* para usar la clase Vector */
import java.util.*;

public class PruebaError {
    /* Declaramos el Vector */
    Vector v = new Vector();

    /* Constructor por defecto */
    public PruebaError() {
        /* Declaramos la variable i para recorrer el vector */
        int i = 0;
        /* Agregamos cuatro elementos al Vector */
        v.addElement(new String("Sergio"));
        v.addElement(new String("Karina"));
        v.addElement(new String("Laura"));
        v.addElement(new String("Martín"));
        /* Note que el for intentará recorrer un vector de diez elementos */
        for (i = 0; i < 10; i++) {
            /* Tomo el elemento de la posición i y lo muestro */
            System.out.println(v.get(i));
        }
    }

    public static void main(String[] args) {
        /*
         * Creo el objeto pero no lo referencio ya que no voy a usar más que el
         * constructor
         */
        new PruebaError();
    }
}