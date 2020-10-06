/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package series;

import model.*;
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

        ListShow ls = new ListShow();

        Show s = new Show("Braking Bad", "Vicente Gilligan", 5, "Comedy drama", 5);
        //ls.setShow(s);

        s = new Show("Game of Thrones", "David Benioff", 6, "Drama", 6);
        //ls.setShow(s);

        //Access.saveLS(ls);
        ls = Access.loadLS();
        System.out.println(ls);
        
        FrameShows fs = new FrameShows();
        fs.setVisible(true);
        

    }

}
