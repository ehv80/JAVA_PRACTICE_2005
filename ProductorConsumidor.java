/* Finalmente agregamos una clase ProductorConsumidor, que tendrá solamente el método main para probar nuestras clases */
public class ProductorConsumidor {
    /* Constructor por defecto no hace nada */
    public ProductorConsumidor() {

    }

    public static void main(String[] args) {
        Cola q = new Cola();
        new Productor(q);
        new Consumidor(q);
    }
}