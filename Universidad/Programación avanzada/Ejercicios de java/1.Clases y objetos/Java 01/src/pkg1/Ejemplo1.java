/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1;

import java.util.Scanner;
import java.util.*;

/**
 *
 * @author user
 */
public class Ejemplo1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println ("Hola Mundo");
        //String nombre = System.console().readLine();
        String nombre="";
        Scanner s = new Scanner(System.in);
        System.out.print ("Como te llamas? ");
        nombre=s.nextLine();        
        System.out.println("Nombre: "+nombre);        
    }
    
}
