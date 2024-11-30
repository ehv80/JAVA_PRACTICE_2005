
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
import java.awt.*;
import javax.swing.*;

public class Ventana extends JFrame {
    /*
     * Debemos tener en cuenta que JFrame puede tener contenedores de nivel
     * superior.
     * Algunos de estos contenedores son:
     * JPanel Panel Vacío
     * JTabbedPane Panel con lengüetas
     * JScrollPane Panel con barras de desplazamientos horizontal y vertical
     * JSplitPane Divide la ventana en dos paneles horizontales o verticales
     * JMenuBar Menú Horizontal
     * JPopupMenu Menú tipo de pop-up
     * Lo que usaremos ahora es JPanel. Así tendremos la ventana vacía, lista para
     * agregarle componentes.
     * Primero debemos declarar el panel como atributo de clase:
     */
    JPanel PanelPrincipal = new JPanel();

    /* Constructor por defecto */
    public Ventana() {
        super("Nuestra Primer Ventana en Java!");
        /* Definimos el tamaño del JPanel de 300 x 250 píxeles */
        PanelPrincipal.setPreferredSize(new Dimension(300, 250));
        /*
         * Agregamos el JPanel a la ventana. Para agregar un panel, el método add()
         * recibe dos parámtetros:
         * uno es el panel, y el otro es el BorderLayout.NORTH
         * Los paneles en Java tienen distintas disposiciones de componentes dentro del
         * contenedor; estas
         * disposiciones se llaman layout, y antes de continuar veremos de qué se trata
         * este tipo de disposiciones.
         */
        this.getContentPane().add(PanelPrincipal, BorderLayout.NORTH);
        super.pack();
        super.show();
    }

    public static void main(String[] args) {
        new Ventana();
    }
}