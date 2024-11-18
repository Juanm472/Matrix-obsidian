/*
 * <><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>
 * Programa de Manejo de Mallas 3D
 * Autores: Juan Manuel López / David Leon / Johan Sebastian Mendez / Sebastian Almanza
 * Fecha: Noviembre 2024
 * Explicación: Este programa permite cargar, guardar, y manipular 
 * mallas 3D. Una malla está formada por vértices y caras definidos 
 * en un espacio tridimensional. 
 *
 * Funcionalidades Implementadas:
 * - cargar: Carga una malla desde un archivo.
 * - guardar: Guarda una malla en un archivo.
 * - listado: Muestra todas las mallas cargadas en el sistema.
 * - envolvente: Calcula la envolvente convexa de una malla específica.
 * - envolvente global: Calcula la envolvente convexa de todas las 
 *   mallas cargadas.
 * - v_cercano: Encuentra el vértice más cercano a un punto dado en 
 *   una malla específica o de forma global.
 * - descargar: Elimina una malla cargada del sistema.
 * - ruta_corta_centro: Calcula la ruta más corta desde un vértice 
 *   al centro geométrico de la malla.
 * - ruta_corta: Calcula la ruta más corta entre dos vértices 
 *   específicos en una malla.
 * - ayuda: Proporciona una descripción de cualquier comando disponible.
 *
 * Este programa corresponde a la tercera entrega del proyecto de 
 * estructura de datos.
 * <><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>
 */

#include <iostream>
#include <string>
#include <vector>
#include <sstream>
#include <fstream>
#include <limits>
#include <algorithm>
#include "kdtree.h"
#include "vertice.h"
#include <queue>
using namespace std;

struct Cara {
    vector<int> indicesVertices;
};

struct Malla {
    string nombre;
    vector<Vertice> vertices;
    vector<Cara> caras;
    kdtree<Vertice> arbolKD;
};

// Funciones auxiliares
string convertirMinusculas(string cadena) {
    for (char& c : cadena) c = tolower(c);
    return cadena;
}

vector<string> dividirComando(const string& linea) {
    vector<string> resultado;
    stringstream ss(linea);
    string palabra;
    while (ss >> palabra) resultado.push_back(palabra);
    return resultado;
}

// Función para cargar una malla desde un archivo
Malla cargarMalla(const string& archivo) {
    Malla malla;
    ifstream file(archivo);
    if (!file.is_open()) {
        cout << "El archivo " << archivo << " no existe o es ilegible.\n";
        return malla;
    }

    getline(file, malla.nombre);
    int numVertices;
    file >> numVertices;
    malla.vertices.resize(numVertices);

    for (int i = 0; i < numVertices; i++) {
        file >> malla.vertices[i].px >> malla.vertices[i].py >> malla.vertices[i].pz;
        malla.arbolKD.insertar(malla.vertices[i]);
    }

    while (true) {
        Cara cara;
        int numVerticesCara;
        file >> numVerticesCara;
        if (numVerticesCara == -1) break;
        cara.indicesVertices.resize(numVerticesCara);
        for (int j = 0; j < numVerticesCara; j++) {
            file >> cara.indicesVertices[j];
        }
        malla.caras.push_back(cara);
    }

    cout << "El objeto " << malla.nombre << " ha sido cargado exitosamente desde el archivo " << archivo << ".\n";
    return malla;
}

// Función para guardar una malla en un archivo
void guardarMalla(const Malla& malla, const string& archivo) {
    ofstream file(archivo);
    if (!file.is_open()) {
        cout << "Error: no se pudo abrir el archivo para escribir.\n";
        return;
    }

    file << malla.nombre << "\n";
    file << malla.vertices.size() << "\n";

    for (const auto& vertice : malla.vertices) {
        file << vertice.px << " " << vertice.py << " " << vertice.pz << "\n";
    }

    for (const auto& cara : malla.caras) {
        file << cara.indicesVertices.size();
        for (const auto& indice : cara.indicesVertices) {
            file << " " << indice;
        }
        file << "\n";
    }
    file << "-1\n";

    cout << "La informacion del objeto " << malla.nombre << " ha sido guardada exitosamente en el archivo " << archivo << ".\n";
}

