/*
 * <><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>
 * Implementación de la clase NodoBinario
 * Autor: Juan Manuel Lopez 
 * Explicación: Este archivo contiene la definición de la clase 
 * `NodoBinario`, que representa un nodo en un árbol binario.
 * Un nodo binario tiene un valor (dato) y punteros a sus hijos 
 * izquierdo y derecho.
 *
 * Métodos Implementados:
 * - Constructor por defecto: Inicializa un nodo vacío.
 * - Constructor con parámetro: Inicializa un nodo con un valor específico.
 * - Destructor: Libera memoria ocupada por el nodo.
 * - obtenerDato: Devuelve el dato almacenado en el nodo.
 * - fijarDato: Asigna un nuevo valor al nodo.
 * - obtenerHijoIzq: Devuelve el hijo izquierdo del nodo.
 * - obtenerHijoDer: Devuelve el hijo derecho del nodo.
 * - fijarHijoIzq: Asigna un nuevo hijo izquierdo al nodo.
 * - fijarHijoDer: Asigna un nuevo hijo derecho al nodo.
 * - esHoja: Verifica si el nodo es una hoja (sin hijos).
 * - altura: Calcula la altura del nodo.
 * - inOrden, preOrden, posOrden: Métodos para realizar recorridos del árbol.
 * - tamano: Calcula el tamaño total del subárbol con este nodo como raíz.
 *
 * Este nodo es utilizado en la implementación de árboles binarios 
 * y sirve como base para estructuras más complejas como árboles AVL.
 * <><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>
 */
#ifndef NODOBINARIO_H_INCLUDED
#define NODOBINARIO_H_INCLUDED

template < class T >
class NodoBinario {
protected:
    T dato;
    NodoBinario<T>* hijoIzq;
    NodoBinario<T>* hijoDer;
public:
    NodoBinario();
    NodoBinario(T val);
    ~NodoBinario();
    T obtenerDato();
    void fijarDato(T val);
    NodoBinario<T>* obtenerHijoIzq();
    NodoBinario<T>* obtenerHijoDer();
    void fijarHijoIzq(NodoBinario<T>* izq);
    void fijarHijoDer(NodoBinario<T>* der);
    bool esHoja();
    int altura();
    void inOrden();
    void preOrden();
    void posOrden();
    int tamano();
};

#include "NodoBinario.hxx"

#endif // NODOBINARIO_H_INCLUDED
