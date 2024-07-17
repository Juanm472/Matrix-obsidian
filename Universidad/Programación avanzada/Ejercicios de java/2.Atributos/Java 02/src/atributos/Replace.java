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
public class Replace {
    public static void main(String args[]){
        String cadena="El perro corre muy rapido";
        cadena=cadena.replace("perro", "guepardo");
        System.out.println (cadena);
        
        cadena="El perro amarillo y el perro blanco tienen hambre";
        cadena=cadena.replace("perro", "guepardo");
        System.out.println (cadena);
        cadena="El perro amarillo y el perro blanco tienen mucha hambre";
        cadena=cadena.replaceFirst("perro", "guepardo");
        System.out.println (cadena);
        
        cadena="El perro amarillo y el perro blanco tienen hambre";
        cadena=cadena.replaceAll("perro", "guepardo"); //hace lo mismo que replace
        System.out.println (cadena);
        
        Mascota m = new Mascota();
        m.nombre="Neron Apolo";
        m.raza="Border Collie";
        System.out.println (m.nombre+" "+m.raza);
        
        
        m.nombre=m.nombre.replace("Neron", "Chester");
        System.out.println (m.nombre+" "+m.raza);
       
        
        
        
        
                
        
                
    }
}
