/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superclases;

/**
 *
 * @author user
 */
public class Main {
    public static void main (String []args) {
        System.out.println("Con la subclase");
        Cat c = new Cat();
        c.setRaza("Montés");  
        c.imprimir();
        c.caminar();
        System.out.println(c.toString());
        
        System.out.println("\nCon la superclase");
        Animales g =  new Cat();
        g.setRaza("Bengalí");          
        g.imprimir();
        //g.caminar(); Esto genera error de compilacion
        System.out.println(g.toString());
    }

}
