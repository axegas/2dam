/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author axegas
 */
public class Frame extends JFrame {

    private Controller control;
    private JPanel pnlMain, pnlLeft, pnlPlayer1, pnlPlayer2, pnlRight;

    public Frame(Controller control) {
        this.control = control;
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(200, 200, 600, 400);
        setTitle("Hangman");
        
        pnlMain = new JPanel(new GridLayout(1,2,10,10));
        pnlLeft = new JPanel();
        pnlPlayer1 = new JPanel(new GridLayout(3,1,10,10));
        pnlPlayer2 = new JPanel(new GridLayout(4,1,10,10));
        pnlRight = new JPanel(new GridLayout(2,1,10,10));
        
        pnlLeft.setBorder(BorderFactory.createTitledBorder("Image"));
        pnlPlayer1.setBorder(BorderFactory.createTitledBorder("Player 1"));
        pnlPlayer2.setBorder(BorderFactory.createTitledBorder("Player 2"));
        
        add(pnlMain);
        pnlMain.add(pnlLeft);
        pnlMain.add(pnlRight);
        pnlRight.add(pnlPlayer1);
        pnlRight.add(pnlPlayer2);
        
        
        
        
        
    }

}
