/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import domain.User;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import test.MainController;

/**
 *
 * @author axegas
 */
public class MainFrame extends JFrame {

    private JTextField txtNick, txtPassword;
    private JLabel lblNick, lblPassword;
    private JButton btnEnter, btnNuevo;
    private JPanel pnlMain;

    private final MainController control;

    public MainFrame(MainController control) {
        this.control = control;
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(300, 300, 700, 250);
        setTitle("Pantalla Login");

        pnlMain = new JPanel(new GridLayout(3, 2, 10, 10));
        add(pnlMain);

        txtNick = new JTextField(50);
        txtPassword = new JTextField(50);

        lblNick = new JLabel("Nick: ");
        lblPassword = new JLabel("Password: ");

        btnEnter = new JButton("Enter");
        btnNuevo = new JButton("Nuevo");

        pnlMain.add(lblNick);
        pnlMain.add(txtNick);
        pnlMain.add(lblPassword);
        pnlMain.add(txtPassword);
        pnlMain.add(btnEnter);
        pnlMain.add(btnNuevo);

        btnEnter.addActionListener(b -> {
            if (!txtNick.getText().equals("") && !txtPassword.getText().equals("")) {
                User u = new User(txtNick.getText(), txtPassword.getText());
                switch (control.conectar(u)) {
                    case 0:
                        System.out.println("El usuario no existe.");
                        break;
                    case 1:
                        System.out.println("Password incorrecto.");
                        break;
                    case 2:
                        System.out.println("Gracias por conectarte!");
                        break;
                }                
            }else{
                System.out.println("Falta rellenar algun campo");
            }
        });

        btnNuevo.addActionListener(b -> {
            if (!txtNick.getText().equals("") && !txtPassword.getText().equals("")) {
                User u = new User(txtNick.getText(), txtPassword.getText());
                control.registrar(u);
                System.out.println("El usuario se ha creado correctamente");
            }else{
                System.out.println("Falta rellenar algun campo");
            }
        });
    }

}
