/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package herencia;

/**
 *
 * @author user
 */
public class ClientePremium extends Cliente {
    private String tipo=null;
    
    public ClientePremium(String nombre, String correo, String tipo){
        this.nombre=nombre;
        this.correo=correo;
        this.tipo=tipo;        
    }
    
    public String toString(){
        return "Nombre: "+  this.nombre+" Correo: "+ this.correo+" Tipo: "+this.tipo;
    }
    
    public String toString2(){
        return "Nombre: "+  super.nombre+" Correo: "+ super.correo+" Tipo: "+this.tipo;
    }
    
    
    public static void main (String [] args){
        ClientePremium c1=new ClientePremium("pedro","p@p.com","maximo");
        System.out.println(c1.toString());
        System.out.println(c1.toString2());
    
    }
}
