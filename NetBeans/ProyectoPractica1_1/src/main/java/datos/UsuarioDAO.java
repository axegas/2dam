/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import domain.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author axegas
 */
public class UsuarioDAO {

    private final static String SQL_SELECT = "select * from usuario";
    private final static String SQL_INSERT = "insert into usuario(id_usuario,usuario,password)values(?,?,?)";
    private final static String SQL_UPDATE = "update usuario set usuario=?,password=? where id_usuario=?";
    private final static String SQL_DELETE = "delete from usuario where id_usuario=?";

    public ArrayList<Usuario> selectAll() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        Usuario u;
        try (Connection conn = Conexion.getConnection();
                PreparedStatement stmt = conn.prepareStatement(SQL_SELECT);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                u = crearUsuario(rs);
                usuarios.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    public int insert(Usuario u) {
        int registros = 0;
        try (Connection conn = Conexion.getConnection();
                PreparedStatement stmt = conn.prepareStatement(SQL_INSERT)) {
            stmt.setInt(1, u.getId_usuario());
            stmt.setString(2, u.getUsuario());
            stmt.setString(3, u.getPassword());
            registros = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registros;
    }

    public int update(Usuario u) {
        int registros = 0;
        try (Connection conn = Conexion.getConnection();
                PreparedStatement stmt = conn.prepareStatement(SQL_UPDATE)) {
            stmt.setString(1, u.getUsuario());
            stmt.setString(2, u.getPassword());
            stmt.setInt(3, u.getId_usuario());
            registros = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registros;
    }

    public int delete(Usuario u) {
        int registros = 0;
        try (Connection conn = Conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(SQL_DELETE)) {
            stmt.setInt(1, u.getId_usuario());
            registros = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registros;
    }

    //este método sirve para, a partir del ResultSet, obtener los datos necesarios para crear el Usuario
    //una vez está creado, lo devuelve para que el método pueda select pueda añadirlo al arraylist
    private Usuario crearUsuario(ResultSet rs) throws SQLException {
        int id_usuario = rs.getInt("id_usuario");
        String usuario = rs.getString("usuario");
        String password = rs.getString("password");
        Usuario u = new Usuario(id_usuario, usuario, password);
        return u;
    }
}
