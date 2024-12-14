/* Ahora crearemos la clase Vendedora, que particularmente se encargará de registrar las ventas en la caja */
public class Vendedora extends Thread {
    Caja c;

    /* Contructor con parámetros */
    public Vendedora(Caja caja) {
        /* Le decimos que caja va a usar */
        this.c = caja;
    }

    /* Sobrecargamos el método run */
    public void run() {
        /* Registramos una venta */
        c.sumar();
    }
}