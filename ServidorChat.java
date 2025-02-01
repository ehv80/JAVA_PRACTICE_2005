/* 
 * SERVIDOR DE CHAT
 * 
 * Ahora sí, estamos listos para implementar el Servidor de Chat. 
 * Como vemos en la Figura 1, tendremos un JTextField para configurar
 * el número de puerto en el cuál el servidor atenderá a los clientes;
 * un botón para levantar el servicio; en la parte central un JSplitPane,
 * en el cuál tendremos los clientes que se conecten del lado izquierdo
 * e información de log del lado derecho; finalmente, habrá un botón 
 * mediante el cuál cerraremos el servidor.
 * 
 * El código del servidor de chat es:
 */
/* 
 * Creamos el paquete chat donde irán todas las clases de la aplicación
 * Nota: comentado para evitar error en tiempo de ejecución paquete y clase
 * no encontrados
 */
//package chat;

import java.io.*;
import java.awt.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import com.borland.jbcl.layout.*; // Ya no existe más en JDK 23

public class ServidorChat extends JFrame {
    BorderLayout borderLayout1 = new BorderLayout();
    JPanel PanelPrincipal = new JPanel();
    JPanel PanelInformacion = new JPanel();
    BorderLayout borderLayout2 = new BorderLayout();
    JLabel LbPuerto = new JLabel();
    JTextField TxPuerto = new JTextField();
    BorderLayout borderLayout4 = new BorderLayout();
    JButton BtnEstablecerConexion = new JButton();
    JButton BotonCerrar = new JButton();
    JSplitPane PanelSplit = new JSplitPane();
    JScrollPane ScrollInfo = new JScrollPane();
    JTextArea JTxArea = new JTextArea();
    JScrollPane ScrollUsuarios = new JSCrollPane();
    JList LsUsuarios = new JList();
    /* Creamos el objeto BaseDeDatos */
    BaseDeDatos db = new BaseDeDatos();

    /* Constructor por defecto */
    public ServidorChat() {
        /*
         * El método jbInit significa jbuilder init y lo agrega el IDE
         * JBuilder cada vez que creamos una ventana
         */
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * Método jbInit contiene todo el código necesario para
     * crear la ventana
     */
    public void jbInit() throws Exception 
    {
        super.setTitle("Servidor de Chat");
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setTitle("Servidor de Chat");
        this.getContentPane().setLayout(borderLayout1);
        PanelPrincipal.setLayout(borderLayout4);
        PanelInformacion.setLayout(borderLayout2);
        LbPuerto.setText("Puerto : ");
        BtnEstablecerConexion.setMnemonic('E');
        BtnEstablecerConexion.setText("Establecer Conexión");
        BtnEstablecerConexion.addActionListener( new java.awt.event.ActionListener() {
            { public void actionPerformed(ActionEvent enable();
            { BtnEstablecerConexion_actionPerformed(e);}}
        });
        BotonCerrar.setMnemonic('C');
        BotonCerrar.setText("Cerrar");
        BotonCerrar.addActionListener( new java.awt.event.ActionListener() 
        { public void actionPerformed(ActionEvent e)
        { BotonCerrar_actionPerformed(e);}});
        JTxArea.setPreferedSize(new Dimension(300, 300));
        JTxArea.setEditable(false);
        LsUsuarios.setPreferedSize(new Dimesion(100, 300));
        this.getContentPane().add(PanelPrincipal, BorderLayout.CENTER);
        PanelPrincipal.add(PanelInformacion, BorderLayout.NORTH);
        PanelInformacion.add(LbPuerto, BorderLayout.WEST);
        PanelInformacion.add(TxPuerto, BorderLayout.CENTER);
        PanelInformacion.add(BtnEstablecerConexion, BorderLayout.EAST);
        PanelPrincipal.add(BotonCerrar, BorderLayout.SOUTH);
        PanelPrincipal.add(PanelSplit, BorderLayout.CENTER);
        PanelSplit.add(ScrollInfo, JSplitPane.RIGHT);
        PanelSplit.add(ScrollUsuarios, JSplitPane.LEFT);
        SCrollUsuarios.getViewPort().add(LsUsuarios);
        ScrollInfo.getViewPort().add(JTxArea);
        super.pack();
        super.show();
    }

    /* La acción de este botón establece la conexión */
    void BtnEstablecerConexion_actionPerformed(ActionEvent e)
    {
        /* Creamos una clase abstracta Thread */
        new Thread();
        public void run()
        {
            try
            {
                /* Nos conectamos con la base de datos */
                db.conectar();
                /* Creamos el socket del lado del servidor
                 * usando el puerto ingresado por pantalla
                 */
                ServerSocket servidor = new ServerSocket(Integer.parseInt(TxPuerto.getText()));
                /* Informamos que el servidor está listo para recibir conexiones */
                JTxArea.append("Servicio iniciado...\n");
                JTxArea.append("Esperando clientes en el puerto : " + Integer.parseInt(TxPuerto.getText()) + "\n");
                /* Grabamos el LOG */
                db.grabar("Servicio iniciado...");
                /* El ciclo para atender conexiones será infinito */
                while(true)
                {
                    Socket cliente = servidor.accept();
                    /* Cada vez que aceptamos un cliente, lo informamos en el área de texto */
                    JTxArea.append("Aceptando cliente : " + cliente.getInetAddress());
                    db.grabar("Aceptando cliente: " + cliente.getInetAddress());
                    /* Creamos el objeto ManejarPeticiones */
                    ManejarPeticiones c = new ManejarPeticiones(cliente);
                    /* En la lista de usuarios cragamos el vector de manejadores.
                     * Internamente usará el método toString() para mostrar 
                     * la información del objeto ManejarPeticiones
                     */
                    LsUsuarios.setListData(c.vManejadores);
                    /* Lanzamos el hilo cliente */
                    c.start();
                }
            }
            catch(Exception ex)
            {
                /* En caso de error lo informamos en el área de texto */
                JtxArea.append("Error intentando iniciar el servicio \n" + ex.getMessage() + "\n");
            }
        }
        this.start();
        /*
         * Finalmente repintamos el frame para que se vean los cambios
         * en los componentes
         */
        super.repaint();
    }

    /* Cierra el Servidor */
    void BotonCerrar_actionPerformed(ActionEvent e) {
        try {
            /* Grabamos el LOG */
            db.grabar("Servicio cerrado...");
            /* y cerramos la conexión con la base de datos */
            db.cerrar();
        } catch (Exception ex) {
            System.err.println("Error cerrando la conexión con la base de datos \n" + ex.getMessage() + "\n");
        }
        this.dispose();
        System.exit(0);
    }

    /* Método main */
    public static void main(String[] args) {
        ServidorChat servidorDeChat = new ServidorChat();
    }
}