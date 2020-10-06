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
public class Venedors {

    static int[][] matriu = new int[18][10];

    public static void main(String[] args) {

        int opc;
        do {
            opc = menu();
            switch (opc) {
                case 1:
                    ingresar();
                    break;
                case 2:
                    total();
                    break;
                case 3:
                    mostrar();
                    break;
                case 4:
                    break;
                default:
                    break;
            }
        } while (opc != 4);
    }

    public static int menu() {
        Scanner s = new Scanner(System.in);
        System.out.println("1. Meter ingresos. ");
        System.out.println("2. Total por vendedor. ");
        System.out.println("3. Ingresos totales. ");
        System.out.println("4. Salir. ");
        System.out.print("Introduzca opcion: ");
        return s.nextInt();
    }

    public static void ingresar() {
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < matriu.length; i++) {
            System.out.print("Venedor " + (i + 1) + ": ");
            for (int j = 0; j < matriu[i].length; j++) {
                matriu[i][j] = s.nextInt();
            }
        }
    }

    public static void mostrar() {
        for (int i = 0; i < matriu.length; i++) {
            System.out.print("Venedor " + (i + 1) + ": ");
            for (int j = 0; j < matriu[i].length; j++) {
                System.out.print(matriu[i][j] + " ");
            }
            System.out.println("\n");
        }
    }

    public static void total() {
        Scanner s = new Scanner(System.in);
        System.out.print("Introduce el nº de vendedor: ");
        int n = s.nextInt();
        for (int j = 0; j < matriu[n].length; j++) {
            System.out.print(matriu[n][j] + " ");
        }
        System.out.println("\n");
    }

}
