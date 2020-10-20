/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysqltest;

import DAO.Client;
import DAO.ClientDAO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author peixe
 */
public class Controller {

    private final ClientDAO conn;
    private ArrayList<Client> clients;
    private int position;
    private Client clienteActual;

    public Controller() {
        this.conn = new ClientDAO();
        try {
            searchAll();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Client getClienteActual() {
        return clienteActual;
    }

    public Client left() {
        if (position > 0) {
            position--;
            clienteActual = clients.get(position);
        }
        return clienteActual;
    }

    public Client right() {
        if (position < clients.size() - 1) {
            position++;
            clienteActual = clients.get(position);
        }
        return clienteActual;
    }

    public Client search(String ID) {
        Client c = null;
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getId().equals(ID)) {
                position = i;
                c = clients.get(i);
                break;
            }
        }
        if(c!=null){
            clienteActual = c;
        }
        return c;
    }

    /*
    public Client search(String ID) {
        Client c = null;
        try {
            c = conn.loadClient(ID);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return c;
    }*/
    private void searchAll() throws SQLException {
        this.clients = conn.loadClients();
        if (clients.isEmpty()) {
            this.position = -1;
            clienteActual = new Client();
        } else {
            this.position = 0;
            clienteActual = clients.get(position);
        }
    }

}
