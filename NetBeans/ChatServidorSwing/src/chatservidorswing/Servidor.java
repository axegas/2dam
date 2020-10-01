/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatservidorswing;

import clases.Paquete;
import clases.Usuario;
import clases.Util;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author peixe
 */
public class Servidor extends JFrame {

    private Thread thread;
    private JTextArea chat;
    private ArrayList<Usuario> usuarios;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Servidor servidor = new Servidor();
        servidor.setVisible(true);
    }

    public Servidor() {
        usuarios = new ArrayList<>();
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
        setTitle("Servidor");

        chat = new JTextArea("");
        chat.setEditable(false);
        JScrollPane sp = new JScrollPane(chat);
        add(sp);
    }

    private void threading() {
        ServerSocket servidorCliente;
        Socket socketRecibido;
        Paquete paqueteEntrada;

        try {
            servidorCliente = new ServerSocket(Util.PUERTO_SERVIDOR());
            while (true) {
                socketRecibido = servidorCliente.accept();
                ObjectInputStream datosEntrada = new ObjectInputStream(socketRecibido.getInputStream());
                paqueteEntrada = (Paquete) datosEntrada.readObject();
                if (paqueteEntrada.getDestino() != null) {
                    chat.append(paqueteEntrada + " ***enviado a*** " + paqueteEntrada.getDestino() + "\n");
                    paqueteEntrada.send(paqueteEntrada.getDestino().getIp(), Util.PUERTO_CLIENTE());                    
                } else {
                    usuarios.add(paqueteEntrada.getOrigen());
                    Paquete p = new Paquete(null, null, "");
                    p.setUsuarios(usuarios);
                    for (int i = 0; i < usuarios.size(); i++) {
                        p.send(usuarios.get(i).getIp(), Util.PUERTO_CLIENTE());
                    }
                    chat.append("Usuario " + paqueteEntrada.getOrigen() + " conectado.\n");
                }
                socketRecibido.close();
            }
        } catch (ClassNotFoundException | IOException ex) {
            //System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

}
