/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoadatos;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author axegas
 */
public class Ejercicio7 {

    static ArrayList<Estudiante> estudiantes = new ArrayList<>();

    public static void main(String args[]) {

        int opc;
        do {
            opc = menu();
            switch (opc) {
                case 1:
                    meterEstudiante();
                    break;
                case 2:
                    eliminarEstudiante();
                    break;
                case 3:
                    modificarEstudiante();
                    break;
                case 4:
                    mostrarEstudiantes();
                    break;
                case 5:
                    canviaLletra();
                    break;
                case 6:
                    verPorNota();
                    break;
                case 7:
                    break;
                default:
                    break;
            }
        } while (opc != 7);
    }

    public static int menu() {
        Scanner s = new Scanner(System.in);
        System.out.println("1. Meter estudiante. ");
        System.out.println("2. Eliminar estudiante. ");
        System.out.println("3. Modificar estudiante. ");
        System.out.println("4. Mostrar estudiantes. ");
        System.out.println("5. Lletra??. ");
        System.out.println("6. Nº total estudiantes por nota. ");
        System.out.println("7. Salir ");
        System.out.print("Introduzca opcion: ");
        return s.nextInt();
    }

    private static void meterEstudiante() {
        Scanner s = new Scanner(System.in);
        System.out.print("Nombre: ");
        String nombre = s.nextLine();
        System.out.print("Apellidos: ");
        String apellidos = s.nextLine();
        System.out.print("DNI: ");
        String dni = s.nextLine();
        System.out.print("Edad: ");
        int edad = s.nextInt();
        System.out.print("Nota: ");
        int nota = s.nextInt();
        estudiantes.add(new Estudiante(nombre, apellidos, dni, edad, nota));
    }

    private static void eliminarEstudiante() {
        Scanner s = new Scanner(System.in);
        System.out.print("Introduce el nombre: ");
        String n = s.nextLine();
        for (int i = 0; i < estudiantes.size(); i++) {
            if (estudiantes.get(i).getNombre().equals(n)) {
                estudiantes.remove(estudiantes.get(i));
            }
        }
    }

    private static void mostrarEstudiantes() {
        estudiantes.forEach(e -> System.out.println(e));
    }

    private static void verPorNota() {
        int NP = 0;
        int S = 0;
        int A = 0;
        int H = 0;
        int N = 0;
        int O = 0;
        int presentados = 0;
        for (Estudiante e : estudiantes) {
            switch (e.getLetra()) {
                case "NP":
                    NP++;
                    break;
                case "S":
                    S++;
                    presentados++;
                    break;
                case "A":
                    A++;
                    presentados++;
                    break;
                case "H":
                    H++;
                    presentados++;
                    break;
                case "N":
                    N++;
                    presentados++;
                    break;
                case "O":
                    O++;
                    presentados++;
                    break;
                default:
                    break;
            }
        }
        System.out.println("NP: " + NP);
        System.out.println("S: " + S + ". Porcentaje: " + (S * 100 / presentados) + "%");
        System.out.println("A: " + A + ". Porcentaje: " + (A * 100 / presentados) + "%");
        System.out.println("N: " + N + ". Porcentaje: " + (N * 100 / presentados) + "%");
        System.out.println("O: " + O + ". Porcentaje: " + (O * 100 / presentados) + "%");
        System.out.println("H: " + H + ". Porcentaje: " + (H * 100 / presentados) + "%");
    }

    private static void modificarEstudiante() {
        Scanner s = new Scanner(System.in);
        System.out.print("Introduce el nombre del estudiante que desea modificar: ");
        String str = s.nextLine();
        int n = -1;
        for (int i = 0; i < estudiantes.size(); i++) {
            if (estudiantes.get(i).getNombre().equals(str)) {
                n = i;
                break;
            }
        }
        if (n != -1) {
            System.out.print("Nombre: ");
            String nombre = s.nextLine();
            System.out.print("Apellidos: ");
            String apellidos = s.nextLine();
            System.out.print("DNI: ");
            String dni = s.nextLine();
            System.out.print("Edad: ");
            int edad = s.nextInt();
            System.out.print("Nota: ");
            int nota = s.nextInt();
            
            estudiantes.get(n).setNombre(nombre);
            estudiantes.get(n).setApellidos(apellidos);
            estudiantes.get(n).setDni(dni);
            estudiantes.get(n).setEdad(edad);
            estudiantes.get(n).setNota(nota);
        } else {
            System.out.println("El estudiante " + str + " no existe.");
        }

    }

    private static void canviaLletra() {
        estudiantes.forEach(e -> e.setLetra());
    }

}
