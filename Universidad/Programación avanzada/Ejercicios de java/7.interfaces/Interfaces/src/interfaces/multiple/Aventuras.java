/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.multiple;

/**
 *
 * @author user
 */
    
    interface PoderVolar{
        public int alturaMaxima=0;
        public void volar();
    }
    interface PoderNadar{
        public void nadar();
    }
    
    interface PoderCorrer{
       public void correr();
    }        
    
    class PersonajeAccion{
        void pelear(){
        }       
    }
    
    class Heroe extends PersonajeAccion implements PoderVolar, PoderNadar, PoderCorrer{
        public void volar(){
        }
        public void nadar(){
        }
        public void correr(){
        }
        
        public String toString(){
            return "Metodo tostring personalizado";
        }
        
    }
public class Aventuras {
    public static void main(String args[]){
        Heroe h1 = new Heroe();
        h1.correr();
        h1.nadar();
        h1.volar();
        h1.pelear();
        
        System.out.println(" h1 "+ h1.toString()); 
    } 
}
