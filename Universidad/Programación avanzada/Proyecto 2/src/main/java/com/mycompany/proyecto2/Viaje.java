/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto2;

public class Viaje {
        int codigo;
    String aeronaveCodigo;
    String fecha;
    String origen;
    String destino;
    double valor;
    String reglas;

    public Viaje(int codigo, String aeronaveCodigo, String fecha, String origen, String destino, double valor, String reglas) {
        this.codigo = codigo;
        this.aeronaveCodigo = aeronaveCodigo;
        this.fecha = fecha;
        this.origen = origen;
        this.destino = destino;
        this.valor = valor;
        this.reglas = reglas;
    }
}
