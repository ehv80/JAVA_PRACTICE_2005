<!--
LISTADO DE LOGS

Para consultar la tabla de logs haremos una página JSP.
Con la información obtenida, la página armará una tabla.
De lo contrario, en caso de no haber información, simplemente
lo notificará. El código de la página JSP será, entonces:
-->
<HTML>

<HEAD>
    <TITLE>Listado de Logs</TITLE>
</HEAD>

<BODY bgcolor="#ffffc0">
    <H1>Listado de Logs</H1>
    <% <!-- Creamos el objeto BaseDeDatos y nos conectamos a la base de datos -->
        BaseDeDatos db = new BaseDeDatos();
        db.conectar();
        <!-- Ejecutamos la consulta -->
        java.sql.ResultSet rs = db.ejecutarSQL("select * from log");
        if(rs.first())
        {
        <!-- Armamos los títulos de la tabla y luego el contenido -->
        out.println("<table border=1 cellspacing=0 cellpadding=0>");
            out.println("<tr>");
                out.println("<td>Fecha</td>");
                out.println("<td>Hora</td>");
                out.println("<td>Mensaje</td>");
                out.println("</tr>");
            out.println("<tr>");
                out.println("<td>rs.getString("fecha")"+"</td>");
                out.println("<td>rs.getString("hora")"+"</td>");
                out.println("<td>rs.getString("mensaje").trim()"+"</td>");
                out.println("</tr>");
            while(rs.next())
            {
            out.println("<tr>");
                out.println("<td>rs.getString("fecha")"+"</td>");
                out.println("<td>rs.getString("hora")"+"</td>");
                out.println("<td>rs.getString("mensaje").trim()"+"</td>");
                out.println("</tr>");
            }
            out.println("</table>")
        }
        else
        out.println("<H2>No se registró actividad...</H2>");
        <!-- Cerramos el cursor y la conexión -->
        rs.close();
        db.cerrar();
        %>
</BODY>

</HTML>