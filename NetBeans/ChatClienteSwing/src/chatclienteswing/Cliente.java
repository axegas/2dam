/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatclienteswing;

import clases.Paquete;
import clases.Usuario;
import clases.Util;
import java.awt.GridLayout;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author peixe
 */
public class Cliente extends JFrame {

    private final Usuario user;
    private Thread thread;
    private JPanel cabecera;
    private JPanel cuerpo;
    private JPanel mensaje;

    private JTextArea chat;
    private JTextField ip;
    private JTextField txtMensaje;

    public Cliente(Usuario user) {
        this.user = user;
        initComponents();
        iniciar();
    }

    private void iniciar() {
        thread = new Thread(this::threading);
        thread.setDaemon(true);
        thread.start();
    }

    private void initComponents() {
        setBounds(300, 300, 400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Chat");
        setLayout(new GridLayout(3, 1, 2, 2));

        cabecera = new JPanel(new GridLayout(1, 2, 2, 2));
        cuerpo = new JPanel(new GridLayout(1, 1, 2, 2));
        mensaje = new JPanel(new GridLayout(1, 2, 2, 2));

        add(cabecera);
        add(cuerpo);
        add(mensaje);

        JLabel nombre = new JLabel("Nombre: " + user.getNombre());
        ip = new JTextField();
        cabecera.add(nombre);
        cabecera.add(ip);

        chat = new JTextArea("");
        cuerpo.add(chat);

        txtMensaje = new JTextField();
        mensaje.add(txtMensaje);

        JButton enviar = new JButton("Enviar");
        mensaje.add(enviar);

        enviar.addActionListener(e -> {
            try {
                enviar();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }

    private void enviar() throws IOException {
        Usuario destino = new Usuario();
        destino.setIp(ip.getText());
        Paquete p = new Paquete(user, destino, txtMensaje.getText());
        chat.append("Yo: " + txtMensaje.getText() + "\n");
        p.send(Util.getIP_SERVIDOR(), Util.getPUERTO_SERVIDOR());
    }

    private void threading() {
        ServerSocket servidorCliente;
        Socket socketRecibido;
        Paquete paqueteEntrada;

        try {
            servidorCliente = new ServerSocket(Util.getPUERTO_CLIENTE());
            while (true) {
                socketRecibido = servidorCliente.accept();
                ObjectInputStream datosEntrada = new ObjectInputStream(socketRecibido.getInputStream());
                paqueteEntrada = (Paquete) datosEntrada.readObject();
                chat.append(paqueteEntrada + "\n");
                socketRecibido.close();
            }
        } catch (ClassNotFoundException | IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
