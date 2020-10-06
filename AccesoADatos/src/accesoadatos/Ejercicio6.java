/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoadatos;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author axegas
 */
public class Ejercicio6 {

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
                    consultarDato();
                    break;
                case 4:
                    mostrar();
                    break;
                case 5:
                    break;
                default:
                    break;
            }
        } while (opc != 5);
    }

    public static int menu() {
        Scanner s = new Scanner(System.in);
        System.out.println("1. Meter ingresos. ");
        System.out.println("2. Total por vendedor. ");
        System.out.println("3. Consultar dato");
        System.out.println("4. Ingresos totales. ");
        System.out.println("5. Salir. ");
        System.out.print("Introduzca opcion: ");
        return s.nextInt();
    }

    public static void ingresar() {
        Random r = new Random();
        for (int i = 0; i < matriu.length; i++) {
            for (int j = 0; j < matriu[i].length; j++) {
                matriu[i][j] = r.nextInt(100) + 1;
            }
        }
    }

    public static void mostrar() {
        for (int i = 0; i < matriu.length; i++) {
            System.out.print("Venedor " + (i + 1) + ": ");
            for (int j = 0; j < matriu[i].length; j++) {
                System.out.print(matriu[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public static void total() {
        int suma = 0;
        Scanner s = new Scanner(System.in);
        System.out.print("Introduce el nº de vendedor: ");
        int n = s.nextInt();
        for (int j = 0; j < matriu[n].length; j++) {
            System.out.print(matriu[n][j] + " ");
            suma += matriu[n][j];
        }
        System.out.print("\n");
        System.out.println("Suma total: " + suma);
    }

    private static void consultarDato() {
        Scanner s = new Scanner(System.in);
        System.out.print("Introduce la coordenada x: ");
        int x = s.nextInt();
        //s.nextLine();
        System.out.print("Introduce la coordenada y: ");
        int y = s.nextInt();
        s.nextLine();

        
        System.out.print("El dato pedido es el: " + matriu[x][y] + " Desea modificarlo? (s/n)");
        String l = s.nextLine();

        if(l.equals("s")){
            System.out.print("Nuevo valor: ");
            matriu[x][y] = s.nextInt();
        }else{
            System.out.println("Muchas gracias");
        }
    }

}
