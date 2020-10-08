/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoadatos;

import java.util.Scanner;

/**
 *
 * @author peixe
 */
public class PrincipalPass {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Longitud passwords: ");
        int longitud = s.nextInt();
        System.out.print("Tamaño vector: ");
        int tam = s.nextInt();
        Password[] passwords = new Password[tam];
        boolean[] sonFuertes = new boolean[tam];
        
        for(int i=0;i<tam;i++){
            passwords[i] = new Password(longitud);
            sonFuertes[i] = passwords[i].esFuerte();
            System.out.println(passwords[i] + "\t" + sonFuertes[i]);
        }
    }
}
