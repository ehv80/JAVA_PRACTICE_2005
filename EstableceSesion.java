/*
 * CÓDIGOS DE ESTADO HTTP
 * 
 * Cuando un servidor web responde a una petición, la respuesta consiste en una
 * línea de estado, algunas cabeceras de respuesta, una línea en blanco, y el
 * documento.
 * La línea de estado indica cuál es la versión de HTTP; incluye un entero que
 * se interpreta como código de estado, y una breve descripción de este código
 * de estado.
 * 
 * A través de los servlets podemos manipular la línea de estado y las cabeceras
 * de respuesta para determinar algunas acciones, como, por ejemplo,
 * reenviar al usuario a otros sitios, indicar que el documento adjunto
 * es una imagen o un archivo, informarle al usuario que se requiere
 * un password para acceder al documento, etc.
 * 
 * El código de estado lo podemos configurar con el método setStatus() de la
 * clase HttpServletResponse. El método recibe un entero como parámetro;
 * en vez de pasarle el número, será más claro usar las constantes
 * definidas en HttpServletResponse. Debemos tener en cuenta que
 * todas estas constantes tendrán el prefijo SC, de Status Code.
 * 
 * A continuación veremos varios códigos de estado:
 * 
 * ESTADO __________ DESCRIPCIÓN __________ SIGNIFICADO
 * 100 _____________ Continue _____________ Continúa con la petición parcial.
 * 101 _____________ Switching Protocols __ El servidor termina con la petición
 * ________________________________________ actual y cambia de protocolo.
 * 200 _____________ OK ___________________ El servidor está bien.
 * 201 _____________ Created ______________ El servidor creó un documento.
 * 202 _____________ Accepted _____________ La petición está en proceso.
 * 203 _____________ Non-Authoritative
 * _________________ Information __________ El documento está siendo devuelto,
 * ________________________________________ pero algunas cabeceras son
 * ________________________________________ incorrectas
 * 204 _____________ No Content ___________ No hay un documento nuevo, sigue
 * ________________________________________ vigente el último.
 * 205 _____________ Reset Content ________ No hay un documento nuevo, pero
 * ________________________________________ el navegador debe hacer refresh
 * ________________________________________ del actual.
 * 304 _____________ Not modified _________ El cliente tiene un documento
 * ________________________________________ en caché y realiza una petición
 * ________________________________________ condicional
 * 400 _____________ Bad Request __________ La sintaxis de la petición está
 * ________________________________________ mal formada.
 * 401 _____________ Unauthorized _________ El cliente intenta entrar en una
 * ________________________________________ página protegida con password.
 * 403 _____________ Forbidden ____________ El recurso no está disponible.
 * 404 _____________ Not Found ____________ No se pudo encontrar el recurso
 * ________________________________________ en la dirección indicada.
 * 405 _____________ Method Not Allowed ___ El Método GET, POST, HEAD, etc
 * ________________________________________ no está permitido.
 * 408 _____________ Request Timeout ______ El cliente tarda demasiado en
 * ________________________________________ enviar la petición.
 * 500 _____________ Internal Server Error_ Es el resultado de servlets que
 * ________________________________________ quedan congelados o devuelven
 * ________________________________________ cabeceras malformadas.
 * 501 _____________ Not Implemented ______ El servidor no puede atender a la
 * ________________________________________ petición del cliente.
 * 503 _____________ Service Unavailable __ El servidor no puede responder
 * ________________________________________ por alguna sobrecarga en el proceso.
 * 
 * Tabla 1. Algunos códigos de estado HTTP.
 * 
 * COOKIES
 * 
 * Las cookies son pequeños trozos de información textual que el servidor
 * web envía al navegador y que el navegador devuelve sin modificar cuando
 * visita más tarde el mismo sitio o dominio.
 * Al dejar que el servidor lea la información enviada previamente al
 * cliente, el sitio puede proporcionar a los visitantes asiduos algunas
 * ventajas, como, por ejemplo, identificar al usuario durante una sesión
 * de compra. Muchas páginas utilizan el "carrito de compras", permitiendo
 * al usuario elegir el artículo y agregarlo al carrito. Como la conexión
 * HTTP se cierra inmediatamente después de enviar cada página, las cookies
 * son una buena solución para mantener la información de los artículos
 * elegidos por el cliente una vez que abandona la página de selección.
 * 
 * Servlet Cookie
 * Para enviar cookies al cliente, deberá crearse un Servlet usando la
 * clase Cookie, la cuál recibe dos parámetros, el nombre y el valor
 * que queremos establecer.
 * 
 * La forma de crearlo es:
 * Cookie c = new Cookie("ID", "25591");
 * 
 * El nombre no podrá tener espacios en blanco ni ninguno de los siguientes
 * caracteres:
 * [ ] ( ) = , " / ? @ : ;
 * 
 * Una vez creada la cookie, para añadirla a la cabecera de la respuesta
 * debemos hacer:
 * response.addCookie(c);
 * 
 * Para leer las cookies que nos envía el cliente, simplemente haremos:
 * request.getCookies();
 * 
 * Este método nos devuelve un array con todas las cookies entrantes.
 * Lo que debemos hacer es recorrer el array hasta que encontremos
 * el nombre de la cookie esperada; obtenemos el nombre con el método
 * getName() de la clase Cookie.
 * El siguiente pretende ser un método genérico para la obtención de
 * valores de un array de cookies, que recibe como parámetros el array
 * de cookies y el nombre de cookie buscado:
 * 
 * public static String getValorDelCookie(Cookie[] cookies, String nombre)
 * {
 * _____for( int i=0; i < cookies.length; i++ )
 * _____{
 * __________Cookie cookie = Cookies[i];
 * __________if(nombre.equals(cookie.getName()) )
 * _______________return (cookie.getValue());
 * _____}
 * _____return(new String("nombre no encontrado"));
 * }
 * 
 * También podemos configurar otras propiedades de las cookies como,
 * por ejemplo, un comentario a través del método setComment(), o
 * el tiempo en segundos que debe pasar hasta que la cookie expire
 * con el método setMaxAge(). Todos estos atributos están especificados
 * en la documentación de Sun de la Clase Cookie.
 * 
 * Seguimiento de Sesión
 * Como vimos, las cookies son inseguras. Imaginemos que el valor
 * especificado en una cookie es el número de tarjeta de crédito:
 * éste estaría viajando por toda la Red.
 * Por otra parte, los navegadores permiten deshabilitar las cookies,
 * es decir, no aceptarlas, de forma tal que nuestras páginas no
 * funcionarían en estos clientes.
 * Para evitar esto, Java provee la API HttpSession. Ésta es una
 * interfaz de alto nivel que nos permitirá mantener información
 * de la sesión de forma bastante sencilla.
 * Para obtener el objeto HttpSession asociado a la petición actual,
 * usamos el método getSession() de la clase HttpServletRequest.
 * Si éste devuelve null, tenemos la posibilidad de crear una
 * nueva sesión, aunque hay una opción que crea una sesión
 * automáticamente si es que no existe. Esta opción consiste en usar
 * el método getSession(), que recibe un boolean, pasándole
 * directamente true:
 * 
 * HttpSession sesion = request.getSession(true);
 * 
 * Los objetos HttpSession residen en el servidor y se asocian
 * de forma automática al cliente a través de un mecanismo similar
 * al de las cookies. Estos objetos de sesión tienen una estructura
 * de datos interna que nos permite almacenar un número de claves y
 * valores asociados. Para obtener el valor de estas claves usaremos
 * el método getAttribute(), y para configurarlo, setAttribute()
 * (estos métodos pertenecen a la versión 2.2; en versiones
 * anteriores los métodos son getValue() y setValue())
 * 
 * A continuación veremos un ejemplo de uso de HttpSession;
 * para ello crearemos una clase Usuario.
 * Ésta tendrá nombre de usuario y contraseña:
 * (Nota: ver el archivo Usuario.java )
 * 
 */
