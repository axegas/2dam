/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoadatos;

/**
 *
 * @author peixe
 */
public class Television extends Electrodomestico {

    private int resolucion;
    private boolean sintonizadorTDT;

    public Television() {
        resolucion = 20;
        sintonizadorTDT = false;
    }

    public Television(int precio, float peso) {
        super(precio, peso);
        resolucion = 20;
        sintonizadorTDT = false;
    }

    public Television(int resolucion, boolean sintonizadorTDT, int precio, float peso, String color, char consumoEnergetico) {
        super(precio, peso, color, consumoEnergetico);
        this.resolucion = resolucion;
        this.sintonizadorTDT = sintonizadorTDT;
    }

    public int getResolucion() {
        return resolucion;
    }

    public void setResolucion(int resolucion) {
        this.resolucion = resolucion;
    }

    public boolean isSintonizadorTDT() {
        return sintonizadorTDT;
    }

    public void setSintonizadorTDT(boolean sintonizadorTDT) {
        this.sintonizadorTDT = sintonizadorTDT;
    }

    @Override
    public int precioFinal() {
        int pFinal = super.precioFinal();
        if (resolucion > 40) {
            pFinal *= 1.3;
        }
        if(sintonizadorTDT){
            pFinal += 50;
        }
        return pFinal;
    }

}
