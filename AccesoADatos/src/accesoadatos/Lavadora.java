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
public class Lavadora extends Electrodomestico {
    
    private static int CARGA = 5;
    
    private int carga;

    public Lavadora() {
        carga = CARGA;
    }

    public Lavadora(int precio, float peso) {
        super(precio, peso);
        carga = CARGA;
    }

    public Lavadora(int carga, int precio, float peso, String color, char consumoEnergetico) {
        super(precio, peso, color, consumoEnergetico);
        this.carga = carga;
    }

    public int getCarga() {
        return carga;
    }
    
    @Override
    public int precioFinal(){
        int pFinal = super.precioFinal();
        if(carga>30){
            pFinal+=50;
        }
        return pFinal;
    }
    
    
    
    
    
    
}
