/*
 * <><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>
 * Definición de la clase Arbol (QuadTree)
 * Autor: [Tu Nombre]
 * Explicacion: Define la clase Arbol, que representa un árbol cuadriculado (QuadTree).
 * La clase incluye un puntero a la raíz del árbol y proporciona varios métodos para
 * gestionar el árbol:
 * 
 * - esVacio: Verifica si el árbol está vacío.
 * - obtenerRaiz: Devuelve el valor de la raíz del árbol.
 * - fijarRaiz: Permite establecer un nodo como la raíz del árbol.
 * - insertar: Inserta un par de valores en el árbol.
 * - altura: Calcula la altura del árbol.
 * - tamano: Calcula el tamaño (número de nodos) del árbol.
 * - buscar: Busca un valor en el árbol.
 * - preOrden: Realiza un recorrido preorden sobre el árbol.
 * - posOrden: Realiza un recorrido posorden sobre el árbol.
 * 
 * La clase utiliza plantillas (template) para ser compatible con cualquier
 * tipo de dato y funciona de manera genérica para manipular elementos en
 * el espacio bidimensional.
 *
 * <><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>
 */
#ifndef __QUADTREE__H__
#define __QUADTREE__H__

#include "nodo.h"

using namespace std;

template<class T>
class Arbol {
  protected:
    Nodo<T> *raiz;
  public:
	Arbol();
	Arbol(pair<T,T> val);
    bool esVacio();
    pair<T,T> obtenerRaiz();
    void fijarRaiz(Nodo<T>* root);
    void insertar(pair<T,T>);
    int altura();
    int tamano();
    void insertar(T& val);
    bool eliminar(T& val);
    Nodo<T>*  buscar(pair<T,T> val);
    void preOrden();
    void posOrden();
};

#include "quadtree.hxx"
#endif
