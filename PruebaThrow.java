//package pruebas; Comentado para evitar la excepción de Clase no encontrada
/* Entonces si no queremos manejar la excepción y deseamos que lo haga el padre
 * en la pila de llamadas, usamos la sentencia throws 
 */
public class PruebaThrow {
    /* Constructor por defecto no hago nada */
    public PruebaThrow() {

    }

    /* Éste método devuelve el resultado de la división */
    public float divide(int a, int b) throws ArithmeticException
    {
        /* Esta línea provoca la excepción que el throws lanza hacia arriba en la pila de llamadas */
        return (a/b)
    }

    public static void main(String[] args) {
        PruebaThrow p = new PruebaThrow();
        /*
         * La llamada provocará un ArithmeticException causado por la división por cero
         */
        try {
            float c = p.divide(15, 0);
        } catch (ArithmeticException ex) {
            /* Imprimimos en pantalla un mensaje de error */
            System.out.println(" Error de división por cero !!! ");
            /* Imprimimos el stack trace o pila de llamadas */
            ex.printStackTrace();
        }
    }
}