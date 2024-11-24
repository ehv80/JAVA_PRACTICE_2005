/* Ahora vamos a ver cómo se usa nuestra excepción NumeroInvalidoExcepction
 * a través del siguiente ejemplo
 */
//package pruebas; Comentado para evitar la excepción de Clase no encontrada
public class PruebaNumeroInvalido {
    /* Declaramos que el Constructor lanza una excepción NumeroInvalidoException */
    public PruebaNumeroInvalido(int a) throws NumeroInvalidoException {
        if (a > 0 && a < 5) {
            // Hace lo que necesita
            System.out.println(" Numero es :" + a);
        } else {
            /* Como no cumple con nuestra condición, lanzamos la excepción implícitamente */
            throw new NumeroInvalidoException();
        }
    }

    public static void main(String[] args) {
        try {
            new PruebaNumeroInvalido(50);
        } catch (NumeroInvalidoException ex) {
            /*
             * Capturo la excepción y muestro el mensaje, y cómo está sobrecargado, mostrará
             * el nuestro
             */
            System.out.println(ex.getMessage());
            /*
             * El método printStackTrace() no está sobrecargado, entonces usará el del padre
             * Exception
             */
            ex.printStackTrace();
        }
    }
}