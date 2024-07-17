/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colecciones;

import java.util.Arrays;
import java.util.Collections;


/**
 *
 * @author user
 */
public class ArreglosDeclaracionInicializacion {
    public static void main(String args[]){
        Long[] even1 ={10L,2L,6L,8L,2L};
        Long[] even2 = even1;
        
        for (int i=0; i<even1.length;i++){
            System.out.println(" --> Even 1:"+even1[i]);
            System.out.println(" --> Even 2:"+even2[i]);
        }
        System.out.println("---------------------");
        for (int i=0; i<even2.length;i++){
            even2[i]=even2[i]*i;
            System.out.println(" --> Even 2: "+even2[i]);
        }
          System.out.println("---------------------");
        for (int i=0; i<even1.length;i++){
            System.out.println(" --> Even 1:"+even1[i]);
        }
        System.out.println("---------------------");
        
    }
}
