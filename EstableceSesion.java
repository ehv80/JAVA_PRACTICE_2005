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
 * 
 * 
 */