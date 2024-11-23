/* La subclase Perro es la siguiente */
public class Perro extends Animal {
    /* Declaro el atributo raza y lo instancio por defecto como Dogo */
    private String raza = "Dogo";

    /* En el Constructor por defecto no hago nada */
    public Perro() {

    }

    public void corre() {
        System.out.println("Soy un Perro y estoy corriendo... ");
    }
    /* Note que no puedo sobreescribir el método camina porque es final */
}