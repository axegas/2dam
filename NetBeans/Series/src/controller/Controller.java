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

    private final ListShow listshow;
    private int position;

    public Controller() {
        position = 0;
        listshow = Access.loadLS();
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

    public Show insert(Show s) {
        listshow.add(s);
        position = listshow.size() - 1;
        Access.saveLS(listshow);
        return getShow();
    }

    public Show delete() {
        Show s = new Show();
        listshow.remove(position);
        if (listshow.size() == 0) {
            position = -1;
        } else {
            if (position > 0) {
                position--;
            }
            s = listshow.get(position);
        }
        Access.saveLS(listshow);
        return s;
    }

    public Show update(Show s) {
        listshow.get(position).setGenre(s.getGenre());
        listshow.get(position).setName(s.getName());
        listshow.get(position).setSeasons(s.getSeasons());
        listshow.get(position).setScreenwriter(s.getScreenwriter());
        listshow.get(position).setSeasons_seen(s.getSeasons_seen());
        Access.saveLS(listshow);
        return s;
    }

    public int getPos() {
        return position;
    }

    public Show getShow() {
        return listshow.get(position);
    }

}
