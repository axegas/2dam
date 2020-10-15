/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import model.Conector;
import model.ListShow;
import model.Show;

/**
 *
 * @author peixe
 */
public class Controller {

    private final ListShow listshow;
    private final Conector conector;
    private int position;

    public Controller() throws SQLException {
        position = 0;
        conector = new Conector();
        listshow = conector.loadShows();
        if (listshow.size() == 0) {
            position = -1;
        }
    }

    public Show first() {
        position = 0;
        return getShow();
    }

    public Show previous() {
        if (position > 0) {
            position--;
        }
        return getShow();
    }

    public Show next() {
        if (position != listshow.size() - 1) {
            position++;
        }
        return getShow();
    }

    public Show last() {
        position = listshow.size() - 1;
        return getShow();
    }

    public void insert(Show s) throws SQLException {
        conector.insertShow(s);
        listshow.add(s);
        position = listshow.size() - 1;        
    }

    public void delete() throws SQLException {
        conector.deleteShow(getShow());
        listshow.remove(position);
        if(getSize()==0){
            position = -1;
        }else{
            if(position!=0){
                position--;
            }
        }
    }

    public void update(Show s) throws SQLException {
        getShow().setGenre(s.getGenre());
        getShow().setName(s.getName());
        getShow().setSeasons(s.getSeasons());
        getShow().setScreenwriter(s.getScreenwriter());
        getShow().setSeasons_seen(s.getSeasons_seen());
        getShow().setPlatform(s.getPlatform());
        getShow().setId(s.getId());
        conector.updateShow(s);
    }

    public int getSize() {
        return listshow.size();
    }

    public Show getShow() {
        return listshow.get(position);
    }

}
