/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehiculos;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class Main {
    
    public static void main(String[] args) {
        Carro bmw= new Carro();
        int nuevaVelocidad=0;
        
        
        System.out.println("Marca : " + bmw.getMarca());
        System.out.println("Version: " + bmw.getVersion());
        System.out.println("Velocidad : " + bmw.getVelocidad());
        System.out.println("Numero de puestos: " + bmw.getNroPuestos());
        bmw.setMarca("BMW");
        bmw.setVersion("X5");
        bmw.setVelocidad(240);
        bmw.setNroPuestos(5);
        System.out.println("Marca : " + bmw.getMarca());
        System.out.println("Version: " + bmw.getVersion());
        System.out.println("Velocidad : " + bmw.getVelocidad());
        System.out.println("Numero de puestos: " + bmw.getNroPuestos());
        bmw.setVelocidad(260);
        System.out.println("El carro aceleró!!!");
        System.out.println("Velocidad : " + bmw.getVelocidad());
        
       /* Scanner s = new Scanner(System.in);
        System.out.print ("Cual es la nueva velocidad? ");
        nuevaVelocidad=s.nextInt();
        bmw.setVelocidad(nuevaVelocidad);
        System.out.println("La nueva velocidad es "+bmw.getVelocidad());        
        */
        
        
        Carro audi= new Carro( "Audi","Q7");
        System.out.println("Marca : " + audi.getMarca());
        System.out.println("Version: " + audi.getVersion());
        System.out.println("Velocidad : " + audi.getVelocidad());
        System.out.println("Numero de puestos: " + audi.getNroPuestos());
        
        audi.setVelocidad(180);
        audi.setNroPuestos(7);
        System.out.println("Velocidad : " + audi.getVelocidad());
        System.out.println("Numero de puestos: " + audi.getNroPuestos());
        /**/
    }
    
}
