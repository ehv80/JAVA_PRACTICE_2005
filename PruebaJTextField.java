
/* Este componente representa los cuadros de texto para ingreso de datos del usuario.
 * En algunos casos necesitaremos un ingreso de password, para lo cual usaremos otro componente
 * llamado JPasswordField, que incluimos en esta explicación, ya que son iguales, aunque
 * éste último muestra un caracter especial (por default, el asterizco) a cada entrada de teclado.
 * La apariencia de JTextField es la que se ve en la Figura 10.
 * En el ejemplo vemos seis JTextField y un JPasswordField; todos ellos arrancan configurados con algo,
 * es decir que cuando se muestre la ventana se verá exactamente como en la Figura 10. A continuación, 
 * el código para lograr esta ventana:
 */
import java.awt.*;
import javax.swing.*;

//import com.borland.jbcl.layout.*; // da error de compilación
public class PruebaJTextField extends JFrame {
    JTextField JtfUno = new JTextField();
    JTextField JtfDos = new JTextField();
    JTextField JtfTres = new JTextField();
    JTextField JtfCuatro = new JTextField();
    JTextField JtfCinco = new JTextField();
    JTextField JtfSeis = new JTextField();
    // VerticalFlowLayout verticalFlowLayout1 = new VerticalFlowLayout(); // da
    // error de compilación clase que no existe
    BorderLayout borderLayout1 = new BorderLayout();
    JPasswordField JpfUno = new JPasswordField();

    /* Construcor por defecto */
    public PruebaJTextField() {
        super.setTitle("Prueba JtextField");
        JtfSeis.setSelectionEnd(5);
        JtfSeis.setText(" También podemos cambiar la orientación ");
        JtfSeis.setHorizontalAlignment(SwingConstants.RIGHT);
        this.getContentPane().setLayout(borderLayout1);
        JtfDos.setText(" Prueba JTextField ");
        JtfUno.setText(" El texto puede empezar seleccionado ");
        JtfUno.setSelectionStart(5);
        JtfUno.setSelectionEnd(15);
        JpfUno.setText(" Esta es la Password ");
        JtfTres.setFont(new java.awt.Font("SansSerif", 1, 12));
        JtfTres.setText(" Éste tiene otra fuente ");
        JtfCuatro.setBackground(Color.GREEN);
        JtfCuatro.setText(" Se puede cambiar el color de fondo ");
        JtfCinco.setForeground(Color.BLUE);
        JtfCinco.setText(" Y el color de la fuente ");
        this.getContentPane().add(JtfUno, null);
        this.getContentPane().add(JtfDos, null);
        this.getContentPane().add(JtfTres, null);
        this.getContentPane().add(JtfCuatro, null);
        this.getContentPane().add(JtfCinco, null);
        this.getContentPane().add(JtfSeis, null);
        this.getContentPane().add(JpfUno, null);
        super.pack();
        super.show();
    }

    public static void main(String[] args) {
        new PruebaJTextField();
    }
}