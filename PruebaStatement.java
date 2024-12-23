/*
 * SENTENCIAS SQL (STATEMENT)
 * 
 * Ahora sabemos cómo conectarnos a una base de datos; vamos a empezar a hacer
 * modificaciones sobre ellas a través de sentencias UPDATE, DELETE o INSERT de
 * SQL.
 * Para esto usaremos el método executeUpdate() del objeto de la clase
 * Statement.
 * Este nos devuelve un entero que indica la cantidad de filas de la tabla
 * afectadas por la sentecia SQL. En el siguiente ejemplo vamos a conectarnos
 * a la base de datos Escuela, y en la tabla Alumnos vamos a insertar
 * la información de algunos alumnos; luego borraremos un alumno en particular.
 */

import java.sql.*;

public class PruebaStatement {
    /*
     * Declaramos las variables globales a la clase
     */
    Connection con;
    Statement stmt;
    ResultSet rs;

    /* Constructor por defecto */
    public PruebaStatement() {
        /*
         * Cargamos el driver JDBC para el gestor de base de datos InterBase
         *
         */
        try {
            Class.forName("interbase.interclient.Driver");
        } catch (ClassNotFoundException ex) {
            System.err.println("Error al cargar el driver JDBC para el gestor de base de datos InterBase!");
            System.err.println("Detalles del error: " + ex.getMessage());
            System.err.println("Detalle de la pila de llamadas: ");
            ex.printStackTrace();
        }
        try {
            con = DriverManager.getConnection(
                    "jdbc:interbase://LILANDRAX/E:/Users/ehv80/Documentos/InterBase/ESCUELA.IB", "SYSDBA", "masterkey");
            stmt = con.createStatement();
            /*
             * Suponiendo que la tabla alumnos ya está creada en la base de datos
             * insertamos cuatro alumnos
             */
            stmt.executeQuery("INSERT INTO ALUMNOS VALUES (1, 'Martin')");
            stmt.executeQuery("INSERT INTO ALUMNOS VALUES (2, 'Laura')");
            stmt.executeQuery("INSERT INTO ALUMNOS VALUES (3, 'Karina')");
            stmt.executeQuery("INSERT INTO ALUMNOS VALUES (4, 'Daniel')");
            /*
             * Borramos el alumno cuyo código es 3. En este caso tomamos el valor
             * del resultado en la variable i
             */
            int i = stmt.executeUpdate("DELETE FROM ALUMNOS WHERE COD_ALUMNO=2");
            /*
             * Informamos la cantidad de filas borradas
             */
            System.out.println("Cantidad de filas borradas en la tabla ALUMNOS: " + i);
            /*
             * Cerramos la Statement y la conexión a la base de datos InterBase
             */
            rs = stmt.executeQuery("SELECT * FROM ALUMNOS");
            /*
             * Preguntamos si se pudo mover al primer registro del cursor, de ser verdadero
             * significa que hay registros
             */
            if (rs.first()) {
                System.out.println("Resultado de la consulta SQL por alumnos mayores a 18 años: ");
                /*
                 * Leemos el String nombre
                 */
                System.out.println(rs.getString("nombre"));
                /*
                 * Si se puede mover a la siguiente posición en el cursor significa
                 * que hay más registros resultados de la consulta SQL
                 */
                while (rs.next()) {
                    System.out.println(rs.getString("nombre"));
                }
            }
            /*
             * Cierra la Statement y la conexión a la Base de datos InterBase llamada
             * Escuela
             */
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            System.err.println("No se puede conectar a la base de datos Interbase llamada ESCUELA!");
            System.err.println("Detalles del error: " + ex.getMessage());
            System.err.println("Detalles de la pila de llamadas: ");
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new PruebaStatement();
    }
}
/*
 * LA INTERFAZ ResultSet
 *
 * Para consultar los datos de una base de datos usamos la sentencia SELECT de
 * SQL.
 * Para esto vamos a utilizar una clase del paquete java.sql, la clase
 * ResultSet.
 * Habíamos visto que el método executeQuery() de la clase Statement nos
 * devolvía
 * una hoja de resultado. Bien, esta hoja es simplemente el resultado de la
 * ejecución
 * del SQL, y de ahora en más la llamaremos cursor.
 * 
 * Lo primero que hay que saber es que el cursor tiene tantas posiciones como
 * filas
 * tenga el resultado de la consulta SQL, y dos más que se sitúan antes del la
 * primera fila y
 * después de la última fila. Para mover el cursor a la primera posición
 * usaremos el método first(), y
 * para ir a la última posición, el método last(). Para ir a la posición
 * siguiente utilizaremos
 * el método next(), y para volver una posición, el método previous().
 * Si deseamos movernos a un registro en especial, emplearemos el método
 * absolute(int numero_fila).
 * Todos estos métodos devuelven una variable de tipo boolean; si el valor es
 * true, significa que
 * pudo hacer el traslado en el cursor.
 * 
 * Obtener los datos de un Objeto de tipo ResultSet
 * Para acceder a los datos del cursor podemos usar getTipo(int numeroCampo)
 * o getTipo(String nombreCampo). Según el tipo de campo, el método puede ser
 * getFloat, getString, getDate, etc. Es decir que si tenemos el siguiente SQL:
 * 
 * SELECT nombre FROM alumnos WHERE cod_alumno=1;
 * 
 * Suponiendo que el ResultSet se llame rs, podemos obtener la información del
 * campo
 * nombre a través del método getString() haciendo:
 * 
 * rs.getString("nombre");
 * 
 * O bien:
 * 
 * rs.getString(1);
 * 
 * Antes de continuar, aclaremos que es necesario tener en cuenta que el número
 * de columna
 * se correspondee con el número de columnas del cursor, por lo tanto, será
 * la columna que establecimos en el SELECT.
 * Veamos un ejemplo con la misma base de datos InterBase llamada Escuela usando
 * la tabla
 * Alumnos, para dejar un poco más aclarada esta cuestión. En este caso, vamos a
 * mostrar
 * por pantalla todos los alumnos mayores a 18 años.
 */