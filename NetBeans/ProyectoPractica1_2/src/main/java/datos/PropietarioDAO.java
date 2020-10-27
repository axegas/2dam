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

    //variablos de acceso a bbdd
    private final static String SQL_SELECT = "select * from propietarios";
    private final static String SQL_INSERT = "insert into propietarios(DNI,Nombre,Edad)values(?,?,?)";
    private final static String SQL_UPDATE = "update propietarios set Nombre=?,edad=? where DNI=?";
    private final static String SQL_DELETE = "delete from propietarios where DNI=?";

    //metodo para seleccionar todos los propietarios y meterlos en un arraylist
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

    //devuelve los datos de un propietario a partir de su DNI
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

    //insertar un propietario en la bd
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

    //actualizar los datos de un propietario
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

    //eleminiar un propietario 
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
    
    //eliminar un propietario y todos los coches que tiene asociados
    public int deleteEnCascada(Propietario p){
        int registros = 0;
        CocheDAO cdao = new CocheDAO();
        ArrayList<Coche> coches = cdao.selectByDNI(p.getDNI());        
        for(int i=0;i<coches.size();i++){
            cdao.delete(coches.get(i));
        }  
        registros = this.delete(p);
        return registros;
    }

    //este método sirve para, a partir del ResultSet, obtener los datos necesarios para crear el propietario.
    //una vez está creado, lo devuelve para que el método pueda select pueda añadirlo al arraylist
    private Propietario crearPropietario(ResultSet rs) throws SQLException {
        String DNI = rs.getString("DNI");
        String nombre = rs.getString("Nombre");
        int edad = rs.getInt("Edad");
        Propietario p = new Propietario(DNI, nombre, edad);
        return p;
    }

}
