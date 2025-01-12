/*
 * Nota: Parece que Servlet ya no existe más en Java Development Kit 23
 */
/*
 * Servlet y JSP
 * 
 * A continuación combinaremos servlets y JSP para manejar datos de un
 * formulario.
 * A tal efecto, vamos a leer dos parámetros y mostrarlos en otra página.
 * El código del servlet que muestra los parámetros será:
 */

/*
 * Creamos el paquete servlet 
 * Nota: comentado para evitar errores en tiempo de ejecución 
 * Paquete y clase no encontrados
 */
//package servlets;

import java.io.*;
import java.util.*;
import javax.servlet.*; // ya no existe más en JDK 23
import javax.servlet.http.*; // ya no existe más en JDK 23

public class MuestraParametros extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html";

    public void init() throws ServletException {
        // nada
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
         * Podemos tomar los parámetros en Java para hacer lo que deseamos,
         * en este caso crear una página HTML
         */
        response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();
        out.println(
                "<HTML>\n" +
                        "<BODY>\n" +
                        "<H1 ALIGN=CENTER>Parámetros leídos </H1>\n" +
                        "<UL>\n" +
                        "<LI>Nombre : " +
                        request.getParameter("nombre") + "\n" +
                        "</LI>" +
                        "<LI>Edad : " +
                        request.getParameter("edad") + "\n" +
                        "</LI>" +
                        "</UL>\n" +
                        "</BODY></HTML>");
    }

    public void destroy() {
        // nada
    }

    public void doPost(HttpServletRequet request, HttpServletResponse response) throws ServletException, IOException {
        /*
         * El Action de HTML llamará a doPost y éste a doGet
         * para tomar los parámetros y crear un nuevo HTML
         */
        doGet(request, response);
    }
}
/*
 * Simplemente llamaremos al método getParameter() de HttpServletRequest,
 * (Nota: ya no existe más en JDK 23)
 * y pediremos el parámetro como argumento teniendo en cuenta que los nombres
 * de parámetros son sensibles a las mayúsculas. El valor de retorno es un
 * String correspondiente al valor uudecode de la primera ocurrencia del
 * parámetro. Devuelve un String vacío si el parámetro existe, pero no tiene
 * valor o null si no existe dicho parámetro.
 * Si el parámetro tuviera más de un valor, deberíamos llamar al método
 * getParameterValues() en lugar de a getParameter(), ya que éste devuelve
 * un array de String.
 * Finalmente, la Figura 7 muestra el formulario, y la Figura 8,
 * el resultado del servlet.
 */