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
public class MainLanzandoExcepciones {
    public static void main(String args[]){
        int x=3, y=0;
        float r=0f;
        LanzandoExcepciones lz= new LanzandoExcepciones();
        try{
            r=lz.calcular1(x, y);
        }
        catch(YEsCero ex){
            System.out.println("Error personalizado: "+ ex.getMessage());
        }
        
    }
    
}
