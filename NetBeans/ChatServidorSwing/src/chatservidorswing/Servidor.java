/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatservidorswing;

import clases.Paquete;
import clases.Util;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JTextArea;

/**
 *
 * @author peixe
 */
public class Servidor extends JFrame{

    private Thread thread;
    private JTextArea chat;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Servidor servidor = new Servidor();
        servidor.setVisible(true);
    }

    public Servidor() {
        initComponents();
        iniciar();
        
    }

    private void iniciar() {
        thread = new Thread(this::threading);
        thread.setDaemon(true);
        thread.start();
    }
    
    private void initComponents(){
        setBounds(300, 300, 400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Servidor");
        //setLayout(new GridLayout(3, 1, 2, 2));
        
        chat = new JTextArea("");
        add(chat);
        
    }

    private void threading() {
        ServerSocket servidorCliente;
        Socket socketRecibido;
        Paquete paqueteEntrada;

        try {
            servidorCliente = new ServerSocket(Util.getPUERTO_SERVIDOR());
            while (true) {
                socketRecibido = servidorCliente.accept();
                ObjectInputStream datosEntrada = new ObjectInputStream(socketRecibido.getInputStream());
                paqueteEntrada = (Paquete) datosEntrada.readObject();
                chat.append(paqueteEntrada + "\n");
                paqueteEntrada.send(paqueteEntrada.getDestino().getIp(), Util.getPUERTO_CLIENTE());
                socketRecibido.close();
            }
        } catch (ClassNotFoundException | IOException ex) {
            //System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

}
