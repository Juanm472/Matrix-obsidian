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
public class Split {
    
    public static void main (String args[]){
        
        int n=0;
        String palabras[];
        
        String cadena= "Esta es una cadena de palabras";
        palabras= cadena.split(" ");
        
        String fecha="2023/05/06";
        palabras= fecha.split("/");
        
        n=palabras.length;
        for (int i=0; i<n;i++){
            System.out.format ("Palabra [%d]:%-20s \n",i,palabras[i]);
        }
        System.out.println("------------------");
         cadena= "Esta es una cadena de palabras mas grande";
        palabras= cadena.split(" ");
        n=palabras.length;
        for (int i=0; i<n;i++){
            System.out.format ("Palabra [%d]:%20s \n",i,palabras[i]);
        }
       System.out.println("------------------");
        String strNumero="100,200,300,400";
        String numeros[];
        numeros= strNumero.split(",");
        n=numeros.length;
        for (int i=0; i<n;i++){
            System.out.format ("Numero [%10d]:%s \n",i,numeros[i]);
        }
        
    }
    
}
