/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
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
    private char[] wordToGuessArray;
    private String wordResult;
    private String wordToGuessString;
    private ImageIcon[] images;
    private int index;

    public Frame() {
        initComponents();
        setListeners();
        start();
    }

    private void initComponents() {
        //general
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(200, 200, 700, 500);
        setTitle("Hangman");

        //buttons
        btnImage = new JButton();
        btnPlayer1 = new JButton("Accept");
        btnPlayer2 = new JButton("Accept");

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

    private void start() {
        index = -1;
        images = new ImageIcon[5];
        for (int i = 0; i < images.length; i++) {
            images[i] = new ImageIcon(getClass().getResource("/images/foto" + i + ".png"));
        }
        btnPlayer2.setEnabled(false);
        txtPlayer2.setEnabled(false);
        btnImage.setIcon(getImage());
    }

    public ImageIcon getImage() {
        index++;
        return images[index];
    }

    private void setListeners() {
        btnPlayer1.addActionListener(e -> {
            wordToGuessArray = txtPlayer1.getPassword();
            txtPlayer1.setEnabled(false);
            btnPlayer1.setEnabled(false);
            btnPlayer2.setEnabled(true);
            txtPlayer2.setEnabled(true);
            wordResult = "";
            wordToGuessString = "";
            for (int i = 0; i < wordToGuessArray.length; i++) {
                wordResult += "-";
                wordToGuessString += wordToGuessArray[i];
            }
            lblWord.setText(wordResult);
            wordToGuessString = wordToGuessString.toUpperCase();
        });

        btnPlayer2.addActionListener(e -> {
            if (txtPlayer2.getText().length() != 1) {
                JOptionPane.showMessageDialog(this, "ONLY ONE LETTER!");
                txtPlayer2.setText("");
            } else {
                char c = txtPlayer2.getText().toUpperCase().charAt(0);
                boolean isLetter = false;
                String aux = "";
                for (int i = 0; i < wordToGuessString.length(); i++) {
                    if (wordToGuessString.charAt(i) == c) {
                        isLetter = true;
                        aux += c;
                    } else {
                        aux += wordResult.charAt(i);
                    }
                }
                wordResult = aux;
                txtPlayer2.setText("");
                lblWord.setText(wordResult);
                if (!isLetter) {
                    btnImage.setIcon(getImage());
                    if (wordResult.contains("-") && index == 4) {
                        btnPlayer2.setEnabled(false);
                        txtPlayer2.setEnabled(false);
                        JOptionPane.showMessageDialog(this, "YOU LOST! The correct word is: " + wordToGuessString);
                    }
                } else {
                    if (!wordResult.contains("-")) {
                        btnPlayer2.setEnabled(false);
                        txtPlayer2.setEnabled(false);
                        JOptionPane.showMessageDialog(this, "YOU WON!");
                    }
                }
            }
        });
    }
}
