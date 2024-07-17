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
public class LanzandoExcepciones  {
    public float calcular1(int x, int y)throws YEsCero{
        float r=0;
        if (y==0){
            throw new YEsCero ("Y no puede ser igual a cero, no se puede dividir \n");
        }
        else{
            r=x/y;
        }
        
        return r;
    }
    
}
