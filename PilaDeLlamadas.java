/* La pila de llamadas es un arreglo que crea el intérprete de Java en tiempo de ejecución
 * para saber en todo momento quién llamó a quién. Esto le sirve al programador para
 * saber dónde tiene que seguir ejecutando cuando termina un bloque de ejecución.
 * Veamos el siguiente ejemplo para ver el método armado.
 */
public class PilaDeLlamadas {
    /* Constructor por defecto */
    public PilaDeLlamadas() {
        this.primerMetodo();
    }

    public void primerMetodo() {
        this.segundoMetodo();
    }

    public void segundoMetodo() {
        this.tercerMetodo();
    }

    public void tercerMetodo() {
        int a = 1 / 0;
    }

    public static void main(String[] args) {
        new PilaDeLlamadas();
    }
}