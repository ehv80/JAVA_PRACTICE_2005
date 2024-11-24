/* Veamos el siguiente programa: cuando quiera convertir el objeto b a entero,
 * arrojará la excepción NumberFormatException
 */
/* Continuamos dentro del paquete pruebas */
package pruebas;

public class PruebaError2 {
    /* Tengo 2 objetos Srting instanciados con 2 y a */
    String a = new String("2");
    String b = new String("a");

    /* Constructor por defecto */
    public PruebaError2() {
        int resultado = 0;
        /* Convierto de String a entero y sumo */
        resultado = Integer.parseInt(a) + Integer.parseInt(b);
        /* Muestro el resultado */
        System.out.println("Resultado : " + resultado);
    }

    public static void main(String[] args) {
        new PruebaError2();
    }
}