/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seriesdb;

import controller.Controller;
import java.sql.SQLException;
import model.Conector;
import view.FrameShows;

/**
 *
 * @author peixe
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {

            
            Conector con = new Conector();
            //con.statement("DROP TABLE Show");
            con.statement("CREATE TABLE IF NOT EXISTS Show (id integer primary key autoincrement, name VARCHAR(50), Screenwriter VARCHAR(50), seasons integer, genre VARCHAR(50), seen integer, platform VARCHAR(50))");
            con.close();
             
            FrameShows fs = new FrameShows(new Controller());
            fs.setVisible(true);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
