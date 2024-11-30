
/*
 * Usaremos JRadioButton para darle opciones al usuario. Por lo general se
 * emplea en el caso
 * de opciones excluyentes, es decir que sólo se puede elegir una de ellas. El
 * aspecto del radio button
 * es el que vemos en la Figura 5 ( ) Opción uno ( ) Opción dos ( ) Opción tres
 * El código para crear la ventana de la Figura 5 es: 
 */
import java.awt.*;
import javax.swing.*;

//import com.borland.jbcl.layout.*; // da error de compilación
public class PruebaJRadioButton extends JFrame {
    FlowLayout flowLayout1 = new FlowLayout();
    /* Creamos los JRadioButton */
    JRadioButton JrBtnOpcionUno = new JRadioButton();
    JRadioButton JrBtnOpcionDos = new JRadioButton();
    JRadioButton JrBtnOpcionTres = new JRadioButton();
    ButtonGroup grupoDeBotones = new ButtonGroup();

    /* Constructor por defecto */
    public PruebaJRadioButton() {
        super.setTitle("Prueba JRadioButton");
        flowLayout1.setHgap(20);
        flowLayout1.setVgap(20);
        this.getContentPane().setLayout(flowLayout1);
        /* Seteamos el texto a los botones */
        JrBtnOpcionUno.setText("Opción Uno");
        JrBtnOpcionDos.setText("Opción Dos");
        JrBtnOpcionTres.setText("Opción Tres");
        grupoDeBotones.add(JrBtnOpcionUno);
        grupoDeBotones.add(JrBtnOpcionDos);
        grupoDeBotones.add(JrBtnOpcionTres);
        this.getContentPane().add(JrBtnOpcionUno, null);
        this.getContentPane().add(JrBtnOpcionDos, null);
        this.getContentPane().add(JrBtnOpcionTres, null);
        /* Establecemos el primer JRadioButton como seleccionado */
        JrBtnOpcionUno.setSelected(true);
        super.pack();
        super.show();
    }

    public static void main(String[] args) {
        new PruebaJRadioButton();
    }

    private void jbInit() throws Exception {
    }
}