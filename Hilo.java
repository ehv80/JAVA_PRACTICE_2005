/* Hay dos formas de crear hilos de ejecución en Java. Una es implementando la interfaz Runnable;
 * la otra es extender la Clase Thread. La implementación de la interfaz Runnable es la forma habitual, y por cierto,
 * la más prolija para crear hilos. La primera posibilidad para crear un hilo de ejecución es simplemente extender la clase Thread
 * como lo muestra la siguiente declaración:
 * public class Hilo extends Thread
 * {
 *      public void run()
 *      {
 *      }
 * }
 * El ejemplo anterior crea una nueva clase Hilo que extiende la clase Thread y sobreescribe el método run();
 * aquí es donde se realizará todo el trabajo de la clase. 
 * La segunda posibilidad es a través de la implementación de la interfaz Runnable de la siguiente manera:
 * public class Hilo implements Runnable
 * {
 *      public void run()
 *      {
 *      }
 * }
 * Esta opción es más flexible, aunque por su calidad de interfaz y por tener todos sus métodos abstractos, nos da los 
 * lineamientos de diseño. El método run() de la clase es el que hace que corra como un hilo. Agreguémosle alguna funcionalidad:
 */
public class Hilo implements Runnable {
    public void run() {
        /* Muestra información sobre el hilo actual en la pantalla */
        System.out.println("Soy el hilo " + Thread.currentThread().getName());
    }
}