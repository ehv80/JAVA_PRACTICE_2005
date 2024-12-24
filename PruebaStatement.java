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
/*
 * PROCESO POR LOTES (BATCH)
 *
 * En algunos casos vamos a necesitar hacer una serie de actualizaciones en
 * conjunto, es decir, ejecutar un lote de consultas SQL; para esto se usa
 * el método executeBatch() de la clase Statement.
 * Supongamos que, volviendo al ejemplo de la base de datos Escuela,
 * necesitamos actualizar dos notas y el promedio entre ellas. En este caso
 * tendremos dos sentencias de SQL para actualizar las notas,
 * y una tercera para actualizar el promedio
 * entre ambas notas. Una vez establecida la conexión
 * y creado el Statement, el código sería el siguiente:
 * 
 * stmt.addBatch("UPDATE NOTAS SET PRIMER_NOTA=6 WHERE COD_ALUMNO=1");
 * stmt.addBatch("UPDATE NOTAS SET SEGUNDA_NOTA=8 WHERE COD_ALUMNO=1");
 * stmt.
 * addBatch("UPDATE NOTAS SET PROMEDIO=(PRIMER_NOTA+SEGUNDA_NOTA)/2 WHERE COD_ALUMNO=1"
 * );
 * int[] vFilasAfectadas = stmt.executeBatch();
 * 
 * Como vemos, debemos ir agregando las sentencias de SQL a través del método
 * addBatch().
 * Una vez que terminamos de agregar las sentencias, las ejecutamos con el
 * método executeBatch(). Este método nos devuelve un arreglo de enteros,
 * cada uno de los cuáles se corresponde con la cantidad de filas afectadas
 * por cada SQL. En nuestro caso, el arreglo tendrá tres posiciones,
 * este será [1, 1, 1], o sea que cada SQL habrá afectado a una sola fila
 * de la tabla notas.
 * Si sumamos el vector, el resultado es la cantidad de filas afectadas
 * por el proceso por lotes completo.
 * 
 * Transacciones
 * En el caso anterior, hay que analizar que pasaría si en medio de
 * la ejecución del proceso por lotes sucediera algo extraordinario,
 * es decir, un corte de luz, se cayera el motor de base de datos,
 * se cortara la ejecución del programa, etc. Lo más probable sería
 * que la actualización quedara a medio hacer. En este ejemplo, los
 * daños no son tan graves, pero ¿qué pasaría si en el sistema
 * de un banco estuviéramos procesando una transacción bancaria
 * entre dos cuentas? Supongamos ahora que queremos transferir
 * $5000 de la cuenta 5 a la cuenta 15, y nuestro proceso se corta
 * en el medio.
 * 
 * stmt.addBatch("UPDATE CUENTAS SET EFECTIVO=EFECTIVO-5000 WHERE COD_CUENTA=5"
 * );
 * stmt.addBatch("UPDATE CUENTAS SET EFECTIVO=EFECTIVO+5000 WHERE COD_CUENTA=15"
 * );
 * int[] vFilasAfectadas = stmt.executeBatch();
 * 
 * Si el proceso se corta en la mitad, habiendo debitado $5000 de la cuenta 5,
 * nunca los acreditará en la cuenta 15, es decir que los $5000 no están en
 * ningún lugar. Éste es un problema que se produce cuando las bases de datos
 * son "No Transaccionales"; en otras palabras, ejecutan las sentencias SQL
 * una por una y van reflejando el resultado sobre la base de datos.
 * Para evitar esto debemos configurar la base de datos como "Transaccional",
 * es decir, que ejecute un conjunto de sentencias SQL y refleje el resultado
 * sólo al final de la transacción (Figura 6). Antes de empezar con un ejemplo,
 * debemos tener en cuenta que la base de datos no sabe cuándo comienza una
 * transacción. Para indicarle a la base de datos lo que queremos que ejecute
 * como una transacción, debemos encerrar el bloque de sentencias SQL entre
 * un BEGIN y un COMMIT.
 * 
 * No Transacciona ___________________________ Transacciona
 * Sentencia SQL 1 ___________________________ BEGIN
 * Sentencia SQL 2 ___________________________ Sentencia SQL 1
 * Sentencia SQL 3 ___________________________ Sentencia SQL 2
 * . _________________________________________ Sentencia SQL 3
 * Error _____________________________________ Error
 * Sentencia SQL 4 ___________________________ Sentencia SQL 4
 * . _________________________________________ COMMIT
 * Las sentencias SQL ________________________ Los SQL no será permanentes
 * 1, 2, 3 son permanentes ___________________ si no llegó al COMMIT.
 * 
 * Figura 6. En una base de datos no transaccional, cuando se provoca
 * un error los SQL ejecutados son permanentes; en una base de datos
 * transaccional se "deshacen" hasta el último BEGIN, lo que se conoce
 * como rollback.
 * 
 * Entonces, para configurar la base de datos como "Transaccional",
 * lo que tenemos que hacer es pedirle que no encierre automáticamente
 * a cada sentencia SQL entre un BEGIN y un COMMIT, ya que en ese caso
 * seguiría siendo "No Transaccional". Para pedirle esto a la base de datos
 * usamos el método setAutoCommit() de la clase Connection.
 * Entonces volviendo al ejemplo de la transacción bancaria, el código
 * sería:
 * 
 * //Ponemos a la base de datos como "Transaccional"
 * con.setAutoCommit(false);
 * //Enviamos el BEGIN para comenzar la transacción
 * stmt.addBatch("BEGIN");
 * stmt.addBatch("UPDATE CUENTAS SET EFECTIVO=EFECTIVO-5000 WHERE COD_CUENTA=5"
 * );
 * stmt.addBatch("UPDATE CUENTAS SET EFECTIVO=EFECTIVO+5000 WHERE COD_CUENTA=15"
 * );
 * //Enviamos el COMMIT para terminar la transacción
 * stmt.addBatch("COMMIT");
 * int[] vFilasAfectadas = stmt.executeBatch();
 * 
 * Ahora sí, nos aseguramos de que si la transacción no se ejecutó completa,
 * abortamos todo lo que había hecho. Esto se conoce como rollback
 * (volver atrás). En algunos casos podemos usar el rollback para cancelar
 * una transacción si no se cumple alguna condición. Por ejemplo, en un
 * sistema de facturación grabamos la factura y deseamos que termine
 * si se imprimió la factura; de lo contrario, que aborte. Como vemos,
 * en este caso no es por error o algo extraordinario, y sin embargo,
 * necesitamos hacer un rollback.
 * 
 * Problemas de las bases de datos transaccionales
 * Una vez que configuramos la base de datos transaccional, debemos
 * saber que estará operando de forma concurrente, es decir, antes
 * atendía una sentencia SQL por vez, pero ahora, un conjunto de
 * sentencias SQL puede ser atendido como una transacción, o
 * sea que la base de datos está trabajando de forma concurrente.
 * El conflicto surge cuando dos transacciones están trabajando
 * en conjunto sobre la base de datos. El problema que se presenta
 * es conocido como "dirty read" o lectura sucia.
 * 
 * Supongamos el siguiente caso. En un banco hay una tabla llamada Cuentas
 * que mantiene las cuentas de todos sus clientes; esta tiene los campos
 * código de cuenta y saldo, e inicialmente posee la información
 * de dos cuentas (Figura 7).
 * 
 * Tabla Cuentas
 * COD_CUENTA _______ SALDO
 * 1 ________________ 1.5000,00
 * 2 ________________ 600,00
 * Figura 7. Tabla Cuentas con la información inicial.
 * 
 * Continuando con el ejemplo, la persona cuya cuenta en un banco es la
 * número 2 ordena un pago de 100 pesos desde su cuenta a la cuenta número 1.
 * lo que genera la transacción A:
 * 
 * BEGIN
 * UPDATE CUENTAS SET SALDO=SALDO+100 WHERE COD_CUENTA=1;
 * UPDATE CUENTAS SET SALDO=SALDO-100 WHERE COD_CUENTA=2;
 * COMMIT
 * 
 * Al mismo tiempo, la persona cuya cuenta es la número 2
 * está retirando 80 pesos en un cajero automático, lo que
 * generará la transacción B:
 * 
 * BEGIN
 * UPDATE CUENTAS SET SALDO=SALDO-80 WHERE COD_CUENTA=2
 * COMMIT
 * 
 * Si todo se ejecuta correctamente, la información
 * final de la tabla CUENTAS debería quedar como se ve
 * en la Figura 8:
 * 
 * Tabla Cuentas
 * COD_CUENTA _______ SALDO
 * 1 ________________ 1.6000,00
 * 2 ________________ 420,00
 * Figura 8. Tabla CUENTAS con la información final,
 * si todo se ejecutó correctamente.
 * 
 * Pero ya dijimos que las transacciones son concurrentes.
 * ¿Qué pasa si entra la transacción A y se ejecuta el primer
 * SQL, luego entra la transacción B y ejecuta su SQL,
 * luego la transacción A ejecuta el último SQL y el COMMIT,
 * y a continuación la transacción B ejecuta el COMMIT? (Figura 9)
 * 
 * Transacción A: BEGIN
 * Transacción A: UPDATE CUENTAS SET SALDO=SALDO+100 WHERE COD_CUENTA=1;
 * Transacción B: UPDATE CUENTAS SET SALDO=SALDO-80 WHERE COD_CUENTA=2;
 * Transacción A: UPDATE CUENTAS SET SALDO=SALDO-100 WHERE COD_CUENTA=2;
 * Transacción A: COMMIT
 * Transacción B: COMMIT
 * Figura 9. Transacciones concurrentes
 * 
 * En este caso, el primer SQL de la transacción A hace SALDO=SALDO+100,
 * es decir que lee 1.500,00 y le suma 100, por lo que quedan 1.600,00
 * en la cuenta 1; pero todavía no se escribe en la base de datos,
 * ya que aún no ejecutó el COMMIT. Ahora viene el SQL de la transacción B,
 * que hace SALDO=SALDO-80; en esta caso lee 600,00 y le resta 80,00
 * por lo que quedan 520,00 en la cuenta 2. A continuación la transacción A
 * ejecuta un SQL sobre la cuenta 2, y resta 100, pero este SQL no trae
 * ningún problema aparejado lee 600 y le resta 100, ya que aún no se ejecutó
 * el COMMIT. Finalmente, la transacción A ejecuta su COMMIT dejando
 * en 1600,00 en el SALDO de la cuenta 1, pero la transacción B
 * también ejecuta su COMMIT dejando 500 en la cuenta 2, por lo que
 * finalmente la tabla CUENTAS queda como se muestra en la Figura 9.
 * 
 * Tabla Cuentas
 * COD_CUENTA _______ SALDO
 * 1 ________________ 1.6000,00
 * 2 ________________ 500,00
 * Figura 9. Tabla CUENTAS con la información final,
 * cuando hay transacciones A y B concurrentes con una lectura sucia.
 * 
 * Se puede evitar que un valor sea leído antes de un COMMIT con los niveles
 * de aislamiento, a través del método setTransactionIsolation()
 * del objeto de la clase Connection:
 * 
 * con.setTransactionIsolation(TRANSACTION_READ_UNCOMMITED);
 * 
 * En JDBC contamos con cinco niveles de aislamiento.
 * El nivel más bajo es para que no soporte transacciones, y el más alto,
 * para que, mientras una transacción esté abierta, ninguna otra transacción
 * pueda realizar cambios en los datos leídos por esa transacción.
 * El nivel más alto es más lento en la ejecución de la aplicación,
 * ya que se incrementan los bloqueos y se disminuye la concurrencia
 * de los usuarios. Pero a pesar de tener el método el nivel de
 * aislamiento que pueda soportarse, depende de las posibilidades
 * de la base de datos que estemos usando
 */