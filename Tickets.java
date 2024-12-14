/* Para finalizar el método main() que ponga el ejemplo en funcionamiento */
public class Tickets {
    public static void main(String[] args) {
        /* Creo la Caja donde acumulo las ventas */
        Caja caja = new Caja();
        /*
         * Creo las tres Vendedoras del Cine que registran las ventas,
         * a las tres Vendedoras le asigno la misma Caja
         */
        Vendedora V1 = new Vendedora(caja);
        Vendedora V2 = new Vendedora(caja);
        Vendedora V3 = new Vendedora(caja);
        /* Empiezan a vender */
        V1.start();
        V2.start();
        V3.start();
        try {
            V1.join();
            V2.join();
            V3.join();
        } catch (InterruptedException ex) {
            System.err.println("Error al comenzar a vender entradas: " + ex.getMessage());
            System.err.println("Detalle de la pila de llamadas: ");
            ex.printStackTrace();
        }
    }
}