/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.Client;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author peixe
 */
public class ClientDAO {

    private Connect con;
    private final static String SQL_SELECT = "select * from clients";

    public ClientDAO() {
        try {
            con = new Connect();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Client> loadClients() {
        ArrayList<Client> clients = new ArrayList<>();
        try (ResultSet rs = con.getResultSet(SQL_SELECT)){            
            Client c;
            while (rs.next()) {
                c = createClient(rs);
                clients.add(c);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return clients;
    }

    public Client loadClient(String id) {
        Client c = null;
        try (ResultSet rs = con.getResultSet(SQL_SELECT + " where id = '" + id + "'")) {
            c = createClient(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return c;
    }   

    private Client createClient(ResultSet rs) throws SQLException {
        String id = rs.getString(1);
        String notes = rs.getString(2);
        Client c = new Client(id, notes);
        return c;
    }

}
