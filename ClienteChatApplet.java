/*
 * Cliente de Chat versión Applet
 * Continuando con el ejemplo integrador, ahora vamos a hacer un cliente de chat,
 * pero no como una aplicación de escritorio, sino como un applet. Note del código
 * su parecido con la versión anterior; solo agregaremos los métodos necesarios para
 * el applet.
 */

//package chat; //Comentado para evitar error en tiempo de ejecución
//paquete y clase no encontrado
/*
 * Title: ClienteChatApplet
 * Description: Cliente de Chat en versión Applet
 * Copyright: Copyright (c) 2004
 * Company: X-Cubo
 * @author Sergio Alejandro Dos Santos
 * @version 1.0
 */

import java.io.*;
import java.net.*;
import java.awt.*;
import javax.swing.*;
import java.applet.*;
import java.awt.event.*;
import com.borland.jbcl.layout.*;

public class ClienteChatApplet extends Applet implements Runnable {
    protected DataInputStream i = null;
    protected DataOutputStream o = null;
    protected Thread listener = null;
    JPanel PanelCliente = new JPanel();
    BorderLayout borderLayout1 = new BorderLayout();
    JPanel PanelDatosConexion = new JPanel();
    JTextField TxMensaje = new JTextField();
    JTextArea JTxTexto = new JTextArea();
    BoxLayout2 boxLayout21 = new BoxLayout2();
    JLabel LbIP = new JLabel();
    JTextField TxPuerto = new JTextField();
    JLabel LbPuerto = new JLabel();
    JTextField TxIP = new JTextField();
    JButton BtnConectar = new JButton();
    BorderLayout borderLayout2 = new BorderLayout();

    /* Método que inicializa el Applet */
    public void init() {
        super.setLayout(new BorderLayout());
        this.setLayout(borderLayout2);
        this.setVisible(true);
        PanelCliente.setPreferredSize(new Dimension(450, 150));
        BtnConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BtnConectar_actionPerformed(e);
            }
        });
        TxMensaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TxMensaje_actionPerformed(e);
            }
        });
        JTxTexto.setEditable(false);
        this.add(PanelCliente, BorderLayout.CENTER);
        this.add(PanelDatosConexion, BorderLayout.NORTH);
        PanelCliente.setLayout(borderLayout1);
        PanelDatosConexion.setLayout(boxLayout21);
        LbIP.setText(" I.P. del Servidor : ");
        LbPuerto.setText(" Puerto : ");
        PanelCliente.add(TxMensaje, BorderLayout.SOUTH);
        PanelCliente.add(JTxTexto, BorderLayout.CENTER);
        BtnConectar.setMnemonic('C');
        BtnConectar.setText(" Conectar ");
        PanelDatosConexion.add(LbIP, null);
        PanelDatosConexion.add(TxIP, null);
        PanelDatosConexion.add(LbPuerto, null);
        PanelDatosConexion.add(TxPuerto, null);
        PanelDatosConexion.add(BtnConectar, null);
    }

    /* Método que dispara el Applet */
    public void start() {
        listener = new Thread(this);
        listener.start();
    }

    /* Método que detiene la ejecución del Applet */
    public void stop() {
        try {
            this.i.close();
            this.o.close();
        } catch (Exception ex) {
            System.err.println("Error cerrando el cliente...\n");
        }
        listener = null;
    }

    /* Sobrecarga el método run */
    public void run() {
        try {
            /* Recibe como parámetro la dirección IP del Servidor y el Puerto */
            String host = getParameter("ip");
            if (host == null)
                host = getCodeBase().getHost();
            String port = getParameter("puerto");
            if (port == null)
                port = "9876";
            JTxTexto.append("Conectando a " + host + ":" + port + "...\n");
            Socket s = new Socket(host, Integer.parseInt(port));
            i = new DataInputStream(new BufferedInputStream(s.getInputStream()));
            o = new DataOutputStream(new BufferedOutputStream(s.getOutputStream()));
            JTxTexto.append("Conectado\n");
            TxMensaje.setEditable(true);
            TxMensaje.requestFocus();
            execute();
        } catch (IOException ex) {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ex.printStackTrace(new PrintStream(out));
            JTxTexto.append("\n" + out);
        }
    }

    /* Método que ejecuta el Applet */
    public void execute() {
        try {
            while (true) {
                String line = i.readUTF();
                JTxTexto.append(line + "\n");
            }
        } catch (NullPointerException ex) {
            JTxTexto.append("Aguarde un instante mientras se establece la conexión...\n");
        } catch (SocketException ex) {
            JTxTexto.append("No está conectado a ningún servidor...\n");
        } catch (IOException ex) {
            JTxTexto.append("Error de Entrada/Salida : " + ex.getMessage() + "\n");
        } finally {
            listener = null;
            validate();
            try {
                o.close();
            } catch (IOException ex) {
                JTxTexto.append("Error : " + ex.getMessage() + "\n");
            }
        }
    }

    /* Constructor por defecto */
    public ClienteChatApplet() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* Método jbInit */
    private void jbInit() throws Exception {
        // nada
    }

    void BtnConectar_actionPerformed(ActionEvent e) {
        TxMensaje.requestFocus();
        listener = new Thread(this);
        listener.start();
        try {
            Socket s = new Socket(TxIP.getText(), Integer.parseInt(TxPuerto.getText()));
            this.i = new DataInputStream(new BufferedInputStream(s.getInputStream()));
            this.o = new DataOutputStream(new BufferedOutputStream(s.getOutputStream()));
        } catch (Exception ex) {
            JTxTexto.append("No está conectado a ningún servidor...\n");
        }
    }

    void TxMensaje_actionPerformed(ActionEvent e)
    {
        try
        {
            o.writeUTF((String)TxMensaje.getText());
            o.flush()
        }
        catch(IOException ex)
        {
            JTxTexto.append("Error de Entrada/Salida : " + ex.getMessage() + "\n");
        }
        TxMensaje.setText(new String());
    }
}