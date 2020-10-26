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
public class PropietarioDAO {

    private final static String SQL_SELECT = "select * from propietarios";
    private final static String SQL_INSERT = "insert into propietarios(DNI,Nombre,Edad)values(?,?,?)";
    private final static String SQL_UPDATE = "update propietarios set Nombre=?,edad=? where DNI=?";
    private final static String SQL_DELETE = "delete from propietarios where DNI=?";

    public ArrayList<Propietario> selectAll() {
        ArrayList<Propietario> propietarios = new ArrayList<>();
        Propietario p;
        try (Connection conn = Conexion.getConnection();
                PreparedStatement stmt = conn.prepareStatement(SQL_SELECT);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                p = crearPropietario(rs);
                propietarios.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return propietarios;
    }

    public Propietario selectByDNI(String DNI) {
        Propietario p = null;
        Coche c;
        try (Connection conn = Conexion.getConnection();
                PreparedStatement stmt = conn.prepareStatement(SQL_SELECT + " where DNI = '" + DNI + "'");
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                p = crearPropietario(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    public int insert(Propietario p) {
        int registros = 0;
        try (Connection conn = Conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(SQL_INSERT)) {
            stmt.setString(1, p.getDNI());
            stmt.setString(2, p.getNombre());
            stmt.setInt(3, p.getEdad());
            registros = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registros;
    }

    public int update(Propietario p) {
        int registros = 0;
        try (Connection conn = Conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(SQL_UPDATE)) {
            stmt.setString(1, p.getNombre());
            stmt.setInt(2, p.getEdad());
            stmt.setString(3, p.getDNI());
            registros = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registros;
    }

    public int delete(Propietario p) {
        int registros = 0;
        try (Connection conn = Conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(SQL_DELETE)) {
            stmt.setString(1, p.getDNI());
            registros = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registros;
    }
    
    public int deleteEnCascada(Propietario p){
        int registros = 0;
        CocheDAO cdao = new CocheDAO();
        ArrayList<Coche> coches = cdao.selectByDNI(p.getDNI());
        registros = this.delete(p);
        for(int i=0;i<coches.size();i++){
            cdao.delete(coches.get(i));
        }        
        return registros;
    }

    private Propietario crearPropietario(ResultSet rs) throws SQLException {
        String DNI = rs.getString("DNI");
        String nombre = rs.getString("Nombre");
        int edad = rs.getInt("Edad");
        Propietario p = new Propietario(DNI, nombre, edad);
        return p;
    }

}
