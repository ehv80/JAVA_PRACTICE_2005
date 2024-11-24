/* Veamos el siguiente programa: cuando quiera convertir el objeto b a entero,
 * arrojará la excepción NumberFormatException
 */
/* Continuamos dentro del paquete pruebas */
// package pruebas; Comentado para evitar la excepción de Clase no encontrada

public class PruebaError2 {
    /* Tengo 2 objetos Srting instanciados con 2 y a */
    String a = new String("2");
    String b = new String("a");

    /* Constructor por defecto */
    public PruebaError2() {
        int resultado = 0;
        /* Convierto de String a entero y sumo */
        /*
         * Ahora si, vamos a manejar el error, reemplazando la línea de la suma por las
         * siguientes
         * para asegurarnos la correcta ejecución del programa
         */
        try {
            resultado = Integer.parseInt(a) + Integer.parseInt(b);
        } catch (NumberFormatException ex) {
            /* Como conocemos el error lo corregimos */
            b = new String("0");
            resultado = Integer.parseInt(a) + Integer.parseInt(b);
        }

        /* Muestro el resultado */
        System.out.println("Resultado : " + resultado);
    }

    public static void main(String[] args) {
        new PruebaError2();
    }
}