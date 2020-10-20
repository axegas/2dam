/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author peixe
 */
public class ClientDAO {

    private Connect con;

    public ClientDAO() {
        try {
            con = new Connect();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Client> loadClients() throws SQLException {
        ArrayList<Client> clients = new ArrayList<>();
        ResultSet rs = con.consulta("select * from clients");
        String id;
        String notes;
        Client c;
        while (rs.next()) {
            id = rs.getString(1);
            notes = rs.getString(2);
            c = new Client(id, notes);
            clients.add(c);
        }
        return clients;
    }

    public Client loadClient(String id) throws SQLException{
        ResultSet rs = con.consulta("select * from clients where id = '"+id+"'");
        String notes;
        Client c = null;
        while (rs.next()) {
            id = rs.getString(1);
            notes = rs.getString(2);
            c = new Client(id, notes);
        }
        return c;
    }

}
