
/* En la Figura 27 vemos como los menús descienden de la clase MenuComponent, a 
 * diferencia del resto de los componente, que descienden de la clase Component.
 * Sin embargo, se comportan de manera similar al resto de los comoponentes Java, 
 * ya que aceptan y manejan eventos de manera similar.
 * Como la jerarquía de composición es tan rígida, construir un menú en Java puede resultar tedioso,
 * pero bastante mecánico. A continuación vamos a crear un menú simple y veremos qué hace cada línea.
 */
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class PruebaMenu extends JFrame {
    JPanel Panel = new JPanel();
    BorderLayout borderLayout1 = new BorderLayout();
    /* Creamos la Barra de Menú (JMenuBar) */
    JMenuBar barraDeMenu = new JMenuBar();
    /* Creamos las opciones del menú (JMenu) */
    JMenu jmOpcion1 = new JMenu();
    JMenu jmOpcion2 = new JMenu();
    /* Creamos los ítems de cada opción (JMenuItem) */
    JMenuItem jmOpcion1A = new JMenuItem();
    JMenuItem jmOpcion2A = new JMenuItem();
    JMenuItem jmOpcion2B = new JMenuItem();

    /* Constructor por defecto */
    public PruebaMenu() {
        super.setTitle("Menú de Java");
        Panel.setLayout(borderLayout1);
        /* Establecemos el texto de cada elemento del menú */
        jmOpcion1.setText("Opción 1");
        jmOpcion2.setText("Opción 2");
        jmOpcion1A.setText("1. Opción A");
        jmOpcion2A.setText("2. Opción A");
        jmOpcion2B.setText("2. Opción B");
        /* Una vez establecido, debemos armar el menú */
        /* A la barra de Menú le agregamos las opciones */
        barraDeMenu.add(jmOpcion1);
        barraDeMenu.add(jmOpcion2);
        /* A las opciones les agregamos los ítems de cada opción */
        jmOpcion1.add(jmOpcion1A);
        jmOpcion1.add(jmOpcion2A);
        jmOpcion2.add(jmOpcion2B);
        /* Una vez armado el menú lo agregamos al frame */
        this.setJMenuBar(barraDeMenu);
        this.getContentPane().add(Panel, BorderLayout.CENTER);
        super.pack();
        super.show();
    }

    public static void main(String[] args) {
        new PruebaMenu();
    }
}