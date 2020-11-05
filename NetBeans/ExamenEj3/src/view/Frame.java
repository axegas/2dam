/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author axegas
 */
public class Frame extends JFrame {

    private JPanel pnlMain, pnlOptions, pnlImage;
    private JRadioButton rbWin, rbMac, rbLinux;
    private ButtonGroup bg;
    private JButton btnOk;
    private ImageIcon img;
    private JLabel lblImg;
    private ImageIcon[] images;

    public Frame() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(200, 200, 400, 400);
        setTitle("Ejercicio 3");

        pnlMain = new JPanel(new BorderLayout());
        pnlOptions = new JPanel(new FlowLayout());
        pnlImage = new JPanel(new BorderLayout());

        add(pnlMain);
        pnlMain.add(pnlOptions, BorderLayout.NORTH);
        pnlMain.add(pnlImage);

        rbWin = new JRadioButton("Windows");
        rbLinux = new JRadioButton("Linux");
        rbMac = new JRadioButton("Macintosh");
        rbLinux.setSelected(true);

        bg = new ButtonGroup();
        bg.add(rbWin);
        bg.add(rbLinux);
        bg.add(rbMac);

        lblImg = new JLabel();
        btnOk = new JButton("OK");

        images = new ImageIcon[3];
        images[0] = new ImageIcon(getClass().getResource("/images/windows.jpg"));
        images[1] = new ImageIcon(getClass().getResource("/images/linux.jpg"));
        images[2] = new ImageIcon(getClass().getResource("/images/mac.jpg"));

        lblImg.setIcon(images[1]);

        pnlOptions.add(rbWin);
        pnlOptions.add(rbLinux);
        pnlOptions.add(rbMac);

        pnlMain.add(lblImg, BorderLayout.CENTER);
        pnlMain.add(btnOk, BorderLayout.SOUTH);

        btnOk.addActionListener(b -> action());

    }

    private void action() {
        for (int i = 0; i < pnlOptions.getComponentCount(); i++) {
            JRadioButton button = (JRadioButton) pnlOptions.getComponent(i);
            if (button.isSelected()) {
                lblImg.setIcon(images[i]);
                JOptionPane.showMessageDialog(this,"You selected: " + button.getText());
            }
        }
    }
}
