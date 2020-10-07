/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoadatos;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author peixe
 */
public class ClasesIterators {

    public static void main(String[] args) {
        //hago un Array de String por hacerlo facil, pero vale para cualquier tipo de objeto
        ArrayList<String> str = new ArrayList<>();

        str.add("hola1");
        str.add("hola2");

        //forma 1: con el clásico for
        for (int i = 0; i < str.size(); i++) {
            String aux = str.get(i);
            System.out.println(aux);
        }

        //forma 2: forEach
        str.forEach(aux -> System.out.println(aux) );
        
        //forma 3: iterator
        Iterator<String> iter = str.iterator();
        while(iter.hasNext()){
            String aux = iter.next();
            System.out.println(aux);
        }
        
        //forma 4: for-loop
        for(String aux : str){
            System.out.println(aux);
        }
    }
}
