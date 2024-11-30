
/* Aplicaciones de escritorio: primer ventana */
/* El contenedor de componentes es el Frame; esta clase está escrita en código nativo,
 * es decir que con sólo instanciarla tendremos una ventanta con las mismas propiedades de las otras ventanas,
 * según la plataforma.
 * Vamos a crear una clase que muestre una ventana. Para esto podemos usar Frame del paquete java.awt o
 * JFrame del paquete javax.swing. Cabe agregar que los contenedores y componentes que tengamos en AWT 
 * los encontraremos en Swing con el prefijo J en el nombre; es decir, si tenemos Button en el paquete java.awt,
 * en el paquete javax.swing tendremos JButton.
 * El código de la ventana será:
 */
import javax.swing.*;

public class Ventana extends JFrame {
    /* Constructor por defecto */
    public Ventana() {
        super("Nuestra Primer Ventana en Java!");
        super.pack();
        super.show();
    }

    public static void main(String[] args) {
        new Ventana();
    }
}