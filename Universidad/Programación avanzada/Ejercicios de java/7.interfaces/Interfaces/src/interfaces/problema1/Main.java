/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.problema1;

/**
 *
 * @author user
 */
public class Main {
        
      public static void main (String args[]){
          NewClass nc = new NewClass();
          System.out.println( nc.metodo1(1));
          System.out.println( nc.metodo1("hola"));
          System.out.println(nc.mostrar());
          //Que sucede si las dos clases tienen la misma firma con diferente return?
          
          
      }
}
