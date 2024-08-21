/*
 * <><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>
 * 
 *  Proyecto Taller 2  Estructuras Lineales
 *  Autores:  
 *  Juan Manuel Lopez
 *  David León
 *  Sebastián Méndez
 *  Sebastián Almanza
 *  
 *
 *  Descripción:
 *  Busqueda de subcadenas en archivos de texto 
 * 
 * <><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>
 */
#include <iostream>
#include <fstream>
#include <vector>
#include <string>

using namespace std;

struct Palabra {
    string palabra;
    unsigned int n_linea;

    Palabra(string p, unsigned int linea) : palabra(p), n_linea(linea) {}
};

class ArchivoTexto {
private:
    vector<string> lineasTexto;

public:
    void leerArchivo(const string &nombreArchivo) {
        ifstream archivo(nombreArchivo);
        if (!archivo.is_open()) {
            cerr << "Error al abrir el archivo" << endl;
            return;
        }

        string linea;
        while (getline(archivo, linea)) {
            lineasTexto.push_back(linea);
        }

        archivo.close();
    }

    vector<Palabra> buscarPorSubcadena(const string &subcadena) {
        vector<Palabra> resultado;
        for (unsigned int i = 0; i < lineasTexto.size(); ++i) {
            if (lineasTexto[i].find(subcadena) != string::npos) {
                resultado.push_back(Palabra(lineasTexto[i], i + 1));
            }
        }
        return resultado;
    }

    vector<Palabra> buscarPorSubcadenaInvertida(const string &subcadena) {
        string subcadenaInvertida(subcadena.rbegin(), subcadena.rend());
        return buscarPorSubcadena(subcadenaInvertida);
    }

    void imprimirResultados(const vector<Palabra> &palabras) {
        for (const auto &p : palabras) {
            cout << "Palabra: " << p.palabra << " en la línea " << p.n_linea << endl;
        }
    }
};

int main(int argc, char* argv[]) {
    if (argc < 3) {
        cerr << "Uso: " << argv[0] << " <archivo> <subcadena>" << endl;
        return 1;
    }

    string nombreArchivo = argv[1];
    string subcadena = argv[2];

    ArchivoTexto archivoTexto;
    archivoTexto.leerArchivo(nombreArchivo);

    cout << "Buscando palabras que contienen la subcadena: " << subcadena << endl;
    vector<Palabra> palabras = archivoTexto.buscarPorSubcadena(subcadena);
    archivoTexto.imprimirResultados(palabras);

    cout << "Buscando palabras que contienen la subcadena invertida: " << subcadena << endl;
    palabras = archivoTexto.buscarPorSubcadenaInvertida(subcadena);
    archivoTexto.imprimirResultados(palabras);

    return 0;
}