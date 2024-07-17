/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colecciones;

import colecciones.Pagos;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class ArreglosRedimensionamiento {
    
    public static void main(String args[]){
        Pagos[] pago =  new Pagos[2];
      
        Scanner s =  new Scanner(System.in);
        for (int i=0 ;i<2;i++){
            pago[i]= new Pagos();  
            System.out.println("Nombre cliente:");
            pago[i].setCliente(s.next());
            System.out.println("plazo:");
            pago[i].setPlazo(s.nextInt());
            System.out.println("Cuota:");
            pago[i].setCuota(s.nextFloat());
        }
        
        System.out.println("\n\nDatos almacenados\n\n");
        for (int i=0 ;i<2;i++){
            System.out.println("Nombre cliente:"+pago[i].getCliente());
            System.out.println("Nro. Cuotas:"+pago[i].getPlazo());
            System.out.println("Valor cuota:"+pago[i].getCuota());            
        }
        
        pago=redimPagos(pago);
        
        System.out.println("\nDEspues de redimensionar\n");
        for (int i=0 ;i<pago.length;i++){
            if (pago[i]==null){
                pago[i]=new Pagos();
            }
            System.out.println("Nombre cliente:"+pago[i].getCliente());
            System.out.println("Nro. Cuotas:"+pago[i].getPlazo());
            System.out.println("Valor cuota:"+pago[i].getCuota());            
        }
    }

    public static Pagos[] redimPagos(Pagos[] pagos){
        Pagos[] auxiliar = new Pagos[pagos.length+1];
        System.arraycopy(pagos, 0, auxiliar, 0, pagos.length);
        return auxiliar;
    }
        
}
    
     