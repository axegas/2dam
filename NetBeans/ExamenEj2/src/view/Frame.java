/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;

/**
 *
 * @author axegas
 */
public class Frame extends JFrame {

    private JPanel pnlMain, pnlButton, pnlToggle, pnlCheck, pnlRadio;
    private JButton btn1, btn2, btn3, btn4, btn5, btn6;
    private JToggleButton tb1, tb2, tb3, tb4, tb5, tb6;
    private JCheckBox chx1, chx2, chx3, chx4, chx5, chx6;
    private JRadioButton rb1, rb2, rb3, rb4, rb5, rb6;
    private ButtonGroup bg;

    public Frame() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(200, 200, 800, 400);
        setTitle("Ejercicio 2");

        pnlMain = new JPanel(new GridLayout(4, 1, 10, 10));
        pnlButton = new JPanel(new FlowLayout());
        pnlToggle = new JPanel(new FlowLayout());
        pnlCheck = new JPanel(new FlowLayout());
        pnlRadio = new JPanel(new FlowLayout());

        pnlButton.setBorder(BorderFactory.createTitledBorder("JButton"));
        pnlToggle.setBorder(BorderFactory.createTitledBorder("JToggleButton"));
        pnlCheck.setBorder(BorderFactory.createTitledBorder("JCheckBox"));
        pnlRadio.setBorder(BorderFactory.createTitledBorder("JRadioButton"));

        add(pnlMain);
        pnlMain.add(pnlButton);
        pnlMain.add(pnlToggle);
        pnlMain.add(pnlCheck);
        pnlMain.add(pnlRadio);

        btn1 = new JButton("Mortadelo");
        btn2 = new JButton("Filemon");
        btn3 = new JButton("Carpanta");
        btn4 = new JButton("Rompetechos");
        btn5 = new JButton("Pepe Gotera");
        btn6 = new JButton("Otilio");

        tb1 = new JToggleButton("Mortadelo");
        tb2 = new JToggleButton("Filemon");
        tb3 = new JToggleButton("Carpanta");
        tb4 = new JToggleButton("Rompetechos");
        tb5 = new JToggleButton("Pepe Gotera");
        tb6 = new JToggleButton("Otilio");

        chx1 = new JCheckBox("Mortadelo");
        chx2 = new JCheckBox("Filemon");
        chx3 = new JCheckBox("Carpanta");
        chx4 = new JCheckBox("Rompetechos");
        chx5 = new JCheckBox("Pepe Gotera");
        chx6 = new JCheckBox("Otilio");

        rb1 = new JRadioButton("Mortadelo");
        rb2 = new JRadioButton("Filemon");
        rb3 = new JRadioButton("Carpanta");
        rb4 = new JRadioButton("Rompetechos");
        rb5 = new JRadioButton("Pepe Gotera");
        rb6 = new JRadioButton("Otilio");
        
        bg = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);
        bg.add(rb3);
        bg.add(rb4);
        bg.add(rb5);
        bg.add(rb6);

        pnlButton.add(btn1);
        pnlButton.add(btn2);
        pnlButton.add(btn3);
        pnlButton.add(btn4);
        pnlButton.add(btn5);
        pnlButton.add(btn6);

        pnlToggle.add(tb1);
        pnlToggle.add(tb2);
        pnlToggle.add(tb3);
        pnlToggle.add(tb4);
        pnlToggle.add(tb5);
        pnlToggle.add(tb6);

        pnlCheck.add(chx1);
        pnlCheck.add(chx2);
        pnlCheck.add(chx3);
        pnlCheck.add(chx4);
        pnlCheck.add(chx5);
        pnlCheck.add(chx6);

        pnlRadio.add(rb1);
        pnlRadio.add(rb2);
        pnlRadio.add(rb3);
        pnlRadio.add(rb4);
        pnlRadio.add(rb5);
        pnlRadio.add(rb6);

    }

}
