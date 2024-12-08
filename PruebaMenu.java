
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

/* Intentaremos usar nombres que nos permitan identificar cada elemento */

public class PruebaMenu extends JFrame {
    JPanel Panel = new JPanel();
    BorderLayout borderLayout1 = new BorderLayout();
    /* Creamos la Barra de Menú (JMenuBar) */
    JMenuBar barraDeMenu = new JMenuBar();
    /* Creamos las opciones del menú (JMenu) */
    JMenu jmOpcion1 = new JMenu();
    JMenu jmOpcion2 = new JMenu();
    JMenu jmOpcion3 = new JMenu();
    JMenu jmOpcion11 = new JMenu();
    JMenu jmOpcion12 = new JMenu();
    /* Creamos los ítems de cada opción (JMenuItem) */
    JMenuItem jmOpcion21 = new JMenuItem();
    JMenuItem jmOpcion22 = new JMenuItem();
    JMenuItem jmOpcion23 = new JMenuItem();
    JMenuItem jmOpcion31 = new JMenuItem();
    JMenuItem jmOpcion32 = new JMenuItem();
    JMenuItem jmSubmenu111 = new JMenuItem();
    JMenuItem jmSubmenu112 = new JMenuItem();
    JMenuItem jmSubmenu113 = new JMenuItem();
    JMenuItem jmSubmenu121 = new JMenuItem();
    JMenuItem jmSubmenu122 = new JMenuItem();
    JMenuItem jmSubmenu123 = new JMenuItem();
    /* Ítems especiales */
    JCheckBoxMenuItem jmOpcion33 = new JCheckBoxMenuItem();
    JRadioButtonMenuItem jmOpcion34 = new JRadioButtonMenuItem();
    JRadioButtonMenuItem jmOpcion35 = new JRadioButtonMenuItem();

    /* Constructor por defecto */
    public PruebaMenu() {
        super.setTitle("Menú Completo de Java");
        Panel.setLayout(borderLayout1);
        /* Establecemos el texto de cada elemento del menú */
        jmOpcion1.setText("Opción 1");
        jmOpcion2.setText("Opción 2");
        jmOpcion3.setText("Opción 3");
        jmOpcion11.setText("1.1");
        jmOpcion22.setText("2.2");
        jmOpcion21.setText("2.1");
        jmOpcion23.setText("2.3");
        jmOpcion31.setText("3.1");
        jmOpcion32.setText("3.2");
        jmSubmenu111.setText("1.1.1");
        jmSubmenu112.setText("1.1.2");
        jmSubmenu113.setText("1.1.3");
        jmOpcion12.setText("1.2");
        jmSubmenu121.setText("1.2.1");
        jmSubmenu122.setText("1.2.2");
        jmSubmenu123.setText("1.2.3");
        jmOpcion33.setText("3.3");
        jmOpcion34.setText("3.4");
        jmOpcion35.setText("3.5");
        /* Deshabilitamos las opciones 3.1 y 3.2 */
        jmOpcion31.setEnabled(false);
        jmOpcion32.setEnabled(false);
        /* Como la opción 3.5 tiene un radio button puede estar seleccionado */
        jmOpcion35.setSelected(true);

        /* Una vez establecido, debemos armar el menú */
        /* A la barra de Menú le agregamos las opciones */
        barraDeMenu.add(jmOpcion1);
        barraDeMenu.add(jmOpcion2);
        barraDeMenu.add(jmOpcion3);

        /* A las opciones les agregamos los ítems de cada opción */
        jmOpcion1.add(jmOpcion11);
        jmOpcion1.add(jmOpcion12);
        jmOpcion2.add(jmOpcion21);
        /* Agregamos separador entre 2.1 y 2.2 */
        jmOpcion2.addSeparator();
        jmOpcion2.add(jmOpcion22);
        /* y agregamos otro separador entre 2.2 y 2.3 */
        jmOpcion2.addSeparator();
        jmOpcion2.add(jmOpcion23);
        jmOpcion3.add(jmOpcion31);
        jmOpcion3.add(jmOpcion32);
        jmOpcion3.add(jmOpcion33);
        jmOpcion3.add(jmOpcion34);
        jmOpcion3.add(jmOpcion35);
        jmOpcion11.add(jmSubmenu111);
        jmOpcion11.add(jmSubmenu112);
        jmOpcion11.add(jmSubmenu113);
        jmOpcion12.add(jmSubmenu121);
        jmOpcion12.add(jmSubmenu122);
        jmOpcion12.add(jmSubmenu123);

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