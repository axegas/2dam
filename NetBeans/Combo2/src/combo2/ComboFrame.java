/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combo2;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author peixe
 */
public class ComboFrame extends JFrame {

    private JPanel panel;
    private String nameCities[];
    private JComboBox comboCities;

    private String nameFriends[];
    private JList listFriends;

    private JLabel labFriends;

    public ComboFrame() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(200, 200, 600, 400);
        setTitle("Simple List");

        panel = new JPanel(new GridLayout(2, 1, 1, 1));
        nameCities = new String[]{"Madrid", "Valencia", "Paris", "New York"};
        comboCities = new JComboBox(nameCities);

        add(panel);

        JPanel cities = new JPanel();
        JPanel friends = new JPanel(new GridLayout(2, 1, 1, 1));

        panel.add(cities);
        panel.add(friends);

        JLabel lab1 = new JLabel("select our city");
        JLabel lab2 = new JLabel();

        cities.add(lab1);
        cities.add(comboCities);
        cities.add(lab2);

        lab1.setForeground(Color.red);
        lab2.setForeground(Color.blue);

        comboCities.addItemListener(e -> lab2.setText(nameCities[comboCities.getSelectedIndex()] + " selected."));

        nameFriends = new String[]{"Black", "Blue", "Cyan", "Dark gray", "Gray", "Green", "Light gray", "Magenta", "Orange", "Pink", "Red", "White", "Yellow"};
        listFriends = new JList(nameFriends);

        listFriends.setVisibleRowCount(5);
        listFriends.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        friends.add(new JScrollPane(listFriends));

        labFriends = new JLabel();
        friends.add(labFriends);
        /*
        listFriends.addListSelectionListener( e -> {
            int[] v = listFriends.getSelectedIndices();            
            String s = "";
            for(int i=0;i<v.length;i++){
                s += nameFriends[v[i]];
                if(i < v.length - 1){
                    s += ", ";
                }                
            }
            labFriends.setText("My friends: " + s);
        });*/

        listFriends.addListSelectionListener(e -> {
            List<String> v = listFriends.getSelectedValuesList();
            String s = "";
            for (int i = 0; i < v.size(); i++) {
                s += v.get(i);
                if (i < v.size() - 1) {
                    s += ", ";
                }
            }
            labFriends.setText("My friends: " + s);
        });

    }
}
