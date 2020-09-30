/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combocities;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author peixe
 */
public class FrameCombo extends JFrame {

    public FrameCombo() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setBounds(200, 200, 600, 400);
        setSize(600,400);
        setTitle("Combo cities");
        
        add(new JLabel("hola"));
    }

}
