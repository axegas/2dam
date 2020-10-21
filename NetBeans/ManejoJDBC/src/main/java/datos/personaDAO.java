/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import domain.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author axegas
 */
public class personaDAO {

    private final static String SQL_SELECT = "select * from persona";
    private final static String SQL_INSERT = "insert into persona(nombre,apellidos,edad)values(?,?,?)";
    private final static String SQL_UPDATE = "update persona set nombre='?',apellidos='?',edad='?' where id=?";
    private final static String SQL_DELETE = "delete from persona where id=?";

    public ArrayList<Persona> selectAll() {
        ArrayList<Persona> personas = new ArrayList<>();
        try (Connection conn = Conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(SQL_SELECT)) {
            Persona p;
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    p = crearPersona(rs);
                    personas.add(p);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personas;
    }

    public int insert(Persona p) {
        int registros = 0;
        try (Connection conn = Conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(SQL_INSERT)) {
            stmt.setString(1, p.getNombre());
            stmt.setString(2, p.getApellidos());
            stmt.setInt(3, p.getEdad());
            registros = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registros;
    }

    public int update(Persona p) {
        int registros = 0;
        try (Connection conn = Conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(SQL_UPDATE)) {
            stmt.setString(1, p.getNombre());
            stmt.setString(2, p.getApellidos());
            stmt.setInt(3, p.getEdad());
            stmt.setInt(4, p.getId());
            registros = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registros;
    }

    public int delete(Persona p) {
        int registros = 0;
        try (Connection conn = Conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(SQL_DELETE)) {
            stmt.setInt(1, p.getId());
            registros = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registros;
    }

    private Persona crearPersona(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String nombre = rs.getString("nombre");
        String apellidos = rs.getString("apellidos");
        int edad = rs.getInt("edad");
        Persona p = new Persona(id, nombre, apellidos, edad);
        return p;
    }

}
