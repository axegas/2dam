/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import controller.JListController;
import java.util.ArrayList;
import model.Client;

/**
 *
 * @author peixe
 */
public class JListFrame extends JFrame {

    private final JListController control;
    private JPanel pnlMain, pnlLeft, pnlButtons, pnlRight;
    private JButton btnRight, btnLeft, btnPrint;
    private JList lstLeft, lstRight;
    private DefaultListModel dlmLeft, dlmRight;

    public JListFrame(JListController control) {
        this.control = control;
        initComponents();
    }

    private void initComponents() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(300, 200, 600, 500);
        setTitle("MySQL Test JList");

        //---List---
        dlmLeft = createModelFromArray(control.getListArray());
        dlmRight = new DefaultListModel();

        lstLeft = new JList(dlmLeft);
        lstRight = new JList(dlmRight);

        lstLeft.setFixedCellWidth(200);
        lstLeft.setFixedCellHeight(40);
        lstRight.setFixedCellWidth(200);
        lstRight.setFixedCellHeight(40);

        lstLeft.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lstRight.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        lstLeft.setVisibleRowCount(10);
        lstRight.setVisibleRowCount(10);

        //---Buttons---
        btnRight = new JButton(">>>");
        btnLeft = new JButton("<<<");
        btnPrint = new JButton("Print");

        //---Panels---
        pnlMain = new JPanel(new FlowLayout());
        pnlLeft = new JPanel(new FlowLayout());
        pnlRight = new JPanel(new FlowLayout());
        pnlButtons = new JPanel(new GridLayout(3, 1, 10, 10));

        add(pnlMain);
        pnlMain.add(pnlLeft);
        pnlMain.add(pnlButtons);
        pnlMain.add(pnlRight);

        pnlLeft.add(new JScrollPane(lstLeft));
        pnlRight.add(new JScrollPane(lstRight));
        pnlButtons.add(btnRight);
        pnlButtons.add(btnLeft);
        pnlButtons.add(btnPrint);

        //---Listeners---
        btnRight.addActionListener(e -> moveList(dlmLeft, dlmRight, lstLeft));

        btnLeft.addActionListener(e -> moveList(dlmRight, dlmLeft, lstRight));

        btnPrint.addActionListener(e -> {
            control.createPDF(dlmRight.toArray());
            for (int i = 0; i < dlmRight.size(); i++) {
                dlmLeft.addElement(dlmRight.get(i));
            }
            dlmRight.removeAllElements();
        });
    }

    public DefaultListModel createModelFromArray(ArrayList<Client> clients) {
        DefaultListModel dlm = new DefaultListModel();
        for (int i = 0; i < clients.size(); i++) {
            dlm.add(i, clients.get(i));
        }
        return dlm;
    }

    private void moveList(DefaultListModel dlmOrigen, DefaultListModel dlmDestino, JList lstOrigen) {
        int index = lstOrigen.getSelectedIndex();
        if (index >= 0) {
            dlmDestino.addElement(lstOrigen.getSelectedValue());
            dlmOrigen.remove(index);
        }
    }
}
