/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import domain.Coche;
import domain.Propietario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author axegas
 */
public class CocheDAO {

    private final static String SQL_SELECT = "select * from coches";
    private final static String SQL_INSERT = "insert into coches(Matricula,Marca,Precio,DNI)values(?,?,?,?)";
    private final static String SQL_UPDATE = "update coches set Marca=?,Precio=?,DNI=? where Matricula=?";
    private final static String SQL_DELETE = "delete from coches where Matricula=?";

    public ArrayList<Coche> selectAll() {
        ArrayList<Coche> coches = new ArrayList<>();
        Coche c;
        try (Connection conn = Conexion.getConnection();
                PreparedStatement stmt = conn.prepareStatement(SQL_SELECT);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                c = crearCoche(rs);
                coches.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return coches;
    }

    public ArrayList<Coche> selectByDNI(String DNI) {
        ArrayList<Coche> coches = new ArrayList<>();
        Coche c;
        try (Connection conn = Conexion.getConnection();
                PreparedStatement stmt = conn.prepareStatement(SQL_SELECT + " where DNI = '" + DNI + "'");
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                c = crearCoche(rs);
                coches.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return coches;
    }

    public int insert(Coche c) {
        int registros = 0;
        PropietarioDAO pdao = new PropietarioDAO();
        Propietario p = pdao.selectByDNI(c.getDNI());
        if (p == null) {
            return -1;
        } else {
            try (Connection conn = Conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(SQL_INSERT)) {
                stmt.setString(1, c.getMatricula());
                stmt.setString(2, c.getMarca());
                stmt.setInt(3, c.getPrecio());
                stmt.setString(4, c.getDNI());
                registros = stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return registros;
        }
    }

    public int update(Coche c) {
        int registros = 0;
        try (Connection conn = Conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(SQL_UPDATE)) {
            stmt.setString(1, c.getMarca());
            stmt.setInt(2, c.getPrecio());
            stmt.setString(3, c.getDNI());
            stmt.setString(4, c.getMatricula());
            registros = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registros;
    }

    public int delete(Coche c) {
        int registros = 0;
        try (Connection conn = Conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(SQL_DELETE)) {
            stmt.setString(1, c.getMatricula());
            registros = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registros;
    }

    private Coche crearCoche(ResultSet rs) throws SQLException {
        String matricula = rs.getString("Matricula");
        String marca = rs.getString("Marca");
        int precio = rs.getInt("Precio");
        String DNI = rs.getString("DNI");
        Coche c = new Coche(matricula, marca, precio, DNI);
        return c;
    }

}
