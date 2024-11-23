
/* HashMap permite crear arreglos de tipo diccionario. En un diccionario, a una palabra
 * le corresponde un significado. En este caso, a una clave le corresponde un elemento.
 * Lo importante es que cualquier objeto Java puede ser clave o ser elemento, y que podemos
 * tener objetos de distinto tipo, como clave o como elemento, en el mismo arreglo.
*/
import java.util.*;

public class PruebaHashMap {
    HashMap m = new HashMap();

    /* Constructor por defecto */
    public PruebaHashMap() {
        /* Con la clave ENTERO cargamos un Integer */
        m.put("ENTERO", new Integer(1));
        /* Con la clave FLOTANTE cargamos un Float */
        m.put("FLOTANTE", new Float(2));
        /* Con la clave "CADENA" cargamos un String */
        m.put("CADENA", new String("Esto es un String"));
        /*
         * Pedimos el elmento a través de su clave y lo convertimos al tipo de dato
         * correspondiente
         */
        Integer a = (Integer) m.get("ENTERO");
        Float b = (Float) m.get("FLOTANTE");
        String c = (String) m.get("CADENA");
        // Mostramos en pantalla
        System.out.println("Entero: " + a);
        System.out.println("Flotante: " + b);
        System.out.println(c);
    }

    public static void main(String[] args) {
        new PruebaHashMap();
    }
}