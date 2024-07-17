/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randomFiles;

/**
 *
 * @author user
 */
public class Estudiante {
    
     private String idEstudiante;
     private String nombre;
     private String apellido;
     private int edad;
     private String carrera;
    
     
     public Estudiante(String idEstudiante){
         this.idEstudiante=idEstudiante;
     }

    public Estudiante() {        
    }
     
     

    /**
     * @return the idEstudiante
     */
    public String getIdEstudiante() {
        return idEstudiante;
    }

    /**
     * @param idEstudiante the idEstudiante to set
     */
    public void setIdEstudiante(String idEstudiante) {
        this.idEstudiante = idEstudiante;
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
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
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
     * @return the carrera
     */
    public String getCarrera() {
        return carrera;
    }

    /**
     * @param carrera the carrera to set
     */
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    
    public String toString() {
        return this.getIdEstudiante() + ", " + this.getNombre() + ", "
                + this.getApellido () + ", " + this.getEdad()+ ", "
                + this.getCarrera() + ".\n";
    } 
    
    
}
