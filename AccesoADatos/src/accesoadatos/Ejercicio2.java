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
public class Ejercicio2 {
      public static void main(String[] args) {
          Scanner s = new Scanner(System.in);
          System.out.println("Dime el lado 1º: ");
          int l1 = s.nextInt();
          System.out.println("Dime el lado 2º: ");
          int l2 = s.nextInt();
          System.out.println("Dime el lado 3º: ");
          int l3 = s.nextInt();
          int suma = l1 + l2;
          
          if(suma>l3){
              System.out.println("El triangulo es válido.");
          }else{
              System.out.println("El triangulo no es válido.");
          }
          
      }
}
