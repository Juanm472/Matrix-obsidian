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
public class Carro {
    private String marca;
    private static String marca1;

    private String version;
    private int  velocidad;
    private int nroPuestos;
    private String placa;
    private String color;
    private static String copyright="Pontificia Universidad";
    private String otraVariable="Algun dato";
    
    public Carro(){
        System.out.println("Acabo de crear un carro");
    }
    
    public Carro(String placa){
        this.placa=placa;
    }
    
    public Carro(String placa, String color, int velocidad){
        this.color=color;
        this.placa=placa;
        this.velocidad=velocidad;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String pPlaca) {
        placa = pPlaca;        
    }
    
    public Carro (String pMarca,String pVersion){
        this.marca=pMarca;
        this.version=pVersion;
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
    
    public void setNroPuestos(int nroPuestos){
        this.nroPuestos=nroPuestos;
    }
    
    public String getColor(){
        System.out.println(" color es "+this.color);
        return this.color;
    }
    
    public String setColor(String color){
        return this.color=color;
    }    
    
    public void cambiarDatos(String placa){
        this.placa=placa;
    }
    public void cambiarDatos(String placa,String color){
        this.placa=placa;
        this.color=color;
    }
          
    public static void info(){
        System.out.println ("Carro generico");        
    }
    public static void info(String mensaje){
        System.out.println ("El mensaje:"+mensaje);        
    }
    public static String getMarca1(){
        return marca1;
    }
    
    public static int getKilometros(){
        return 1000;
    }
}
