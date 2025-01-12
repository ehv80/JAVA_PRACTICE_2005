/*
 * Cabeceras de solicitud HTTP
 * 
 * Para leer las cabeceras de una petición HTTP, por ejemplo de un navegador,
 * lo que hacemos es llamar al método getHeader() de HttpServletRequest.
 * (Nota: ya no existe más en Java Development Kit 23)
 * Éste devuelve un String con la información de la cabecera; en caso de
 * no tener información, devolverá null.
 * Hay algunas cabeceras que se usan con tanta asiduidad, que están
 * representadas
 * por métodos especiales:
 * 
 * · getCookies(): devuelve el contenido de la cabecera Cookie, lo analiza y
 * lo almacena en un array de objetos de tipo Cookie.
 * 
 * · getAuthType() y getRemoteUser(): dividen la cabecera Authorization en sus
 * diferentes componentes.
 * 
 * · getDateHeader(): lee la cabecera específica y la convierte a Date.
 * 
 * · getIntHeader(): lee la cabecera específica y la convierte a int.
 * 
 * · getHeaderNames(): si no sabemos cuál es la cabecera, este método devuelve
 * un Enumeration de todos los nombres de cabecera que tenga la petición.
 * 
 * También tenemos otros métodos que nos brindan más información sobre
 * la petición. Algunos de ellos son:
 * 
 * · getMethod(): devuelve información sobre la línea de petición, es decir,
 * si es GET, POST, HEAD, PUT o DELETE.
 * 
 * · getRequestURI(): devuelve la parte de la URL que viene después del host
 * y antes de los datos del formulario, si es que los hay.
 * 
 * · getRequestProtocol(): devuelve la tercera parte de la línea de petición,
 * que generalmente es "HTTP/1.0" ó "HTTP/1.1"
 * 
 * El siguiente ejemplo consiste en un servlet que muestra el método, la URL,
 * el protocolo y una tabla con todas las cabeceras de la petición:
 */

// package servlets; //comentado para evitar error en tiempo de ejecución
// paquete y clase no encontrados

import java.io.*;
import java.util.*;

import javax.servlet.*; // Ya no existe más en JDK 23
import javax.servlet.http.*;

public class MostrarCabeceras extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html";

    public void init() throws ServletException {
        // nada
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();
        out.println(
                "<HTML>\n" +
                        "<BODY>\n" +
                        "<H1 ALIGN=CENTER>Ejemplo de Cabeceras </H1>\n" +
                        "<B>Método : </B>" + request.getMethod() + "<BR>\n" +
                        "<B>URL : </B>" + request.getRequestURI() + "<BR>\n" +
                        "<B>Protocolo : </B>" + request.getProtocol() + "<BR><BR>\n" +
                        "<TABLE BORDER=1 ALIGN=CENTER>\n" +
                        "<TR>\n" +
                        "<TH>Nombre de la cabecera<TH>Valor");
        /*
         * Solicitamos todas las cabeceras
         */
        Enumeration headersNames = request.getHeadersNames();
        /*
         * Mientras haya cabeceras las leemos y agregamos a la tabla
         */
        while (headersNames.hasMoreElements()) {
            String headerName = (String) headersNames.nextElement();
            out.println("<TR><TD>" + headerName);
            out.println(" <TD>" + request.getHeader(headerName));
        }
        out.println("</TABLE>\n</BODY></HTML>");
    }

    public void destroy() {
        // nada
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
/*
 * Debemos tener en cuenta que la salida varía de acuerdo con el navegador que
 * usemos. La Figura 9 muestra la salida provocada por las peticiones de
 * Internet Explorer 5.5
 * 
 * Hay diversos métodos por los cuáles podemos obtener otros datos;
 * uno de ellos es a través de HttpServletRequest, como por ejemplo
 * la dirección IP del cliente que hizo la petición con el método
 * getRemoteAddr(), el nombre del dominio con getRemoteHost(),
 * el usuario con getRemoteUser(), etc.
 */