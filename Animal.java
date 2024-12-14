/* Ahora veamos un ejemplo combinando atributos y métodos declarados como Final.
 * Para el ejemplo haremos la clase Perro, que hereda de Animal. Veamos la Clase Animal.
 */
public class Animal extends Thread {
    /* atributos de clase */
    String nombre = new String();
    /* Declaro tipo como Final */
    final String tipo;
    /* Declaro cantidadDePatas, como no pongo modificador es public */
    int cantidadDePatas;
    int prioridad;

    /* El Constructor por defecto instancia el objeto con valores por defecto */
    public Animal() {
        this.nombre = "Perro";
        this.tipo = "Mamífero";
        this.cantidadDePatas = 4;
        this.prioridad = 6;
        /* Establece la prioridad del Thread a través del método de la clase padre */
        super.setPriority(this.prioridad);
    }

    /* Constructor con parámetros */
    public Animal(String n, String t, int pt, int pd) {
        this.nombre = n;
        this.tipo = t;
        this.cantidadDePatas = pt;
        this.prioridad = pd;
        /* Establece la prioridad del Thread a través del método de la clase padre */
        super.setPriority(this.prioridad);
    }

    /* Declaro el método camina como final */
    public final void camina() {
        System.out.println("Soy un Animal y estoy caminando... ");
    }

    public void corre() {
        System.out.println("Soy un Animal y estoy corriendo... ");
    }

    /* Sobrecargamos el método run */
    public void run() {
        System.out.println("Llegó el-la " + this.nombre + " con prioridad: " + this.prioridad);
    }
}