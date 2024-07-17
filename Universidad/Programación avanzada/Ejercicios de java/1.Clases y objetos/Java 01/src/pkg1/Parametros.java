/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1;

/**
 *
 * @author user
 */
public class Parametros {    
     public static void main(String[] args) {
         System.out.println("Numero de parametros :" +args.length);
         System.out.println("Los parametros son: ");
         for (int i=0;i<args.length;i++){
             System.out.println ("Parametro ["+(i+1)+"]: " + args[i]);
         }
     }
}
