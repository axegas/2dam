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
public class Ejercicio3 {
      public static void main(String[] args) {
          Scanner s = new Scanner(System.in);
          System.out.print("Introduce un número: ");
          int num = s.nextInt();
          for(int i=1;i<=num;i++){
              if(num%i==0){
                  System.out.println(i);
              }
          }
      }
}
