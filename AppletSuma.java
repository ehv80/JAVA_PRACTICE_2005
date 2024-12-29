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
 * con el siguiente código:
 * <HTML>
 * 
 * <HEAD>
 * <TITLE>
 * Página HTML de Prueba AppletSuma.html
 * </TITLE>
 * </HEAD>
 * 
 * <BODY>
 * <H1>Ingrese dos números y presione el botón sumar</H1>.<br>
 * <APPLET codebase="." code="AppletSuma.class" name="Suma" width="400"
 * height="300" hspace="0" vspace="0">
 * </APPLET>
 * </BODY>
 * 
 * </HTML>
 * 
 * Lo único que hicimos fue configurar los parámetros del applet.
 * La siguiente tabla describe para qué sirven estos parámetros:
 * 
 * PARÁMETRO __________ DESCRIPCIÓN
 * 
 * codebase ____________ Permite indicar al navegador el directorio
 * _____________________ donde se encuentra el applet, en caso de
 * _____________________ poner . significa que el HTML y el applet
 * _____________________ están en el mismo directorio.
 * 
 * code ________________ Permite poner el nombre completo del applet
 * _____________________ que tiene el método init(). Note que en
 * _____________________ nuestro ejemplo tiene el nombre del paquete
 * _____________________ delante de la clase (como está comentado no es así)
 * 
 * name ________________ Una cadena que describe el applet. Lo que pongamos
 * _____________________ acá se mostrará en la barra de estado del navegador.
 * 
 * width _______________ Ancho del applet
 * 
 * height ______________ Alto del applet
 * 
 * hspace ______________ Define el espacio horizontal que debe quedar alrededor
 * _____________________ del applet
 * 
 * vspace ______________ Define el espacio vertical que debe quedar alrededor
 * _____________________ del applet
 */
/*
 * SONIDOS EN LOS APPLETS
 * Nuestros applets pueden incluir sonidos a través de la interfaz
 * AudioClip. El archivo de sonido lo podemos cargar desde una
 * dirección URL a través del método getAudioClip() para su
 * posterior ejecución, o través del método play(), también
 * desde una dirección URL, con la diferencia de que este método
 * lo carga y lo ejecuta. Otros métodos importantes que provee la
 * interfaz AudioClip son loop() para que repita el sonido
 * cada vez que termine y stop() para detener la ejecución del sonido.
 * 
 * En cuanto a estos applets, es recomendable cargar los archivos
 * de sonido a través de un thread, ya que si tardan en cargarse,
 * el applet tardará en devolverle el control al usuario.
 * Si lo hacemos en un thread distinto, el usuario puede comenzar
 * a usar el applet mientras se está cargando el sonido.
 */