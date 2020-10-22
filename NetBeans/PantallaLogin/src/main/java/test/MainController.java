/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import datos.UserDAO;
import domain.User;
import java.util.ArrayList;

/**
 *
 * @author axegas
 */
public class MainController {

    private final UserDAO conn;
    private ArrayList<User> users;

    public MainController() {
        this.conn = new UserDAO();
        searchAll();
    }

    private void searchAll() {
        this.users = conn.selectAll();
    }
    
    public int conectar(User u){
        int estado = 0;
        for(int i=0;i<users.size();i++){
            if(users.get(i).getNick().equals(u.getNick())){
                estado = 1;
                if(users.get(i).getPassword().equals(u.getPassword())){
                    estado = 2;
                }
                break;
            }            
        }        
        return estado;
    }
    
    public void registrar(User u){
        conn.insert(u);
        u = conn.selectUser(u);
        users.add(u);   
    }
}
