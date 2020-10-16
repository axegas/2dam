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
public interface Entregable {
    public abstract void entregar();
    public abstract void devolver();
    public abstract boolean isEntregado();
    public abstract boolean compareTo(Object a);
      
}
