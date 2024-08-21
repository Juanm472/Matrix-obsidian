/*
 * <><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>
 *  Taller 00
 *  Autor Juan Manuel Lopez
 *  Fecha: Agosto 2024
 *
 * <><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>
 */

#include <iostream>
using namespace std;

struct venta {
    int cantidad;
    double precio;
}; // Aquí faltaba el punto y coma

int main() {
    venta *puntero, valor_venta;
    puntero = &valor_venta;

    cout << "Cantidad de productos: ";
    cin >> (*puntero).cantidad;

    cout << "Precio del producto: ";
    cin >> (*puntero).precio;

    cout << "Valor a pagar: " << (*puntero).cantidad * (*puntero).precio << endl; // Corregido acceso a miembros

    return 0;
}
