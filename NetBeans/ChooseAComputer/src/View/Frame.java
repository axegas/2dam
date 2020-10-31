/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Controller;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

/**
 *
 * @author peixe
 */
public class Frame extends JFrame {

    private final String[][] prMicros = {{"Intel 1", "300"}, {"Intel 2", "350"}, {"AMD 1", "200"}, {"AMD 2", "250"}};
    private final String[][] prMonitors = {{"LG1", "300"}, {"LG2", "350"}, {"HP1", "200"}, {"HP2", "250"}};
    private final String[][] prRam = {{"RAM 1GB", "300"}, {"RAM 2GB", "350"}, {"RAM 4GB", "200"}, {"RAM 8GB", "250"}};
    private final String[][] prMisc = {{"Mouse normal", "300"}, {"Mouse pro", "350"}, {"Keyboard normal", "200"}, {"Keyboard pro", "250"}};
    private final Controller control;

    private JPanel pnlMain, pnlMicros, pnlRam, pnlMonitors, pnlMisc, pnlOptions, pnlResult;
    private JTextArea txtaResult;
    private JButton btnPrint, btnPreview;
    private ButtonGroup bgMicros, bgRam, bgMonitor;
    private JCheckBox cbMouseNormal, cbMousePro, cbKeyboardNormal, cbKeyboardPro;

    public Frame(Controller control) {
        this.control = control;
        initComponents();
    }

    private void initComponents() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(200, 200, 600, 400);
        setTitle("Choose a Computer");

        pnlMain = new JPanel(new BorderLayout());
        pnlMicros = new JPanel(new GridLayout(prMicros.length, 1, 10, 10));
        pnlRam = new JPanel(new GridLayout(prRam.length, 1, 10, 10));
        pnlMonitors = new JPanel(new GridLayout(prMonitors.length, 1, 10, 10));
        pnlMisc = new JPanel(new GridLayout(prMisc.length, 1, 10, 10));
        pnlOptions = new JPanel(new GridLayout(1, 4, 10, 10));
        pnlResult = new JPanel(new BorderLayout());

        add(pnlMain);
        pnlMain.add(pnlOptions, BorderLayout.NORTH);
        pnlMain.add(pnlResult, BorderLayout.CENTER);
        pnlOptions.add(pnlMicros);
        pnlOptions.add(pnlRam);
        pnlOptions.add(pnlMonitors);
        pnlOptions.add(pnlMisc);

        pnlMicros.setBorder(BorderFactory.createTitledBorder("Processor"));
        pnlRam.setBorder(BorderFactory.createTitledBorder("RAM"));
        pnlMonitors.setBorder(BorderFactory.createTitledBorder("Monitor"));
        pnlMisc.setBorder(BorderFactory.createTitledBorder("Miscellanea"));

        btnPrint = new JButton("Print");
        btnPreview = new JButton("Preview");
        btnPrint.setEnabled(false);
        txtaResult = new JTextArea();
        txtaResult.setEditable(false);

        pnlResult.add(btnPrint, BorderLayout.SOUTH);
        pnlResult.add(btnPreview, BorderLayout.NORTH);
        pnlResult.add(txtaResult, BorderLayout.CENTER);

        bgMicros = new ButtonGroup();
        bgRam = new ButtonGroup();
        bgMonitor = new ButtonGroup();

        for (int i = 0; i < prMicros.length; i++) {
            JRadioButton rbMicro = new JRadioButton(prMicros[i][0]);
            JRadioButton rbRam = new JRadioButton(prRam[i][0]);
            JRadioButton rbMonitor = new JRadioButton(prMonitors[i][0]);

            bgMicros.add(rbMicro);
            bgRam.add(rbRam);
            bgMonitor.add(rbMonitor);

            pnlMicros.add(rbMicro);
            pnlRam.add(rbRam);
            pnlMonitors.add(rbMonitor);
        }

        cbMouseNormal = new JCheckBox("Mouse normal");
        cbMousePro = new JCheckBox("Mouse pro");
        cbKeyboardNormal = new JCheckBox("Keyboard normal");
        cbKeyboardPro = new JCheckBox("Keyboard pro");

        pnlMisc.add(cbMouseNormal);
        pnlMisc.add(cbMousePro);
        pnlMisc.add(cbKeyboardNormal);
        pnlMisc.add(cbKeyboardPro);

        btnPreview.addActionListener(b -> showPrice());
        btnPrint.addActionListener(b -> control.createPDF(txtaResult.getText()));

    }

    private void showPrice() {

        txtaResult.setText("");
        int total = 0;

        total += getPrizeButtons("Processor", pnlMicros, prMicros);
        total += getPrizeButtons("RAM", pnlRam, prRam);
        total += getPrizeButtons("Monitor", pnlMonitors, prMonitors);
        txtaResult.append("Extras:\n");
        total += getPrizeCheck(pnlMisc, prMisc);
        
        txtaResult.append("--------------------------------------------------------------------------\n");
        txtaResult.append("Total: " + total);
        btnPrint.setEnabled(true);
    }

    public int getPrizeButtons(String element, JPanel panel, String[][] prizes) {
        int prize = 0;
        for (int i = 0; i < panel.getComponentCount(); i++) {
            JRadioButton button = (JRadioButton) panel.getComponent(i);
            if (button.isSelected()) {
                String value = button.getText();
                prize = Integer.parseInt(prizes[i][1]);
                txtaResult.append(element + " -> " + value + ": " + prize + "\n");
            }
        }
        return prize;
    }

    public int getPrizeCheck(JPanel panel, String[][] prizes) {
        int prize = 0;
        for (int i = 0; i < panel.getComponentCount(); i++) {
            JCheckBox checkBox = (JCheckBox) panel.getComponent(i);
            if (checkBox.isSelected()) {
                String value = checkBox.getText();
                prize = Integer.parseInt(prizes[i][1]);
                txtaResult.append("\t" + value + ": " + prize + "\n");
            }
        }
        return prize;
    }
}
