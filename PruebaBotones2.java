import java.awt.*;
import javax.swing.*;
import com.borland.jbcl.layout.*; // da error de compilación
import oracle.javatools.ui.layout.*;

public class PruebaBotones2 extends JFrame {
        VerticalFlowLayout verticalFlowLayout1 = new VerticalFlowLayout();
        JButton JBtnDeshabilitado = new JButton(new ImageIcon(
                        "E:\\Users\\ehv80\\Documentos\\Programacion_en_Lenguaje_Java\\JAVA_PRACTICE_2005\\taza.jpg"));
        JButton JBtnSinBordes = new JButton(new ImageIcon(
                        "E:\\Users\\ehv80\\Documentos\\Programacion_en_Lenguaje_Java\\JAVA_PRACTICE_2005\\taza.jpg"));
        JButton JBtnPresionado = new JButton(new ImageIcon(
                        "E:\\Users\\ehv80\\Documentos\\Programacion_en_Lenguaje_Java\\JAVA_PRACTICE_2005\\taza.jpg"));

        /* Constructor por defecto */
        public PruebaBotones2() {
                super.setTitle("Prueba JButton 2");
                JBtnDeshabilitado.setEnabled(false);
                JBtnDeshabilitado.setText("Deshabilitado");
                this.getContentPane().setLayout(verticalFlowLayout1);
                JBtnSinBordes.setBorderPainted(false);
                JBtnSinBordes.setContentAreaFilled(false);
                JBtnSinBordes.setFocusPainted(false);
                JBtnSinBordes.setText("Sin Bordes");
                JBtnPresionado.setText("Presionado");
                /* Cargamos el ícono para el botón presionado */
                JBtnPresionado.setPressedIcon(new ImageIcon(
                                "E:\\Users\\ehv80\\Documentos\\Programacion_en_Lenguaje_Java\\JAVA_PRACTICE_2005\\taza_presionada.gif"));
                /* Cargamos el ícono para el botón deshabilitado */
                JBtnDeshabilitado.setDisabledIcon(new ImageIcon(
                                "E:\\Users\\ehv80\\Documentos\\Programacion_en_Lenguaje_Java\\JAVA_PRACTICE_2005\\taza_deshabilitada.jpg"));
                this.getContentPane().add(JBtnDeshabilitado, null);
                this.getContentPane().add(JBtnSinBordes, null);
                this.getContentPane().add(JBtnPresionado, null);
                super.pack();
                super.show();
        }

        public static void main(String[] args) {
                new PruebaBotones2();
        }
}