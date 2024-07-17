package interfaces.anidamiento;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class Anidamiento1 {
    
    public  class Anidamiento1C1{
        public void metodo1(){
            System.out.println ("Metodo 1 de A1 Anidamiento1C1");
        }
    }
    private class Anidamiento2C1{
        public void metodo2(){
            System.out.println ("Metodo 2 de A2 Anidamiento1C2");
        }
    }
    
    public void llamar(){
        Anidamiento1C1 a1 =  new Anidamiento1C1();
        a1.metodo1();
        Anidamiento2C1 a2 = new Anidamiento2C1();
        a2.metodo2();
        
    }
    
}
