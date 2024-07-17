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
public class Exception2_1 {
    public static void main(String args[]){
        int x=2, y=2;
        try{
           float z=x/(x-y);
        }catch(ArithmeticException ex){
            System.out.println("Se presenta error ["+ex.getMessage()+"]");
        }
        finally{
            System.out.println("Este codigo siempre se ejecuta");
        }


    }
    
}
