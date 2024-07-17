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
public class ThrowException3 {
    
    public static void main(String args[]){
        metodo2();
    }
        public static void metodo1() throws NumberFormatException {
        String cadena = "123a";
        try {
            Integer entero = Integer.parseInt(cadena);
        } catch (NumberFormatException e) {
            System.out.println("Aqui metodo1 maneja el error");
            throw e;
        }
    }
    public static void metodo2()  {
        try{
            metodo1();
        }
        catch(NumberFormatException e){
            System.out.println("Resultado de getMessage :" + e.getMessage());
            System.out.println("Resultado de printStackTrace");
            e.printStackTrace();
        }
    }
}
