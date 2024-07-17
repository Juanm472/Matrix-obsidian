/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.anidamiento;

public class Externa {

    public class Interna {
        public void imprimir() {
            System.out.println("Clase interna");
        }
    }

    public void imprimir() {
        System.out.println("Clase externa");
    }
}