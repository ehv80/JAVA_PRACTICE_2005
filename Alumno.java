/* Uso extends para declarar que la Clase Alumno está heredando de la Clase Persona */
public class Alumno extends Persona {
    /*
     * Declaro ahora los datos de Alumno, note que nombre y dni no las
     * debo declarar porque los heredo desde Persona
     */
    private float notaPrimerParcial;
    private float notaSegundoParcial;

    /* Constructor */
    public Alumno(int codigo, String nombre, float notaPrimero, float notaSegundo) {
        /* Con super hago referencia a la variable nombre de la clase padre Persona */
        super.nombre = nombre;
        /* Como dni es privado, debo acceder a él a través del método setCodigo */
        super.setCodigo(codigo);
        /* Inicializo las variables de Alumno */
        this.notaPrimerParcial = notaPrimero;
        this.notaSegundoParcial = notaSegundo;
    }

    /*
     * Éste método calcula el promedio, note que es privado, por lo tanto no se
     * podrá llamar desde afuera
     */
    private float getPromedio() {
        return ((this.notaPrimerParcial + this.notaSegundoParcial) / 2);
    }

    /*
     * Éste método muestra los datos del Alumno y el Promedio de las notas de los
     * parciales
     */
    public void mostrar() {
        /*
         * Uso mostrar de la superclase Persona y agrego lo que necesito para mostrar lo
         * demás de Alumno
         */
        super.mostrar();
        System.out.println("Nota del Primer Parcial: " + this.notaPrimerParcial);
        System.out.println("Nota del Segundo Parcial: " + this.notaSegundoParcial);
        System.out.println("Promedio de las notas de los parciales: " + this.getPromedio());
    }
}