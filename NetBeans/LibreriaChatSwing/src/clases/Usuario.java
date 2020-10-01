package clases;

import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author peixe
 */
public class Usuario  implements Serializable{

    private String nombre;
    private String ip;

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    public Usuario() {       
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getIp() {
        return ip;
    }

    public String getNombre() {
        return nombre;
    }
}
