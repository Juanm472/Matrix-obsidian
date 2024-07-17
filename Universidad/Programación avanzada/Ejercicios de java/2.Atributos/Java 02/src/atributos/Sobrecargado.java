/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atributos;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class Sobrecargado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        sobrecarga(1);
        sobrecarga(2,3);
        sobrecarga(3,"palabra");        
    }
    public static void sobrecarga (int i){
	System.out.println ("1 parámetro entero");
    }   
    public static void sobrecarga (int i, int j){
        System.out.println ("2 parámetros enteros");
    }

    public static void sobrecarga (int i, String x){
        System.out.println ("1 parámetro entero y 1 parámetro String");
    }
        
}
