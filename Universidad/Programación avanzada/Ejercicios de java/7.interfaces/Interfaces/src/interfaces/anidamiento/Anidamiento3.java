/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.anidamiento;

/**
 *
 * @author user
 */
/**
 *
 * @author user
 */

public class Anidamiento3 {
    
    public static void main (String args[]){
        Anidamiento1 a1 = new Anidamiento1();
       
        a1.llamar();       
        //Instanciar una clase publica que está anidada en otra       
        Anidamiento1.Anidamiento1C1 x = a1.new Anidamiento1C1();        
        
        x.metodo1();
       
        Anidamiento2 a2 = new Anidamiento2();
        a2.llamar(); 
       
        
        
        
        
       
        
    }
    
}
