/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colecciones;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author user
 */
public class ArreglosOrdenados {
     public static void main(String args[]){
        int limite=10;
        Random random = new Random();

        Integer[] numeros =  new Integer[limite];
        
        for (int i=0 ;i<numeros.length  ;i++){
            numeros[i]= random.nextInt(101);
        }
        
        System.out.println("\n\nDatos almacenados\n\n");
        for (int i=0 ;i<numeros.length  ;i++){
            System.out.println("numeros["+i+"]:"+numeros[i]);  
        }
        Arrays.sort(numeros);
        System.out.println("\n\nDatos ordenados\n\n");
        for (int i=0 ;i<numeros.length  ;i++){
            System.out.println("numeros["+i+"]:"+numeros[i]);  
        }

        Arrays.sort(numeros, Collections.reverseOrder());
        System.out.println("\n\nDatos almacenados al reves\n\n");
        for (int i=0 ;i<numeros.length  ;i++){
            System.out.println("numeros["+i+"]:"+numeros[i]);  
        }

        
        

     }
    
}
