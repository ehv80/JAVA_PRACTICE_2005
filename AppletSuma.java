/*
 * Vamos a hacer un applet que sirva para sumar dos números.
 * Éste tendrá dos cuadros de texto para el ingreso de números,
 * un botón que ejecutará la suma y dejará el resultado en un
 * tercer cuadro de texto.
 * El código del applet quedará así:
 */

//package prueba; //comentado para evitar error en tiempo de 
//ejecución paquete y clase no encontrados

import java.awt.*;
import java.applet.*;
import javax.swing.*;
import java.awt.event.*;

public class AppletSuma extends JApplet {
    GridBagLayout gridBagLayout1 = new GridBagLayout();
    JTextField TxNumeroUno = new JTextField();
    JTextField TxNumeroDos = new JTextField();
    JButton BotonSumar = new JButton();
    JTextField TxResultado = new JTextField();

    /* Constructor por defecto no hace nada */
    public AppletSuma() {

    }

    /* Sobrecargamos el Método init: inicializa el applet */
    public void init() {
        /* Acá ponemos el código para armar la ventana */
        this.setLayout(gridBagLayout1);
        TxResultado.setEnabled(false);
        BotonSumar.setText("Sumar");
        BotonSumar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BotonSumar_actionPerformed(e);
            }
        });
        this.add(TxNumeroUno, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
                GridBagConstraints.NONE, new Insets(20, 20, 1, 20), 50, 0));
        this.add(TxNumeroDos, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
                GridBagConstraints.NONE, new Insets(1, 20, 20, 20), 50, 0));
        this.add(BotonSumar, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
                GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        this.add(TxResultado, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
                GridBagConstraints.NONE, new Insets(20, 20, 20, 20), 50, 0));
    }

    /* Acción del botón sumar */
    public void BotonSumar_actionPerformed(ActionEvent e) {
        int numeroUno = Integer.parseInt(TxNumeroUno.getText());
        int numeroDos = Integer.parseInt(TxNumeroDos.getText());
        int resultado = numeroUno + numeroDos;
        TxResultado.setText(new Integer(resultado).toString());
    }
}
/*
 * Ahora para probar el programa, primero lo compilamos con el comando
 * 
 * #> javac AppletSuma.java
 * 
 * que genera el archivo AppletSuma.class
 * 
 * Luego creamos el archivo HTML: AppletSuma.html
 */