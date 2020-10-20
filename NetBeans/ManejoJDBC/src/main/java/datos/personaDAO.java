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
        Connection conn;
        PreparedStatement stmt;
        ResultSet rs;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            Persona p;
            int id;
            String nombre;
            String apellidos;
            int edad;

            while (rs.next()) {
                id = rs.getInt("id");
                nombre = rs.getString("nombre");
                apellidos = rs.getString("apellidos");
                edad = rs.getInt("edad");
                p = new Persona(id, nombre, apellidos, edad);
                personas.add(p);
            }

            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personas;
    }

    public int insert(Persona p) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, p.getNombre());
            stmt.setString(2, p.getApellidos());
            stmt.setInt(3, p.getEdad());
            registros = stmt.executeUpdate();

            Conexion.close(stmt);
            Conexion.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return registros;
    }

    public int update(Persona p) {

        Connection conn;
        PreparedStatement stmt;
        int registros = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, p.getNombre());
            stmt.setString(2, p.getApellidos());
            stmt.setInt(3, p.getEdad());
            stmt.setInt(4, p.getId());
            registros = stmt.executeUpdate();

            Conexion.close(stmt);
            Conexion.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return registros;
    }

    public void delete(Persona p) {
        Connection conn;
        PreparedStatement stmt;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, p.getId());
            stmt.executeUpdate();

            Conexion.close(stmt);
            Conexion.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
