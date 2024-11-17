#ifndef VERTICE_H
#define VERTICE_H

#include <cmath>
#include <iostream>

struct Vertice {
    float px, py, pz;

    Vertice() : px(0), py(0), pz(0) {}
    Vertice(float x, float y, float z) : px(x), py(y), pz(z) {}

    // Calcular distancia euclidiana entre dos vértices
    float distancia(const Vertice& otro) const {
        return sqrt(pow(px - otro.px, 2) + pow(py - otro.py, 2) + pow(pz - otro.pz, 2));
    }

    // Sobrecarga del operador << para imprimir vértices
    friend std::ostream& operator<<(std::ostream& os, const Vertice& v) {
        os << "(" << v.px << ", " << v.py << ", " << v.pz << ")";
        return os;
    }
};

#endif // VERTICE_H

