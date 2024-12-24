import java.util.*;
import java.sql.*;

/* Uso extends para declarar que la Clase Alumno está heredando de la Clase Persona */
public class Alumno extends Persona {
    /*
     * Declaro ahora los datos de Alumno, note que nombre y dni no las
     * debo declarar porque los heredo desde Persona
     */
    private Integer ID_ALumno;
    private java.sql.Date fechaNacimiento;
    private Notas notas;
    private Direccion direccion;
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

    /*
     * Recibimos el Statement como parámetro para no hacer la conexión
     * dentro del método
     */
    public boolean buscar(Integer ID_ALumno, Statement stmt) throws Exception {
        boolean encontrado = false;
        /*
         * Ejecutamos la sentencia SQL para consultar por el código de alumno
         */
        ResultSet rs = stmt.executeQuery("SELECT * FROM ALUMNOS WHERE COD_ALUMNO='" + ID_ALumno + "'");
        if (rs.first()) {
            /*
             * Si hay resultado, instanciamos los atributos de la clase
             * con los valores de la base de datos
             */
            this.ID_ALumno = new Integer(rs.getInt("cod_alumno"));
            super.nombre = rs.getString("nombre");
            this.fechaNacimiento = rs.getDate("fecha_nacimiento");
            /*
             * Como Dirección es un objeto, usamos su propio método buscar()
             * pasándole como parámeto el código de dirección de la base de datos
             */
            this.direccion.buscar(rs.getInt("cod_direccion"));
            /*
             * Con Notas hacemos los mismo pero el código de la tabla notas
             * es el código de alumno
             */
            super.nombre.buscar(ID_ALumno);
            /*
             * Finalmente, como fue encontrado ponemos esta variable a true
             */
            encontrado = true;
        }
        /*
         * Devolvemos encontrado
         */
        return (encontrado);
    }
}
/*
 * ARQUITECTURA DE UNA APLICACIÓN
 * Lo que necesitamos hacer ahora es escribir los objetos de forma tal que
 * representen la base de datos, ya que vamos a acceder a datos a través
 * de los objetos de nuestro sistema. Para esto debemos valernos de la
 * teoría de objetos y la de base de datos en conjunto, para saber cómo
 * representar cada caso de la mejor forma posible.
 * Volviendo a nuestro ejemplo de la Base de Datos InterBase llamada Escuela,
 * sabemos que tenemos la tabla Alumnos.
 * 
 * NOMBRE DEL CAMPO ___________ TIPO DE DATO
 * COD_ALUMNO _________________ Numeric
 * NOMBRE _____________________ Char(30)
 * FECHA_NACIMIENTO ___________ Date
 * COD_DIRECCION ______________ Numeric
 * Tabla 2. Tabla Alumnos con los datos de los Alumnos de la Base de Datos
 * Escuela.
 * 
 * Entonces comenzando con los campos propios de la tabla
 * y dejando a un lado las claves foráneas, nuestro objeto de la clase Alumno
 * estará definido de la siguiente manera:
 */
/*
 * Entonces, el objeto de la clase Alumno, ahora sí completo quedará:
 * (agregándole un objeto de la clase Direccion y un objeto de la clase Notas)
 */
/*
 * Ahora definiremos los métodos que interactúan con la base de datos.
 * A estos métodos los llamaremos buscar(), grabar(), borrar(), etc, y en ellos
 * representaremos las acciones que necesitemos que el objeto haga
 * sobre la base de datos.
 * Haremos el método buscar() de la clase Alumno, que recibe como parámetro
 * el código de alumno y devuelve un boolean; si este boolean es true,
 * significa que el alumno fue encontrado. Por otro lado, el método lanzará
 * las excepciones para tratarlas en la interfaz y no en el objeto.
 */