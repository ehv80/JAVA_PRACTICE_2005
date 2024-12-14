/* Ahora implementemos un método main() para ver los hilos en acción: */
public class PruebaHilo {
    public static void main(String[] args) {
        /* Creamos tres hilos de la clase Thread con los nombres uno, dos y tres */
        Thread hilo1 = new Thread(new Hilo(), "uno");
        Thread hilo2 = new Thread(new Hilo(), "dos");
        Thread hilo3 = new Thread(new Hilo(), "tres");
        /*
         * Hacemos comenzar a los hilos, invocando al método start()
         * provocamos que el hilo ejecute su método run()
         */
        /*
         * Veamos ahora qué pasa si detenemos el segundo hilo durante 10 segundos.
         * Para lograrlo vamos a mandarlo a dormir a través del método sleep().
         * Debemos recordar que al enviar a un hilo a dormir, lo que en realidad estamos
         * haciendo es
         * interrumpiendo el proceso, por lo tanto esta acción puede arrojar una
         * excepción del tipo InterruptedException,
         * y debemos manejar dicha excepción. El código del main quedará ahora así:
         */
        try {
            hilo2.sleep(1000); /* mando a dormir el hilo durante 10 segundos */
        } catch (InterruptedException ex) {
            System.err.println("Error al dormir el hilo: " + hilo2.getName());
            System.err.println("por captura de InterruptedException: " + ex.getMessage());
            System.err.println("Detalle de la pila de llamadas: ");
            ex.printStackTrace();
        }
        hilo1.start();
        hilo2.start();
        hilo3.start();
    }
}