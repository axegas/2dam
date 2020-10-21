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
import mysqltest.ControllerJList;

/**
 *
 * @author peixe
 */
public class FrameJList extends JFrame {

    private final ControllerJList control;
    private JPanel pnlMain, pnlLeft, pnlButtons, pnlRight;
    private JButton btnRight, btnLeft, btnPrint;
    private JList lstLeft, lstRight;
    private DefaultListModel dlmLeft, dlmRight;

    public FrameJList(ControllerJList control) {
        this.control = control;
        initComponents();
    }

    private void initComponents() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(300, 200, 600, 600);
        setTitle("MySQL Test JList");

        //---List---
        dlmLeft = control.getListModel();
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

        //---Listeners
        btnRight.addActionListener(e -> {
            int index = lstLeft.getSelectedIndex();
            if (index >= 0) {
                dlmRight.addElement(lstLeft.getSelectedValue());
                dlmLeft.remove(index);
            }
        });

        btnLeft.addActionListener(e -> {
            int index = lstRight.getSelectedIndex();
            if (index >= 0) {
                dlmLeft.addElement(lstRight.getSelectedValue());
                dlmRight.remove(index);
            }
        });

        btnPrint.addActionListener(e -> control.createPDF(dlmRight));

    }
}
