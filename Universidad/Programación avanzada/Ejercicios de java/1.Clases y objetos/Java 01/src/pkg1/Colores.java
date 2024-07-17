/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1;

/**
 *
 * @author user
 */
public class Colores {
    public static void main(String[] args) {
        String rojo = "\033[31m";
        String verde = "\033[32m";
        String naranja = "\033[33m";
        String azul = "\033[34m";
        String morado = "\033[35m";
        String blanco = "\033[37m";
        System.out.println(naranja + "mandarina" + verde + " hierba");
        System.out.println(naranja + " saltamontes" + rojo + " tomate");
        System.out.println(blanco + " sábanas" + azul + " cielo");
        System.out.println(morado + " nazareno" + azul + " mar");
    }
}