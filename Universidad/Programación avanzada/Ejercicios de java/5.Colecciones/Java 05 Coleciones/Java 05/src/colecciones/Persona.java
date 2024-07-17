/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colecciones;

import java.util.Comparator;

/**
 *
 * @author user
 */
class Persona implements Comparator<Persona>   {

    private String nroId;
    public String nombre;
    private String apellidos;
    private int edad;
    // Constructor de la clase
    
    Persona() {
    }
    
    
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;

    }

    public Persona(String nroId,String nombre, String apellidos, int edad) {
        this.nroId=nroId;
        this.nombre = nombre;
        this.apellidos=apellidos;
        this.edad = edad;

    }
    

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

  
    /**
     * @return the nroId
     */
    public String getNroId() {
        return nroId;
    }

    /**
     * @param nroId the nroId to set
     */
    public void setNroId(String nroId) {
        this.nroId = nroId;
    }
    
    public  int compare(Persona a, Persona b)
        {
            //return   a.edad-b.edad;
            //return   b.edad-a.edad;
            return a.nombre.compareTo(b.nombre);
            //return a.nombre.compareTo(b.nombre);
        }

    public String toString(){
        return "\nId: "+this.getNroId()+" - Nombre: "+ this.getNombre()+" - Apellidos: "+this.getApellidos()+" - Edad: "+this.getEdad();
    }




}
