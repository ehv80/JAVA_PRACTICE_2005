/* Vale la pena aclarar que la dirección 127.0.0.1 es la dirección de loopback;
 * sino tenemos una interfaz de red configurada en nuestra computadora, igualmente
 * poseeremos esta dirección IP. Ahora bien, si sabemos el nombre de host y no conocemos
 * la dirección IP de una PC, podemos usar el método getByName() de la clase InetAddress
 * para crear una instancia de InetAddress de la siguiente manera
 *
 * InteAddress i = InetAddress.getByName("PCSergio");
 * 
 * Si cambiamos la forma de instanciar la clase InetAddress por esta última en el ejemplo PruebaIP.java
 * obtendremos el mismo resultado. 
 * 
 * En este punto debemos tener en cuenta que no hay sólo una dirección IP por PC,
 * sino que tendremos una IP por interfaz de red configurada. Por ejemplo, si disponemos de 
 * dos placas de red, tendremos tres direcciones de IP, una por cada placa más la dirección de loopback.
 * Para obtener todas las IP de una PC, Java nos provee el método getAllByName() de la clase InetAddress.
 * Este método nos devuelve un arreglo de instancias de la clase InetAddress.
 * 
 */

import java.net.*;

public class PruebaArrayDeIP {
    /* Constructor por defecto */
    public PruebaArrayDeIP() {
        try {
            /*
             * Creamos un arreglo de instancias de la clase InetAddress de nombre i usando
             * el método getAllByName()
             */
            InetAddress[] i = InetAddress.getAllByName("LILANDRAX");
            System.out.println("Nombre de la computadora: LILANDRAX");
            /* Imprimimos todas las IP recorriendo el arrelgo */
            for (int j = 0; j < i.length; j++)
                System.out.println("IP " + j + " : " + i[j].getHostAddress());
        } catch (UnknownHostException ex) {
            System.err.println("No se pueden resolver las direcciones IP de la PC!");
            System.err.println("Detalle del error: " + ex.getMessage());
            System.err.println("Detalle de la pila de llamadas: ");
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new PruebaArrayDeIP();
    }
}