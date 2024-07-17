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
public class Cat extends Animales{
    //private String raza="Albino";
    public Cat(){
    
    }
    
    public String getRaza(){
        return raza;
    }
    
    public void setRaza(String raza){
        this.raza=raza;
        super.raza="-->>>"+raza;
    }
    
    public void caminar(){
        System.out.println ("El gato esta caminando");
    }
    
    public void imprimir (){
        System.out.println ("->Metodo imprimir de la subclase");
        System.out.println("Cat.raza:"+this.raza);
        System.out.println("Cat.getRaza:"+getRaza());
        System.out.println("Super.raza:"+super.raza);
        
    }
    
    /*
    public String toString (){
        return  ("Subclase.raza:"+this.raza);
    }
    */
}

