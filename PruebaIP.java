/*
 * PROTOCOLO DE RED
 * Aquí hay que tener en cuenta que las computadoras no son las que se
 * comunican,
 * sino los programas. Ellos deben entenderse para poder establecer una
 * comunicación exitosa.
 * Al idioma que utilizan los programas para entenderse se lo denomina
 * protocolo.
 * El protocolo más conocido es el TCP/IP, ya que es el que se utiliza en
 * Internet;
 * otro muy difundido es el UDP (User Datagram Protocol).
 * 
 * Sockets
 * Un socket es simplemente un canal de comunicación. Está compuesto por dos
 * vías,
 * una para enviar mensajes y la otra para recibir respuestas.
 * Para programar sockets, Java usa dentro del paquete java.net dos clases:
 * Socket (cliente) y ServerSocket (servidor), lo que hace a los dos
 * indispensables.
 * El cliente es el que lanza la petición; el servidor espera peticiones y les
 * da una respuesta, es decir, las atiende.
 * Para establecer la comunicación debemos saber exactamente con qué PC nos
 * queremos
 * comunicar, y la identificaremos a través de su dirección de IP.
 * Por otro lado, el servidor que está corriendo en dicha PC nos estará
 * esperando en
 * un puerto especial (Figura 1). Éste se identifica a través de un número que
 * debemos
 * elegir, si es que programamos nosotros el servidor. Usualmente elegimos
 * un número alto para asegurarnos de que el puerto elegido no tenga conflictos
 * con alguna aplicación estándar. Los puertos reservados por estas
 * aplicaciones, por ejemplo
 * telnet, ftp, http, o smtp van de 0 a 1023. Por lo tanto debemos asegurarnos
 * de elegir un número de puerto mayor a 1023
 * Clientes ________________ Servidor
 * [ Aplicación ] <--------> [puerto] Protocolos TCP o UDP
 * [ Aplicación ] <--------> [puerto]
 * [ Aplicación ] <--------> [puerto]
 * [ Aplicación ] <--------> [puerto]
 * Figura 1. Las aplicaciones se comunican con el Servidor a través de puertos
 * 
 * TCP versus UDP
 * UDP (User Datagram Protocol) se trata de un servicio de transporte no
 * orientado
 * a la conexión. Es más eficiente que TCP (Transmission Control Protocol), pero
 * su
 * fiabilidad no está garantizada. Los datos se envían y se reciben en paquetes
 * cuya entrega no está asegurada. Los paquetes pueden ser duplicados, pueden
 * perderse o llegar en un orden diferente de aquel con que se enviaron.
 * El protocolo de comunicaciones con datagramas UDP es un protocolo sin conexión.
 * Esto significa que cada vez que se envíen los datagramas, es imprescindible enviar
 * el descriptor del socket local y la dirección del socket que debe recibir el datagrama.
 * Como se puede observar, es necesario que se envíen datos adicionales cada vez que se
 * realice una comunicación.
 * En cambio, TCP está orientado a la conexión donde los datos se transfieren sin estar en registros o bloques.
 * Si se rompe la conexión entre los procesos, éstos serán informados. El protocolo de comunicaciones con streams
 * es un protocolo orientado a conexión, ya que para establecer una comunicación utiliza el protocolo TCP.
 * Otra gran diferencia es que en UDP hay un límite de tamaño de los datagramas, establecido en 64 kilobytes, 
 * mientras que TCP no tiene límite.
 * 
 * CLASE InetAddress
 * Esta clase sencillamente representa una dirección de IP (Internet Protocol). Esta dirección es la que
 * identifica unívocamente a una PC dentro de una red. Esta clase es de tipo final, por lo tanto no podemos
 * crear un objeto que haga referencia a la clase. Para crear una instancia de esta clase, podemos hacerlo
 * a través de getLocalHost(), getByName() o getAllByName().
 * En este primer ejemplo vamos a crear una instancia y, a continuación, imprimir la dirección IP de la máquina local. 
 */

import java.net.*;

public class PruebaIP {
    /* Constructor por defecto */
    public PruebaIP() {
        try {
            /*
             * Creamos una instancia de nombre i usando el método getLocalHost() de la clase
             * InetAddress
             */
            InetAddress i = InetAddress.getLocalHost();
            System.out.println("La I.P. es: " + i.getHostAddress());
            System.out.println("El host es: " + i.getHostName());
        } catch (UnknownHostException ex) {
            System.err.println("No se puede resolver la I.P.");
            System.err.println("Detalles del error: " + ex.getMessage());
            System.err.println("Detalle de la pila de llamadas: ");
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new PruebaIP();
    }
}