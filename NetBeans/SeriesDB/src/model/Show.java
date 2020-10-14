/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author axegas
 */
public class Show implements Serializable {

    private String name;
    private String Screenwriter;
    private int seasons;
    private String genre;
    private int seasons_seen;
    private String platform;
    private int id;

    public Show(String name, String Screenwriter, int seasons, String genre, int seasons_seen, String platform) {
        this.name = name;
        this.Screenwriter = Screenwriter;
        this.seasons = seasons;
        this.genre = genre;
        this.seasons_seen = seasons_seen;
        this.platform = platform;
    }

    public Show() {
        this.name = "";
        this.Screenwriter = "";
        this.seasons = 0;
        this.genre = "";
        this.seasons_seen = 0;
        this.platform = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getPlatform() {
        return platform;
    }

    public String getScreenwriter() {
        return Screenwriter;
    }

    public void setScreenwriter(String Screenwriter) {
        this.Screenwriter = Screenwriter;
    }

    public int getSeasons() {
        return seasons;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getSeasons_seen() {
        return seasons_seen;
    }

    public void setSeasons_seen(int seasons_seen) {
        this.seasons_seen = seasons_seen;
    }

    @Override
    public String toString() {
        return "Show{" + "name=" + name + ", Screenwriter=" + Screenwriter + ", seasons=" + seasons + ", genre=" + genre + ", seasons_seen=" + seasons_seen + '}';
    }

}
