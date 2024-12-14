/* Ahora vamos a hacer el método main correspondiente para probar nuestra clase Animal
 * y hacer una carrera entre una Liebre y una Tortuga
 */
public class CarreraDeAnimales {
    public static void main(String[] args) {
        /*
         * Creamos los animales con sus respectivos nombre, tipo, cantidadDePatas,
         * prioridad de ejecución
         */
        Animal tortuga = new Animal("Tortuga", "Reptil", 4, 1);
        Animal liebre = new Animal("Liebre", "Mamífero", 4, 10);
        /* La tortuga largará primero */
        tortuga.start();
        /* Luego largará la liebre */
        liebre.start();
        try {
            tortuga.join();
            liebre.join();
        } catch (InterruptedException ex) {
            System.err.println("Error al largar la carrera de animales y hacer join: " + ex.getMessage());
            System.err.println("Detalle de la pila de llamadas: ");
            ex.printStackTrace();
        }
    }
}