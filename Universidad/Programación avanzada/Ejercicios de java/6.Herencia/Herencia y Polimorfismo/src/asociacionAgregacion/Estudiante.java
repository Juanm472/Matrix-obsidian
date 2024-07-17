/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asociacionAgregacion;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Estudiante {
    private String nombre;
    private int edad;
    private ArrayList<Curso> cursos=null;

    // Constructor
    public Estudiante(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        cursos = new ArrayList<Curso>();
    }

    // Método para añadir un curso al estudiante
    public void agregarCurso(Curso curso) {
        cursos.add(curso);
    }

    // Otros métodos de la clase Estudiante...
}