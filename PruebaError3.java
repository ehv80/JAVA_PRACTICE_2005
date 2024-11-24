/* Ahora veamos algunas excepciones que nos obliga a capturar.
 * A tal efecto, supongamos el siguiente programa
 */
//package pruebas; Comentado para evitar excepción de clase no encontrada
public class PruebaError3 {
    /* Constructor por defecto no hago nada */
    public PruebaError3() {

    }

    public static void main(String[] args) {
        byte b[] = new byte[256];
        System.in.read();
    }
}