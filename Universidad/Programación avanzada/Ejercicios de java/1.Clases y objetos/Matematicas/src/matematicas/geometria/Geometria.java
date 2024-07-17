/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matematicas.geometria;

/**
 *
 * @author user
 */
public class Geometria {
    
    private final double PI=3.14; //Declaracion de una constante

    public double areaCirculo(double radio){
        double area=0;

        if (radio<=0){
            System.out.println("Valor de radio no valido");
            area=-1;
        }
        else{
            area=PI*Math.pow(radio, 2.0);
        }
        return area;
    }
 public double circunferenciaCirculo(double radio){
        double circunferencia=0;
        if (radio<=0){
            System.out.println("Valor de radio no valido");
            circunferencia=-1;
        }
        else{
            circunferencia=2*PI*radio;
        }
        circunferencia=Math.round(circunferencia*100.0)/100.0;
        
        
        return circunferencia;
    }
 
 public double areaTriangulo(double base, double altura){
        double area=0f;
        if (base<=0|| altura<=0){
            System.out.println("Datos de ingreso no validos");
            area=-1;
        }
        else{
            area=(base*altura)/2;
        }
        area=Math.round(area*100.0)/100.0;
        
        return area;
    }
 public double areaCuadrilatero(double l1, double l2){
        double area=0f;
        if (l1<=0|| l2<=0){
            System.out.println("Datos de ingreso no validos");
            area=-1;
        }
        else{
            area=l1*l2;
        }
        area=Math.round(area*100.0)/100.0;
        
        return area;
    }
   
    
}
