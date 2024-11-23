import java.util.*;

public class PruebaClaseVector {
    /* Instancio un Vector referenciado con la variable v */
    Vector v = new Vector();

    /* Contructor por defecto */
    public PruebaClaseVector() {
        /* Pregunto si está vacío */
        if (v.isEmpty()) {
            /*
             * Como está vacío agrego elementos al Vector,
             * note que agrego instancias de la clase String
             */
            v.addElement("ROJO");
            v.addElement("VERDE");
            v.addElement("AZUL");
            v.addElement("NEGRO");
        }
        /* Muestro la cantidad de elementos del Vector */
        System.out.println("El Vector tiene " + v.size() + " elementos");
        /* Muestro el contenido del Vector */
        System.out.println(v.toString());
        /*
         * Pregunto si el Vector contiene un objeto de la clase String instanciado con
         * "ROJO"
         */
        if (v.contains("ROJO")) {
            /* Busco la posición de la instancia "ROJO" */
            int posicion = v.indexOf("ROJO");
            /* Borro el elemento que está en esa posición */
            v.remove(posicion);
        }
        /*
         * Ahora uso el método Borrar, pero como parámetro le
         * paso la instancia que quiero borrar
         */
        v.remove("VERDE");
        /* Vuelvo a mostrar la cantidad de elementos del Vector */
        System.out.println("El Vector tiene " + v.size() + " elementos");
        /* Vuelvo a mostrar el contenido del Vector */
        System.out.println(v.toString());
        /* Muestro el elemento de la posición 1 */
        System.out.println("El elemento de la posición 2 es: " + v.get(1));
    }

    public static void main(String[] args) {
        /*
         * Creo una nueva instancia de PruebaClaseVector pero no la
         * referencio porque el código está directamente en el constructor
         */
        new PruebaClaseVector();
    }
}