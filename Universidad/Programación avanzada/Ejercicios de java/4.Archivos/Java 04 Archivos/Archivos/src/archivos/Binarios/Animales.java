/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos.Binarios;

import java.io.Serializable;

/**
 *
 * @author user
 */
public class Animales implements java.io.Serializable {
    
    private String familia;
    private String raza;
    private  boolean nomada;
    private float pesoMax;
    private float edadMax;

    public Animales (String familia, String raza, boolean nomada, float pesoMax, float edadMax){
        this.familia=familia;
        this.raza=raza;
        this.nomada= nomada;
        this.pesoMax=pesoMax;
        this.edadMax=edadMax;
                
    }
    
    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public boolean isNomada() {
        return nomada;
    }

    public void setNomada(boolean nomada) {
        this.nomada = nomada;
    }

    public float getPesoMax() {
        return pesoMax;
    }

    public void setPesoMax(float pesoMax) {
        this.pesoMax = pesoMax;
    }

    public float getEdadMax() {
        return edadMax;
    }

    public void setEdadMax(float edadMax) {
        this.edadMax = edadMax;
    }
    
    public String toString(){
        return "Familia: "+this.familia+ " Raza: " + this.raza+" Edad Max: "+this.edadMax + " Peso Max:"+ this.pesoMax;
    }
    
}
