/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysqltest;

import UI.Frame;
import java.sql.SQLException;

/**
 *
 * @author peixe
 */
public class MySQLTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
  
            /*
            CREATE SCHEMA `di` ;
            CREATE TABLE `di`.`client` (
            `id` VARCHAR(10) NOT NULL,
            `notes` VARCHAR(255) NULL,
            PRIMARY KEY (`id`));
             */
            
            Frame f = new Frame(new Controller());
            f.setVisible(true);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}
