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
public class Casa {
    private String direccion;
    private ArrayList<Habitante> habitantes;

    // Constructor
    public Casa(String direccion) {
        this.direccion = direccion;
        habitantes = new ArrayList<Habitante>();
    }

    // Método para añadir un habitante a la casa
    public void agregarHabitante(Habitante habitante) {
        habitantes.add(habitante);
    }

    // Otros métodos de la clase Casa...
}