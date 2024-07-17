/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1;
import barcos.*;
import vehiculos.Carro;


/**
 *
 * @author user
 */
public class Transportes {
    public static void main(String[] args) {
        Yate yate1=  new Yate();
        yate1.setCalado((float) 10.5);
        yate1.setCapacidad(15);
        yate1.setManga((float) 5.5);
        yate1.setPotencia((float) 155.5);
        yate1.setMotores(2);
        yate1.setNombre("El Arcangel");
        
        System.out.println("Datos del Yate");
        
        System.out.println("Calado: "+yate1.getCalado());
        System.out.println("Manga: "+yate1.getManga());
        System.out.println("Capacidad: "+yate1.getCapacidad());
        System.out.println("Nombre: "+yate1.getNombre());
        
        
        
        Carro bmw= new Carro();
        System.out.println("---------->Datos del Carro v1");
        System.out.println("Marca : " + bmw.getMarca());
        System.out.println("Version: " + bmw.getVersion());
        System.out.println("Velocidad : " + bmw.getVelocidad());
        System.out.println("Numero de puestos: " + bmw.getNroPuestos());
        bmw.setMarca("BMW");
        bmw.setVersion("X5");
        bmw.setVelocidad(240);
        bmw.setNroPuestos(5);
        System.out.println("---------->Datos del Carro v2");
        System.out.println("Marca : " + bmw.getMarca());
        System.out.println("Version: " + bmw.getVersion());
        System.out.println("Velocidad : " + bmw.getVelocidad());
        System.out.println("Numero de puestos: " + bmw.getNroPuestos());
        
        System.out.println("---------->Datos del Carro v3");
        Carro audi= new Carro( "Audi","Q7");
        System.out.println("Marca : " + audi.getMarca());
        System.out.println("Version: " + audi.getVersion());
        System.out.println("Velocidad : " + audi.getVelocidad());
        System.out.println("Numero de puestos: " + audi.getNroPuestos());
        
        audi.setVelocidad(180);
        audi.setNroPuestos(7);
        System.out.println("Velocidad : " + audi.getVelocidad());
        System.out.println("Numero de puestos: " + audi.getNroPuestos());
        
    }

    
}
