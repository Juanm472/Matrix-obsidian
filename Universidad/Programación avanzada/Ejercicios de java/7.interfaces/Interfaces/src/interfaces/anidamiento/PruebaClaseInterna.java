/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.anidamiento;

public class PruebaClaseInterna {

    public static void main(String[] args) {
        Externa externa=new Externa();
        Externa.Interna interna=externa.new Interna(); 
        interna.imprimir();
        externa.imprimir();
    }

}