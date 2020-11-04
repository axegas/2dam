/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatclienteswing;

import clases.Usuario;
import clases.Util;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author peixe
 */
public class Inicio extends JFrame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Inicio ini = new Inicio();
        ini.setVisible(true);
    }

    public Inicio() {
        initComponents();
    }

    private void initComponents() {
        setBounds(200, 200, 300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Inicio");

        JPanel panel = new JPanel(null);
        setContentPane(panel);

        JLabel titulo = new JLabel("Introduce tu nombre: " +  getIp());
        titulo.setBounds(10, 10, 500, 10);
        panel.add(titulo);

        JTextField nombre = new JTextField();
        nombre.setBounds(10, 50, 180, 30);
        panel.add(nombre);
        
//        JButton s = new JButton("entrar");
//        s.setBounds(10, 50, 30, 30);
//        panel.add(s);
//        
//        s.addActionListener(b -> click(nombre.getText()));
        nombre.addActionListener(e -> click(nombre.getText()));
    }

    public void click(String str) {
        try {
            Usuario user = new Usuario(str);
            JOptionPane.showMessageDialog(this,user + getIp());
            user.setIp(getIp());
            
            Cliente c = new Cliente(user);
            c.setVisible(true);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            System.out.println(ex.getMessage());
        }
    }

    public static String getIp() {
        String ip = "";
        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress("google.com", 80));
            ip = socket.getLocalAddress().getHostAddress();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return ip;
    }
}
