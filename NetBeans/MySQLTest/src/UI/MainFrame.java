/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import model.Client;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import controller.MainController;

/**
 *
 * @author peixe
 */
public class MainFrame extends JFrame {

    private JLabel lblNotes, lblID, lblSearch;
    private JButton btnSearch, btnAll, btnLeft, btnRight;
    private JTextArea taNotes;
    private JPanel pnlMain, pnlTop, pnlMiddle, pnlBottom;
    private JTextField txtSearch, txtID;
    private final MainController control;

    public MainFrame(MainController control) {
        this.control = control;
        initComponents();
        updateEnabled(false);
    }

    private void initComponents() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(300, 300, 700, 250);
        setTitle("MySQL Test");

        //Labels
        lblNotes = new JLabel("Notes");
        lblID = new JLabel("ID");
        lblSearch = new JLabel("ID Search");

        //Buttons
        btnSearch = new JButton("Search");
        btnAll = new JButton("All");
        btnLeft = new JButton("<");
        btnRight = new JButton(">");

        //TextArea
        taNotes = new JTextArea(5, 40);
        taNotes.setEditable(false);

        //TextField
        txtSearch = new JTextField(10);
        txtID = new JTextField(10);
        txtID.setEditable(false);
        txtID.setBackground(Color.white);

        //Panels
        pnlMain = new JPanel(new BorderLayout());
        pnlTop = new JPanel(new FlowLayout());
        pnlMiddle = new JPanel(new FlowLayout());
        pnlBottom = new JPanel(new FlowLayout());

        add(pnlMain);
        pnlMain.add(pnlTop, BorderLayout.NORTH);
        pnlMain.add(pnlMiddle, BorderLayout.CENTER);
        pnlMain.add(pnlBottom, BorderLayout.SOUTH);

        pnlTop.add(lblSearch);
        pnlTop.add(txtSearch);
        pnlTop.add(btnSearch);
        pnlTop.add(btnAll);
        pnlMiddle.add(lblID);
        pnlMiddle.add(txtID);
        pnlMiddle.add(lblNotes);
        pnlMiddle.add(taNotes);
        pnlBottom.add(btnLeft);
        pnlBottom.add(btnRight);

        //Listeners
        btnLeft.addActionListener(e -> actualiza(control.left()));
        btnRight.addActionListener(e -> actualiza(control.right()));
        btnSearch.addActionListener(e -> {
            updateEnabled(false);
            actualiza(new Client());
        });

        btnAll.addActionListener(e -> {
            updateEnabled(true);
            txtSearch.setText("");
            actualiza(control.getClienteActual());
        });

        txtSearch.addActionListener(e -> {
            String id = txtSearch.getText();
            Client c = control.search(id);
            if (c != null) {
                actualiza(c);
            }
        });
    }

    private void actualiza(Client c) {
        txtID.setText(c.getId());
        taNotes.setText(c.getNotes());
    }

    private void updateEnabled(boolean state) {
        txtSearch.setEditable(!state);
        btnLeft.setEnabled(state);
        btnRight.setEnabled(state);

        txtSearch.setBackground(Color.white);
    }
}
