/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysqltest;

import UI.Frame;

/**
 *
 * @author peixe
 */
public class MySQLTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Frame f = new Frame(new Controller());
        f.setVisible(true);
    }
}
