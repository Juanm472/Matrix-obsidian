/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractas;

/**
 *
 * @author user
 */
public class Main{
   
    public static void main(String[] args) {
         Carro carro1 = new Carro ("\nMazda", 160 ,6,6, "reu604");
         System.out.println ("\nMarca:"+carro1.getMarca());
         System.out.println ("\nVelocidad:"+carro1.getVelocidad());
         System.out.println ("\nNroPuestos:"+carro1.getNroPuestos());
         System.out.println ("\nPasajeros:"+carro1.getNroPasajeros());
         System.out.println ("\nPlaca:"+carro1.getPlaca());
            
    }
}
