/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

/**
 *
 * @author axegas
 */
public class Frame extends JFrame {

    private JPanel pnlMain, pnlName, pnlRes;
    private JLabel lblName, lblSurname;
    private JButton btnAddList, btnAddCombo;
    private JList list;
    private JComboBox combo;
    private JTextField txtName, txtSurname;
    private String[] listNames;
    private String[] comboNames;
    private ArrayList<String> arrayList;
    private ArrayList<String> arrayCombo;
    private DefaultListModel dlmList;

    public Frame() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(200, 200, 800, 500);
        setTitle("Ejercicio 1");

        pnlMain = new JPanel(new GridLayout(3, 1, 10, 10));
        pnlName = new JPanel(new GridLayout(2, 2, 10, 10));
        pnlRes = new JPanel(new FlowLayout());

        btnAddList = new JButton("Add");
        btnAddCombo = new JButton("Add");

        lblName = new JLabel("Name:");
        lblSurname = new JLabel("Surname:");

        txtName = new JTextField(50);
        txtSurname = new JTextField(50);
        dlmList = new DefaultListModel();
        list = new JList(dlmList);
        combo = new JComboBox();

        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        add(pnlMain);

        pnlMain.add(pnlName);
        pnlMain.add(btnAddList);
        pnlMain.add(pnlRes);
        pnlName.add(lblName);
        pnlName.add(txtName);
        pnlName.add(lblSurname);
        pnlName.add(txtSurname);
        pnlRes.add(new JScrollPane(list));
        pnlRes.add(btnAddCombo);
        pnlRes.add(combo);

        btnAddList.addActionListener(b -> addList());
        btnAddCombo.addActionListener(b -> addCombo());

    }

    private void addList() {
        String name = txtName.getText();
        String surname = txtSurname.getText();

        dlmList.add(dlmList.size(), name + " " + surname);
    }

    private void addCombo() {
        int indexes[] = list.getSelectedIndices();
        for (int i = 0; i < indexes.length; i++) {
            combo.addItem(dlmList.get(indexes[i]));

        }
    }
}
