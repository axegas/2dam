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
public class Serie implements Entregable{

    private String titulo;
    private int temporadas;
    private boolean entregado;
    private String genero;
    private String creador;

    public Serie(String titulo, int temporadas, String genero, String creador) {
        this.titulo = titulo;
        this.temporadas = temporadas;
        this.genero = genero;
        this.creador = creador;
        this.entregado = false;
    }

    public Serie(String titulo, String creador) {
        temporadas = 3;
        entregado = false;
        genero = "";
        this.titulo = titulo;
        this.creador = creador;
    }

    public Serie() {
        temporadas = 3;
        entregado = false;
        titulo = "";
        genero = "";
        creador = "";
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    @Override
    public String toString() {
        String str = entregado ? "si" : "no";    
        return "Titulo: " + titulo + ", Temporadas: " + temporadas + ", Entregado: " + str + ", Genero: " + genero + ", Creador: " + creador;
    }

    @Override
    public void entregar() {
        this.entregado = true;
    }

    @Override
    public void devolver() {
        this.entregado = false;
    }

    @Override
    public boolean isEntregado() {
        return this.entregado;
    }

    @Override
    public boolean compareTo(Object a) {
        return this.temporadas == ((Serie) a).getTemporadas();
    }
    
}
