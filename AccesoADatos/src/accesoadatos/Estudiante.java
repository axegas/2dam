/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoadatos;

/**
 *
 * @author axegas
 */
public class Estudiante {
    private String nombre;
    private String apellidos;
    private String dni;
    private int edad;
    private int nota;
    private String letra;

    public Estudiante(String nombre, String apellidos, String dni, int edad, int nota) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.edad = edad;
        this.nota = nota;
        setLetra();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
        setLetra();
    }
    
    public void setLetra(){
        boolean b;
        if(nota<0){
            letra = "NP";
        }else if(nota < 5){
            letra = "S";
        }else if(nota < 7){
            letra = "A";
        }else if(nota < 9){
            letra = "N";
        }else if(nota < 10){
            letra = "O";
        }else{
            letra = "H";
        }
    }
    
    public String getLetra(){
        return letra;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", edad=" + edad + ", nota=" + nota + '}';
    }
    
    
}
