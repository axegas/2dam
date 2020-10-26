/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author axegas
 */
public class Propietario {
    private String DNI;
    private String nombre;
    private int edad;

    public Propietario(String DNI, String nombre, int edad) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.edad = edad;
    }

    public Propietario(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public Propietario() {
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Propietario: " + nombre + ", DNI: " + DNI + ", edad: " + edad;
    }
    
    
}
