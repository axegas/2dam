/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatclienteswing;

import clases.Paquete;
import clases.Usuario;
import clases.Util;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
    private JPanel panel;
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
        p.send(Util.IP_SERVIDOR(), Util.PUERTO_SERVIDOR());
    }

    private void initComponents() {
        setBounds(300, 300, 420, 380);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Chat");
        panel = new JPanel(null);
        setContentPane(panel);

        JLabel nombre = new JLabel("Nombre: " + user);
        nombre.setBounds(20, 15, 75, 30);
        panel.add(nombre);

        listaUsers = new JComboBox();
        listaUsers.setBounds(240, 20, 150, 30);
        listaUsers.addItemListener(e -> destino = (Usuario) listaUsers.getSelectedItem());
        panel.add(listaUsers);

        chat = new JTextArea("");        
        chat.setEditable(false);
        JScrollPane sp = new JScrollPane(chat);
        sp.setBounds(20, 60, 370, 200);
        panel.add(sp);

        txtMensaje = new JTextField();
        txtMensaje.setBounds(20, 280, 370, 50);
        txtMensaje.addActionListener(e -> enviar());
        panel.add(txtMensaje);

    }

    private void enviar() {
        try {
            Paquete p = new Paquete(user, destino, txtMensaje.getText());
            chat.append("Yo: " + txtMensaje.getText() + "\n");
            p.send(Util.IP_SERVIDOR(), Util.PUERTO_SERVIDOR());
            txtMensaje.setText("");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void threading() {
        ServerSocket servidorCliente;
        Socket socketRecibido;
        Paquete paqueteEntrada;

        try {
            servidorCliente = new ServerSocket(Util.PUERTO_CLIENTE());
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
