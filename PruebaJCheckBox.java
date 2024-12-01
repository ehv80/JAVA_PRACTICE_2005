
/*
 * El comportamiento, así como la programación, de los JCheckBox es igual al de
 * los JRadioButton.
 * La diferencia que existe entre ellos es de tipo conceptual. Mientras que los
 * JRadioButton se usan
 * en caso de opciones excluyentes, los JCheckBox se utilizan en los casos en
 * que el usuario puede
 * elegir varias opciones presentadas.
 * Los JCheckBox en la ventana se verán como muesra la Figura 9
 * [ |/] C/C++
 * [ |/] Java
 * [ |/] Smalltalk
 * [ |/] TurboPascal
 * [ |/] Fortrand
 * El código de la ventana del ejemplo es:
 */
import java.awt.*;
import javax.swing.*;

//import com.borland.jbcl.layout.*; // da error de compilación
public class PruebaJCheckBox extends JFrame {
    // VerticalFlowLayout verticalFlowLayout1 = new VerticalFlowLayout(); // da
    // error de compilación clase que no existe
    FlowLayout flowLayout1 = new FlowLayout();
    JCheckBox JchBoxUno = new JCheckBox();
    JCheckBox JchBoxDos = new JCheckBox();
    JCheckBox JchBoxTres = new JCheckBox();
    JCheckBox JchBoxCuatro = new JCheckBox();
    JCheckBox JchBoxCinco = new JCheckBox();

    /* Constructor por defecto */
    public PruebaJCheckBox() {
        super.setTitle("Prueba JCheckBox");
        flowLayout1.setHgap(30);
        this.getContentPane().setLayout(flowLayout1);
        JchBoxUno.setText(" C/C++ ");
        JchBoxDos.setText(" Java ");
        JchBoxTres.setText(" Smalltalk ");
        JchBoxCuatro.setText(" TurboPascal ");
        JchBoxCinco.setText(" Fortrand ");
        JchBoxUno.setSelected(true);
        JchBoxDos.setSelected(true);
        JchBoxCuatro.setSelected(true);
        this.getContentPane().add(JchBoxUno, null);
        this.getContentPane().add(JchBoxDos, null);
        this.getContentPane().add(JchBoxTres, null);
        this.getContentPane().add(JchBoxCuatro, null);
        this.getContentPane().add(JchBoxCinco, null);
        super.pack();
        super.show();
    }

    public static void main(String[] args) {
        new PruebaJCheckBox();
    }
}