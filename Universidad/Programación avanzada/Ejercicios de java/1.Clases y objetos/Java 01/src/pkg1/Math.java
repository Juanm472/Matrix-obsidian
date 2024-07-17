/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1;

//import geometria.s1.Geometria;
import geometria.s1.Geometria;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class Math {
    
        public static void main(String[] args) {
            
            int opcion;
            Scanner s = new Scanner(System.in);
           
            do{
                System.out.println("Menu de opciones\n");
                System.out.println("1. Area del circulo");
                System.out.println("2. Circunferencia del circulo");
                System.out.println("3. Area del triangulo");
                System.out.println("4. Area de un cuadrilatero");
                System.out.println("5. Salir");
                opcion=s.nextInt();
               
                menu(opcion);
            }while(opcion!=5);
 
        }
        public static void menu(int opcion){
            switch (opcion){
                case 1:areaCirculo();break;
                case 2:circunferenciaCirculo();break;
                case 3:areaTriangulo();break;
                case 4:areaCuadrilatero();break;
                        
            }
          
        }
        public static void areaCirculo(){
            double radio;
            double area;
            Scanner s = new Scanner(System.in);
            System.out.println("Area del circulo: ");
            System.out.println("Indique el radio:");
            radio=s.nextDouble();
            Geometria g= new Geometria();
            area=g.areaCirculo(radio);
            if (area>0){
               System.out.println("El area del circulo es: "+area);
               System.out.println("-----------------------------------");
            }
        }
       public static void circunferenciaCirculo(){
            double radio=0;
            double circunferencia;
            Scanner s = new Scanner(System.in);
            System.out.println("Circunferencia del circulo: ");
            System.out.println("Indique el radio:");
            radio=s.nextDouble();
            Geometria g= new Geometria();
            circunferencia=g.circunferenciaCirculo(radio);
            if (circunferencia>0){
               System.out.println("La circunferencia del circulo es: "+circunferencia);
               System.out.println("-----------------------------------");
            }
        }       
       
       public static void areaTriangulo(){
            double base=0, altura=0;
            double area;
            
            Scanner s = new Scanner(System.in);
            System.out.println("Area del triangulo: ");
            System.out.println("Indique la base:");
            base=s.nextDouble();
            System.out.println("Indique la altura:");
            altura=s.nextDouble();
            Geometria g= new Geometria();
            area=g.areaTriangulo(base, altura);
            if (area>0){
               System.out.println("El area del trianguo es: "+area);
               System.out.println("-----------------------------------");
            }
            
        }     
       
        public static void areaCuadrilatero(){
            double l1=0, l2=0;
            double area;
            
            Scanner s = new Scanner(System.in);
            System.out.println("Area del cuadrilater: ");
            System.out.println("Indique lado 1:");
            l1=s.nextDouble();
            System.out.println("Indique lado 2:");
            l2=s.nextDouble();
            Geometria g= new Geometria();
            area=g.areaCuadrilatero(l1, l2);
            if (area>0){
               System.out.println("El area del cuadrilatero es: "+area);
               System.out.println("-----------------------------------");
            }
        }  
              
}
