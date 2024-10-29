/*
 * <><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>
 * Implementacion de un nodo en un árbol cuadriculado
 * Autor: Juan Manuel Lopez 
 * Explicacion: Define la clase Nodo, que representa un nodo de un árbol
 * cuadriculado. Cada nodo contiene un par de valores de tipo T y tiene punteros
 * a sus cuatro hijos (NW, NE, SW, SE), correspondientes a las cuatro 
 * subdivisiones del espacio en el árbol.
 * 
 * La clase incluye métodos para:
 * - Inicializar el nodo.
 * - Obtener y fijar el valor del nodo.
 * - Insertar un nuevo valor en el nodo.
 * - Buscar un valor dentro del árbol.
 * - Realizar recorridos preorden y posorden.
 * - Calcular la altura y el tamaño del árbol.
 * 
 * Se utiliza el template para que el nodo pueda almacenar cualquier tipo de
 * dato (T), y las operaciones de búsqueda, inserción y recorrido sean genéricas.
 *
 * <><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>
 */
#ifndef __NODO__H__
#define __NODO__H__

using namespace std;

template< class T >
class Nodo
{
  protected:
    pair<T,T> dato;         // Par de datos almacenados en

#ifndef __NODO__H__
#define __NODO__H__

using namespace std;

template< class T >
class Nodo
{
  protected:
    pair<T,T> dato;
    Nodo<T>* NW;
    Nodo<T>* NE;
    Nodo<T>* SW;
    Nodo<T>* SE;


  public:
  	Nodo();
  	Nodo(pair<T,T> val);
  	int altura();
  	int tamano();
    pair<T,T> obtenerDato();
    void insertar(pair<T,T>  val);
    void fijarDato(pair<T,T> val);
    void preOrden();
    void posOrden();
    Nodo* buscar(pair<T,T> val);
};

#include "nodo.hxx"
#endif
