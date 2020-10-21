/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

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

    public ArrayList<Client> loadClients() {
        ArrayList<Client> clients = new ArrayList<>();
        try (ResultSet rs = con.getResultSet("select * from clients")) {
            Client c;
            while (rs.next()) {
                c = createClient(rs);
                clients.add(c);
            }
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return clients;
    }

    public Client loadClient(String id) {
        Client c = null;
        try (ResultSet rs = con.getResultSet("select * from clients where id = '" + id + "'")) {
            c = createClient(rs);
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return c;
    }

    public DefaultListModel loadClientsModel() {
        DefaultListModel clients = new DefaultListModel();
        try (ResultSet rs = con.getResultSet("select * from clients")) {
            Client c;
            while (rs.next()) {
                c = createClient(rs);
                clients.addElement(c);
            }
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return clients;
    }

    private Client createClient(ResultSet rs) throws SQLException {
        String id = rs.getString(1);
        String notes = rs.getString(2);
        Client c = new Client(id, notes);
        return c;
    }

}