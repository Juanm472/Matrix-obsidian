/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author user
 */
public class DeATres implements Secuencia{
    public int incrementar(int actual){
        return actual+3;
    }

     public int decrementar(int actual){
        return actual-3;
    }
     
     public int incrementar(int actual, int siguiente){
         return 0;
     }
}
