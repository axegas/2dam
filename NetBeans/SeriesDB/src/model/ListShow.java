/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author axegas
 */
public class ListShow {

    private final ArrayList<Show> shows;

    public ListShow() {
        shows = new ArrayList<>();
    }
    
    public void remove(int pos){
        shows.remove(pos);
    }

    public void add(Show s) {
        this.shows.add(s);
    }

    public Show get(int pos) {
        return shows.get(pos);
    }

    public int size() {
        return shows.size();
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < shows.size(); i++) {
            str += shows.get(i) + "\n";
        }
        return str;
    }
}
