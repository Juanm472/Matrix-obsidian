/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atributos;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class MainCarro {
    
    public static void main(String[] args) {
         Carro audi= new Carro("audi","blanco",120);
         System.out.println("Marca: "+audi.getMarca());
         System.out.println("Color: "+audi.getColor());
         System.out.println("Velocidad: "+audi.getVelocidad());
        
        Carro bmw= new Carro();
        int nuevaVelocidad=0;
       
        bmw.setMarca("BMW");
        bmw.setVersion("X5");
        bmw.setVelocidad(240);
        bmw.setColor("rojo");
        
       
        
        
        System.out.println("Marca : " + bmw.getMarca());
        System.out.println("Version: " + bmw.getVersion());
        System.out.println("Velocidad : " + bmw.getVelocidad());
        System.out.println("Color: " + bmw.getColor());
        /*Uso de la sobre carga*/
        bmw.cambiarDatos("ABC123");
        System.out.println("Placa : " + bmw.getPlaca());
        bmw.cambiarDatos("XYZ987","azul");
        System.out.println("Cambio de placa : " + bmw.getPlaca());
        System.out.println("Cambio de Color: " + bmw.getColor());
        bmw.setNroPuestos(5);
        
        System.out.println("Numero de puestos: " + bmw.getNroPuestos());
          
        
        //Llamado a un metodo estatico
         System.out.println("\nEjemplo de sobre carga metodo estatico\n");
         Carro.info();
         Carro.info(bmw.getMarca());
        
    }
  
}
