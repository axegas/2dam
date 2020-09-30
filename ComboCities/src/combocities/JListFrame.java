/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combocities;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author peixe
 */
public class JListFrame extends JFrame {

    private JPanel panel;
    private String nameColours[];
    private Color colours[];

    private JList listColours;

    public JListFrame() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(200, 200, 600, 400);
        setTitle("Simple List");

        panel = new JPanel(new FlowLayout());
        nameColours = new String[]{"Black", "Blue", "Cyan", "Dark gray", "Gray", "Green", "Light gray", "Magenta", "Orange", "Pink", "Red", "White", "Yellow"};
        colours = new Color[]{Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW};

        add(panel);

        listColours = new JList(nameColours);
        listColours.setVisibleRowCount(5);
        listColours.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        panel.add(new JScrollPane(listColours));

        listColours.addListSelectionListener(e -> panel.setBackground(colours[listColours.getSelectedIndex()]));
    }
}
