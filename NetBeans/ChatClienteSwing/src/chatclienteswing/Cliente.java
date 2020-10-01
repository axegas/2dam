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
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
    private Usuario destino;

    private Thread thread;
    private JPanel cabecera;
    private JPanel cuerpo;
    private JPanel mensaje;

    private JTextArea chat;
    private JTextField txtMensaje;
    private JComboBox listaUsers;

    private ArrayList<Usuario> usuarios;
    private Usuario[] usuariosArray;

    public Cliente(Usuario user) throws IOException {
        this.user = user;
        this.destino = user;
        usuarios = new ArrayList<>();
        initComponents();
        conectar();
        iniciar();
    }

    private void iniciar() {
        thread = new Thread(this::threading);
        thread.setDaemon(true);
        thread.start();
    }

    private void conectar() throws IOException {
        Usuario dest = null;
        Paquete p = new Paquete(user, dest, "");
        p.send(Util.getIP_SERVIDOR(), Util.getPUERTO_SERVIDOR());
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

        JLabel nombre = new JLabel("Nombre: " + user);
        listaUsers = new JComboBox();

        cabecera.add(nombre);
        cabecera.add(listaUsers);

        chat = new JTextArea("");
        cuerpo.add(chat);

        txtMensaje = new JTextField();
        mensaje.add(txtMensaje);

        JButton enviar = new JButton("Enviar");
        mensaje.add(enviar);

        enviar.addActionListener(e -> enviar() );

        listaUsers.addItemListener(e -> destino = (Usuario) listaUsers.getSelectedItem());
    }

    private void enviar() {
        try {
            Paquete p = new Paquete(user, destino, txtMensaje.getText());
            chat.append("Yo: " + txtMensaje.getText() + "\n");
            p.send(Util.getIP_SERVIDOR(), Util.getPUERTO_SERVIDOR());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
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
                if (paqueteEntrada.getOrigen() != null) {
                    chat.append(paqueteEntrada + "\n");
                } else {
                    usuarios = paqueteEntrada.getUsuarios();
                    usuariosArray = new Usuario[usuarios.size()];
                    usuariosArray = usuarios.toArray(usuariosArray);
                    listaUsers.setModel(new DefaultComboBoxModel(usuariosArray));
                }
                socketRecibido.close();
            }
        } catch (ClassNotFoundException | IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
