package colecciones;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.TreeSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class TreeSet1 {
  public static void main(String[] args) {
    TreeSet<String> marcas = new TreeSet<String>();
    marcas.add("Volvo");
    marcas.add("BMW");
    marcas.add("Ford");
    marcas.add("Ford");
    marcas.add("Mazda");
    marcas.add("Mazda");
    System.out.println(marcas);
    
    TreeSet<PersonaTreeSet> personas = new TreeSet<PersonaTreeSet>();
    /*
    Esto funciona exactamente igual
    List<Persona> personas = new TreeSet<Persona>();
    
    */
   
    PersonaTreeSet p1 = new PersonaTreeSet();
    PersonaTreeSet p2 = new PersonaTreeSet();
    PersonaTreeSet p3 = new PersonaTreeSet();
    PersonaTreeSet p4 = new PersonaTreeSet();
    
    
    personas.add(new PersonaTreeSet("12014525","maria","galvis",18)  );
    personas.add(new PersonaTreeSet("965874","pedro","Gomez",52)  );
    
    p1.setNroId("998877");
    p1.setNombre("Juan");
    p1.setApellidos("Romero");
    p1.setEdad(12);
    personas.add(p1);
    
    p2 = new PersonaTreeSet();
    p2.setNroId("65874");
    p2.setNombre("Juliana");
    p2.setApellidos("Perez");
    p2.setEdad(9);
    personas.add(p2);
    
    p3 = new PersonaTreeSet();
    p3.setNroId("65874");
    p3.setNombre("Juliana");
    p3.setApellidos("Perez");
    p3.setEdad(8);
    personas.add(p3);
            
    p4 = new PersonaTreeSet();
    p4.setNroId("65874");
    p4.setNombre("Juliana");
    p4.setApellidos("Perez");
    p4.setEdad(8);
    personas.add(p4);
    
    personas.add(p1);
    personas.add(p1);//Se puede adicionar dos veces el mismo objeto, pero solo se registra una vez

    System.out.println(personas);
    
    System.out.println("\nLista de personas usando iteradores\n");
    //Recorrer un TreeSet con iteradores    
    Iterator it  = personas.iterator();
    int k=1;
    while (it.hasNext()){
        PersonaTreeSet pIt =(PersonaTreeSet)it.next();
        System.out.println ("Personas Nro. "+k++);
        System.out.format("Id: %s\nNombre: %s\nApellidos: %s\nEdad: %d\n\n", pIt.getNroId(),pIt.getNombre(),pIt.getApellidos(),pIt.getEdad());

    }
    
    PersonaTreeSet pr = null;
    
    it  = personas.iterator();
    k=1;
    //Eliminar a la persona de Id: 998877
    while (it.hasNext()){
        PersonaTreeSet pIt =(PersonaTreeSet)it.next();
        //pr=pIt;
        if (pIt.getNroId().equals("998877")){
            System.out.println ("Eliminando persona Nro. "+k);
            pr=pIt;
        }
        k++;
        
    }
    //No se recomienda eliminar dentro del mismo ciclo con el iterator
    personas.remove(pr);
    
    
    it  = personas.iterator();
    k=1;
    System.out.println("\nLista de personas despues de un borrado\n");

    while (it.hasNext()){
        PersonaTreeSet pIt =(PersonaTreeSet)it.next();
        System.out.println ("Personas Nro. "+k++);
        System.out.format("Id: %s\nNombre: %s\nApellidos: %s\n\n", pIt.getNroId(),pIt.getNombre(),pIt.getApellidos());

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
