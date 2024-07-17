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
public class Animales {
    protected String raza;
    public Animales() {
    }

    protected void setRaza(String raza) {
        this.raza = raza;
    }

    protected void imprimir (){
        System.out.println ("->Metodo imprimir de la superclase");
        System.out.println("Animales.raza:"+raza);
    }

    protected String getRaza() {
        return raza;
    }
    public String toString (){
        return  ("To String de la Superclase.raza:"+this.raza);
    }
}

