/*
 * Un Chat Con Java
 *
 * En este Apéndice B vamos a hacer
 * una aplicación integrando todo lo que
 * hemos aprendido a lo largo del libro.
 * A tal efecto, vamos a desarrollar un chat,
 * es decir, las partes servidor y cliente.
 * Como veremos, para las pantallas
 * usaremos Swing; para registrar el log, 
 * JDBC; para la comunicación, sockets, etc.
 * 
 * BASE DE DATOS
 * 
 * Toda la información que genere el servidor durante su ejecución 
 * la almacenaremos en una base de datos. En este caso, el motor
 * elegido es SQL Server y para establecer la conexión usaremos
 * el puente JDBC-ODBC a través de un DNS de Windows. 
 * Lo primero que haremos será crear la tabla llamada log:
 * 
 * NOMBRE DEL CAMPO _________ TIPO DE DATO ________ LONGITUD
 * Fecha ____________________ Char ________________ 15 
 * Hora _____________________ Char ________________ 15 
 * Mensaje __________________ Char ________________ 300
 * Tabla 1. Datos de la tabla log.
 * 
 * SENTENCIA SQL:
 * CREATE TABLE LOG (
 *   ID int not Null,
 *   FECHA varchar(15),
 *   HORA varchar(15),
 *   MENSAJE varchar(300),
 *   CONSTRAINT PK_LOG PRIMARY KEY (ID)
 * )
 * 
 * Para evitar problemas, en caso de que deseemos usar otro motor de base de datos,
 * definimos todos los tipos de datos como char, de forma tal que evitamos tener
 * que cambiar la clase. Finalmente, la clase Base de Datos será: 
 * 
 */

/*
 * Creamos el paquete chat para poner todas
 * las clases de la aplicación
 * Nota: Comentado para evitar errores en
 * tiempo de ejecución paquete y clase 
 * no encontrados
 */
//package chat;

import java.sql.*;
import java.text.*;

public class BaseDeDatos
{
    Connection con = null;
    Statement stmt = null;
    int indice = 0;

    /*
     * Constructor por defecto
     */
    public BaseDeDatos()
    {
        // nada
    }

    /*
     * El método conectar va a establecer la conexión con la base de datos
     */
    public void conectar() throws Exception
    {
        /* Usamos el puente JDBC-ODBC */
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        /* Creamos un DNS en Windows de Nombre chat */
        con = DriverManager.getConnection("jdbc:odbc:chat", "sa", "sysadmin");
        /* Creamos el statement */
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    }

    /*
     * El método grabar se encargará de grabar la información
     * en la tabla log
     */
    public void grabar(String msg) throws Exception
    {
        /* Tomamos la fecha del sistema */
        DateFormat formatoFecha = new java.text.SimpleDateFormat("dd/MM/yyyy");
        java.util.Date fechaDeSistema = new java.util.Date();
        /* Tomamos la hora del sistema */
        DateFormat formatoHora = new java.text.SimpleDateFormat("HH:mm:ss");
        java.util.Date horaDeSistema = new java.util.Date();
        /* Grabamos el log */
        stmt.executeUpdate("insert into log values(" + this.indice +  ",\""; + formatoFecha.format(fechaDeSistema) + "\"," + formatoHora.format(horaDeSistema) + "\"," + msg + "\")");
        this.indice++;
    }
    /*
     * Cierra la conexión a la base de datos
     */
    public void cerrar() throws Exception
    {
        stmt.close();
        con.close();
    }

    /* Este método nos permite ejecutar consultas en la base de datos */
    public ResultSet ejecutarSQL(String sql) throws Exception
    {
        return (this.stmt.executeQuery(sql));
    }
}
