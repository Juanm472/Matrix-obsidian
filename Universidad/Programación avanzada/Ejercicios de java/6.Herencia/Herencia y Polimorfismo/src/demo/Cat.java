/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo;

/**
 *
 * @author user
 */
public class Cat extends Animal{
   private String raza="Raza subclase";
    public Cat(){
    
    }
    
    protected void setRaza(String raza) {
        System.out.println ("setRaza en la subclase");
        this.raza = raza;
    }
    
    public void imprimir (){
        System.out.println("1."+this.raza);
        System.out.println("2."+super.raza);
        System.out.println("soy el hijo");
        super.imprimir();
    }
    public static void main (String []args) {
        Cat c = new Cat();
        c.setRaza("Raza main");  
        c.imprimir();
    }
}
