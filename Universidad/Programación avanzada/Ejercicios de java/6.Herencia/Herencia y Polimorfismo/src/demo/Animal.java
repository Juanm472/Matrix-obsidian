/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo;

/**
 *
 * @author user
 */
public class Animal {
    protected String raza="Raza Superclase";
    public Animal() {
    }

    protected void setRaza(String raza) {
        System.out.println ("setRaza en la superclase");
        this.raza = raza;
    }

    protected String getRaza() {
        return raza;
    }
      protected void imprimir (){
        System.out.println("soy la superclase:"+this.raza);
    }

}

