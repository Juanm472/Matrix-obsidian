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
 class Anidamiento1C2{
        public void metodo1(){
            System.out.println ("Metodo 1 de A1 Anidamiento1C2");
        }
    }
 class Anidamiento2C2{
        public void metodo2(){
            System.out.println ("Metodo 2 de A2 en Anidamiento2C2");
        }
    }


public class Anidamiento2 {
    public void llamar(){
        Anidamiento1C2 a1 =  new Anidamiento1C2();
        a1.metodo1();
        Anidamiento2C2 a2 = new Anidamiento2C2();
        a2.metodo2();
        
    }
    
}