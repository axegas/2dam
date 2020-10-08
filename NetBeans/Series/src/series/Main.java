/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package series;

import controller.Controller;
import view.FrameShows;

/**
 *
 * @author axegas
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        
        FrameShows fs = new FrameShows(new Controller());
        fs.setVisible(true);

    }

}
