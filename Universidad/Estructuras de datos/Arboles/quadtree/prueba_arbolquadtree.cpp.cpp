/*
 * <><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>
 * Programa de prueba para el árbol cuadriculado (QuadTree)
 * Autor: Juan Manuel Lopez 
 * Explicacion: Este programa implementa un árbol cuadriculado (QuadTree) y realiza
 * varias operaciones para verificar su correcto funcionamiento.
 * 
 * 1. Crea un árbol vacío.
 * 2. Verifica si el árbol está vacío.
 * 3. Inserta varios valores en el árbol.
 * 4. Obtiene y muestra la raíz del árbol.
 * 5. Busca un valor en el árbol.
 * 6. Calcula y muestra la altura y el tamaño del árbol.
 * 7. Realiza recorridos en preorden y posorden.
 * 
 * Este programa ejemplifica cómo utilizar la clase `Arbol` para manejar datos
 * en un QuadTree, proporcionando ejemplos de inserción, búsqueda y recorridos.
 *
 * <><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>
 */
#include <iostream>
#include "quadtree.h"

int main() {
    // Crear un árbol vacío
    Arbol<int> arbol;

    // Verificar si el árbol está vacío
    if (arbol.esVacio()) {
        std::cout << "El árbol está vacío." << std::endl;
    }

    // Insertar valores
    arbol.insertar({10, 20});
    arbol.insertar({15, 25});
    arbol.insertar({5, 30});

    // Mostrar la raíz
    try {
        std::pair<int, int> raiz = arbol.obtenerRaiz();
        std::cout << "Raíz: (" << raiz.first << ", " << raiz.second << ")" << std::endl;
    } catch (const std::runtime_error& e) {
        std::cerr << e.what() << std::endl;
    }

    // Buscar un valor en el árbol
    Nodo<int>* resultado = arbol.buscar({15, 25});
    if (resultado != nullptr) {
        std::cout << "Valor encontrado: (" << resultado->obtenerDato().first << ", " << resultado->obtenerDato().second << ")" << std::endl;
    } else {
        std::cout << "Valor no encontrado." << std::endl;
    }

    // Obtener y mostrar la altura del árbol
    int altura = arbol.altura();
    std::cout << "Altura del árbol: " << altura << std::endl;

    // Obtener y mostrar el tamaño del árbol
    int tamano = arbol.tamano();
    std::cout << "Tamaño del árbol: " << tamano << std::endl;

    // Realizar recorrido preorden
    std::cout << "Recorrido preorden:" << std::endl;
    arbol.preOrden();

    // Realizar recorrido posorden
    std::cout << "Recorrido posorden:" << std::endl;
    arbol.posOrden();

    return 0;
}
