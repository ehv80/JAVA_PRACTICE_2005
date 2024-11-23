/* Ahora veamos un ejemplo combinando atributos y métodos declarados como Final.
 * Para el ejemplo haremos la clase Perro, que hereda de Animal. Veamos la Clase Animal.
 */
public class Animal {
    /* Declaro tipo como Final */
    final String tipo;
    /* Declaro cantidadDePatas, como no pongo modificador es public */
    int cantidadDePatas;

    /* El Constructor por defecto instancia el objeto con valores por defecto */
    public Animal() {
        this.tipo = "Mamífero";
        this.cantidadDePatas = 0;
    }

    /* Declaro el método camina como final */
    public final void camina() {
        System.out.println("Soy un Animal y estoy caminando... ");
    }

    public void corre() {
        System.out.println("Soy un Animal y estoy corriendo... ");
    }
}