// Función para listar mallas
void listarMallas(const vector<Malla>& mallas) {
    if (mallas.empty()) {
        cout << "Memoria vacia.\n";
        return;
    }
    cout << "Hay " << mallas.size() << " objetos en memoria:\n";
    for (const auto& malla : mallas) {
        cout << malla.nombre << " contiene " << malla.vertices.size() << " vertices, "
             << malla.caras.size() << " caras.\n";
    }
}

// Función para calcular la caja envolvente de una malla
Malla calcularCajaEnvolvente(const Malla& malla, const string& nombreCaja) {
    Malla caja;
    caja.nombre = nombreCaja;

    float xmin = numeric_limits<float>::max(), ymin = numeric_limits<float>::max(), zmin = numeric_limits<float>::max();
    float xmax = numeric_limits<float>::lowest(), ymax = numeric_limits<float>::lowest(), zmax = numeric_limits<float>::lowest();

    for (const auto& vertice : malla.vertices) {
        xmin = min(xmin, vertice.px);
        ymin = min(ymin, vertice.py);
        zmin = min(zmin, vertice.pz);
        xmax = max(xmax, vertice.px);
        ymax = max(ymax, vertice.py);
        zmax = max(zmax, vertice.pz);
    }

    caja.vertices = {
        {xmin, ymin, zmin}, {xmax, ymin, zmin}, {xmin, ymax, zmin}, {xmax, ymax, zmin},
        {xmin, ymin, zmax}, {xmax, ymin, zmax}, {xmin, ymax, zmax}, {xmax, ymax, zmax}
    };

    cout << "La caja envolvente del objeto " << malla.nombre << " se ha generado con el nombre " << caja.nombre << ".\n";
    return caja;
}

// Función para calcular la envolvente global (de todos los objetos cargados)
Malla calcularEnvolventeGlobal(const vector<Malla>& mallas, const string& nombreCaja) {
    Malla caja;
    caja.nombre = nombreCaja;

    float xmin = numeric_limits<float>::max(), ymin = numeric_limits<float>::max(), zmin = numeric_limits<float>::max();
    float xmax = numeric_limits<float>::lowest(), ymax = numeric_limits<float>::lowest(), zmax = numeric_limits<float>::lowest();

    for (const auto& malla : mallas) {
        for (const auto& vertice : malla.vertices) {
            xmin = min(xmin, vertice.px);
            ymin = min(ymin, vertice.py);
            zmin = min(zmin, vertice.pz);
            xmax = max(xmax, vertice.px);
            ymax = max(ymax, vertice.py);
            zmax = max(zmax, vertice.pz);
        }
    }

    caja.vertices = {
        {xmin, ymin, zmin}, {xmax, ymin, zmin}, {xmin, ymax, zmin}, {xmax, ymax, zmin},
        {xmin, ymin, zmax}, {xmax, ymin, zmax}, {xmin, ymax, zmax}, {xmax, ymax, zmax}
    };

    cout << "La caja envolvente global se ha generado con el nombre " << caja.nombre << ".\n";
    return caja;
}

// Función para encontrar el vértice más cercano en una malla
void encontrarVerticeCercano(const Malla& malla, const Vertice& punto) {
    double mejorDistancia = numeric_limits<double>::max();
    Vertice mejorVertice = malla.arbolKD.encontrarMasCercano(punto, mejorDistancia);

    cout << "El vertice mas cercano es " << mejorVertice 
         << " a una distancia de " << mejorDistancia << ".\n";
}

// Función para encontrar el vértice más cercano en la envolvente global
void encontrarVerticeCercanoGlobal(const vector<Malla>& mallas, const Vertice& punto) {
    double mejorDistancia = numeric_limits<double>::max();
    Vertice mejorVertice;
    for (const auto& malla : mallas) {
        Vertice verticeCercano = malla.arbolKD.encontrarMasCercano(punto, mejorDistancia);
        double distancia = verticeCercano.distancia(punto);
        if (distancia < mejorDistancia) {
            mejorDistancia = distancia;
            mejorVertice = verticeCercano;
        }
    }

    cout << "El vertice mas cercano global es " << mejorVertice
         << " a una distancia de " << mejorDistancia << ".\n";
}

