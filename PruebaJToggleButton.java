
/* Los JToggleButton cambian entre dos estados: normal o presionado.
 * Los usos son similares a los JRadioButton, aunque sólo podemos tener una opción.
 * El código de la ventana de la Figura 7 es el siguiente: 
 */
import java.awt.*;
import javax.swing.*;

// import com.borland.jbcl.layout.*; // da error de compilación
public class PruebaJToggleButton extends JFrame {
    FlowLayout flowLayout1 = new FlowLayout();
    JToggleButton JtBtnUno = new JToggleButton();
    JToggleButton JtBtnDos = new JToggleButton();

    // VerticalFlowLayout verticalFlowLayout1 = new VerticalFlowLayout(); //da error
    // de compilación clase no existe
    /* Constructor por defecto */
    public PruebaJToggleButton() {
        super.setTitle("Prueba JToggleButton");
        JtBtnUno.setSelected(true);
        JtBtnUno.setText("Éste botón empieza presionado");
        JtBtnDos.setText("Este normal");
        this.getContentPane().setLayout(flowLayout1);
        this.getContentPane().add(JtBtnUno, null);
        this.getContentPane().add(JtBtnDos, null);
        super.pack();
        super.show();
    }

    public static void main(String[] args) {
        new PruebaJToggleButton();
    }
}