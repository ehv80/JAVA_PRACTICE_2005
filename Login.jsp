<!--
 Ahora crearemos una página web HTML que pida nombre de Usuario
 y contraseña, y establesca el atributo en una nueva sesión
 
-->

<HTML>

<HEAD>
    <TITLE>Login</TITLE>
</HEAD>

<BODY>
    <H1 ALIGN="CENTER">Login</H1>
    <FORM ACTION="servlet/EstableceSesion" METHOD="POST">
        <CENTER>
            Usuario : <INPUT TYPE="TEXT" NAME="usuario"><BR>
            Contraseña : <INPUT TYPE="TEXT" NAME="password"><BR>
            <INPUT TYPE="SUBMIT" Value="Enviar">
        </CENTER>
    </FORM>
</BODY>
<FOOTER>
    Pie de página de Login.jsp
</FOOTER>

</HTML>

<!-- 
En el ACTION del FORM llamamos al Servlet EstableceSesion
cuyo código es el siguiente: 
(Nota: ver el archivo EstableceSesion.java)
-->