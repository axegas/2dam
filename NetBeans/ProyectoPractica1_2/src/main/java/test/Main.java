/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import datos.CocheDAO;
import datos.PropietarioDAO;
import domain.Coche;
import domain.Propietario;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author axegas
 */
public class Main {

    private static CocheDAO daoC;
    private static PropietarioDAO daoP;

    public static void main(String[] args) {

        daoP = new PropietarioDAO();
        daoC = new CocheDAO();
        int opc;
        do {
            opc = menu();
            switch (opc) {
                case 0:
                    break;
                case 1:
                    insertaCoche();
                    break;
                case 2:
                    insertaPropietario();
                    break;
                case 3:
                    actualizaCoche();
                    break;
                case 4:
                    actualizaPropietario();
                    break;
                case 5:
                    eliminarCoche();
                    break;
                case 6:
                    eliminarPropietario();
                    break;
                case 7:
                    eliminarPropietarioCascada();
                    break;
                case 8:
                    datosPropietario();
                    break;
                case 9:
                    verCoches();
                    break;
                case 10:
                    verPropietarios();
                    break;
                default:
                    break;
            }
        } while (opc != 0);
    }

    //un pequeño menú para que el usuario elija la opción que desee
    public static int menu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("1. inserta coche");
        System.out.println("2. inserta propietario");
        System.out.println("3. actualiza coche");
        System.out.println("4. actualiza propietario");
        System.out.println("5. elimina coche");
        System.out.println("6. elimina propietario");
        System.out.println("7. elimina propietario y sus coches asociados ");
        System.out.println("8. datos propietario");
        System.out.println("9. ver coches");
        System.out.println("10. ver propietarios");
        System.out.println("0. salir");
        return scan.nextInt();
    }

    //este metodo printea, a partir de un dni dado, los datos de un determinado usuario junto a los coches que tiene matriculados
    public static void datosPropietario() {
        Scanner scan = new Scanner(System.in);
        System.out.println("DNI propietario: ");
        String DNI = scan.nextLine();
        Propietario p = daoP.selectByDNI(DNI);
        ArrayList<Coche> coches = daoC.selectByDNI(DNI);
        System.out.println(p);
        coches.forEach(c -> System.out.println("\t" + c));
    }

    //metodo para insertar un coche en la base de datos
    public static void insertaCoche() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Matricula: ");
        String matricula = scan.nextLine();
        System.out.println("Marca: ");
        String marca = scan.nextLine();
        System.out.println("DNI propietario: ");
        String dni = scan.nextLine();
        System.out.println("Precio: ");
        int precio = scan.nextInt();
        int registros = daoC.insert(new Coche(matricula, marca, precio, dni));
        if (registros > 0) {
            System.out.println("Insertado satisfactoriamente");
        } else {
            System.out.println("Error al insertar");
        }
    }

    //metodo para insertar un propietario en la base de datos
    public static void insertaPropietario() {
        Scanner scan = new Scanner(System.in);
        System.out.println("DNI: ");
        String dni = scan.nextLine();
        System.out.println("Nombre: ");
        String nombre = scan.nextLine();
        System.out.println("Edad: ");
        int edad = scan.nextInt();
        int registros = daoP.insert(new Propietario(dni, nombre, edad));
        if (registros > 0) {
            System.out.println("Insertado satisfactoriamente");
        } else {
            System.out.println("Error al insertar");
        }

    }

    //para ver los propietarios de la base de datos
    public static void verPropietarios() {
        ArrayList<Propietario> propietarios = daoP.selectAll();
        propietarios.forEach(p -> System.out.println(p));
    }

    //para ver los coches de la base de datos
    public static void verCoches() {
        ArrayList<Coche> coches = daoC.selectAll();
        coches.forEach(c -> System.out.println(c));
    }

    //actualizar los datos de un coche
    public static void actualizaCoche() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Matricula: ");
        String matricula = scan.nextLine();
        System.out.println("Marca: ");
        String marca = scan.nextLine();
        System.out.println("DNI propietario: ");
        String dni = scan.nextLine();
        System.out.println("Precio: ");
        int precio = scan.nextInt();
        int registros = daoC.update(new Coche(matricula, marca, precio, dni));
        if (registros > 0) {
            System.out.println("Actualizado satisfactoriamente");
        } else {
            System.out.println("Error al actualizar");
        }
    }

    //actualizar los datos de un propietario
    public static void actualizaPropietario() {
        Scanner scan = new Scanner(System.in);
        System.out.println("DNI: ");
        String dni = scan.nextLine();
        System.out.println("Nombre: ");
        String nombre = scan.nextLine();
        System.out.println("Edad: ");
        int edad = scan.nextInt();
        int registros = daoP.update(new Propietario(dni, nombre, edad));
        if (registros > 0) {
            System.out.println("Actualizado satisfactoriamente");
        } else {
            System.out.println("Error al actualizar");
        }
    }

    //eliminar un coche de la base de datos
    public static void eliminarCoche() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Matricula: ");
        String matricula = scan.nextLine();
        Coche c = new Coche();
        c.setMatricula(matricula);
        int registros = daoC.delete(c);
        if (registros > 0) {
            System.out.println("Eliminado satisfactoriamente");
        } else {
            System.out.println("Error al eliminar");
        }
    }

    //eliminar un propietario de la base de datos
    public static void eliminarPropietario() {
        Scanner scan = new Scanner(System.in);
        System.out.println("DNI: ");
        String dni = scan.nextLine();
        Propietario p = new Propietario();
        p.setDNI(dni);
        int registros = daoP.delete(p);
        if (registros > 0) {
            System.out.println("Eliminado satisfactoriamente");
        } else {
            System.out.println("Error al eliminar");
        }
    }

    //eliminar un propietario de la base de datos, junto con los coches que tiene asociados
    public static void eliminarPropietarioCascada() {
        Scanner scan = new Scanner(System.in);
        System.out.println("DNI: ");
        String dni = scan.nextLine();
        Propietario p = new Propietario();
        p.setDNI(dni);
        int registros = daoP.deleteEnCascada(p);
        if (registros > 0) {
            System.out.println("Eliminado satisfactoriamente");
        } else {
            System.out.println("Error al eliminar");
        }
    }

}
