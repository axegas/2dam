/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoadatos;

import java.util.Scanner;

/**
 *
 * @author axegas
 */
public class Ejercicio4 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Introduce un número: ");
        int num = s.nextInt();
        for (int i = 1; i <= num; i++) {
            if (i <= num) {
                System.out.print(i + "\t");
            }
            if ((i * 2) <= num) {
                System.out.print(i * 2 + "\t");
            }
            if ((i * 3) <= num) {
                System.out.print(i * 3 + "\t");
            }
            System.out.println();
        }
    }
}
