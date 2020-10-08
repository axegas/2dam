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
public class Electrodomestico {

    private static final int PRECIO_BASE = 100;
    private static final String COLOR = "blanco";
    private static final char CONSUMO_ENERGETICO = 'F';
    private static final float PESO = 5;

    protected int precioBase;
    protected String color;
    protected char consumoEnergetico;
    protected float peso;

    public Electrodomestico() {
        precioBase = PRECIO_BASE;
        color = COLOR;
        consumoEnergetico = CONSUMO_ENERGETICO;
        peso = PESO;
    }

    public Electrodomestico(int precio, float peso) {
        this.precioBase = precio;
        this.peso = peso;
        color = COLOR;
        consumoEnergetico = CONSUMO_ENERGETICO;
    }

    public Electrodomestico(int precio, float peso, String color, char consumoEnergetico) {
        this.precioBase = precio;
        this.peso = peso;
        if (consultarConsumoEnergetico(consumoEnergetico)) {
            this.consumoEnergetico = consumoEnergetico;
        }
        if (comprobarColor(color)) {
            this.color = color;
        }
    }

    public int getPrecioBase() {
        return precioBase;
    }

    public String getColor() {
        return color;
    }

    public char getConsumoEnergetico() {
        return consumoEnergetico;
    }

    public float getPeso() {
        return peso;
    }

    public int precioFinal() {
        int pFinal = precioBase;

        switch (consumoEnergetico) {
            case 'A':
                pFinal += 100;
                break;
            case 'B':
                pFinal += 80;
                break;
            case 'C':
                pFinal += 60;
                break;
            case 'D':
                pFinal += 50;
                break;
            case 'E':
                pFinal += 30;
                break;
            case 'F':
                pFinal += 10;
                break;
            default:
                break;
        }

        if (peso > 0 && peso <= 19) {
            pFinal += 10;
        } else if (peso >= 20 && peso <= 49) {
            pFinal += 50;
        } else if (peso >= 50 && peso <= 79) {
            pFinal += 80;
        } else {
            pFinal += 100;
        }

        return pFinal;
    }

    private boolean consultarConsumoEnergetico(char consumoEnergetico) {
        return consumoEnergetico >= 'A' && consumoEnergetico <= 'F';
    }

    private boolean comprobarColor(String color) {
        color = color.toLowerCase();
        return color.equals("blanco") || color.equals("negro") || color.equals("rojo") || color.equals("azul") || color.equals("gris");
    }

}
