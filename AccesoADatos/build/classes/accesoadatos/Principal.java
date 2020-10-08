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
public class Principal {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Nombre: ");
        String nombre = s.nextLine();
        System.out.print("DNI: ");
        String DNI = s.nextLine();
        char sexo;
        do {
            System.out.print("Sexo (H/M): ");
            sexo = s.nextLine().charAt(0);
            if(sexo != 'H' && sexo != 'M'){
                System.out.println("Incorrecto.");
            }
        } while (sexo != 'H' && sexo != 'M');
        System.out.print("Edad: ");
        int edad = s.nextInt();
        System.out.print("Peso: ");
        float peso = s.nextFloat();
        System.out.print("Altura: ");
        float altura = s.nextFloat();
        
        Persona p1 = new Persona(nombre,edad,sexo);
        Persona p2 = new Persona(nombre, edad, DNI, sexo, peso, altura);
        Persona p3 = new Persona();
        
        p3.setNombre(nombre);
        p3.setEdad(edad);
        p3.setPeso(peso);
        p3.setAltura(altura);
        p3.setSexo(sexo);
        
        
        
        

    }
}
