
/* Los JLabel son etiquetas de texto que sirven para mosrtar un texto sencillo, 
 * o una imagen. En general estarán relacionados con la entrada del usuario. 
 * EL contenido de la etiqueta puede tener la dirección que necesitemos, al igual que el texto
 * y las imágenes de los botones. La apariencia del componente en una ventana es sencillamente 
 * la que se muestra en la Figura 8.
 * El código para la ventana de la Figura 8 es:
 */
import java.awt.*;
import javax.swing.*;

//import com.borland.jbcl.layout.*; // da error de compilación
public class PruebaJLabel extends JFrame {
    // VerticalFlowLayout verticalFlowLayout1 = new VerticalFlowLayout(); // da
    // error de compilación clase no existe
    FlowLayout flowLayout1 = new FlowLayout();
    JLabel LbUno = new JLabel();
    JLabel LbDos = new JLabel();
    JLabel LbTres = new JLabel();
    JLabel LbCuatro = new JLabel();
    JLabel LbCinco = new JLabel();
    JLabel LbSeis = new JLabel();

    /* Constructor por defecto */
    public PruebaJLabel() {
        super.setTitle("Prueba JLabel");
        // this.getContentPane().setLayout(verticalFlowLayout1);
        this.getContentPane().setLayout(flowLayout1);
        LbUno.setText("Etiqueta normal");
        LbDos.setToolTipText("");
        LbDos.setHorizontalAlignment(SwingConstants.RIGHT);
        LbDos.setText("Alineada a la derecha");
        LbTres.setHorizontalAlignment(SwingConstants.CENTER);
        LbTres.setText("Centrada");
        LbCuatro.setFont(new java.awt.Font("Serif", 1, 14));
        LbCuatro.setText("Con otra fuente");
        LbCinco.setForeground(UIManager.getColor("EditorPane.caretForeground"));
        LbCinco.setToolTipText("");
        LbCinco.setText("Con otro color de fuente");
        LbSeis.setBackground(UIManager.getColor("ComboBox.background"));
        LbSeis.setBorder(BorderFactory.createLoweredBevelBorder());
        LbSeis.setText("Con borde 3D");
        this.getContentPane().add(LbUno, null);
        this.getContentPane().add(LbDos, null);
        this.getContentPane().add(LbTres, null);
        this.getContentPane().add(LbCuatro, null);
        this.getContentPane().add(LbCinco, null);
        this.getContentPane().add(LbSeis, null);
        super.pack();
        super.show();
    }

    public static void main(String[] args) {
        new PruebaJLabel();
    }
}