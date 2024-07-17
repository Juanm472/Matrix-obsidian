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
public class FormateoDeSalida {
    
    public static void main (String args[]){
        int x1, y1, x2, y2;
        float pendiente;
        String nombre1, apellido1, nombre2, apellido2;
        x1=4;
        y1=5;
        x2=7;
        y2=67;
        
        pendiente = (y2-y1)/(x2-x1);
        System.out.format("El primer punto de la recta es %d, %d y el segundo punto es %d, %d y la pendiente es : %15.3f\n",x1,y1,x2,y2,pendiente );
        System.out.println("El primer punto de la recta es "+x1+", "+y1+" y el segundo punto es "+x2+", "+y2+" y la pendiente es : "+pendiente );
        
        System.out.format("Punto x1 ");
        System.out.format("%15d\n",x1);
        System.out.format("Coordenada punto y1: %2s\n",y1);
        System.out.format("Punto x2: %15s%n",x2);
        System.out.format("Punto y2: %15s%n",y2);
        System.out.format("Pendiente: %14.6f%n", pendiente);
        double pi=3.141592;
        System.out.format("PI: %15.2f%n", pi);
        
        nombre1="Pedro Raul";
        apellido1="Jimenez";

        nombre2="Javier";
        apellido2="Gonzalez";
        
        /*Si es negativo, los espacios se rellenan por la derecha, si es positivo, se rellenan por la izquierda*/
        
        
        
    }
    
}
