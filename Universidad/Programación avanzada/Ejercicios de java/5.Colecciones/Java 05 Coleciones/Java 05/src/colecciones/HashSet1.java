package colecciones;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class HashSet1 {

    public static void main(String[] args) {
        //LinkedHashSet<String> marcas = new LinkedHashSet<String>();
        HashSet<String> marcas = new HashSet<String>();
        marcas.add("Volvo");
        marcas.add("BMW");
        marcas.add("JAC");
        marcas.add("Ford");
        marcas.add("Mazda");
        marcas.add("Mazda");

        System.out.println("Listado de marcas");
        System.out.println(marcas);
        System.out.println("\n");

        HashSet<Persona> personas = new HashSet<Persona>();

        Persona p1 = new Persona();
        personas.add(new Persona("12014525", "maria", "galvis", 18));
        personas.add(new Persona("12014525", "maria", "galvis", 18));
        personas.add(new Persona("965874", "pedro", "Gomez", 52));

        p1.setNroId("998877");
        p1.setNombre("Juan Ricardo");
        p1.setApellidos("Romero");
        p1.setEdad(12);
        personas.add(p1);
        personas.add(p1);

        p1 = new Persona();
        p1.setNroId("65874");
        p1.setNombre("Juliana");
        p1.setApellidos("Perez");
        p1.setEdad(17);

        personas.add(p1); //Se adiciona dos veces, pero el objeto solo la guarda una vez

        Persona p2 = new Persona("456789", "Javier", "Lopez", 8);
        personas.add(p2);
        personas.add(p2);
        System.out.println("\nLista de personas usando iterador simple\n");
       
        //Esto NO ESTA PERMITIDO EN UN HASHSET
        //Collections.sort(personas, Comparator.comparing(Persona::getNombre));

        for (Persona p : personas) {
            System.out.format("Id: %s |  Nombre: %s |  Apellidos: %s | Edad: %d\n", p.getNroId(), p.getNombre(), p.getApellidos(), p.getEdad());
        }

        personas.removeAll(personas);

        System.out.println("\nLista de personas despues de removeAll\n");
        
        
        Iterator it = personas.iterator();
        int k = 1;
        while (it.hasNext()) {
            Persona pIt = (Persona) it.next();
            System.out.println("Personas Nro. " + k++);
            System.out.format("Id: %s | Nombre: %s  | Apellidos: %s  ", pIt.getNroId(), pIt.getNombre(), pIt.getApellidos());

        }

    }
}
