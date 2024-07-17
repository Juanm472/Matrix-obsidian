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
public class OperacionesCadenas {
    public static void main (String args[]){
        String cadena ="Esta es una cadena de ejemplo que sirve una vez";
        
        System.out.println("Recorrer cadena caracter a caracter");
        for (int i =0; i<cadena.length(); i++)
            System.out.print(cadena.charAt(i)+"-");
        System.out.println("\n");
    
        System.out.println("indexOf:"+cadena.indexOf("a"));
        System.out.println("indexOf pos:"+cadena.indexOf("a",5));
        System.out.println("LastIndexOf:"+cadena.lastIndexOf("una"));
        System.out.println("LastIndexOf:"+cadena.lastIndexOf("una",30)  );
        System.out.println("Substring:"+cadena.substring(12,19));
        System.out.println("toLowerCase:"+cadena.toLowerCase());
        System.out.println("toUpperCase:"+cadena.toUpperCase());
        System.out.println("length:"+cadena.length());
        System.out.println("contains:"+cadena.contains("ejemplo"));
        System.out.println("compareTo:"+"A".compareTo("D"));
        
        System.out.println("compareTo:"+"cadena".compareTo("CADENA"));
        
        System.out.println("compareTo:"+"CADENA".compareTo("cadena"));
        System.out.println("Ejemplo compareTo:"+"cadena".compareTo("caeeNa"));
        double d=150.5;
        double x=100.5;
        String dx=String.valueOf(d)+String.valueOf(x);
        
        System.out.println("valueOf:"+dx);
        System.out.println("at:"+"Javeriana".charAt(3));
        
    }
}
