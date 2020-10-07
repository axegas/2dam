/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.*;

/**
 *
 * @author peixe
 */
public class Controller {

    private ListShow listshow;
    private int position;

    public Controller() {
        position = 0;
        listshow = Access.loadLS();
        if (listshow.longitude() == 0) {
            System.out.println("no hay datos");
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
        if (position != listshow.longitude() - 1) {
            position++;
        }
        return getShow();
    }

    public Show last() {
        position = listshow.longitude() - 1;
        return getShow();
    }

    public Show insert(Show s) {
        listshow.setShow(s);
        position = listshow.longitude() - 1;
        Access.saveLS(listshow);
        return getShow();
    }

    public Show delete() {
        Show s = new Show();
        listshow.deleteShow(position);
        if (listshow.longitude() == 0) {
            position = -1;
        } else {
            if (position > 0) {
                position--;
            }
            s = listshow.getShow(position);
        }
        Access.saveLS(listshow);
        return s;
    }

    public Show update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getPos() {
        return position;
    }

    public Show getShow() {
        return listshow.getShow(position);
    }

    public Show update(Show s) {
        listshow.getShow(position).setGenre(s.getGenre());
        listshow.getShow(position).setName(s.getName());
        listshow.getShow(position).setSeasons(s.getSeasons());
        listshow.getShow(position).setScreenwriter(s.getScreenwriter());
        listshow.getShow(position).setSeasons_seen(s.getSeasons_seen());
        return s;
    }
}
