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
public class Exception1_1 {

    public static void main(String args[]) {
        int arreglo[] = new int[10];
        
        boolean hayError=false;
        
        try {
            for (int i = 0; i <= 9; i++) {
                arreglo[i] = i * i;
                System.out.println(arreglo[i]);
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Se presenta error [" + ex.getMessage() + "]");
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            hayError=true;
            //break;
            //i=14;
        }

        if (hayError)
            System.out.println("El programa capturo un error");
        else
            System.out.println("El programa corrio bien");
        
        //Objeto x =null;
        //x.metodo();
        
        System.out.println("Fin del programa");

    }

}
