/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colecciones;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author user
 */
public class ArreglosObjetos {
    
    public static void main (String args[]){
    
    
        Persona[] pp = new Persona[5];
        pp[0] = new Persona("Mario", 22);
        pp[1] = new Persona("Pepe", 52);
        pp[2] = new Persona("Manuel", 27);
        pp[3] = new Persona("David", 25);
        pp[4] = new Persona("Alberto", 8);
        
        
        
        
        System.out.println ("Arreglo antes de ordenar");

        for(int i=0;i<pp.length;i++)
            System.out.println("Nombre: "+pp[i].getNombre()+" "+ pp[i].getEdad());
        
        //Arrays.sort(pp, new Persona() );
        Arrays.sort(pp, Comparator.comparing(Persona::getNombre));
        
        System.out.println ("\nArreglo ordenado\n");

        for(int i=0;i<pp.length;i++)
           System.out.println("Nombre: "+pp[i].getNombre()+" "+ pp[i].getEdad());
        
        
    }
    
}
