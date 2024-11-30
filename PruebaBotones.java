
/* El código para lograr una ventana de la Figura 2 
 * ( Cinco Botones en disposición Norte, Sur, Oeste, Centro, Este ) es el siguiente: 
 * */
import java.awt.*;
import javax.swing.*;

public class PruebaBotones extends JFrame {
    /* Creamos una instancia de BorderLayout */
    BorderLayout borderLayout1 = new BorderLayout();
    /*
     * Creamos los botones usando el constructor que recibe un Icon
     * como parámetro para esta usamos la clase ImageIcon
     */
    JButton JBtnOeste = new Jbutton(new ImageIcon(
            "E:\\Users\\ehv80\\Documentos\\Programacion_en_Lenguaje_Java\\JAVA_PRACTICE_2005\\izquierda.gif"));
    JButton JBtnNorte = new Jbutton(new ImageIcon(
            "E:\\Users\\ehv80\\Documentos\\Programacion_en_Lenguaje_Java\\JAVA_PRACTICE_2005\\arriba.gif"));
    JButton JBtnEste = new Jbutton(new ImageIcon(
            "E:\\Users\\ehv80\\Documentos\\Programacion_en_Lenguaje_Java\\JAVA_PRACTICE_2005\\derecha.gif"));
    JButton JBtnSur = new Jbutton(new ImageIcon(
            "E:\\Users\\ehv80\\Documentos\\Programacion_en_Lenguaje_Java\\JAVA_PRACTICE_2005\\abajo.gif"));
    JButton JBtnCentro = new JButton();

    /* Constructor por defecto */
    public PruebaBotones() {
        /* Ponemos título a la Ventana */
        super.setTitle("Prueba JButton");
        /*
         * A través de los métodos Hgap y Vgap logramos el espacio entre los botones, en
         * este caso, 10 píxeles
         */
        borderLayout1.setHgap(10);
        borderLayout1.setVgap(10);
        /* Cargamos el Layout creado al panel */
        this.getContentPane().setLayout(borderLayout1);
        JBtnOeste.setMnemonic('O');
        /* A través del método setText agregamos texto a los botones */
        JBtnOeste.setText("Oeste");
        JBtnNorte.setHorizontalTextPosition(SwingConstants.CENTER);
        JBtnNorte.setMnemonic('N');
        JBtnNorte.setText("Norte");
        JBtnNorte.setVerticalTextPosition(SwingConstants.BOTTOM);
        JBtnCentro.setMnemonic('C');
        JBtnCentro.setText("Centro");
        JBtnEste.setHorizontalTextPosition(SwingConstants.LEFT);
        JBtnEste.setMnemonic('E');
        JBtnEste.setText("Este");
        JBtnSur.setHorizontalTextPosition(SwingConstants.CENTER);
        JBtnSur.setMnemonic('S');
        JBtnSur.setText("Sur");
        JBtnSur.setVerticalTextPosition(SwingConstants.TOP);
        /* Agregamos los botones al container del frame */
        this.getContentPane().add(JBtnOeste, BorderLayout.WEST);
        this.getContentPane().add(JBtnNorte, BorderLayout.NORTH);
        this.getContentPane().add(JBtnCentro, BorderLayout.CENTER);
        this.getContentPane().add(JBtnEste, BorderLayout.EAST);
        this.getContentPane().add(JBtnSur, BorderLayout.SOUTH);
        super.pack();
        /* Finalmente mostramos la ventana */
        super.show();
    }

    public static void main(String[] args) {
        new PruebaBotones();
    }
}