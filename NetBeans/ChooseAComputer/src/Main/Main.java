/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Controller.Controller;
import View.Frame;

/**
 *
 * @author peixe
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Controller control = new Controller();
        Frame f = new Frame(control);
        f.setVisible(true);
        
    }
    
}
