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
public class Ejercicio1 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Double percentatge;
        String tipo;

        System.out.print("Introdueix el tipus de conductor: ");
        tipo = s.nextLine();
        System.out.print("Introdueix el percentatge: ");
        percentatge = s.nextDouble();

        if (tipo.equals("carrega") || tipo.equals("especial") || tipo.equals("novel")) {
            if (percentatge > 0.3) {
                System.out.println("No apto");
            } else {
                System.out.println("Apto");
            }
        } else {
            if (percentatge > 0.5) {
                System.out.println("No apto");
            } else {
                System.out.println("Apto");
            }
        }
    }
}
