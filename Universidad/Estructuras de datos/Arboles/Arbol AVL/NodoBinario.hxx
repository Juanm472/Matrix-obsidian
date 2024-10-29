/*
 * <><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>
 * Implementación de la clase NodoBinario
 * Autor: Juan Manuel Lopez 
 * Explicación: Este archivo contiene la implementación de la 
 * clase `NodoBinario`, que representa un nodo en un árbol binario.
 * Cada nodo contiene un dato, así como punteros a sus hijos 
 * izquierdo y derecho, y métodos para manipular y obtener 
 * información sobre el nodo.
 *
 * Métodos Implementados:
 * - NodoBinario(): Constructor por defecto.
 * - NodoBinario(T val): Constructor que inicializa el nodo con un valor.
 * - ~NodoBinario(): Destructor que libera la memoria ocupada por los hijos.
 * - obtenerDato(): Devuelve el dato almacenado en el nodo.
 * - fijarDato(T val): Asigna un nuevo valor al nodo.
 * - obtenerHijoIzq(): Devuelve el hijo izquierdo del nodo.
 * - obtenerHijoDer(): Devuelve el hijo derecho del nodo.
 * - fijarHijoIzq(NodoBinario<T>* izq): Asigna un nuevo hijo izquierdo.
 * - fijarHijoDer(NodoBinario<T>* der): Asigna un nuevo hijo derecho.
 * - esHoja(): Verifica si el nodo es una hoja (sin hijos).
 * - altura(): Calcula la altura del nodo en el árbol.
 * - inOrden(): Realiza un recorrido en orden del subárbol.
 * - preOrden(): Realiza un recorrido en preorden del subárbol.
 * - posOrden(): Realiza un recorrido en posorden del subárbol.
 * - tamano(): Calcula el tamaño del subárbol con este nodo como raíz.
 * <><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>
 */
#ifndef NODOBINARIO_HXX_INCLUDED
#define NODOBINARIO_HXX_INCLUDED

#include "NodoBinario.h"
#include <iostream>

template < class T >
NodoBinario<T>::NodoBinario(){
    this->hijoIzq = nullptr;
    this->hijoDer = nullptr;
}

template < class T >
NodoBinario<T>::NodoBinario(T val){
    this->hijoIzq = nullptr;
    this->hijoDer = nullptr;
    this->dato = val;
}

template < class T >
NodoBinario<T>::~NodoBinario(){
    if(this->hijoIzq != nullptr){
        delete this->hijoIzq;
        this->hijoIzq = nullptr;
    }
    if(this->hijoDer != nullptr){
        delete this->hijoDer;
        this->hijoDer = nullptr;
    }
}

template < class T >
T NodoBinario<T>::obtenerDato(){
    return this->dato;
}

template < class T >
void NodoBinario<T>::fijarDato(T val){
    this->dato = val;
}

template < class T >
NodoBinario<T>* NodoBinario<T>::obtenerHijoIzq(){
    return this->hijoIzq;
}

template < class T >
NodoBinario<T>* NodoBinario<T>::obtenerHijoDer(){
    return this->hijoDer;
}

template < class T >
void NodoBinario<T>::fijarHijoIzq(NodoBinario<T>* izq){
    this->hijoIzq = izq;
}

template < class T >
void NodoBinario<T>::fijarHijoDer(NodoBinario<T>* der){
    this->hijoDer = der;
}

template < class T >
bool NodoBinario<T>::esHoja(){
    return (this->hijoIzq == nullptr && this->hijoDer == nullptr);
}

template < class T >
int NodoBinario<T>::altura(){
    int valt;

    if(this->esHoja()){
        valt = 0;
    } else {
        int valt_izq = -1;
        int valt_der = -1;
        if(this->hijoIzq != nullptr)
            valt_izq = (this->hijoIzq)->altura();
        if(this->hijoDer != nullptr)
            valt_der = (this->hijoDer)->altura();
        if (valt_izq > valt_der)
            valt = valt_izq + 1;
        else
            valt = valt_der + 1;

    }
    return valt;
}

template <class T>
void NodoBinario<T>::inOrden() {
    if (this->hijoIzq != nullptr)
        (this->hijoIzq)->inOrden();
    std::cout << this->dato << " ";
    if (this->hijoDer != nullptr)
        (this->hijoDer)->inOrden();
}

template <class T>
void NodoBinario<T>::preOrden() {
    std::cout << this->dato << " ";
    if (this->hijoIzq != nullptr)
        (this->hijoIzq)->preOrden();
    if (this->hijoDer != nullptr)
        (this->hijoDer)->preOrden();
}

template < class T >
void NodoBinario<T>::posOrden() {
    if (this->hijoIzq != nullptr)
        (this->hijoIzq)->posOrden();
    if (this->hijoDer != nullptr)
        (this->hijoDer)->posOrden();
    std::cout << this->dato << " ";
}

template <class T>
int NodoBinario<T>::tamano() {
    int tamIzq = 0;
    int tamDer = 0;

    if (this->hijoIzq != nullptr)
        tamIzq = (this->hijoIzq)->tamano();
    if (this->hijoDer != nullptr)
        tamDer = (this->hijoDer)->tamano();

    return tamIzq + tamDer + 1;

}

#endif // NODOBINARIO_HXX_INCLUDED
