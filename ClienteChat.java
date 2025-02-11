/*
 * CLIENTE DE CHAT
 * A continuación vamos a crear el cliente de Chat (Figura 3). 
 * Como vemos, en el caso del cliente la pantalla es mucho mas simple:
 * sólo tendremos dos JTextField, el primero para ingresar la IP 
 * donde se encuentra el servidor de chat, y el segundo para el 
 * número de puerto; en el medio de la ventana un cuadro de texto donde
 * el usuario verá lo que escriben los otros participantes; y finalmente,
 * un tercer JTextField donde ingresará sus mensajes.
 * El código del cliente será:
 */

//package chat; //comentado para evitar error en tiempo de ejecución
//paquete y clase no encontrados

import java.io.*;
import java.net.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import com.borland.jbcl.layout.*;

public class ClienteChat extends Frame implements Runnable
{
    /* Creamos buffers de entrada y salida */
    protected DataInputStream i = null;
    protected DataOutputStream o = null;
    /* y un hilo para escuchar */
    protected Thread listener = null;
    JPanel PanelCliente = new JPanel();
    BorderLayout borderLayout1 = new BorderLayout();
    JPanel PanelDatosConexion = new JPanel();
    JTextField TxMensaje = new JTextField();
    BoxLayout2 boxLayout21 = new BoxLayout2();
    JLabel LbPuerto = new JLabel();
    JTextField TxIP = new JTextField();
    JButton BtnConecar = new JButton();
    BorderLayout borderLayout2 = new BorderLayout();
    JButton BtnSalir = new JButton();
    JScrollPane ScrollPane = new JScrollPane();
    JTextArea JTxTexto = new JTextArea();
    /* Constructor por defecto */
    public ClienteChat()
    {
        try
        {
            jbInit();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    /* Sobrecarga el método run */
    public void run()
    {
        try
        {
            while(true)
            {
                /* Leemos los mensajes y los agregamos al cuadro de texto */
                String line = i.readUTF();
                JTxTexto.append(line + "\n");
            }
        }
        /* Capturamos los errores correspondientes */
        catch(NullPointerException ex)
        {
            JTxTexto.append("Aguarde un instante mientras se establece la conexión...\n");
        }
        catch(SocketException ex)
        {
            JTxTexto.append("No está conectado a ningún servidor...\n");
        }
        catch(IOException ex)
        {
            JTxTexto.append("Error de entrada/salida : "+ ex.getMessage() + "\n");
        }
        finally
        {
            /* Si los errores son insalvables intentaremos cerrar todo */
            listener = null;
            validate();
            try
            {
                o.close();
            }
            catch(IOException ex)
            {
                JTxTexto.append("Error : " + ex.getMessage() + "\n");
            }
        }
    }
    /* Código que arma la ventana jbInit */
    private void jbInit() throws Exception 
    {
        super.setTitle("Cliente de Chat");
        super.setLayout( new BorderLayout() );
        this.setLayout(borderLayout2);
        this.setVisible(true);
        PanelCliente.setMinimumSize( new Dimension(350, 150));
        PanelCliente.setPreferredSize( new Dimension(450, 150));
        BtnConecar.addActionListener( new java.awt.event.ActionListener()
        { public void actionPerformed(ActionEvent e)
        { BtnConecar_actionPerformed(e);}});
        TxMensaje.addActionListener( new java.awt.event.ActionListener()
        { public void actionPerformed( ActionEvent e)
        { TxMensaje_actionPerformed(e);}});
        BtnSalir.setMnemonic('S');
        BtnSalir.setText("Salir");
        BtnSalir.addActionListener( new java.awt.event.ActionListener()
        { public void actionPerformed(ActionEvent e)
        { BtnSalir_actionPerformed(e);}});
        PanelDatosConexion.setMinimumSize( new Dimension(350, 27));
        JTxTexto.setEditable(false);
        ScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.add(PanelCliente, BorderLayout.CENTER);
        this.add(PanelDatosConexion, BorderLayout.NORTH);
        PanelCliente.setLayout(borderLayout1);
        PanelDatosConexion.setLayout(boxLayout21);
        LbIP.setText(" I.P. del Servidor : ");
        LbPuerto.setText(" Puerto : ");
        PanelCliente.add(TxMensaje, BorderLayout.SOUTH);
        PanelCliente.add(ScrollPane, BorderLayout.CENTER);
        BtnConecar.setMnemonic('C');
        BtnConecar.setText(" Conectar ");
        PanelDatosConexion.add(LbIP, null);
        PanelDatosConexion.add(TxIP, null);
        PanelDatosConexion.add(LbPuerto, null);
        PanelDatosConexion.add(TxPuerto, null);
        PanelDatosConexion.add(BtnConecar, null);
        PanelDatosConexion.add(BtnSalir, null);
        ScrollPane.getViewport().add(JTxTexto, null);
        super.pack();
        super.show();
    }
    /* La acción del botón será crear una instancia de esta clase como hilo */
    void BtnConecar_actionPerformed(ActionEvent e)
    {
        TxMensaje.requestFocus();
        listener = new Thread(this);
        listener.start();
        try 
        {
            /* Creamos el socket del cliente con la I.P. y el puerto ingresados por pantalla */
            Socket s = new Socket(TxIP.getText(), Integer.parseInt(TxPuerto.getText()));
            /* Creamos los buffers de entrada y salida */
            this.i = new DataInputStream( new BufferedInputStream( s.getInputStream()));
            this.o = new DataOutputStream( new BufferedOutputStream( s.getOutputStream()));
        }
        catch(Exception ex)
        {
            JTxTexto.append("No está conectado a ningún servidor...\n");
        }
    }
    /* La acción del JTextField será enviar los mensajes a los otros clientes a través del servidor */
    void TxMensaje_actionPerformed(ActionEvent e)
    {
        try
        {
            o.writeUTF((String)TxMensaje.getText());
            o.flush();
        }
        catch(IOException ex)
        {
            JTxTexto.append("Error de entrada/salida : " + ex.getMessage() + "\n");
            TxMensaje.setText(new String());
        }
    }
    /* Finalmente el método para salir de la aplicación */
    void BtnSalir_actionPerformed(ActionEvent e)
    {
        try
        {
            this.i.close();
            this.o.close();
            super.dispose();
            System.exit(0);
        }
        catch(Exception ex)
        {
            System.exit(0);
        }
    }

    /* Método main */
    public static void main(String[] args)
    {
        ClienteChat clienteDeChat = new ClienteChat();
    }
}