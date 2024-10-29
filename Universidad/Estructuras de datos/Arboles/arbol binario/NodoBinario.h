/*
 * <><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>
 * Implementacion arbol bianrio  
 * Autor: Juan Manuel Lopez 
 * Explicacion: Define la clase NodoBinario, que representa un nodo en el árbol binario. 
 *  Cada nodo tiene un valor (dato) y dos punteros a sus hijos izquierdo y derecho (hijoIzq y hijoDer). 
 *  La clase incluye métodos para obtener y establecer el valor y los hijos,
 *  calcular la altura y el tamaño del subárbol, insertar nuevos nodos, 
 *  buscar nodos y realizar recorridos del árbol en diferentes órdenes. 
 *
 * <><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>
 */

#ifndef __NODOBINARIO__H__
#define __NODOBINARIO__H__

using namespace std;

template<class T>
class NodoBinario {
protected:
    T dato;
    NodoBinario *hijoIzq, *hijoDer;
public:
    NodoBinario();
    T& obtenerDato();
    void fijarDato(T& val);
    NodoBinario* obtenerHijoIzq();
    NodoBinario* obtenerHijoDer();
    void fijarHijoIzq(NodoBinario *izq);
    void fijarHijoDer(NodoBinario *der);
    int altura();
    int tamano();
    void insertar(T& val);
    NodoBinario* buscar(T& val);
    NodoBinario* extremo_der();
    NodoBinario* extremo_izq();
    void preOrden();
    void inOrden();
    void posOrden();
    void nivelOrden();
};

#include "NodoBinario.hxx"
#endif
