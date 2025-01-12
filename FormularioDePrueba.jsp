<!-- 
 Ahora, debemos hacer una página HTML o JSP que muestre un formulario: 
 -->
<HTML>

<HEAD>
    <TITLE>Formulario para probar el Servlet MuestraParametros</TITLE>
</HEAD>

<BODY>
    <H1 ALIGN="CENTER">Formulario para probar el Servlet MuestraParametros</H1>
    <FORM ACTION="/servlet/MuestraParametros" METHOD="POST">
        Nombre : <INPUT TYPE="TEXT" NAME="nombre"> <br>
        Edad : <INPUT TYPE="TEXT" NAME="edad"> <br>
        <INPUT TYPE="SUBMIT" VALUE="Enviar">
        </CENTER>
    </FORM>
</BODY>
<FOOTER>Fin de Formulario para probar el Servlet MuestraParametros</FOOTER>

</HTML>