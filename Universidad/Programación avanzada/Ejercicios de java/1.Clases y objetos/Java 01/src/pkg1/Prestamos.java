/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1;

public class Prestamos {

private float porcentajeInteres;

   public Prestamos() {
       this.porcentajeInteres = 0.0512f;
   }

   public float calcular(float valorcredito, int nromeses) {// devuelve un parametro double
       float calculo = 0.0f;
       if (valorcredito <= 0.0f || valorcredito > 100.0f) { // si el valor credito es menor o igual a 0, o es mayor a 100, genera error
           System.out.println("Valor de crédito no valido");

       } if (nromeses <= 0) { // si el valor credito es menor o igual a 0, o es mayor a 100, genera error
           System.out.println("Plazo de meses no valido");

       } else {
           calculo = valorcredito * porcentajeInteres * nromeses;// el pow es una funcion potencia
           // Declaradas de forma estática
           // Normalmente deben ser instanciadas con new
       }
       return calculo;
   }
}