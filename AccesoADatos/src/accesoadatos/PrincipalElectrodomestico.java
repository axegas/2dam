/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoadatos;

/**
 *
 * @author peixe
 */
public class PrincipalElectrodomestico {
    
     public static void main(String[] args) {
         Electrodomestico[] electrodomesticos;
         electrodomesticos = new Electrodomestico[10];
         electrodomesticos[0] = new Lavadora();
         electrodomesticos[1] = new Television();
         electrodomesticos[2] = new Lavadora();
         electrodomesticos[3] = new Television();
         electrodomesticos[4] = new Lavadora();
         electrodomesticos[5] = new Television();
         electrodomesticos[6] = new Lavadora();
         electrodomesticos[7] = new Television();
         electrodomesticos[8] = new Lavadora();
         electrodomesticos[9] = new Television();
         
         int precioLava = 0;
         int precioTele = 0;
         for (Electrodomestico electrodomestico : electrodomesticos) {
             if (electrodomestico instanceof Lavadora) {
                 precioLava += electrodomestico.precioFinal();
             } else {
                 precioTele += electrodomestico.precioFinal();
             }
         }
         System.out.println("Lavadoras: " + precioLava);
         System.out.println("Televisores: " + precioTele);
     }
     
    
}
