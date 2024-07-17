/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractas.geometria;

/**
 *
 * @author user
 */
public class MainFigura {
    public static void main(String args[]){
        Circulo circulo = new Circulo();
        Cuadrado cuadrado = new Cuadrado();
        Rectangulo rectangulo = new Rectangulo();
        
        System.out.println ("El area de un circulo de radio 2 es "+circulo.area(2));
        System.out.println ("El area de un cuadrado de lado 4 es "+cuadrado.area(4));
        System.out.println ("El area de un cuadrado de lado 4 y 2 es "+rectangulo.area(4, 2));
        
        System.out.println ("Mensaje del circulo "+circulo.mensaje());
        System.out.println ("Mensaje del cuadrado "+cuadrado.mensaje());        
        
    }
    
    public static void metodoEstatico(){
    
    }
    
}
