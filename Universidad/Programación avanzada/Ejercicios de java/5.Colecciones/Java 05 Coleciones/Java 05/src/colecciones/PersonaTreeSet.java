package colecciones;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class PersonaTreeSet  implements Comparable<PersonaTreeSet>{
    
   private String nroId;
   private String nombre;
   private String apellidos;
   private int edad;

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
   
   public PersonaTreeSet (){
       
   }
   
   public PersonaTreeSet (String nroId, String nombre, String apellidos, int edad){
       this.nroId=nroId;
       this.nombre= nombre;
       this.apellidos= apellidos;
       this.edad=edad;
   }

    public String getNroId() {
        return nroId;
    }

    public void setNroId(String nroId) {
        this.nroId = nroId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
           
    
    public String toString(){
        return this.nroId+" "+this.nombre+" "+this.apellidos+" "+this.edad;
    }
  
    //Esto se sobreescribe para los TreeSet
    
    public int compareTo(PersonaTreeSet p) { 
        return this.edad-p.getEdad();
    }  
    
}
