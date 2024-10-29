/*
 * <><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>
 * Implementación del Árbol AVL
 * Autor: Juan Manuel Lopez 
 * Métodos Implementados:
 * - Constructor y destructor.
 * - esVacio(): Verifica si el árbol está vacío.
 * - insertarRaiz(): Inserta la raíz en el árbol.
 * - insertar(): Inserta un valor y balancea el árbol si es necesario.
 * - eliminar(): Elimina un valor del árbol y lo balancea.
 * - preOrden(): Recorre el árbol en preorden.
 * - inOrden(): Recorre el árbol en inorden.
 * - posOrden(): Recorre el árbol en posorden.
 * - nivelOrden(): Recorre el árbol por niveles.
 * - altura(): Calcula la altura del árbol o de un nodo específico.
 * - balanceo(): Calcula el factor de balanceo de un nodo.
 * - rotacionIzquierda() y rotacionDerecha(): Realizan rotaciones para
 *   mantener el balance del árbol.
 *
 * <><><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>
 */
#include <iostream>
#include "ArbolAVL.h"
#include <list>

//using namespace std;
int main () {
    ArbolAVL<int> arbol;
    NodoBinario<int>* nodoRaiz = new NodoBinario<int>(2);
    arbol.insertarRaiz(nodoRaiz);
    arbol.insertar(15);
    arbol.insertar(4);
    arbol.insertar(10);
    arbol.insertar(21);
    arbol.insertar(30);
    arbol.insertar(5);
    arbol.insertar(19);
    arbol.insertar(38);
    arbol.insertar(27);
    arbol.insertar(8);

    std:: cout<< "Arbol en preorden: ";
    arbol.preOrden();
    std:: cout << std::endl;
    std:: cout<< "Arbol en posorden: ";
    arbol.posOrden();
    std:: cout << std::endl;
    std:: cout<< "Arbol en nivelorden: ";
    arbol.nivelOrden();
    std:: cout << std::endl;
    std:: cout<< "Arbol en inOrden: ";
    arbol.inOrden();
    std:: cout << std::endl;


return 0;
}
