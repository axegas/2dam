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
public class Videojuego implements Entregable {

    private String titulo;
    private int horasEstimadas;
    private boolean entregado;
    private String genero;
    private String companyia;

    public Videojuego(String titulo, int horasEstimadas, String genero, String companyia) {
        this.titulo = titulo;
        this.horasEstimadas = horasEstimadas;
        this.genero = genero;
        this.companyia = companyia;
    }

    public Videojuego() {
        this.titulo = "";
        this.horasEstimadas = 10;
        this.entregado = false;
        this.genero = "";
        this.companyia = "";
    }

    public Videojuego(String titulo, int horasEstimadas) {
        this.titulo = titulo;
        this.horasEstimadas = horasEstimadas;
        this.entregado = false;
        this.genero = "";
        this.companyia = "";
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getHorasEstimadas() {
        return horasEstimadas;
    }

    public void setHorasEstimadas(int horasEstimadas) {
        this.horasEstimadas = horasEstimadas;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCompanyia() {
        return companyia;
    }

    public void setCompanyia(String companyia) {
        this.companyia = companyia;
    }

    @Override
    public String toString() {
        String str = entregado ? "si" : "no";        
        return "Titulo: " + titulo + ", Horas Estimadas: " + horasEstimadas + ", Entregado: " + str + ", Genero: " + genero + ", Compañia: " + companyia;
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
        return this.horasEstimadas == ((Videojuego) a).getHorasEstimadas();
    }

}
