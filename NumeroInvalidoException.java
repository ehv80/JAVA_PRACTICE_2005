/* Supongamos ahora que tenemos una Clase cuyo constructor recibe un entero.
 * Si dicho entero está entre 0 y 5, hace lo que necesita con el número; si no,
 * arroja una excepción creada por nosotros. Primero veamos la clase que representa
 * a la excepción
 */
//package pruebas; Comentado para evitar la excepción de Clase no encontrada
public class NumeroInvalidoException extends Exception {
    /* Sobrecargamos el método getmessage() para devolver el mensaje de error */
    public String getMessage() {
        return (" El número es inválido !!! ");
    }
}
/*
 * Dos cosas para tener en cuenta acerca de la creación de excepciones son,
 * por un lado, que el nombre de la clase termina en Exception para respetar la
 * nomenclatura de Java;
 * y por otro, que debemos elegir de qué clase de Exception va a heredar. En
 * este caso,
 * como es una excepción genérica, vamos a hacerla heredar de la clase
 * Exception.
 * Pero, por ejemplo, si queremos representar una excepción de un cálculo
 * matemático,
 * lo correcto sería que heredara de ArithmeticException.
 * Note además que la clase NumeroInvalidoException no tiene constructor.
 */