/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Show;

/**
 *
 * @author axegas
 */
public class FrameShows extends JFrame {

    private JPanel pnlFrame;
    private JPanel pnlButtons;
    private JPanel pnlMain;
    private JButton btnFirst, btnPrevious, btnNext, btnLast, btnInsert, btnDelete, btnUpdate;
    private JLabel lblTitle, lblScreenwriter, lblSeasons, lblGenre, lblSeen, lblPlatform;
    private JTextField txtTitle, txtScreenwriter, txtSeasons, txtGenre, txtSeen, txtPlatform;
    private JComboBox cmbPlatform;
    private String[] platforms;
    private final Controller control;

    public FrameShows(Controller control) {
        this.control = control;
        initComponents();
        updating(obtenShow());
        setTextFields(false);
    }

    private void initComponents() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(200, 200, 600, 400);
        setTitle("My Shows");

        pnlFrame = new JPanel(new BorderLayout());
        pnlButtons = new JPanel(new FlowLayout());
        pnlMain = new JPanel(new GridLayout(7, 2, 10, 10));

        add(pnlFrame);
        pnlFrame.add(pnlButtons, BorderLayout.NORTH);
        pnlFrame.add(pnlMain, BorderLayout.CENTER);

        btnFirst = new JButton("|<");
        btnPrevious = new JButton("<");
        btnNext = new JButton(">");
        btnLast = new JButton(">|");
        btnInsert = new JButton("+");
        btnDelete = new JButton("-");
        btnUpdate = new JButton("*");

        ButtonsListener bl = new ButtonsListener();
        btnFirst.addActionListener(bl);
        btnPrevious.addActionListener(bl);
        btnNext.addActionListener(bl);
        btnLast.addActionListener(bl);
        btnInsert.addActionListener(bl);
        btnDelete.addActionListener(bl);
        btnUpdate.addActionListener(bl);

        pnlButtons.add(btnFirst);
        pnlButtons.add(btnPrevious);
        pnlButtons.add(btnNext);
        pnlButtons.add(btnLast);
        pnlButtons.add(btnInsert);
        pnlButtons.add(btnDelete);
        pnlButtons.add(btnUpdate);

        lblTitle = new JLabel("Title");
        lblScreenwriter = new JLabel("Screenwriter");
        lblSeasons = new JLabel("Seasons");
        lblGenre = new JLabel("Genre");
        lblSeen = new JLabel("Seen Seasons");
        lblPlatform = new JLabel("Platform");

        txtTitle = new JTextField(50);
        txtScreenwriter = new JTextField(50);
        txtSeasons = new JTextField(50);
        txtGenre = new JTextField(50);
        txtSeen = new JTextField(50);
        txtPlatform = new JTextField(50);

        platforms = new String[3];
        platforms[0] = "NETFLIX";
        platforms[1] = "HBO";
        platforms[2] = "DISNEY";

        cmbPlatform = new JComboBox(platforms);
        cmbPlatform.setVisible(false);

        pnlMain.add(lblTitle);
        pnlMain.add(txtTitle);
        pnlMain.add(lblScreenwriter);
        pnlMain.add(txtScreenwriter);
        pnlMain.add(lblSeasons);
        pnlMain.add(txtSeasons);
        pnlMain.add(lblGenre);
        pnlMain.add(txtGenre);
        pnlMain.add(lblSeen);
        pnlMain.add(txtSeen);
        pnlMain.add(lblPlatform);
        pnlMain.add(txtPlatform);
        pnlMain.add(cmbPlatform);
    }

    private void setButtons(boolean state) {
        btnFirst.setEnabled(state);
        btnPrevious.setEnabled(state);
        btnNext.setEnabled(state);
        btnLast.setEnabled(state);
        btnDelete.setEnabled(state);
        btnUpdate.setEnabled(state);
        btnInsert.setEnabled(state);
    }

    private void setTextFields(boolean state) {
        txtTitle.setEditable(state);
        txtScreenwriter.setEditable(state);
        txtSeasons.setEditable(state);
        txtGenre.setEditable(state);
        txtSeen.setEditable(state);
        txtPlatform.setEditable(state);

        cmbPlatform.setVisible(state);
        lblPlatform.setVisible(!state);
        txtPlatform.setVisible(!state);
    }

    private void updating(Show s) {
        txtTitle.setText(s.getName());
        txtScreenwriter.setText(s.getScreenwriter());
        txtSeasons.setText(String.valueOf(s.getSeasons()));
        txtGenre.setText(s.getGenre());
        txtSeen.setText(String.valueOf(s.getSeasons_seen()));
        txtPlatform.setText(s.getPlatform());
    }

    private Show obtenShow() {
        Show s = new Show();
        if (control.getSize() == 0) {
            setButtons(false);
            btnInsert.setEnabled(true);
        } else {
            s = control.getShow();
        }
        return s;
    }

    class ButtonsListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Show s = new Show();
            if (e.getSource() == btnFirst) {
                s = control.first();
            } else if (e.getSource() == btnPrevious) {
                s = control.previous();
            } else if (e.getSource() == btnNext) {
                s = control.next();
            } else if (e.getSource() == btnLast) {
                s = control.last();
            } else if (e.getSource() == btnInsert) {
                s = insert();
            } else if (e.getSource() == btnDelete) {
                s = delete();
            } else if (e.getSource() == btnUpdate) {
                s = update();
            }
            updating(s);
        }

        private Show fillShow() {
            return new Show(txtTitle.getText(), txtScreenwriter.getText(), Integer.parseInt(txtSeasons.getText()), txtGenre.getText(), Integer.parseInt(txtSeen.getText()), txtPlatform.getText());
        }

        private Show insert() {  
            Show s;
            if (btnInsert.getText().equals("+")) {
                btnInsert.setText("+++");
                setButtons(false);
                btnInsert.setEnabled(true);
                setTextFields(true);
                s = new Show();                
            } else {
                btnInsert.setText("+");
                setButtons(true);
                setTextFields(false);
                txtPlatform.setText(cmbPlatform.getSelectedItem() + "");                   
                try {
                    s = fillShow();
                    control.insert(s);
                } catch (SQLException | NumberFormatException ex) {
                    s = obtenShow();
                    System.out.println(ex.getMessage());
                }                
            }
            return s;
        }

        private Show delete() {
            try {
                control.delete();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            return obtenShow();
        }

        private Show update() {
            Show s = control.getShow();
            int id = s.getId();
            if (btnUpdate.getText().equals("*")) {
                btnUpdate.setText("***");
                setButtons(false);
                btnUpdate.setEnabled(true);
                setTextFields(true);
            } else {
                btnUpdate.setText("*");
                setButtons(true);
                setTextFields(false);
                txtPlatform.setText(cmbPlatform.getSelectedItem() + "");
                try {
                    s = fillShow();
                    s.setId(id);
                    control.update(s);
                } catch (SQLException | NumberFormatException ex) {
                    System.out.println(ex.getMessage());
                }
            }
            return s;
        }
    }
}
