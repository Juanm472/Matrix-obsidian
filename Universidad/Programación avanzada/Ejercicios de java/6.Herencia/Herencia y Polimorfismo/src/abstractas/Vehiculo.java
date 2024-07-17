package abstractas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public abstract class Vehiculo {
    protected String marca;
    private int  velocidad;
    private int nroPasajeros;

    public Vehiculo( String marca, int velocidad ,int nroPasajeros){
        this.marca=marca;
        this.velocidad=velocidad;
        this.nroPasajeros=nroPasajeros;
    }
    
    public abstract String getMarca() ; //No tiene implementacion

    public abstract void setMarca(String marca) ;//No tiene implementacion

    
    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getNroPasajeros() {
        return nroPasajeros;
    }

    public void setNroPasajeros(int nroPasajeros) {
       nroPasajeros = nroPasajeros;
        
    }
    
    
    
    
}
