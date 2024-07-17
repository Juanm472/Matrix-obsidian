package colecciones;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedList1 {
  public static void main(String[] args) {
    LinkedList<String> marcas = new LinkedList<String>();
    marcas.add("Volvo");
    marcas.add("BMW");
    marcas.add("Ford");
    marcas.add("Mazda");
    
    marcas.addLast("Renault");
    marcas.addFirst("Chevrolet");   
    
    
    System.out.println(marcas);
    
    LinkedList<Persona> personas = new LinkedList<Persona>();
    /*
    Esto funciona exactamente igual
    List<Persona> personas = new ArrayList<Persona>();
    
    */
    
    Persona p1 = new Persona();
    
    
    personas.add(new Persona("12014525","Maria","galvis",18)  );
    personas.add(new Persona("965874","Pedro","Gomez",52)  );
    
    p1.setNroId("998877");
    p1.setNombre("Juan");
    p1.setApellidos("Romero");
    p1.setEdad(12);
    personas.add(p1);
    
    p1 = new Persona();
    p1.setNroId("65874");
    p1.setNombre("Juliana");
    p1.setApellidos("Perez");
    p1.setEdad(8);
    
    personas.add(p1);
    
    /*
    Persona pp = new Persona();
    System.out.println("Digite el id de la persona");
    pp.setNroId(s.next()    );
    
    System.out.println("Digite el nombre de la persona");
    pp.setNombre( s.next()    );
    
    System.out.println(" Digite apellidos de la persona");
    pp.setApellidos( s.next()    );
    
    System.out.println(" Digitie edad de la persona");
    pp.setEdad( s.nextInt()  );
    
    personas.add(pp);
    */    
    
    System.out.println ("Mostrar por pantalla el Linkedlist usando toString");
    System.out.println(personas);
    

    
   //Ordenamiento
    //Version mas corta
     Collections.sort(personas, Comparator.comparing(Persona::getNombre));
    Collections.sort(personas, Comparator.comparing(Persona::getNombre).reversed());

    System.out.println("\n-------------------------------\n");
    System.out.println("\nLista de personas usando iteradores simple y ordenado por Nombre descendente\n");
    for (Persona p : personas){
        System.out.format("Id: %s |  Nombre: %s |  Apellidos: %s | Edad: %d\n", p.getNroId(),p.getNombre(),p.getApellidos(),p.getEdad());
    }
         
     
    //Con el metodo compare en la misma clase del Objeto
    Collections.sort(personas, new Persona() ); 
 
    System.out.println("\nLista de personas usando iteradores y ordenado por Nombre\n");
    //Recorrer un ArrayList con iteradores    
    Iterator it  = personas.iterator();
    int k=1;
    while (it.hasNext()){       
        
        Persona p =(Persona)it.next();
        System.out.print ("Personas Nro. "+k++);
        System.out.format("  Id: %s |  Nombre: %s |  Apellidos: %s | Edad: %d\n", p.getNroId(),p.getNombre(),p.getApellidos(),p.getEdad());
    }
    
    System.out.println("------------------");
    //Cambiar un valor ej. a la persona que se llama Juan segun la posicion
    
    for (int j=0; j<personas.size();j++){
       if (personas.get(j).getNombre().equals("Juan")){
           personas.get(j).setNombre("Juan Guillermo");
           System.out.format("Registro modificado Id: %s | Nombre: %s | Apellidos: %s | Edad: %d\n", personas.get(j).getNroId(),personas.get(j).getNombre(),personas.get(j).getApellidos(),personas.get(j).getEdad());
       }
    }
    
    //Eliminar registro dos
    personas.remove(1);
    System.out.println("------------------\nLista de personas despues de eliminar registro dos");
    for (Persona p : personas){
        System.out.format("Id: %s | Nombre: %s | Apellidos: %s | Edad: %d\n", p.getNroId(),p.getNombre(),p.getApellidos(),p.getEdad());
    }
    
    // Cambiar un objeto por otro
    Persona p2 = new Persona ("456789","Javier","Lopez",36);
    personas.set(0, p2);
    
    System.out.println("------------------\nLista de personas despues de cambiar a Juan Guillermo por Javier");
    for (Persona p : personas){
        System.out.format("Id: %s | Nombre: %s | Apellidos: %s\nEdad: %d\n", p.getNroId(),p.getNombre(),p.getApellidos(),p.getEdad());
    }
  
    personas.removeAll(personas);
    
    System.out.println("\nLista de personas despues de removeAll\n");

    it  = personas.iterator();
    k=1;
    while (it.hasNext()){
        Persona pIt =(Persona)it.next();
        System.out.println ("Personas Nro. "+k++);
        System.out.format("Id: %s\nNombre: %s\nApellidos: %s\n\n", pIt.getNroId(),pIt.getNombre(),pIt.getApellidos());

    }
    
    
    
  }
} 
