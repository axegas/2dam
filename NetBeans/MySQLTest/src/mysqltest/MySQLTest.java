/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysqltest;

import controller.JListController;
import UI.JListFrame;

/**
 *
 * @author peixe
 */
public class MySQLTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /*        
        CREATE SCHEMA `di` ;
        CREATE TABLE `di`.`clients` (
        `id` VARCHAR(10) NOT NULL,
        `notes` VARCHAR(255) NULL,
        PRIMARY KEY (`id`));
        
        insert into clients values ('1','12zdgfjzdjf34');
        insert into clients values ('2','123gzjz4');
        insert into clients values ('3','123zdgfjzdj4');
        insert into clients values ('4','12xfgkjzdj34');
        insert into clients values ('5','1fdsgjfd234');
        insert into clients values ('6','12<sdgs<dg34');   
        insert into clients values ('7','12zdgfjzdjf34');
        insert into clients values ('8','123gzjz4');
        insert into clients values ('9','123zdgfjzdj4');
        insert into clients values ('10','12xfgkjzdj34');
        insert into clients values ('11','1fdsgjfd234');
        insert into clients values ('12','12<sdgs<dg34'); 
        
         */
        //Frame f = new Frame(new Controller());
        
        
        
        
        JListFrame f = new JListFrame(new JListController());
        f.setVisible(true);
       
     
    }
}
