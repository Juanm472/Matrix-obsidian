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
public class ThrowException1 {
    
    public static void main(String args[]){
        calcular();
        metodo2();
    }
    
    public static void calcular() {
        int x=3,y=0;
        float r=0f;
        ThrowException2 th=new ThrowException2();
        try{
            r=th.dividir(x, y);
            System.out.println  ("Resultado: "+ r);
        }
        catch(ArithmeticException ex){
            System.out.println("Manejo de error lanzado por otra Clase :" + ex.getMessage());
        }
       
    }
    
    public static void metodo1() throws NumberFormatException {
        String cadena = "123a";
        try {
            Integer entero = Integer.parseInt(cadena);
        } catch (NumberFormatException e) {
            System.out.println("Aqui metodo1 captura el error:"+e.getMessage());
            throw e;
        }
    }
    public static void metodo2()  {
        try{
            metodo1();
        }
        
        catch(NumberFormatException e){
            System.out.println("Excepcion al invocar al metodo1 :" + e.getMessage());
        }
        catch(Exception e){
            System.out.println("Manejo generico de errores: " + e.getMessage());
        }
    }
}
