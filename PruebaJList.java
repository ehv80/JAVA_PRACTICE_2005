
/* El concepto de JList es similar al de JComboBox, solo que muestra los ítems en un cuadro.
 * A menudo, la lista de ítems crece tanto, que no entra en el cuadro, por lo tanto el usuario
 * no podrá acceder a ellos. Entonces, lo que debemos hacer es poner primero el contenedor JScrollPane,
 * y dentro de éste, el componente JList (Figura 12), con lo que se logra que aparezcan las barras de desplazamiento
 * vertical, para acceder a los ítems que quedan abajo, o una barra horizontal en caso de que estos sean demasiado largos
 * y superen el ancho del JList.
 * Los JList se ven como lo muestra la Figura 13.
 * El código de la ventana es:
  */
import java.awt.*;
import javax.swing.*;
import java.util.*;

//import com.borland.jbcl.layout.*; // da error de compilación poque ya no existe
public class PruebaJList() extends JFrame {
    Vector v = new Vector();
    BoxLayout boxLayout1 = new BoxLayout(null, 0);
    JScrollPane scrollPaneUno = new JScrollPane();
    JScrollPane scrollPaneDos = new JScrollPane();
    JList JListUno = new JList();
    JList JListDos = new JList();

    /* Constructor por defecto */
    public PruebaJList()
    {
        super.setTitle("Prueba JList");
        this.getContentPane().setLayout(boxLayout1);
        this.getContentPane().add(scrollPaneUno, null);
        scrollPaneUno.getViewport().add(JListUno, null);
        this.getContentPane().add(scrollPaneDos, null);
        scrollPaneDos.getViewport().add(JListDos, null);
        for(int i=1; i<5; i++)
        {
            v.addElement("Dato " + i);
        }
        JListUno.setListData(v);
        JListDos.setListData(v);
        super.pack();
        super.show();
    }

    public static void main(String[] args) {
        new PruebaJList();
    }
}