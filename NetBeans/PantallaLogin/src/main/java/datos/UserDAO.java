/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import domain.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author axegas
 */
public class UserDAO {

    private final static String SQL_SELECT = "select * from user";
    private final static String SQL_INSERT = "insert into user(nick,password)values(?,?)";
    //private final static String SQL_UPDATE = "update persona set nombre='?',apellidos='?',edad='?' where id=?";
    //private final static String SQL_DELETE = "delete from persona where id=?";

    public ArrayList<User> selectAll() {
        ArrayList<User> personas = new ArrayList<>();
        try (Connection conn = Conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(SQL_SELECT)) {
            User p;
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    p = crearUSer(rs);
                    personas.add(p);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personas;
    }

    public User selectUser(User u) {
        try (Connection conn = Conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement("select * from user where nick='" + u.getNick() + "' and password = '" + u.getPassword() + "'")) {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    u = crearUSer(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }

    public void insert(User u) {
        try (Connection conn = Conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(SQL_INSERT)) {
            stmt.setString(1, u.getNick());
            stmt.setString(2, u.getPassword());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private User crearUSer(ResultSet rs) throws SQLException {
        int id = rs.getInt(1);
        String nick = rs.getString(2);
        String password = rs.getString(3);
        User p = new User(id, nick, password);
        return p;
    }
}
