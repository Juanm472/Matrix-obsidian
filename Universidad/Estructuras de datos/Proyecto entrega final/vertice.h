#ifndef VERTICE_H
#define VERTICE_H

#include <iostream>  // Asegúrate de incluir iostream para std::ostream

class Vertice {
public:
    float px, py, pz;  // Coordenadas del vértice

    // Constructor
    Vertice(float x = 0, float y = 0, float z = 0) : px(x), py(y), pz(z) {}

    // Sobrecarga del operador de salida para imprimir el vértice
    friend std::ostream& operator<<(std::ostream& os, const Vertice& v);

    // Método para calcular la distancia entre dos vértices
    double distancia(const Vertice& otro) const {
        return sqrt(pow(px - otro.px, 2) + pow(py - otro.py, 2) + pow(pz - otro.pz, 2));
    }
};

// Sobrecarga del operador de salida
std::ostream& operator<<(std::ostream& os, const Vertice& v) {
    os << "(" << v.px << ", " << v.py << ", " << v.pz << ")";
    return os;
}

#endif  // VERTICE_H
