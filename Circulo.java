/* Las clases abstractas no pueden ser instanciadas "nunca".
 * Si instanciamos una clase abstracta, provocaremos un error en tiempo de compilación.
 * Ahora, hagamos la clase Circulo que hereda de Figura
 */
class Circulo extends Figura {
    /* Constructor por defecto no hago nada */
    public Circulo() {

    }

    /*
     * Círculo debe definir el método dibujar porque en la superclase no estaba
     * implementado
     */
    public void dibujar() {
        System.out.println("Dibujando un Círculo... ");
    }
}