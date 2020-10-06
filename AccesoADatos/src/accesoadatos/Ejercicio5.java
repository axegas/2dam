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
        int aux;
        int[] v = new int[15];
        int j,i;
        
        for (i = 0; i < 15; i++) {
            aux = r.nextInt(90) + 1;
            for(j=0;j<i;j++){
                if(v[j]==aux){
                    break;
                }
            }
            if(j==i){
                v[i] = aux;
            }else{
                i--;
            }
        }

        for (i = 0; i < 15; i++) {
            System.out.println(v[i]);
        }
    }

}
