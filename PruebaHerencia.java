/* Finalmente, para probar el ejemplo hacemos la clase PruebaHerencia, que 
 * instancia un Alumno y una Persona
 */
public class PruebaHerencia {
    /* Constructor por defecto no hago nada */
    public PruebaHerencia() {

    }

    public static void main(String[] args) {
        /* Creo una instancia de Alumno y la referencio con la variable a */
        Alumno a = new Alumno(1, "Pedro", 10, 5);
        System.out.println("---- Alumno ----");
        /* Hace referencia al método mostrar de alumno */
        a.mostrar();
        /*
         * Vea que puedo llamar al método getNombre con la instancia de Alumno
         * porque el método fue heredado de Persona
         */
        System.out.println("El alumno es: " + a.getNombre());
        /*
         * Vea también que puedo instanciar una Persona y usarla sin problemas
         */
        System.out.println("---- Persona ----");
        Persona p = new Persona();
        p.setNombre("Juan");
        p.setCodigo(10);
        /* Hace referencia al método mostrar de la clase Persona */
        p.mostrar();
    }
}