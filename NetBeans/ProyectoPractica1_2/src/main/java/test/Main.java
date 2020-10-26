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

/**
 *
 * @author axegas
 */
public class Main {

    public static void main(String[] args) {
        PropietarioDAO daoP = new PropietarioDAO();
        ArrayList<Propietario> propietarios = daoP.selectAll();

        CocheDAO daoC = new CocheDAO();
        //ArrayList<Coche> coches = daoC.selectAll();

        //public Coche(String matricula, String marca, int precio, String DNI) {
        Coche co = new Coche("CCC", "opel", 200, "111");
        co.setMarca("peugeot");
        //daoC.update(co);
        daoC.delete(co);
        ArrayList<Coche> coches = daoC.selectAll();
        //coches.forEach(c -> System.out.println(c));

        //propietarios.forEach(p -> System.out.println(p));
        //coches.forEach(c -> System.out.println(c));
        //Propietario pro = new Propietario("222","juan",27);
        //pro.setNombre("pepe");
        //daoP.delete(pro);
        //propietarios = daoP.selectAll();
        //propietarios.forEach(p -> System.out.println(p));
        datosPropietario(propietarios, "20384844A");
    }

    public static void datosPropietario(ArrayList<Propietario> propietarios, String DNI) {
        Propietario p = damePropietario(propietarios, DNI);
        CocheDAO daoC = new CocheDAO();
        ArrayList<Coche> coches = daoC.selectByDNI(DNI);
        System.out.println(p);
        coches.forEach(c -> System.out.println("\t" + c));
    }

    public static Propietario damePropietario(ArrayList<Propietario> propietarios, String DNI) {
        Propietario p = null;
        for (int i = 0; i < propietarios.size(); i++) {
            if (propietarios.get(i).getDNI().equals(DNI)) {
                p = propietarios.get(i);
                break;
            }
        }
        return p;
    }
}
