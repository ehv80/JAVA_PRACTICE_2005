public final class PruebaFinal {
    /*
     * El ejemplo es muy sencillo y sirve solamente para ver la sintaxis
     * Al declarar la clase como Final nadie puede heredar nada de PruebaFinal
     */
    /* Constructor por defecto no hago nada */
    public PruebaFinal() {

    }

    public static void main(String[] args) {
        /* Instancio el objeto Perro y lo referencio con la variable p */
        Perro p = new Perro();
        p.camina();
        p.corre();
    }
}