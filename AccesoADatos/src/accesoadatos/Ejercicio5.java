/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoadatos;

import java.util.Random;

/**
 *
 * @author axegas
 */
public class Ejercicio5 {

    public static void main(String[] args) {
        Random r = new Random();
        int[] v = new int[15];
        for (int i = 0; i < 15; i++) {
            v[i] = r.nextInt(90) + 1;
        }

        for (int i = 0; i < 15; i++) {
            System.out.println(v[i]);
        }
    }

}
