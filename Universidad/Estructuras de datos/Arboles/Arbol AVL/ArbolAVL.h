#ifndef ARBOLAVL_H_INCLUDED
#define ARBOLAVL_H_INCLUDED
/*
 * <><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>
 * Implementación del Árbol AVL
 * Autor: Juan Manuel Lopez 
 * Explicación: Este archivo contiene la definición de la clase 
 * `ArbolAVL`, que implementa un árbol binario balanceado por alturas (AVL).
 * Un Árbol AVL es un árbol binario de búsqueda que se mantiene 
 * balanceado automáticamente después de cada inserción o eliminación.
 *
 * Métodos Implementados:
 * - Constructor y destructor
 * - esVacio: Verifica si el árbol está vacío.
 * - datoRaiz: Devuelve el dato almacenado en la raíz.
 * - insertarRaiz: Inserta una raíz en el árbol.
 * - altura: Calcula la altura del árbol o de un nodo específico.
 * - tamano: Calcula el tamaño total del árbol.
 * - buscar: Busca un valor en el árbol.
 * - preOrden, inOrden, posOrden, nivelOrden: Realizan recorridos del árbol.
 * - obtenerSucesor: Devuelve el sucesor de un nodo dado.
 * - balanceo: Calcula el factor de balanceo de un nodo.
 * - balancear: Balancea el subárbol a partir de un nodo dado.
 * - insertarRec: Inserta un valor de manera recursiva y balancea el árbol.
 * - eliminarRec: Elimina un valor de manera recursiva y balancea el árbol.
 * - rotacionDerecha: Realiza una rotación hacia la derecha.
 * - rotacionIzquierda: Realiza una rotación hacia la izquierda.
 *
 * Este árbol es utilizado para mantener operaciones de búsqueda, 
 * inserción y eliminación en tiempo logarítmico gracias a su estructura 
 * balanceada.
 * <><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>
 */
#include "NodoBinario.h"

template < class T >
class ArbolAVL {
protected:
    NodoBinario<T>* raiz;
public:
    ArbolAVL();
    ~ArbolAVL();
    bool esVacio();
    T datoRaiz();
    bool insertarRaiz(NodoBinario<T>* val);
    int altura();
    int altura(NodoBinario<T>* nodo);
    int tamano();
    bool buscar(T val);
    void preOrden();
    void inOrden();
    void posOrden();
    void nivelOrden();
    NodoBinario<T>* obtenerSucesor(NodoBinario<T>* nodo);
    int balanceo(NodoBinario<T>* nodo);
    NodoBinario<T>* balancear(NodoBinario<T>* nodo);
    NodoBinario<T>* insertarRec(NodoBinario<T>* nodo, T val);
    void insertar(T val);
    NodoBinario<T>* eliminarRec(NodoBinario<T>* nodo, T val);
    NodoBinario<T>* encontrarMinimo(NodoBinario<T>* nodo);
    void eliminar(T val);
    NodoBinario<T>* rotacionDerecha(NodoBinario<T>* y);
    NodoBinario<T>* rotacionIzquierda(NodoBinario<T>* x);
};

#include "ArbolAVL.hxx"

#endif // ARBOLAVL_H_INCLUDED
