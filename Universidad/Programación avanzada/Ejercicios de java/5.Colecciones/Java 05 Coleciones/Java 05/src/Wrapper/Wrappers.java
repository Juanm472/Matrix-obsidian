/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wrapper;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class Wrappers {
    
    public static void main (String[] args){
        Scanner s = new Scanner (System.in);
        String strInt;
        int nroInt;
        Integer wInt;
        System.out.println ("Escriba un numero entero:");
        strInt= s.nextLine();
        //Convertir String a Integer
        wInt = Integer.parseInt(strInt);
        System.out.println ("El Wrap de Integer es :"+wInt);
        wInt= wInt*2;
        //Convertir Integer a int
        nroInt= wInt;
        nroInt= wInt.intValue();
        System.out.println ("El numero entero por dos es :"+nroInt);
        System.out.println ("El numero entero convertido a Flotante es:"+wInt.floatValue());
        
        
        

        
        
    }
    
}
