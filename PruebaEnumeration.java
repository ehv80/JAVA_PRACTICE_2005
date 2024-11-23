
/* En el siguiente ejemplo cargamos un vector con numeros del cero al nueve
 * y luego lo mostramos usando Enumeration
 */
import java.util.*;

public class PruebaEnumeration {
    Vector v = new Vector();

    /* Constructor por defecto */
    public PruebaEnumeration() {
        for (int i = 0; i < 10; i++)
            v.addElement(new Integer(i));
        /* El método elements() de Vector devuelve un objeto Enumeration */
        Enumeration e = v.elements();
        /* Mientras haya elementos */
        while (e.hasMoreElements()) {
            /* Tomamos el siguiente elemento */
            Integer a = (Integer) e.nextElement();
            /* Y lo mostramos en pantalla */
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        new PruebaEnumeration();
    }
}