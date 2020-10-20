/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

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
public class Connect {

    private static final String HOST = "127.0.0.1";
    private static final String DB = "di";
    private static final String URL = "jdbc:mysql://" + HOST + ":3306/" + DB;
    private static final String ATRIBUTES = "?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String USUARIO = "root";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String CLAVE = "apg946130";

    private final Connection conexion;

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connect() throws SQLException {
        conexion = DriverManager.getConnection(URL + ATRIBUTES, USUARIO, CLAVE);
    }

    public void close(Connection con) throws SQLException {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
}
