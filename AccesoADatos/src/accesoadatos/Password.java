/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoadatos;

import java.util.Random;

/**
 *
 * @author peixe
 */
public class Password {

    private int longitud;
    private String pass;

    public Password() {
        longitud = 8;
        pass = generaPass();
    }

    public Password(int longitud) {
        this.longitud = longitud;
        pass = generaPass();
    }

    public int getLongitud() {
        return longitud;
    }

    public String getPass() {
        return pass;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
        this.pass = generaPass();
    }

    public String generaPass() {
        Random r = new Random();
        String simbolos = "0123456789" + "abcdefghijklmnopqrstuvwxyz" + "abcdefghijklmnopqrstuvwxyz".toUpperCase();
        int num;
        String aux = "";
        char x;
        for (int i = 0; i < longitud; i++) {
            num = r.nextInt(simbolos.length());
            x = simbolos.charAt(num);
            aux += x;
        }
        return aux;
    }

    public boolean esFuerte() {
        int num = 0;
        int min = 0;
        int may = 0;
        char c;
        for (int i = 0; i < pass.length(); i++) {
            c = pass.charAt(i);
            if (Character.isDigit(c)) {
                num++;
            } else if (Character.isLowerCase(c)) {
                min++;
            } else {
                may++;
            }
        }
        return num > 5 && may > 2 && min > 1;
    }

    @Override
    public String toString() {
        return "Contraseña: " + pass;
    }
    
    

}
