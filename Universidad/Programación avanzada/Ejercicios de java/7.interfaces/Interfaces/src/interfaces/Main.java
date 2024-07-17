/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;

/**
 *
 * @author user
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int v2=0,v3=0;
        DeADos d2= new DeADos();
        DeATres d3= new DeATres();
        
        System.out.println("Secuencia de dos en dos");
        
        for (int i=0; i<10;i++){
            v2=d2.incrementar(v2);
            System.out.println("Next: "+v2);
        }
        for (int i=0; i<10;i++){
            v2=d2.decrementar(v2);
            System.out.println("Prev: "+v2);
        }
        
        System.out.println("\nSecuencia de tres en tres");
        for (int i=0; i<10;i++){
            v3=d3.incrementar(v3);
            System.out.println("Next: "+v3);
        }
        for (int i=0; i<10;i++){
            v3=d3.decrementar(v3);
            System.out.println("Prev: "+v3);
        }


        
    }
    
}
