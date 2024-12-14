/* El Consumidor saca datos de la Cola */
public class Consumidor implements Runnable {
    Cola q;

    /* Constructor con parámetros */
    public Consumidor(Cola q) {
        this.q = q;
        new Thread(this, "Consumidor").start();
    }

    /* Sobrecargamos el método run */
    public void run() {
        while (true)
            q.get();
    }
}