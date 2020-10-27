/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author axegas
 */
public class Conexion {

    //estas variables las uso para poder cambiar los parámetros de la conexion a la BD de una forma más sencilla, 
    //para que cuando empiece un nuevo proyecto, solo tenga que cambiar los parametros adecuados
    private static final String DB = "test";
    private static final String HOST = "localhost";
    private static final String USUARIO = "root";
    private static final String CLAVE = "apg946130";
    private static final String URL = "jdbc:mysql://" + HOST + ":3306/" + DB + "?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";   

    /*
    En un principio esto no hace falta, pero en algunas ocasiones me ha dado problemas al conectar a la bd, 
    Y con este código lo he solucionado.
    
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CLAVE);
    }

}
