
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author axegas
 */
public class TestMySQLJDBC {

    private static final String URL = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String USUARIO = "root";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String CLAVE = "apg946130";

    public static void main(String[] args) {

        try {
            Class.forName(DRIVER);
            Connection conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);

            Statement instruccion = conexion.createStatement();
            String sql = "SELECT * FROM persona";
            ResultSet resultado = instruccion.executeQuery(sql);
            
            while (resultado.next()) {
                System.out.println(resultado.getInt("id_persona")+"\t"+resultado.getString("nombre")+"\t"+resultado.getString("apellidos")+"\t"+resultado.getString("email")+"\t"+resultado.getInt("edad"));
            }
            resultado.close();
            instruccion.close();
            conexion.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

}
