/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atributos;

/**
 *
 * @author user
 */
public class mainBarco_1 {
    
    
    public static void main (String args[]){
         Barco n = new Barco("El velero");
         System.out.println("Nombre del barco N: "+n.getNombreBarco());
         Barco b = new Barco();
         System.out.println("Nombre del barco B: "+b.getNombreBarco());

    }
    
    
}
