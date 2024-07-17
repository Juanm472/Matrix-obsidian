/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dependencia;

/**
 *
 * @author user
 */
public class Libro {
    private String titulo;
    private String autor;
    private int numeroDePaginas;
    
    // Constructor
    public Libro(String titulo, String autor, int numeroDePaginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.numeroDePaginas = numeroDePaginas;
    }
    
    // Métodos para obtener los atributos del libro
    public String getTitulo() {
        return titulo;
    }
    
    public String getAutor() {
        return autor;
    }
    
    public int getNumeroDePaginas() {
        return numeroDePaginas;
    }
    
    // Otros métodos de la clase Libro...
}

