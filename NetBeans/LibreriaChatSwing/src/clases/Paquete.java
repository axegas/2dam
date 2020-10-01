package clases;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author peixe
 */
public class Paquete implements Serializable {
    
    private final Usuario origen;
    private final Usuario destino;
    private final String mensaje;
    
    public Paquete(Usuario origen, Usuario destino, String mensaje){
        this.origen = origen;
        this.destino = destino;
        this.mensaje = mensaje;
    }
    
    public Usuario getOrigen(){
        return origen;
    }
    
    public Usuario getDestino(){
        return destino;
    }
    
    public String getMensaje(){
        return mensaje;
    }
    
    @Override
    public String toString(){
        return origen.getNombre() + ": " + mensaje;
    }
    
    public void send(String ip, int puerto) throws IOException{
        ObjectOutputStream datosSalida;
        Socket enviaDestinatario = new Socket(ip, puerto);
        datosSalida = new ObjectOutputStream(enviaDestinatario.getOutputStream());
        datosSalida.writeObject(this);
        datosSalida.close();
    }
    
}
