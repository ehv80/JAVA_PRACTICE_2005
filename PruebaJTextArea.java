
/* Al igual que JList, los JTextArea podrán tener más texto que el que cabe en la parte visible
 * del componente, así que tendremos que cargar primero un JScrollPane y luego agregarle el JTextArea.
 * Un componente JTextArea en una ventana se verá como lo muestra la Figura 18.
 * El código de la ventana de la Figura 18 es el siguiente:
 */
import java.awt.*;
import javax.swing.*;
//import com.borland.jbcl.layout.*; // da error de compilación porque ya no existe más

public class PruebaJTextArea extends JFrame {
    BorderLayout borderLayout1 = new BorderLayout();
    JScrollPane scrollPane = new JScrollPane();
    JTextArea JTxaTexto = new JTextArea();

    /* Constructor por defecto */
    public PruebaJTextArea() {
        super.setTitle("Prueba JTextArea");
        this.getContentPane().setLayout(borderLayout1);
        JTxaTexto.setText("jTextArea1");
        this.getContentPane().add(scrollPane, BorderLayout.CENTER);
        scrollPane.getViewport().add(JTxaTexto, null);
        JTxaTexto.setText("AGUINALDO (ART.243º): Queda establecida una remuneración anual\n" +
                "complementaria o aguinaldo, equivalente a la doceava parte de las\n" +
                "remuneraciones devengadas durante el año calendario a favor del\n" +
                "trabajador en todo concepto (salario, horas extraordinarias, comisiones,\n" +
                "u otras), la que será abonada antes del 31 de diciembre, o en el momento en\n" +
                "que termine la relación laboral si ello ocurre antes de esa época del año.\n");
        super.pack();
        super.show();
    }

    public static void main(String[] args) {
        new PruebaJTextArea();
    }
}