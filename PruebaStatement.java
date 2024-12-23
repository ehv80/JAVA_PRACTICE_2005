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