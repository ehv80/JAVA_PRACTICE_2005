/* Ahora vamos a implementar, en forma sencilla, la clase Persona y,
 * a partir de ella, la clase Alumno, para ejemplificar la Teoría de la Herencia Simple en Java
 */
public class Persona {
    /*
     * Note la declaración de las variables
     * dni es private
     * y
     * nombre protected
     */
    private int codigo;
    protected String nombre;

    /* En el Constructor por defecto no hago nada */
    public Persona() {

    }

    /*
     * Necesito dos métodos (get y set) para poner y sacar el valor del dni ya que
     * éste es privado
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return (this.codigo);
    }

    /* Por prolijidad también agrego los métodos para poner y acceder al nombre */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return (this.nombre);
    }

    /* Éste método muestra los datos de la Persona */
    public void mostrar() {
        System.out.println("Código de DNI: " + this.codigo);
        System.out.println("Nombre: " + this.nombre);
    }
}