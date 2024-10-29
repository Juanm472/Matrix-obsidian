/*
 * <><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>
 * Implementacion arbol bianrio  
 * Autor: Juan Manuel Lopez 
 * Explicacion: Define la clase ArbolBinario, que representa el árbol binario en sí.
 * La clase tiene un puntero a la raíz del árbol (raiz) * y métodos para verificar si el árbol está vacío, obtener el dato de la raíz, 
 * calcular la altura y el tamaño del árbol, insertar y eliminar nodos, y realizar recorridos en diferentes órdenes. 
 *
 * <><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>
 */



#ifndef __ARBOLBINARIO__H__
#define __ARBOLBINARIO__H__

#include "NodoBinario.h"

using namespace std;

template<class T>
class ArbolBinario {
protected:
    NodoBinario<T> *raiz;
public:
    ArbolBinario();
    bool esVacio();
    T& datoRaiz();
    int altura();
    int tamano();
    void insertar(T& val);
    bool eliminar(T& val);
    NodoBinario<T>* buscar(T& val);
    void preOrden();
    void inOrden();
    void posOrden();
    void nivelOrden();
};

#include "ArbolBinario.hxx"
#endif
