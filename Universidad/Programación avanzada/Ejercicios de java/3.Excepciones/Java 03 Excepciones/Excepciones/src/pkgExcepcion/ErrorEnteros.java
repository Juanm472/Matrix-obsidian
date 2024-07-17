/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgExcepcion;

/**
 *
 * @author user
 */
public class ErrorEnteros {
    public static void main (String args[]){
        String cadena = "123a 67575 765 57hjhjghjmhv";
        try{
            Integer entero = Integer.parseInt(cadena);
            System.out.println("El numero es "+entero);
        }
        catch(NumberFormatException ex){
            System.out.println("No se puede convertir en numero");
            System.out.println(ex.getMessage());
            ex.printStackTrace();
       }
       System.out.println("Fin del programa");

    }
    
}