// Función para calcular la distancia entre dos vértices
double calcularDistancia(const Vertice& v1, const Vertice& v2) {
    return sqrt(pow(v2.px - v1.px, 2) + pow(v2.py - v1.py, 2) + pow(v2.pz - v1.pz, 2));
}

// Función para calcular la ruta más corta entre dos vértices en la malla usando Dijkstra
void calcularRutaCorta(int i1, int i2, const Malla& malla) {
    int n = malla.vertices.size();
    vector<double> distancias(n, numeric_limits<double>::infinity());
    vector<int> padres(n, -1);
    priority_queue<pair<double, int>, vector<pair<double, int>>, greater<pair<double, int>>> pq;

    distancias[i1] = 0;
    pq.push({0, i1});

    while (!pq.empty()) {
        int u = pq.top().second;
        pq.pop();

        // Si hemos llegado al vértice de destino, terminamos
        if (u == i2) break;

        // Recorremos los vecinos (vértices conectados por caras)
        for (const auto& cara : malla.caras) {
            if (find(cara.indicesVertices.begin(), cara.indicesVertices.end(), u) != cara.indicesVertices.end()) {
                for (int v : cara.indicesVertices) {
                    if (v != u) {
                        double distancia = calcularDistancia(malla.vertices[u], malla.vertices[v]);
                        if (distancias[u] + distancia < distancias[v]) {
                            distancias[v] = distancias[u] + distancia;
                            padres[v] = u;
                            pq.push({distancias[v], v});
                        }
                    }
                }
            }
        }
    }

    // Mostrar el resultado de la ruta más corta
    if (distancias[i2] != numeric_limits<double>::infinity()) {
        cout << "La distancia mas corta entre los vertices " << i1 << " y " << i2 << " es " << distancias[i2] << ".\n";

        // Mostrar el camino
        vector<int> camino;
        for (int v = i2; v != -1; v = padres[v]) {
            camino.push_back(v);
        }
        reverse(camino.begin(), camino.end());
        cout << "El camino más corto es: ";
        for (int v : camino) {
            cout << v << " ";
        }
        cout << endl;
    } else {
        cout << "No se pudo encontrar un camino entre los vertices " << i1 << " y " << i2 << ".\n";
    }
}

// Función para calcular la ruta más corta entre un vértice y el centro de la malla
void calcularRutaCortaCentro(int i1, const Malla& malla) {
    int n = malla.vertices.size();
    if (n == 0) {
        cout << "La malla esta vacia.\n";
        return;
    }

    // Calcular el centro de la malla (promediando las coordenadas de los vértices)
    double cx = 0, cy = 0, cz = 0;
    for (const auto& v : malla.vertices) {
        cx += v.px;
        cy += v.py;
        cz += v.pz;
    }
    cx /= n;
    cy /= n;
    cz /= n;

    Vertice centro(cx, cy, cz);

    // Calcular la ruta más corta entre el vértice i1 y el centro
    int i2 = -1;
    double minDist = numeric_limits<double>::infinity();
    for (int i = 0; i < malla.vertices.size(); ++i) {
        double dist = calcularDistancia(malla.vertices[i], centro);
        if (dist < minDist) {
            minDist = dist;
            i2 = i;
        }
    }

    cout << "La ruta más corta desde el vértice " << i1 << " hasta el centro de la malla es a través del vértice " << i2
         << " con una distancia de " << minDist << ".\n";
}

