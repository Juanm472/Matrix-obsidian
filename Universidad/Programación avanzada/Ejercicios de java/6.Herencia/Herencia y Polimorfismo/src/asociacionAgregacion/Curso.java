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
public class Curso {
    private String nombre;
    private ArrayList<Estudiante> estudiantes;

    // Constructor
    public Curso(String nombre) {
        this.nombre = nombre;
        estudiantes = new ArrayList<Estudiante>();
    }

    // Método para añadir un estudiante al curso
    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    // Otros métodos de la clase Curso...
}