public class UsoClaseInteger {
    Integer c;

    public UsoClaseInteger() {
        /* Creamos un Integer desde un int */
        Integer a = new Integer(1);
        /* Creamos un Integer desde un String */
        Integer b = new Integer("1");
        /* Si compareTo devuelve cero quiere decir que los dos Integer son iguales */
        if (a.compareTo(b) == 0) {
            /* intValue() devuelve el int con el que está instanciado el Integer */
            int suma = a.intValue() + b.intValue();
            c = new Integer(suma);
        }
        /* Convertimos el Integer a String usando el método toString() */
        System.out.println("El resultado es: " + c.toString());
    }

    public statis void main(String[] args) {
        new UsoClaseInteger();
    }
}