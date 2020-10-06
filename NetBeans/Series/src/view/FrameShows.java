/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author axegas
 */
public class FrameShows extends JFrame {

    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JButton b1, b2, b3, b4, b5, b6, b7;
    private JLabel l1, l2, l3, l4, l5;
    private JTextField t1, t2, t3, t4, t5;

    public FrameShows() {
        initComponents();

    }

    private void initComponents() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(200, 200, 600, 400);
        setTitle("My Shows");
        
        panel1 = new JPanel(new BorderLayout());
        panel2 = new JPanel(new GridLayout(5,2,1,1));
        panel3 = new JPanel(new FlowLayout());        
        
        add(panel1);
        panel1.add(panel3,BorderLayout.NORTH);
        panel1.add(panel2,BorderLayout.CENTER);
        
        b1 = new JButton("|<");
        b2 = new JButton("<");
        b3 = new JButton(">");
        b4 = new JButton(">|");
        b5 = new JButton("+");
        b6 = new JButton("-");
        b7 = new JButton("*");
        panel3.add(b1);
        panel3.add(b2);
        panel3.add(b3);
        panel3.add(b4);
        panel3.add(b5);
        panel3.add(b6);
        panel3.add(b7);
        
        
        
    }

}
