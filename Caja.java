/* Supongamos que queremos acumular la venta de entradas a un cine en el cuál tenemos tres vendedoras.
 * Si lo implementamos sin sincronización, lo más probable es que al final del día hayamos perdido
 * la cuenta de varias entradas por lo expuesto en el ejemplo anterior. Veamos cómo se resuelve utilizando sincronización;
 * para ello, primero creamos la clase Caja donde se van a acumular las entradas vendidas:
 */
public class Caja {
    /* En esta variable almaceno las entradas vendidas */
    int entradas = 0;

    /* Creo el método sumar como un monitor */
    public synchronized void sumar() {
        /* Cada vez que vendo sumo una entrada */
        this.entradas += 1;
        System.out.println("Entradas vendidas: " + this.entradas);
    }
}