void mostrarAyuda(const string& comando) {
    if (comando == "cargar") {
        cout << "Comando 'cargar':\n"
             << "Carga una malla desde un archivo especificado. El archivo debe contener los vertices y las caras de la malla.\n"
             << "Uso: cargar <nombre_archivo>\n";
    } else if (comando == "guardar") {
        cout << "Comando 'guardar':\n"
             << "Guarda una malla en un archivo especificado. El archivo contendra los vertices y las caras de la malla.\n"
             << "Uso: guardar <nombre_malla> <archivo>\n";
    } else if (comando == "listado") {
        cout << "Comando 'listado':\n"
             << "Muestra un listado de todas las mallas que se encuentran actualmente cargadas en memoria.\n"
             << "Uso: listado\n";
    } else if (comando == "envolvente") {
        cout << "Comando 'envolvente':\n"
             << "Calcula la caja envolvente de una malla específica o de todas las mallas cargadas (envolvente global).\n"
             << "Uso: envolvente <nombre_malla> (para una malla específica)\n"
             << "       envolvente (para la envolvente global)\n";
    } else if (comando == "v_cercano") {
        cout << "Comando 'v_cercano':\n"
             << "Encuentra el vértice más cercano a un punto especificado en una malla o globalmente.\n"
             << "Uso: v_cercano <px> <py> <pz> <nombre_malla> (para una malla específica)\n"
             << "       v_cercano <px> <py> <pz> global (para todos los objetos cargados)\n";
    } else if (comando == "descargar") {
        cout << "Comando 'descargar':\n"
             << "Elimina una malla cargada de la memoria.\n"
             << "Uso: descargar <nombre_malla>\n";
    } else if (comando == "ruta_corta_centro") {
        cout << "Comando 'ruta_corta_centro':\n"
             << "Calcula la ruta mas corta entre un vertice especificado y el centro de la malla.\n"
             << "Uso: ruta_corta_centro <i1> <nombre_objeto>\n";
    } else if (comando == "ruta_corta") {
        cout << "Comando 'ruta_corta':\n"
             << "Calcula la ruta más corta entre dos vetices especificados en una malla.\n"
             << "Uso: ruta_corta <i1> <i2> <nombre_objeto>\n";
    } else {
        cout << "Comando no reconocido. Usa 'ayuda' para ver la lista de comandos disponibles.\n";
    }
}
int main() {
    vector<Malla> mallas;
    string comando;

    cout << "==================================================================================================" << endl;
    cout << "   Bienvenido a la aplicacion de modelado 3D   " << endl;
    cout << "==================================================================================================" << endl;
    cout << "Comandos disponibles:" << endl;
    cout << "1. cargar <nombre_archivo>                   - Carga una malla desde un archivo." << endl;
    cout << "2. guardar <nombre_malla> <archivo>          - Guarda una malla en un archivo." << endl;
    cout << "3. listado                                   - Lista todas las mallas cargadas." << endl;
    cout << "4. envolvente <nombre_malla>                 - Calcula la caja envolvente de una malla." << endl;
    cout << "5. envolvente                                - Calcula la caja envolvente global de todos los objetos." << endl;
    cout << "6. v_cercano <px> <py> <pz> <nombre_malla>   - Encuentra el vertice mas cercano a un punto." << endl;
    cout << "7. v_cercano <px> <py> <pz>                  - Encuentra el vertice mas cercano globalmente." << endl;
    cout << "8. descargar <nombre_malla>                  - Elimina una malla cargada de la memoria." << endl;
    cout << "9. ruta_corta_centro i1 nombre_objeto        - Calcula la ruta corta desde el vertice i1 hasta el centro." << endl;
    cout << "10. ruta_corta i1 i2 nombre_objeto           - Calcula la ruta corta entre los vertices i1 e i2." << endl;
    cout << "11. ayuda <comando>                          - Muestra una explicacion breve de un comando." << endl;
    cout << "12. salir                                    - Salir de la aplicacion." << endl;
    cout << "==================================================================================================" << endl;

    while (true) {
        cout << "$ ";
        getline(cin, comando);
        vector<string> partes = dividirComando(comando);
        if (partes.empty()) continue;

        string accion = convertirMinusculas(partes[0]);

        if (accion == "cargar" && partes.size() == 2) {
            Malla nuevaMalla = cargarMalla(partes[1]);
            if (!nuevaMalla.nombre.empty()) {
                auto it = find_if(mallas.begin(), mallas.end(), [&](const Malla& m) { return m.nombre == nuevaMalla.nombre; });
                if (it != mallas.end()) {
                    cout << "El objeto " << nuevaMalla.nombre << " ya ha sido cargado en memoria.\n";
                } else {
                    mallas.push_back(nuevaMalla);
                }
            }
        } else if (accion == "guardar" && partes.size() == 3) {
            auto it = find_if(mallas.begin(), mallas.end(), [&](const Malla& m) { return m.nombre == partes[1]; });
            if (it != mallas.end()) {
                guardarMalla(*it, partes[2]);
            } else {
                cout << "El objeto " << partes[1] << " no ha sido cargado en memoria.\n";
            }
        } else if (accion == "listado") {
            listarMallas(mallas);
        } else if (accion == "envolvente" && partes.size() == 2) {
            auto it = find_if(mallas.begin(), mallas.end(), [&](const Malla& m) { return m.nombre == partes[1]; });
            if (it != mallas.end()) {
                Malla caja = calcularCajaEnvolvente(*it, "env_" + it->nombre);
                mallas.push_back(caja);
            } else {
                cout << "El objeto " << partes[1] << " no ha sido cargado en memoria.\n";
            }
        } else if (accion == "envolvente" && partes.size() == 1) {
            Malla cajaGlobal = calcularEnvolventeGlobal(mallas, "env_global");
            mallas.push_back(cajaGlobal);
        } else if (accion == "v_cercano" && partes.size() == 5) {
    float px = stof(partes[1]);
    float py = stof(partes[2]);
    float pz = stof(partes[3]);
    string nombreMalla = partes[4];

    if (nombreMalla == "global") {
        // Búsqueda global en todas las mallas cargadas
        Vertice punto(px, py, pz);
        encontrarVerticeCercanoGlobal(mallas, punto);
    } else {
        // Búsqueda específica en una malla
        auto it = find_if(mallas.begin(), mallas.end(), [&](const Malla& m) { return m.nombre == nombreMalla; });
        if (it != mallas.end()) {
            Vertice punto(px, py, pz);
            encontrarVerticeCercano(*it, punto);
        } else {
            cout << "El objeto " << partes[4] << " no ha sido cargado en memoria.\n";
        }
    }

        } else if (accion == "v_cercano" && partes.size() == 4) {
            float px = stof(partes[1]);
            float py = stof(partes[2]);
            float pz = stof(partes[3]);

            Vertice punto(px, py, pz);
            encontrarVerticeCercanoGlobal(mallas, punto);
        } else if (accion == "descargar" && partes.size() == 2) {
            auto it = find_if(mallas.begin(), mallas.end(), [&](const Malla& m) { return m.nombre == partes[1]; });
            if (it != mallas.end()) {
                mallas.erase(it);
                cout << "El objeto " << partes[1] << " ha sido eliminado de la memoria.\n";
            } else {
                cout << "El objeto " << partes[1] << " no ha sido encontrado en memoria.\n";
            }
        } else if (accion == "ruta_corta_centro" && partes.size() == 3) {
            int i1 = stoi(partes[1]);
            string nombreMalla = partes[2];
            auto it = find_if(mallas.begin(), mallas.end(), [&](const Malla& m) { return m.nombre == nombreMalla; });
            if (it != mallas.end()) {
                calcularRutaCortaCentro(i1, *it);
            } else {
                cout << "El objeto " << partes[2] << " no ha sido cargado en memoria.\n";
            }
        } else if (accion == "ruta_corta" && partes.size() == 4) {
            int i1 = stoi(partes[1]);
            int i2 = stoi(partes[2]);
            string nombreMalla = partes[3];
            auto it = find_if(mallas.begin(), mallas.end(), [&](const Malla& m) { return m.nombre == nombreMalla; });
            if (it != mallas.end()) {
                calcularRutaCorta(i1, i2, *it);
            } else {
                cout << "El objeto " << partes[3] << " no ha sido cargado en memoria.\n";
            }
        } else if (accion == "ayuda" && partes.size() == 2) {
            mostrarAyuda(partes[1]);
        } else if (accion == "salir") {
            break;
        } else {
            cout << "Comando no reconocido. Usa 'ayuda' para obtener información sobre los comandos disponibles.\n";
        }
    }

    return 0;
}