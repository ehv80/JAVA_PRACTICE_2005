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
        hilo1.start();
        hilo2.start();
        hilo3.start();
    }
}