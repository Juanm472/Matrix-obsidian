#ifndef KDTREE_H
#define KDTREE_H

#include <cmath>
#include <limits>
#include "vertice.h"

template<class T>
class kdnodo {
private:
    T dato;
    kdnodo<T>* hijoIzq;
    kdnodo<T>* hijoDer;
    int tag;  // 0: X, 1: Y, 2: Z

public:
    kdnodo() : hijoIzq(nullptr), hijoDer(nullptr), tag(0) {}
    T& obtenerDato() { return dato; }
    void fijarDato(const T& val) { dato = val; }
    kdnodo<T>* obtenerHijoIzq() { return hijoIzq; }
    kdnodo<T>* obtenerHijoDer() { return hijoDer; }
    void fijarHijoIzq(kdnodo<T>* izq) { hijoIzq = izq; }
    void fijarHijoDer(kdnodo<T>* der) { hijoDer = der; }
    int obtenerTag() { return tag; }
    void fijarTag(int value) { tag = value; }
};

template<class T>
class kdtree {
private:
    kdnodo<T>* raiz;

    kdnodo<T>* insertarRecursivo(kdnodo<T>* nodo, T dato, int profundidad) {
        if (nodo == nullptr) {
            nodo = new kdnodo<T>();
            nodo->fijarDato(dato);
            nodo->fijarTag(profundidad % 3);  // Ciclo: X -> Y -> Z
            return nodo;
        }

        int tag = nodo->obtenerTag();
        if ((tag == 0 && dato.px < nodo->obtenerDato().px) ||
            (tag == 1 && dato.py < nodo->obtenerDato().py) ||
            (tag == 2 && dato.pz < nodo->obtenerDato().pz)) {
            nodo->fijarHijoIzq(insertarRecursivo(nodo->obtenerHijoIzq(), dato, profundidad + 1));
        } else {
            nodo->fijarHijoDer(insertarRecursivo(nodo->obtenerHijoDer(), dato, profundidad + 1));
        }
        return nodo;
    }

    T encontrarMasCercanoRecursivo(kdnodo<T>* nodo, const T& objetivo, int profundidad, double& mejorDistancia, T mejor) const {
        if (nodo == nullptr) return mejor;

        T puntoActual = nodo->obtenerDato();
        double distanciaActual = puntoActual.distancia(objetivo);

        if (distanciaActual < mejorDistancia) {
            mejorDistancia = distanciaActual;
            mejor = puntoActual;
        }

        int tag = nodo->obtenerTag();
        kdnodo<T>* ladoPrimario = (tag == 0 && objetivo.px < puntoActual.px) ||
                                  (tag == 1 && objetivo.py < puntoActual.py) ||
                                  (tag == 2 && objetivo.pz < puntoActual.pz)
                                  ? nodo->obtenerHijoIzq() : nodo->obtenerHijoDer();

        kdnodo<T>* ladoSecundario = ladoPrimario == nodo->obtenerHijoIzq() ? nodo->obtenerHijoDer() : nodo->obtenerHijoIzq();

        mejor = encontrarMasCercanoRecursivo(ladoPrimario, objetivo, profundidad + 1, mejorDistancia, mejor);

        double distanciaPlano = (tag == 0) ? fabs(objetivo.px - puntoActual.px) :
                              (tag == 1) ? fabs(objetivo.py - puntoActual.py) :
                                           fabs(objetivo.pz - puntoActual.pz);

        if (distanciaPlano < mejorDistancia) {
            mejor = encontrarMasCercanoRecursivo(ladoSecundario, objetivo, profundidad + 1, mejorDistancia, mejor);
        }

        return mejor;
    }

public:
    kdtree() : raiz(nullptr) {}

    void insertar(T dato) {
        raiz = insertarRecursivo(raiz, dato, 0);
    }

    T encontrarMasCercano(const T& objetivo, double& mejorDistancia) const {
        if (raiz == nullptr) {
            throw std::runtime_error("El árbol está vacío.");
        }
        return encontrarMasCercanoRecursivo(raiz, objetivo, 0, mejorDistancia, raiz->obtenerDato());
    }
};

#endif // KDTREE_H