/*
 * Ahora crearemos una página web HTML que pida nombre de Usuario
 * y contraseña, y establesca el atributo en una nueva sesión
 * (Nota: ver el archivo Login.jsp )
 * En el ACTION del FORM llamamos al Servlet EstableceSesion
 * cuyo código es el siguiente:
 * 
 */

//package servlets; //Comentado para evitar error en tiempo
//de ejecución paquete y clase no encontrados

import java.io.*;
import java.util.*;
import javax.servlet.*; //Ya no existe más en JDK 23
import javax.servlet.http.*;// Ya no existe más en JDK 23

public class EstableceSesion extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html";

    public void init() throws ServletException {
        // nada
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Creamos el objeto Usuario */
        Usuario u = new Usuario();
        /* Tomamos los parámetros y configuramos el objeto Usuario */
        u.setNombreUsuario(request.getParameter("usuario"));
        u.setContraseña(request.getParameter("password"));
        /* Tomamos la sesión actual */
        HttpSession sesion = request.getSession(true);
        /* Establecemos la clave usuario con el objeto */
        sesion.setAttribute("usuario", u);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Llamamos a doGet para que establezca la sesión */
        doGet(request, response);
        /* Tomamos la sesion actual */
        HttpSession sesion = request.getSession(true);
        /*
         * De la sesión tomamos el objeto que tiene como clave usuario
         */
        Usuario u = (Usuario) sesion.getAttribute("usuario");
        /* Con los datos del objeto generamos la salida */
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(
                "<HTML>\n" +
                        "<BODY>\n" +
                        "<H1 ALIGN=CENTER> Objeto recuperado de la sesion actual </H1>\n" +
                        "<UL>\n" +
                        "<LI>Usuario : " + u.getNombreUsuario() + "</LI>\n" +
                        "<LI>Password : " + u.getContraseña() + "</LI>\n" +
                        "</UL>\n" +
                        /*
                         * Agregamos los métodos que nos proveen información adicional
                         */
                        "<H1> Información adicional </H1>\n" +
                        "<UL>\n" +
                        "<LI> ID : " + sesion.getId() + "\n" + "</LI>\n" +
                        "<LI> ¿Es nuevo? : " + sesion.IsNew() + "</LI>\n" +
                        "<LI> Tiempo de creación : " + sesion.getCreationTime() +
                        "(" + new Date(sesion.getCreationTime()) + ") \n" + "</LI>\n" +
                        "<LI> Intervalo de interactividad : " + sesion.getMaxInactiveInterval() + "</LI>\n" +
                        "</UL>\n" +
                        "</BODY></HTML>");
    }
}
/*
 * Como vemos el ejemplo es muy trivial, ya que no es necesario
 * establecer una clave de sesión si vamos a usar el objeto
 * en el mismo servlet. Pero a través de él vimos de manera
 * sencilla cómo establecer y recuperar los objetos de sesión.
 * Aunque los datos que establecemos en una sesión son los más
 * importantes, tenemos también otros métodos que nos proveen
 * información muy útil.
 * Algunos de ellos los podemos ver en la Tabla 2:
 * MÉTODO __________ DESCRIPCION
 * getID() _________ Devuelve un identificador único generado para
 * _________________ cada sesión.
 * isNew() _________ Devuelve true si el cliente nunca ha visto
 * _________________ la sesión, normalmente porque acaba de ser
 * _________________ creada. Si la sesión ya existía, devuelve
 * _________________ false.
 * getCreationTime() Devuelve la hora de creación en milisegudos
 * getMaxInactiveInterval() Devuelve la cantidad de tiempo, en
 * _________________ segundos, que la sesión debería seguir sin
 * _________________ accesos antes de ser eliminada. Un valor
 * _________________ negativo indica que la sesión nunca se
 * _________________ debe eliminar.
 * Tabla 2. Otros métodos que nos proporcionan información útil.
 * 
 */