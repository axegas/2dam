/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatclienteswing;

import clases.Usuario;
import java.awt.GridLayout;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
        Inicio main = new Inicio();
        main.setVisible(true);
    }

    public Inicio() {
        initComponents();
    }

    private void initComponents() {
        setBounds(300, 300, 200, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Inicio");
        
        JPanel panel = new JPanel(new GridLayout(2,1,10,10));
        add(panel);
        
        JLabel titulo = new JLabel("Introduce tu nombre: ");
        panel.add(titulo);
        
        JTextField nombre = new JTextField();
        panel.add(nombre);  
        
        nombre.addActionListener(e -> {
            try {
                click(nombre.getText());
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        });        
    }
    
    public void click(String str) throws IOException{
        Usuario user = new Usuario(str);
        user.setIp(getIp());
        Cliente c = new Cliente(user);
        c.setVisible(true);
    }
    
    public String getIp() throws IOException{
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("google.com", 80));
        String IP = socket.getLocalAddress().getHostAddress();
        return IP;        
    }
    

}
