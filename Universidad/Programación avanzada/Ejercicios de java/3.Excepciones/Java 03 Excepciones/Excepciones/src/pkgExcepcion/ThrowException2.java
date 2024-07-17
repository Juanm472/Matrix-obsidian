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
public class ThrowException2 {
    public float dividir (int x, int y) throws ArithmeticException {            
        float z=0;
        try{
            z=x/y;
        }
        catch(ArithmeticException ex){
               System.out.println("Aqui recibe el error: " + ex.getMessage());
               throw ex;//Aqui lanza el error para que sea manejado por el objeto que invoca el metodo
        }
        return z;
    }
}

