/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractas.geometria;

/**
 *
 * @author user
 */
public abstract class Figura {
    public abstract double area(double dato); 
    public String mensaje (){
        return "Clase figura es abstracta";
    }
    
}
