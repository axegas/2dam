/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author axegas
 */
public class Access {

    private static final File file = new File("series.dat");

    public static void saveLS(ListShow ls) {
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(ls);
            oos.close();
        } catch (IOException ex) {
            System.out.println("Error saving file");
            //ex.printStackTrace();
        }
    }

    public static ListShow loadLS() {
        ListShow ls = new ListShow();
        try {            
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            ls = (ListShow) ois.readObject();
            ois.close();
        } catch (ClassNotFoundException | IOException ex) {
            System.out.println("Error loading file");
            //ex.printStackTrace();
        } 
        return ls;
    }

}
