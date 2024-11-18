#ifndef KDTREE_H
#define KDTREE_H

#include <vector>
#include <limits>
#include <cmath>  // Asegúrate de incluir cmath para funciones matemáticas como sqrt, pow, fabs
#include <algorithm>

template <typename T>
class kdtree {
public:
    struct Nodo {
        T punto;
        Nodo* izquierda;
        Nodo* derecha;

        Nodo(const T& p) : punto(p), izquierda(nullptr), derecha(nullptr) {}
    };

private:
    Nodo* raiz;

    // Modificado para ser 'const', ya que no debe modificar el árbol.
    Nodo* insertar(Nodo* nodo, const T& punto) const {
        if (nodo == nullptr) return new Nodo(punto);
        
        // Calcular el eje de división
        int eje = obtenerEje(nodo->punto, punto);

        if (obtenerCoordenada(punto, eje) < obtenerCoordenada(nodo->punto, eje))
            nodo->izquierda = insertar(nodo->izquierda, punto);
        else
            nodo->derecha = insertar(nodo->derecha, punto);

        return nodo;
    }

    int obtenerEje(const T& a, const T& b) const {
        if (a.px != b.px) return 0;  // Dividir según el eje X
        if (a.py != b.py) return 1;  // Dividir según el eje Y
        return 2;  // Dividir según el eje Z
    }

    double obtenerCoordenada(const T& punto, int eje) const {
        if (eje == 0) return punto.px;
        if (eje == 1) return punto.py;
        return punto.pz;
    }

public:
    kdtree() : raiz(nullptr) {}

    void insertar(const T& punto) {
        raiz = insertar(raiz, punto);
    }

    // Cambiado para 'const' debido a que se está llamando desde un objeto 'const'
    T encontrarMasCercano(const T& punto, double& mejorDistancia) const {
        return encontrarMasCercano(raiz, punto, mejorDistancia);
    }

    // Cambiado a 'const' para que no modifique el estado del árbol
    T encontrarMasCercano(const Nodo* nodo, const T& punto, double& mejorDistancia) const {
        if (nodo == nullptr) return T();

        double distancia = punto.distancia(nodo->punto);
        if (distancia < mejorDistancia) {
            mejorDistancia = distancia;
            return nodo->punto;
        }

        int eje = obtenerEje(nodo->punto, punto);
        const Nodo* primerBusqueda = nullptr;
        const Nodo* segundoBusqueda = nullptr;

        if (obtenerCoordenada(punto, eje) < obtenerCoordenada(nodo->punto, eje)) {
            primerBusqueda = nodo->izquierda;
            segundoBusqueda = nodo->derecha;
        } else {
            primerBusqueda = nodo->derecha;
            segundoBusqueda = nodo->izquierda;
        }

        // Buscar en el primer nodo
        T mejor = encontrarMasCercano(primerBusqueda, punto, mejorDistancia);

        // Si la distancia mínima ya es más pequeña que la diferencia en el eje, buscar en el otro nodo
        if (fabs(obtenerCoordenada(punto, eje) - obtenerCoordenada(nodo->punto, eje)) < mejorDistancia) {
            T posibleMejor = encontrarMasCercano(segundoBusqueda, punto, mejorDistancia);
            if (posibleMejor.distancia(punto) < mejorDistancia) {
                mejor = posibleMejor;
            }
        }

        return mejor;
    }
};

#endif  // KDTREE_H
