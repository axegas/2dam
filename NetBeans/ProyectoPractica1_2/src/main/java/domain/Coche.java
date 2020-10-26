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
public class Coche {
    private String matricula;
    private String marca;
    private int precio;
    private String DNI;

    public Coche(String matricula, String marca, int precio, String DNI) {
        this.matricula = matricula;
        this.marca = marca;
        this.precio = precio;
        this.DNI = DNI;
    }

    public Coche() {
    }

    public Coche(String marca, int precio, String DNI) {
        this.marca = marca;
        this.precio = precio;
        this.DNI = DNI;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    @Override
    public String toString() {
        return "Coche{" + "matricula=" + matricula + ", marca=" + marca + ", precio=" + precio + ", DNI=" + DNI + '}';
    }
    
    
}
