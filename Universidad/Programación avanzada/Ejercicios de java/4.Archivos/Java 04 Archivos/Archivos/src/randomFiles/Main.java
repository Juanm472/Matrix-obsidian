/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randomFiles;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class Main {
    public static void main (String[] args){
        int opcion;
        do{
            opcion=menu();        
        }while(opcion!=6);
        
        
    }
    
    static int menu(){
        int opcion;
        Scanner s =  new Scanner(System.in);
        System.out.println ("Menu de opciones\n\n");
        System.out.println ("1. Registrar Estudiante");
        System.out.println ("2. Consultar Estudiante");
        System.out.println ("3. Modificar Estudiante");
        System.out.println ("4. Lista completa de Estudiantes");
        System.out.println ("5. Borrar Estudiante");
        System.out.println ("6. Salir");
        opcion=s.nextInt();
        switch (opcion){
            case 1: registrarEstudiante();      
            case 4: listaCompleta();
        }
        return opcion;        
    }
    
    static void registrarEstudiante(){
        
        Estudiante estudiante;
        String idEstudiante;
        String nombre;
        String apellido;
        String edadStr;
        int edad;
        String carrera;
        int id=0;
        Scanner se = new Scanner(System.in);
        do{
            System.out.print("Introduce el ID del estudiante (Nro. Mayor que cero):");
            idEstudiante=se.nextLine();
            try {
                id=Integer.parseInt(idEstudiante);
            } catch (NumberFormatException e) {
                System.out.println("Debes introducir un Id mayor que cero");
            }
        }while(idEstudiante.isEmpty() || id<=0);
        
        do{
            System.out.print("Introduce el nombre del estudiante:(max 20 caracteres) ");
            nombre=se.nextLine();
        }while(nombre.isEmpty() || nombre.length()>20);
         
        do{
            System.out.print("Introduce el apellido del estudiante:(max 20 caracteres) ");            
            apellido=se.nextLine();
        }while(apellido.isEmpty() || apellido.length()>20);
         
        do{
            edad=0;
            System.out.print("Introduce la edad del estudiante: ");
            edadStr=se.nextLine();
            try {
                edad=Integer.parseInt(edadStr);
            } catch (NumberFormatException e) {
                System.out.println("Debes introducir un número entero");
            }
        }while(edadStr.isEmpty() || edad<=0);
        do{
            System.out.print("Introduce el nombre de la carrera a estudia :(max 20 caracteres) ");            
            carrera=se.nextLine();
        }while(carrera.isEmpty() || carrera.length()>20);
        estudiante= new Estudiante(idEstudiante);
        estudiante.setNombre(nombre);
        estudiante.setApellido(apellido);
        estudiante.setCarrera(carrera);
        estudiante.setEdad(edad);
        estudiante.setCarrera(carrera);
        ManejoArchivos.adicionarEstudiante(estudiante);
    }
    static void listaCompleta(){
        ManejoArchivos.listarEstudiantes();
        
        
        
    }
    
}
