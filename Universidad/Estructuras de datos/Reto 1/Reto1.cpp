/*
 * <><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>
 * 
 *  Proyecto Reto 1 TAD Cafeteras
 *  Autor Juan Manuel Lopez
 *  Fecha Julio 2024
 *
 *  Descripción:
 *  Implementación de TAD para la creación de cafeteras.
 * 
 * <><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>
 */

#include <iostream>
#include <string>

using namespace std;

struct Cafetera {
    void prepararCapuchino(const string& marca) const {
        cout << "Preparando capuchino con cafetera " << marca << "." << endl;
    }

    void prepararTinto(const string& marca) const {
        cout << "Preparando tinto con cafetera " << marca << "." << endl;
    }
};

// Implementación específica para Oster
struct Oster {
    Cafetera cafetera;
    void prepararCapuchino() const {
        cafetera.prepararCapuchino("Oster");
    }

    void prepararTinto() const {
        cafetera.prepararTinto("Oster");
    }
};

// Implementación específica para Haceb
struct Haceb {
    Cafetera cafetera;
    void prepararCapuchino() const {
        cafetera.prepararCapuchino("Haceb");
    }

    void prepararTinto() const {
        cafetera.prepararTinto("Haceb");
    }
};

int main() {
    Oster cafeteraOster;
    Haceb cafeteraHaceb;
    int opcionMarca, opcionPreparacion;

    while (true) {
        cout << "\nMenu de Cafeteras" << endl;
        cout << "1. Usar cafetera Oster" << endl;
        cout << "2. Usar cafetera Haceb" << endl;
        cout << "3. Salir" << endl;
        cout << "Selecciona una opcion (1-3): ";
        cin >> opcionMarca;

        switch (opcionMarca) {
            case 1: // Selección de cafetera Oster
                cout << "Selecciona la bebida para la cafetera Oster" << endl;
                cout << "1. Capuchino" << endl;
                cout << "2. Tinto" << endl;
                cout << "Selecciona una opcion (1-2): ";
                cin >> opcionPreparacion;

                switch (opcionPreparacion) {
                    case 1:
                        cafeteraOster.prepararCapuchino();
                        break;
                    case 2:
                        cafeteraOster.prepararTinto();
                        break;
                    default:
                        cout << "Opcion invalida. Por favor, selecciona una opcion entre 1 y 2." << endl;
                        continue;
                }
                cin.get(); // Esperar a que el usuario presione Enter antes de cerrar
                return 0; // Terminar el programa después de preparar el café

            case 2: // Selección de cafetera Haceb
                cout << "Selecciona la bebida para la cafetera Haceb" << endl;
                cout << "1. Capuchino" << endl;
                cout << "2. Tinto" << endl;
                cout << "Selecciona una opcion (1-2): ";
                cin >> opcionPreparacion;

                switch (opcionPreparacion) {
                    case 1:
                        cafeteraHaceb.prepararCapuchino();
                        break;
                    case 2:
                        cafeteraHaceb.prepararTinto();
                        break;
                    default:
                        cout << "Opcion invalida. Por favor, selecciona una opcion entre 1 y 2." << endl;
                        continue;
                }
                cin.get(); // Esperar a que el usuario presione Enter antes de cerrar
                return 0; // Terminar el programa después de preparar el café

            case 3: // Salir
                cout << "Saliendo del programa." << endl;
                return 0;

            default:
                cout << "Opcion invalida. Por favor, selecciona una opcion entre 1 y 3." << endl;
                break;
        }
    }

    return 0;
}
