/*
 * SERVIDORES
 * Cuando escribimos una dirección de un sitio web en un navegador, se produce
 * una
 * petición al servidor que almacena este sitio. Cuando estamos navegando, en
 * este caso
 * asumimos el papel de usuarios, y notamos que cualquier tarea que realice el
 * servidor
 * es transparente para nosotros. Es decir que en esta arquitectura sólo vemos
 * la capa
 * de presentación, o sea, páginas HTML o JSP.
 * 
 * Los primeros servidores web sólo se encargaban de enviar información al
 * usuario final, cualquier otra información requería algún tipo de
 * configuración especial. La arquitectura mas conocida era de dos capas
 * (Figura 3) y se soportaba sobre el servidor web Apache, con capacidad
 * para ejecutar programas de tipo script escritos en Perl.
 * 
 * [ Servidor Web Apache ] <--- Protocolo HTTP ---> [ Cliente Navagador Web ]
 * Figura 3. Modelo Cliente-Servidor de dos capas.
 * 
 * A medida que las demandas se fueron incrementando, tuvieron que hacer este
 * proceso más eficiente. Por otra parte, además de aumentar la demanda, cada
 * vez requería procesos más complejos. Así fue que después de muchos intentos
 * nacieron los "Application Servers" o Servidores de Aplicaciones. Éstos
 * presentan un modelo de N capas (Figura 4), y se denominan así porque pueden
 * incrementar o disminuir la cantidad de capas de acuerdo a nuestras
 * necesidades.
 * 
 * [ Cliente ] <---> [ Servidor de Aplicaciones ] <---> [ Bases de datos ]
 * [ HTML ] <------> [ Web Container Servlet ] <------> [ Servidor de Correo ]
 * [ XHTML ] <-----> [ Application Container ] <------> [ Otros Servicios ]
 * [ XML ] <-------> ________________________ <-------> ___________________
 * [ Applet ]
 * [ Aplicaciones ]
 * Figura 4. Modelo de N capas de los Application Servers.
 * 
 * Java Application Servers
 * Este tipo de servidores crecieron mucho debido a que ofrecen una manera de
 * integrar casi todas las funcionalidades requeridas por la gran mayoría
 * de los sistemas empresariales; por otra parte, están diseñados sobre el
 * estándar J2EE de SUN.
 * 
 * [ Bases de datos Oracle ] <--- JDBC ---> [ Servlet Engine (Web Container) ]
 * [ Bases de datos Postgres ] <--- JDBC ---> [ Servidor Web ]
 * [ Bases de datos InterBase ] <--- JDBC ---> [ JDK ]
 * [ Aplicaciones (COBOL, C/C++, FORTRAN, etc)] <---> Solicitudes de Internet
 * [ ERP (JDEdwards, TANGO, SAP, etc)] <---> HTTP / HTTPS
 * Figura 5. Arquitectura de un Java Application Server.
 * 
 * Para poder probar nuestros ejemplos, debemos instalar un Web Container
 * con capacidad para ejecutar servlets o un Application Server.
 * 
 * Hay una gran cantidad de servidores gratuitos que podemos bajar directamente
 * desde internet. Los más populares son:
 * 
 * · Apache Tomcat: Tomcat puede ser usado como pequeño servidor para probar
 * páginas JSP y servlets, o puede integrarse en el servidor web Apache.
 * Es muy rápido, de gran rendimiento, pero difícil de configurar e instalar.
 * Podemos obtenerlo en la dirección jakarta.apache.org
 * (Nota: es el que instalé en mi computadora, versión 11,
 * y su URL actual es: https://tomcat.apache.org/ )
 * 
 * · JavaServer Web Development Kit (JSWDK): se usaba como pequeño servidor
 * para probar servlets y páginas JSP antes de desarollar un completo servidor
 * web
 * que soportara estas tecnologías. Es gratuito y potente, pero también difícil
 * de instalar y configurar. Podemos obtenerlo de
 * java.sun.com/products/servlet/download.html
 * (Nota: ya no existe más)
 * 
 * · SUN's Java Web Server: este servidor está escrito en Java, y fue uno
 * de los primeros servidores que soportaron todas las especificaciones
 * servlet 2.1 y JSP 1.0. Podemos obtenerlo en
 * www.sun.com/software/jwebserver/try
 * Para obtener una versión gratuita de propósitos académicos podemos ir a
 * freeware.thesphere.com
 * (Nota: ya no existe más)
 * 
 * NUESTRO PRIMER SERVLET
 * 
 * Lo que vamos a hacer ahora es un servlet que maneje peticiones GET.
 * Estas peticiones GET son hechas por el navegador web cuando el usuario
 * busca una URL en la línea de direcciones, sigue un enlace desde una
 * página web, o llena un formulario que no especifica un METHOD. 
 * Los servlets también pueden manejar peticiones POST que son generadas
 * cuando alguien crea un formulario HTML que especifica METHOD="POST".
 *  
 */

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

/* Extiende a HttpServlet y sobreescribe el método doGet */
public class PrimerServlet extends HttpServlet {
    /* Definimos el contenido para devolver HTML */
    private static final String CONTENT_TYPE = "text/html";

    /* El método init inicializa las variables locales */
    public void init() throws ServletException {
        // nada
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(CONTENT_TYPE);
        /* Tomamos el PrintWriter */
        PrintWriter out = response.getWriter();
        /* Devolvemos una página HTML */
        out.println("<html>");
        out.println("<head><title>Primer Servlet</title></head>");
        out.println("<body>");
        out.println("<p>El servlet recibió un get y ésta es la respuesta</p>");
        out.println("</body></html>");
    }

    /* Libera los recursos usados */
    public void destroy() {
        // nada
    }
}

/*
 * Nota: Parece que Servlet ya no existe más en Java Development Kit 23
 */
/*
 * Note que doGet recibe dos parámetros:
 *
 * · HttpServletRequest: esta clase tiene métodos que nos permiten tomar
 * información entrante como datos de un form, cabeceras de petición HTTP, etc.
 * 
 * · HttpServletResponse: esta clase tiene métodos que nos permiten especificar
 * líneas de respuesta HTTP, cabeceras de respuesta, etc. Nos permite, también,
 * obtener el PrintWriter que usaremos para enviar la salida de vuelta al
 * cliente.
 * 
 * Finalmente, nuetro primer servlet en el navegador web se verá como en la
 * Figura 6: "El servlet recibió un get y ésta es la respuesta"
 */