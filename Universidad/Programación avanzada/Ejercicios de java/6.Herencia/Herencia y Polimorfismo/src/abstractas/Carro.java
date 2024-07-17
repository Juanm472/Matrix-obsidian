/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractas;

/**
 *
 * @author user
 */
public class Carro extends Vehiculo {
    
    private String version;
    private int nroPuestos;
    private String placa;

    
    public Carro (String marca, int velocidad ,int nroPasajeros,int nroPuestos, String placa){
        super(marca,velocidad,nroPasajeros);
        this.nroPuestos=nroPuestos;
        this.placa=placa;
    }
    
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String pPlaca) {
        placa = pPlaca;        
    }
    
    public String getMarca(){
        
        return this.marca;
    }
   
     public void setMarca(String marca){
        //Recomendable hacer esto de así
        super.marca=marca;
    }
    
    public String getVersion(){
        return version;
    }
    
    
    
    public int getNroPuestos(){
        return this.nroPuestos;
    }
    
   
    
    public void setVersion(String pVersion){
        version=pVersion;
    }
    
    public int getVelocidad(){
        return super.getVelocidad();
    }
    
    
    public void setVelocidad(int pVelocidad){
        super.setVelocidad(pVelocidad);
    }
    
    public void setNroPuestos(int pNroPuestos){
        this.nroPuestos=pNroPuestos;
    }
    
    
    
    
    
}
