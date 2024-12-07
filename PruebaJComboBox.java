
/* El JComboBox puede verse como una lista desplegable de ítems. Sirve para reducir la entrada por teclado y,
 * al mismo tiempo, el error generado por el usuario al teclear. Por su puesto que la entrada debe ser siempre
 * similar o estar dentro de un conjunto finito de opciones; es decir, la razón social de la persona no puede ser elegida
 * de un combo box, ya que no podríamos tener todos los nombres posibles cargados en él, pero es una buena posibilidad
 * para datos como la localidad, la provincia, o la nacionalidad.
 * Agreguemos que el combo box es editable, con lo cuál adquiere las capacidades del JTextField, es decir, permite
 * el ingreso por teclado y, también, desplegar la lista de opciones cargadas. La apariencia de este componente en una ventana
 * se ve en la Figura 11.
 * El código para lograr la ventana de la Figura 11 es el siguiente:
 */
import java.awt.*;
import javax.swing.*;
//import com.borland.jbcl.layout.*; // da error de compilación porque no existe más

public class PruebaJComboBox extends JFrame {
    // VerticalFlowLayout verticalFlowLayout1 = new VerticalFlowLayout();
    // da error de compilación porque la clase no exsite
    FlowLayout flowLayout1 = new FlowLayout();
    JComboBox JcbUno = new JComboBox();
    JComboBox JcbDos = new JComboBox();

    /* Constructor por defecto */
    public PruebaJComboBox() {
        super.setTitle("Prueba JComboBox");
        this.getContentPane().setLayout(flowLayout1);
        this.getContentPane().add(JcbUno, null);
        this.getContentPane().add(JcbDos, null);
        for (int i = 1; i < 5; i++) {
            JcbUno.addItem("Dato " + i);
            JcbDos.addItem("Dato " + i);
        }
        super.pack();
        super.show();
    }

    public static void main(String[] args) {
        new PruebaJComboBox();
    }
}