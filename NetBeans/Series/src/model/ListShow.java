/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author axegas
 */
public class ListShow implements Serializable {
    private final ArrayList<Show> shows;

    public ListShow() {
        shows = new ArrayList<>();
    }

    public ArrayList<Show> getShows() {
        return shows;
    }

    public void setShow(Show s) {
        this.shows.add(s);
    }
    
    public int longitude(){
        return shows.size();
    }

    @Override
    public String toString() {
        String str = "";
        for(int i=0;i<shows.size();i++){
            str += shows.get(i) + "\n";
        }
        return str;
    }
}
