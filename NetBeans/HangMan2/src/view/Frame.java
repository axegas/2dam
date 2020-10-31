/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author axegas
 */
public class Frame extends JFrame {

    private JPanel pnlMain, pnlLeft, pnlPlayer1, pnlPlayer2, pnlRight;
    private JButton btnImage, btnPlayer1, btnPlayer2;
    private JLabel lblTitle, lblLetter, lblWord;
    private JPasswordField txtPlayer1;
    private JTextField txtPlayer2;
    private String wordResult;
    private final Controller control;

    public Frame() {
        this.control = new Controller();
        initComponents();
        setListeners();
        start(true);
    }

    private void initComponents() {
        //general
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(200, 200, 700, 500);
        setTitle("Hangman");

        //buttons        
        btnPlayer1 = new JButton("Accept");
        btnPlayer2 = new JButton("Accept");
        btnImage = new JButton();
        btnImage.setIcon(control.nextImage());

        //labels
        lblTitle = new JLabel("Word to guess");
        lblLetter = new JLabel("Letter");
        lblWord = new JLabel("");
        Font font = new Font("Arial", Font.BOLD, 50);

        lblWord.setFont(font);
        lblWord.setForeground(Color.red);

        //textfields
        txtPlayer2 = new JTextField(50);
        txtPlayer1 = new JPasswordField(50);

        //panels
        pnlMain = new JPanel(new GridLayout(1, 2, 5, 5));
        pnlLeft = new JPanel(new GridLayout(1, 1, 10, 10));
        pnlPlayer1 = new JPanel(new GridLayout(3, 1, 10, 10));
        pnlPlayer2 = new JPanel(new GridLayout(4, 1, 10, 10));
        pnlRight = new JPanel(new GridLayout(2, 1, 10, 10));

        pnlLeft.setBorder(BorderFactory.createTitledBorder("Image"));
        pnlPlayer1.setBorder(BorderFactory.createTitledBorder("Player 1"));
        pnlPlayer2.setBorder(BorderFactory.createTitledBorder("Player 2"));

        //add elements
        add(pnlMain);
        pnlMain.add(pnlLeft);
        pnlMain.add(pnlRight);
        pnlRight.add(pnlPlayer1);
        pnlRight.add(pnlPlayer2);

        pnlLeft.add(btnImage);
        pnlPlayer1.add(lblTitle);
        pnlPlayer1.add(txtPlayer1);
        pnlPlayer1.add(btnPlayer1);
        pnlPlayer2.add(lblLetter);
        pnlPlayer2.add(txtPlayer2);
        pnlPlayer2.add(btnPlayer2);
        pnlPlayer2.add(btnPlayer2);
        pnlPlayer2.add(lblWord);

    }

    private void start(boolean state) {
        txtPlayer1.setEnabled(state);
        btnPlayer1.setEnabled(state);
        btnPlayer2.setEnabled(!state);
        txtPlayer2.setEnabled(!state);
    }

    private void finish(String str) {
        start(true);
        control.start();
        JOptionPane.showMessageDialog(this, str);
        //btnImage.setIcon(control.nextImage());
        txtPlayer1.setText("");
    }

    private void setListeners() {
        btnPlayer1.addActionListener(e -> {
            wordResult = control.firstPlayer(txtPlayer1.getPassword());
            lblWord.setText(wordResult);
            start(false);
        });

        btnPlayer2.addActionListener(e -> {
            String str = txtPlayer2.getText();
            txtPlayer2.setText("");
            if (str.length() != 1) {
                JOptionPane.showMessageDialog(this, "ONLY ONE LETTER!");
            } else {
                wordResult = control.secondPlayer(str.toUpperCase().charAt(0));
                lblWord.setText(wordResult);

                switch (control.getResult()) {
                    case 1:
                        finish("YOU WON!");
                        break;
                    case 2:
                        btnImage.setIcon(control.nextImage());
                        break;
                    case 3:
                        btnImage.setIcon(control.nextImage());
                        finish("YOU LOST!");
                        break;
                    default:
                        break;
                }
            }
        });
    }
}
