/*
 * Bases de Datos
 * La necesidad de mantener una gran cantidad de datos organizados
 * para poder consultarlos rápidamente dio origen a las bases de datos.
 * Desde Java es posible manejar las bases de datos más populares del mercado,
 * como Access, XBase, Btrieve, Paradox, SQL Server, Oracle, etc.
 * Así que en este capítulo, veremos cómo crear aplicaciones con acceso a bases
 * de datos.
 * 
 * CONECTIVIDAD JDBC
 * Para la conexión a bases de datos vamos a usar la API estandar JDBC (Java
 * Data Base Connectivity).
 * Para aquellos que tengan experiencia con bases de datos en Windows, JDBC es
 * equivalente a ODBC.
 * Este estándar está escrito en Lenguaje de Programación C para Windows, es
 * decir, depende de la plataforma.
 * Por lo tanto, si queremos que nuestra aplicación sea multiplataforma, debemos
 * usar el driver JDBC.
 * 
 * Tipos de drivers JDBC
 * Debemos saber que hay cuatro tipos de drivers JDBC. El primero es el puente
 * JDBC-ODBC,
 * que procesa las llamadas JDBC y las convierte en llamadas ODBC (Figura 1).
 * El problema de este tipo de driver es que depende de las DLLs de ODBC; por
 * ende,
 * los programas que lo usen sólo podrán ejecutarse bajo Windows.
 * 
 * ______________________________ [ Aplicación JAVA ]
 * API JDBC --------------------> [ Driver JDBC ]
 * API ODBC --------------------> [ Driver ODBC ]
 * API DBMS --------------------> [ Biblioteca cliente DBMS ]
 * Protocolo DBMS --------------> |
 * ______________________________ [ Protocolo de DBMS ]
 * ______________________________ [ Motor de DBMS ]
 * Figura 1. Driver JDBC de tipo uno (puente JDBC-ODBC más driver ODBC)
 * 
 * El segundo tipo de drivers son los que efectúan llamadas a la API nativa
 * del motor de base de datos. Parte de ellos está escrita en Java, pero sólo
 * parcialmente en Java, y por eso comparten los problemas de portabilidad
 * del driver de tipo uno puente JDBC-ODBC.
 * 
 * _______________________________ [ Aplicación JAVA ]
 * API JDBC ---------------------> [ Driver JDBC ]
 * API DBMS ---------------------> [ Biblioteca cliente DBMS ]
 * Protocolo DBMS ---------------> |
 * _______________________________ [ Protocolo de DBMS ]
 * _______________________________ [ Motor de DBMS ]
 * Figura 2. Driver JDBC de tipo dos (driver Java parcialmente nativo)
 * 
 * El tercer tipo de drivers (Figura 3.) lo constituyen aquellos que están
 * escritos completamente en Java, y convierten las llamadas JDBC a un protocolo
 * independiente de la base de datos: estas llamadas se transmiten por la red
 * hasta
 * una aplicación servidora que recibe las peticiones y las convierte en
 * llamadas a
 * funciones nativas de la base de datos utilizada. Este tipo de drivers es muy
 * flexible,
 * dado que las aplicaciones cliente son tan portables como lo es Java. Un
 * factor importante
 * para tener en cuenta es que utilizando este tipo de drivers no será necesario
 * configurar la máquina donde corra la aplicación, solamente el servidor.
 * 
 * ________________________________ [ Aplicación JAVA ]
 * API JDBC ----------------------> [ Biblioteca cliente JDBC ]
 * Protocolo JDBC ----------------> |
 * ________________________________ [ Biblioteca servidor JDBC ]
 * API DBMS ----------------------> [ Motor de DBMS ]
 * Figura 3. Driver JDBC de tipo tres (driver Java nativo JDBC-RED).
 * 
 * El cuarto tipo de driver lo constituyen aquellos que están escritos
 * totalmente en Java
 * y convierten todas las llamadas JDBC a llamadas nativas del gestor de bases
 * de datos correspondiente
 * (Figura 4). Las aplicaciones que los utilicen también serán portables.
 * 
 * _________________________________ [ Aplicación JAVA ]
 * API JDBC -----------------------> [ Biblioteca cliente JDBC ]
 * Protocolo DBMS -----------------> |
 * _________________________________ [ Motor de DBMS ]
 * Figura 4. Driver JDBC de tipo cuatro (driver puro java y protocolo nativo).
 * 
 * JDBC versus ODBC
 * El ODBC de Microsoft (Open Data Base Connectivity) es probablemente la API
 * más extendida para el acceso a bases de datos. Ofrece la posibilidad de
 * conectar
 * la mayoría de las bases de datos en casi todas las plataformas. Se puede usar
 * ODBC desde Java, pero es preferible hacerlo con la ayuda de JDBC, mediante el
 * driver JDBC de tipo uno puente JDBC-ODBC. A continuación veremos algunas de
 * las
 * ventajas de la conexión a través de JDBC:
 * 
 * 1. ODBC no es apropiado para uso directo con Java porque usa una interfazz C.
 * Las llamadas desde Java a código nativo C tienen como inconvenientes la
 * seguridad,
 * la implementación, la robustez, y la portabilidad.
 * 
 * 2. Una traducción literal de la API C de ODBC a la API de Java no es
 * deseable.
 * Por ejemplo, Java no tiene punteros, y ODBC hace un uso intensivo de éstos.
 * Se puede pensar en JDBC como un ODBC traducido a una interfaz orientada a
 * objetos,
 * que es el natural para programadores Java.
 * 
 * 3. ODBC es difícil de aprender. Mezcla características simples y avanzadas, y
 * sus
 * opciones son complejas para consultas simples. Por otro lado, JDBC ha sido
 * diseñado
 * para mantener las cosas sencillas, mientras que permite las características
 * avanzadas
 * cuando son necesarias.
 * 
 * 4. Una API Java como JDBC es necesaria cuando hay que producir una solución
 * Java pura.
 * Al usar ODBC, el gestor de drivers de ODBC y los drivers deben instalarse
 * manualmente en
 * cada máquina cliente. Como el driver JDBC está completamente escrito en Java,
 * el código
 * JDBC se instala automáticamente.
 * 
 * Últimamente Microsoft introdujo nuevas APIs como RDO, ADO, y OLE DB. Estos
 * diseños
 * son orientados a objetos, es decir que apuntan a la misma dirección de JDBC.
 * 
 * CONEXIÓN A UNA BASE DE DATOS
 * Para comenzar, debemos conseguir el driver JDBC de la base de datos que vamos
 * a usar.
 * Hoy, todas las bases de datos reconocidas proveen un driver para Java. Por
 * supuesto,
 * en este punto debemos haber elegido un motor de base de datos.
 * 
 * Una vez obtenido el driver, debemos establecer la conexión de nuestro
 * programa con
 * la base de datos. Para establecer una conexión, lo primero que tenemos que
 * hacer es
 * cargar el driver a través del método forName de la clase Class. Este método
 * recibe
 * como parámetro el camino completo de la clase que contiene el driver. Por
 * ejemplo,
 * si vamos a usar InterBase como motor de base de datos la sentencia será:
 * 
 * Class.forName("interbase.interclient.Driver");
 * 
 * En la documentación del driver encontraremos el nombre de la clase que
 * debemos usar.
 * Recordemos que la sentencia anterior arrojará una excepción del tipo
 * ClassNotFoundException,
 * de modo que nos podemos asegurar que la clase esté cargada antes de
 * continuar.
 * 
 * Una vez cargado el driver, establecemos la conexión, la cuál se hará a través
 * de la clase Connection.
 * Ésta es de tipo interfaz, por ende no podemos crear una nueva e instanciarla.
 * Para ello
 * debemos usar la clase DriverManager, por lo que quedará:
 * 
 * Connection con = DriverManager.getConnection(String_de_Conexion, Usuario,
 * Contraseña);
 * 
 * El String o cadena de conexión dependerá de la base de datos; la
 * documentación
 * del driver también nos indicará la forma adecuada de armar esta cadena de
 * conexión.
 * La Figura 5 muestra el estándar propuesto por JDBC. En este punto ya tenemos
 * una conexión
 * establecida con la base de datos.
 * 
 * ________________________ jdbc:<subprotocolo>:<subname>
 * _________________________|_____|_____________|
 * _____ Nombre del protocolo_____|_____________|
 * ______ Nombre del driver. Un ejemplo_________|
 * ______ de subprotocolo es ODBC.______________|
 * ____________________________________________ Nombre que identifica a la base
 * ____________________________________________ de datos.
 * ____________________________________________ El subnombre puede variar
 * ____________________________________________ dependiendo del
 * ____________________________________________ subproducto, y puede tener un
 * ____________________________________________ subnombre con
 * ____________________________________________ cualquier sintaxis interna que
 * ____________________________________________ el fabricante
 * ____________________________________________ del driver haya escogido.
 * Figura 5. Estándar propuesto para las cadenas de conexión
 * (connection string).
 * 
 * Lo único que nos queda por hacer es crear una instancia de la clase Statement
 * (sentencia)
 * para que de esa forma podamos ejecutar sentecias SQL. Para lograr esto
 * usaremos
 * la instancia de la clase Connection llamada con.
 * 
 * Statement stmt = con.createStatement();
 * 
 * Para ejecutar una sentencia SQL vamos a usar los métodos que nos provee el
 * objeto Statement:
 * 
 * executeQuery() nos devuelve una hoja de resultado;
 * 
 * executeUpdate() devuelve un entero que representa la cantidad de filas que
 * fueron afectadas por el SQL en la base de datos, y
 * 
 * executeBatch(), cuya descripción dejaremos para el final del capítulo, cuando
 * veamos transacciones.
 * 
 * NUESTRA PRIMERA CONEXIÓN
 * Vamos a ver un ejemplo de una conexión a una base de datos InterBase 5.0
 * (en mi computadora es Interbase 2020 Developer Edition).
 * Este motor no fue elegido por ser el mejor ni mucho menos, sino, simplemente,
 * porque Borland (ahora la web dice Embarcadero) provee una versión para
 * desarrolladores
 * gratis y está al alcance de todos en Internet. Además, tiene versiones para
 * Windows, Linux y Solaris.
 * Por otra parte, InterBase provee un driver JDBC de tipo 3 y de tipo 4, es
 * decir,
 * que nuestra aplicación será multiplataforma.
 * En este caso, el motor de base de datos está instalado en la PC con la IP
 * 192.168.10.2
 * (En mi computadora la IP es 192.168.1.4)
 * y tiene una base de datos llamada Escuela.
 */

import java.sql.*;

public class PrimerConexion {
    /* Constructor por defecto */
    public PrimerConexion() {
        /*
         * Cargamos la clase del driver JDBC
         */
        try {
            Class.forName("interbase.interclient.Driver");
        } catch (ClassNotFoundException ex) {
            System.err.println("Error al cargar el driver JDBC del motor de base de datos InterBase!");
            System.err.println("Detalles del error: " + ex.getMessage());
            System.err.println("Detalles de la pila de llamadas: ");
            ex.printStackTrace();
        }

        try {
            /*
             * Creamos la conexión al gestor de base de datos InterBase
             */
            Connection con = DriverManager.getConnection(
                    "jdbc:interbase://LILANDRAX/E:/Users/ehv80/Documentos/InterBase/ESCUELA.IB", "SYSDBA",
                    "masterkey");
            /*
             * Creamos una Statement (sentencia SQL)
             */
            Statement stmt = con.createStatement();
            /*
             * Cerramos el Statement y la conexión
             */
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            System.err.println("Error al conectarse a la base de datos Interbase y crear una Statement!");
            System.err.println("Detalles del error: " + ex.getMessage());
            System.err.println("Detalles de la pila de llamadas: ");
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new PrimerConexion();
    }
}