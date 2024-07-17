/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atributos;

/**
 *
 * @author user
 */
public class Barco {
    private int nroPasajeros;
    private String nombreBarco;
    private String nombreCapitan;
    private float calado;

    public Barco(){
        System.out.println("He creado un barco");
    }
    public Barco(String nombreBarco ){
        this.nombreBarco=nombreBarco;
    }
    
    public int getNroPasajeros(){
        return this.nroPasajeros;
    }    
    public String getNombreBarco(){
        return this.nombreBarco;
    }
    
    public String getNombreCapitan(){
        return this.nombreCapitan;
    }
    
    public float getCalado(){
        return this.calado;
    }
    
    public void setNroPasajeros(int nroPasajeros ){
        this.nroPasajeros=nroPasajeros;
    }    
    public void  setNombreBarco(String nombreBarco){
         this.nombreBarco=nombreBarco;
    }
    
    public void setNombreCapitan(String nombreCapitan ){
        this.nombreCapitan=nombreCapitan;
    }
    
    public void setCalado(float calado){
        this.calado=calado;
    }
    
}
