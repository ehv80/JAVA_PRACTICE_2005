/* Ahora seguimos por el Productor, que se encargará de poner datos en la Cola */
public class Productor implements Runnable {
    Cola q;

    /* Constructor con parámetros */
    public Productor(Cola q) {
        this.q = q;
        new Thread(this, "Productor").start();
    }

    /* Sobrecargamos el método run */
    public void run() {
        int i = 0;
        while (true)
            q.put(i++);
    }
}