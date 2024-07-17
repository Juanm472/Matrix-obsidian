/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehiculos;

/**
 *
 * @author user
 */
public class Carro {
    private String marca;
    private String version;
    private int  velocidad;
    private int nroPuestos;
    private String placa;

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String pPlaca) {
        placa = pPlaca;        
    }
    
    public Carro (){
        
    }
    public Carro (String marca,String version){
        this.marca=marca;
        this.version=version;
    }
    
    
    public String getMarca(){
        return marca;
    }
    
    public String getVersion(){
        return version;
    }
    
    
    public int getVelocidad(){
        return this.velocidad;
    }
    
    public int getNroPuestos(){
        return this.nroPuestos;
    }
    
    public void setMarca(String marca){
        this.marca=marca;
    }
    
    public void setVersion(String pVersion){
        version=pVersion;
    }
    
    
    public void setVelocidad(int pVelocidad){
        velocidad=pVelocidad;
    }
    
    public void setNroPuestos(int pNroPuestos){
        this.nroPuestos=pNroPuestos;
    }
    
}
