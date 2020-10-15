/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author peixe
 */
public class Conector {

    private final String url = "src/database/base.db";
    private Connection conexion;

    public Conector() {
        try {
            conexion = DriverManager.getConnection("jdbc:sqlite:" + url);
        } catch (SQLException ex) {
            System.err.println("No se ha podido conectar a la base de datos\n" + ex.getMessage());
        }
    }

    public void close() throws SQLException {
        conexion.close();
    }

    public ResultSet consulta(String query) throws SQLException {
        ResultSet rs;
        Statement stm = conexion.createStatement();
        rs = stm.executeQuery(query);
        return rs;
    }

    public void statement(String query) throws SQLException {
        PreparedStatement preparedStatement = conexion.prepareStatement(query);
        preparedStatement.executeUpdate();
    }

    public void insertShow(Show s) throws SQLException {
        this.statement("INSERT INTO Show (name,Screenwriter,seasons,genre,seen,platform) VALUES ('" + s.getName() + "','" + s.getScreenwriter() + "','" + s.getSeasons() + "','" + s.getGenre() + "','" + s.getSeasons_seen() + "','" + s.getPlatform() + "')");
    }

    public void deleteShow(Show s) throws SQLException {
        this.statement("DELETE FROM Show WHERE id= " + s.getId() + "");
    }

    public void updateShow(Show s) throws SQLException {
        this.statement("UPDATE Show SET name='" + s.getName() + "', Screenwriter='" + s.getScreenwriter() + "', seasons=" + s.getSeasons() + ", genre='" + s.getGenre() + "', seen=" + s.getSeasons_seen() + ", platform='" + s.getPlatform() + "' WHERE id= " + s.getId() + "");
    }

    public ListShow loadShows() throws SQLException {
        ResultSet rs = this.consulta("select * from Show");
        ListShow ls = new ListShow();
        while (rs.next()) {
            int i = rs.getInt(1);
            String name = rs.getString(2);
            String Screenwriter = rs.getString(3);
            int seasons = rs.getInt(4);
            String genre = rs.getString(5);
            int seen = rs.getInt(6);
            String platform = rs.getString(7);
            Show s = new Show(name, Screenwriter, seasons, genre, seen, platform);
            s.setId(i);
            ls.add(s);
        }
        return ls;
    }

}
