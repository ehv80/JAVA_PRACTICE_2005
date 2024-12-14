/*
 * Bloqueos
 * Los bloqueos se dan bajo ciertas condiciones inusuales. Éstos son muy
 * difíciles de encontrar y eliminar.
 * Se producen cuando dos hilos presentan una dependencia circular. Por ejemplo,
 * supongamos dos Hilos A y B.
 * En este caso A entra en el monitor de B y éste, a su vez, en el monitor de A.
 * Si ahora A intenta llamar a un método sincronizado de B, entonces éste quedará bloqueado.
 * Hasta ahora todas son condiciones normales, el problema surge si bajo estas condiciones B llama a un método sincronizado de A;
 * si esto ocurre, los dos hilos quedarán bloqueados infinitamente, lo que provocará que la aplicación entera se bloquee.
 * Para que la aplicación termine su ejecución deberíamos matar a A. Esto se conoce como deadlock, y es más fácil de entender a 
 * través de gráficos como se ve en la Figura 8.
 *      ( A ) ------[ Monitor de B ]
 *        /\                     |
 *        |                      \/
 *      [ Monitor de A]<-------- ( B )
 * 
 * Comunicación entre hilos
 * Para terminar con los hilos, veamos el problema clásico en que uno de los hilos produce datos
 * para que otro los consuma. Este problema se encuentra por todas partes como Productor-Consumidor.
 * Para compilicarlo, nuestro productor va a tener que esperar a que el consumidor termine para volver a producir datos.
 * Para resolver esto Java brinda un mecanismo de comunicación entre procesos.
 * Este mecanismo se base en tres métodos que están implementados en la clase Object, es decir que todos los objetos los poseen;
 * por otra parte, están implementados como final de manera tal que no podremos reescribirlos. 
 * Estos tres métodos son wait(), notify() y notifyall().
 * Para finalizar, agreguemos que estos métodos sólo pueden ser llamados desde un método que haya sido declarado como synchronized.
 *  - wait(): le indica al hilo en curso que abandone el monitor 
 *            y se vaya a dormir hasta que otro hilo entre en el mismo monitor y llame a notify()
 *  - notify(): despierta al primer hilo que realizó una llamada a wait sobre el mismo objeto
 *  - notifyall(): despierta a todos los hilos que realizaron una llamada a wait sobre el mismo objeto. 
 *                 El hilo con mayor prioridad es el primero en ejecutarse.
 * Veamos el ejemplo de nuestro problema del Productor-Consumidor
 * Empezamos por la clase Cola, que es el espacio compartido donde pondrá datos el Productor, y por supuesto, sacará el consumidor:  
 */
public class Cola {
    int n;
    boolean hayValor = false;

    /* Constructor por defecto no hace nada */
    public Cola() {

    }

    synchronized int get() {
        if (!hayValor) {
            try {
                wait();
            } catch (InterruptedException ex) {
                System.err.println("Error al esperar en método get: " + ex.getMessage());
                System.err.println("Detalle de la pila de llamadas: ");
                ex.printStackTrace();
            }
        }
        System.out.println("Obtenido: " + n);
        hayValor = false;
        notify();
        return n;
    }

    synchronized void put(int n) {
        if (hayValor) {
            try {
                wait();
            } catch (InterruptedException ex) {
                System.err.println("Error al esperar en método put: " + ex.getMessage());
                System.err.println("Detalle de la pila de llamadas: ");
                ex.printStackTrace();
            }
        }
        this.n = n;
        hayValor = true;
        System.out.println("Colocado: " + n);
        notify();
    }
}