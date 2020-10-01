/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author peixe
 */
public class Util {
    private static final int PUERTO_CLIENTE = 9999;
    private static final int PUERTO_SERVIDOR = 9000;
    private static final String IP_SERVIDOR = "192.168.1.34";

    public static int getPUERTO_CLIENTE() {
        return PUERTO_CLIENTE;
    }

    public static int getPUERTO_SERVIDOR() {
        return PUERTO_SERVIDOR;
    }

    public static String getIP_SERVIDOR() {
        return IP_SERVIDOR;
    }   
    
}
