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
public class Concatenar {
    public static void main (String args[]){
        String palabra1;
        String palabra2;
        String frase;
        palabra1="hola";
        palabra2="mundo";
        frase=palabra1+" "+palabra2;
        System.out.println(frase);
        
        StringBuilder  sb,sb1;
        String palabra3;
        sb= new StringBuilder("Clase string builder");         
        System.out.println(sb);
        //sb=sb+" algo ";//Esto genera error de compilacion
        sb1=  new StringBuilder (" otra forma de maneja String");
        sb.append(sb1);
        System.out.println(sb);
        palabra3=" y se puede concatenar con Strings ";
        sb.append(palabra3);
        System.out.println(sb);
        

        
        
    }
    
    
}
