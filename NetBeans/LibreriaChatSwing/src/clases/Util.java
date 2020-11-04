/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 *
 * @author peixe
 */
public class Util {

    private static final int PUERTO_CLIENTE = 9999;
    private static final int PUERTO_SERVIDOR = 9000;
    private static final String IP_SERVIDOR = "192.168.1.34";

    public static int PUERTO_CLIENTE() {
        return PUERTO_CLIENTE;
    }

    public static int PUERTO_SERVIDOR() {
        return PUERTO_SERVIDOR;
    }

    public static String IP_SERVIDOR() {
        return IP_SERVIDOR;
    }

    public static String getIp() {
        String ip = "";
        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress("google.com", 80));
            ip = socket.getLocalAddress().getHostAddress();            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return ip;
    }
}
