/*
 * <><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>
 * Implementación de la clase Arbol (QuadTree)
 * Autor: [Tu Nombre]
 * Explicacion: Este archivo contiene la implementación de los métodos
 * de la clase `Arbol`, que representa un árbol cuadriculado (QuadTree).
 * 
 * Métodos Implementados:
 * - Constructor por defecto: Inicializa el árbol vacío.
 * - Constructor con valor: Crea un árbol con un nodo raíz.
 * - esVacio: Verifica si el árbol está vacío.
 * - obtenerRaiz: Devuelve el valor de la raíz.
 * - altura: Calcula la altura del árbol.
 * - tamano: Calcula el tamaño del árbol.
 * - insertar: Inserta un valor en el árbol.
 * - buscar: Busca un valor en el árbol.
 * - preOrden: Realiza un recorrido en preorden.
 * - posOrden: Realiza un recorrido en posorden.
 *
 * Esta implementación maneja de forma básica la estructura y operaciones
 * de un QuadTree. Se utiliza para organizar datos bidimensionales y realizar
 * operaciones de búsqueda eficientes en un espacio dividido en cuadrantes.
 *
 * <><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>
 */
#include <bits/stdc++.h>
#include "quadtree.h"

using namespace std;

template<class T>
Arbol<T>::Arbol() {
    this->raiz = NULL;  // Inicializa la raíz como NULL
}

template<class T>
Arbol<T>::Arbol(pair<T,T> val) {
    this->raiz = new Nodo<T>(val);  // Crea la raíz con el valor proporcionado
}


template<class T>
bool Arbol<T>::esVacio() {
    return this->raiz == NULL;  // Devuelve true si la raíz es NULL
}

template<class T>
pair<T,T> Arbol<T>::obtenerRaiz() {
    if (this->raiz != nullptr) {
        return this->raiz->obtenerDato();  // Devuelve el valor almacenado en la raíz
    } else {
        throw runtime_error("El árbol está vacío.");  // Maneja el caso en que el árbol esté vacío
    }
}

template<class T>
int Arbol<T>::altura() {
    return (this->raiz != NULL) ? this->raiz->altura() : 0;  // Llama al método altura del nodo raíz
}

template<class T>
int Arbol<T>::tamano() {
    return (this->raiz != NULL) ? this->raiz->tamano() : 0;  // Llama al método tamaño del nodo raíz
}

template<class T>
void Arbol<T>::insertar(pair<T,T> val) {
    if (this->esVacio()) {
        // Si el árbol está vacío, crea la raíz
        this->raiz = new Nodo<T>(val);
    } else {
        // De lo contrario, inserta en el árbol existente
        this->raiz->insertar(val);
    }
}



template<class T>
Nodo<T>* Arbol<T>::buscar(pair<T,T> val) {
    return (this->raiz != NULL) ? this->raiz->buscar(val) : NULL;  // Busca en el árbol
}

template<class T>
void Arbol<T>::preOrden() {
    if (this->raiz != NULL) {
        this->raiz->preOrden();  // Realiza el recorrido en preorden
    }
}

template<class T>
void Arbol<T>::posOrden() {
    if (this->raiz != NULL) {
        this->raiz->posOrden();  // Realiza el recorrido en posorden
    }
}
