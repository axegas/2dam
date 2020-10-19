
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
public class Principal {

    public static void main(String[] args) {
        System.out.println(generaPass());
        /*   Scanner s = new Scanner(System.in);
        System.out.print("Nombre: ");
        String nombre = s.nextLine();
        System.out.print("DNI: ");
        String DNI = s.nextLine();
        char sexo;
        do {
            System.out.print("Sexo (H/M): ");
            sexo = s.nextLine().charAt(0);
            if (sexo != 'H' && sexo != 'M') {
                System.out.println("Incorrecto.");
            }
        } while (sexo != 'H' && sexo != 'M');
        System.out.print("Edad: ");
        int edad = s.nextInt();
        System.out.print("Peso: ");
        float peso = s.nextFloat();
        System.out.print("Altura: ");
        float altura = s.nextFloat();

        Persona p1 = new Persona(nombre, edad, sexo);
        Persona p2 = new Persona(nombre, edad, DNI, sexo, peso, altura);
        Persona p3 = new Persona();

        p3.setNombre(nombre);
        p3.setEdad(edad);
        p3.setPeso(peso);
        p3.setAltura(altura);
        p3.setSexo(sexo);

        muestraDatos(p1);
        muestraDatos(p2);
        muestraDatos(p3);*/

    }

    public static void muestraDatos(Persona p) {
        boolean esMayor = p.esMayorDeEdad();
        int imc = p.calcularIMC();
        System.out.println(p + "\n\t" + "Es mayor: " + esMayor + "\n\tIMC: " + imc);
    }

    private static String generaPass() {
        Random r = new Random();
        String numeros = "0123456789";
        String minusculas = "abcdefghijklmnopqrstuvwxyz";
        String mayusculas = minusculas.toUpperCase();
        String simbolos = numeros + minusculas + mayusculas;
        int num;
        String aux = "";
        char x;
        for (int i = 0; i < 8; i++) {
            num = r.nextInt(simbolos.length());
            x = simbolos.charAt(num);
            aux += x;
        }
        return aux;
    }
}
