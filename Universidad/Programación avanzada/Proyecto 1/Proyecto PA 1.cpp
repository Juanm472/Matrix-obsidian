/*  Proyecto #1
 	Integrantes: Juan Manuel Lopez y Sofia Mantilla 
 	Correos: lopezv-j@javeriana.edu.co y sofiamantilla@javeriana.edu.co
	fecha de entrega: 10/09/23


*/





#include <iostream>
#include <windows.h>
#include <conio.h>
#include <fstream>
#include <string>
#include <ctime>
#include <vector>
#include <algorithm>

using namespace std;

const int Ancho = 70;
const int Largo = 15;
const int PosicionX = 2;
const int VelocidadObstaculos = 100; 
const char CaracterObstaculo = '#';

struct Obstaculo {
    int x;
    int y;
};

struct PuntajeInfo {
    string nombre;
    int puntaje;
};

void ocultarCursor() {
    HANDLE consoleHandle = GetStdHandle(STD_OUTPUT_HANDLE);
    CONSOLE_CURSOR_INFO cursorInfo;
    GetConsoleCursorInfo(consoleHandle, &cursorInfo);
    cursorInfo.bVisible = false;
    SetConsoleCursorInfo(consoleHandle, &cursorInfo);
}

void gotoxy(int x, int y) {
    HANDLE hcon;
    hcon = GetStdHandle(STD_OUTPUT_HANDLE);
    COORD dwPos;
    dwPos.X = x;
    dwPos.Y = y;
    SetConsoleCursorPosition(hcon, dwPos);
}

void tablero(int ancho, int largo) {
    char matriz[largo][ancho];
    for (int i = 0; i < largo; i++) {
        for (int j = 0; j < ancho; j++) {
            if (i == 0 || i == largo - 1)
                matriz[i][j] = char(205);
            else if (j == 0 || j == ancho - 1)
                matriz[i][j] = char(186);
            else
                matriz[i][j] = ' ';
        }
    }

    for (int i = 0; i < largo; i++) {
        for (int j = 0; j < ancho; j++) {
            cout << matriz[i][j];
        }
        cout << endl;
    }
}

void puntaje(int s) {
    gotoxy(PosicionX + Ancho + 5, 0);
    cout << "Puntaje:  " << s;
}

void guardarPuntaje(const string& nombre, int puntaje) {
    vector<PuntajeInfo> puntajes;
    ifstream archivoEntrada("puntajes.bin", ios::binary);

    // Leer los puntajes existentes del archivo
    if (archivoEntrada.is_open()) {
        PuntajeInfo puntajeLeido;
        while (archivoEntrada.read(reinterpret_cast<char*>(&puntajeLeido.puntaje), sizeof(puntajeLeido.puntaje))) {
            int nombreLength;
            archivoEntrada.read(reinterpret_cast<char*>(&nombreLength), sizeof(nombreLength));
            char* buffer = new char[nombreLength + 1];
            archivoEntrada.read(buffer, nombreLength);
            buffer[nombreLength] = '\0';
            puntajeLeido.nombre = buffer;
            delete[] buffer;
            puntajes.push_back(puntajeLeido);
        }
        archivoEntrada.close();
    }

    // Agregar el nuevo puntaje a la lista
    PuntajeInfo nuevoPuntaje;
    nuevoPuntaje.nombre = nombre;
    nuevoPuntaje.puntaje = puntaje;
    puntajes.push_back(nuevoPuntaje);

    // Ordenar la lista de puntajes en orden descendente
    sort(puntajes.begin(), puntajes.end(), [](const PuntajeInfo& a, const PuntajeInfo& b) {
        return a.puntaje > b.puntaje;
    });

    // Limitar la lista a los 10 mejores puntajes
    if (puntajes.size() > 10) {
        puntajes.resize(10);
    }

    // Escribir la lista de puntajes ordenada en el archivo
    ofstream archivoSalida("puntajes.bin", ios::binary | ios::trunc);
    if (archivoSalida.is_open()) {
        for (const PuntajeInfo& p : puntajes) {
            archivoSalida.write(reinterpret_cast<const char*>(&p.puntaje), sizeof(p.puntaje));
            int nombreLength = p.nombre.length();
            archivoSalida.write(reinterpret_cast<const char*>(&nombreLength), sizeof(nombreLength));
            archivoSalida.write(p.nombre.c_str(), nombreLength);
        }
        archivoSalida.close();
    } else {
        cout << "Error al abrir el archivo de puntajes." << endl;
    }
}

void mostrarPuntajes() {
    ifstream archivo("puntajes.bin", ios::binary);
    if (archivo.is_open()) {
        vector<PuntajeInfo> puntajes;
        PuntajeInfo puntaje;
        while (archivo.read(reinterpret_cast<char*>(&puntaje.puntaje), sizeof(puntaje.puntaje))) {
            int nombreLength;
            archivo.read(reinterpret_cast<char*>(&nombreLength), sizeof(nombreLength));
            char* buffer = new char[nombreLength + 1];
            archivo.read(buffer, nombreLength);
            buffer[nombreLength] = '\0';
            puntaje.nombre = buffer;
            delete[] buffer;
            puntajes.push_back(puntaje);
        }
        archivo.close();

        cout << "Los 10 mejores puntajes:\n";
        int n = min(static_cast<int>(puntajes.size()), 10);
        for (int i = 0; i < n; i++) {
            cout << puntajes[i].nombre << ": " << puntajes[i].puntaje << endl;
        }
    } else {
        cout << "No hay puntajes registrados." << endl;
    }
}

void borrarX(int x, int y) {
    gotoxy(x, y);
    cout << " ";
}

void crearObstaculo(Obstaculo& obstaculo) {
    obstaculo.x = Ancho - 2;
    obstaculo.y = rand() % (Largo - 2) + 1;
}

void moverObstaculo(Obstaculo& obstaculo) {
    borrarX(obstaculo.x, obstaculo.y);
    obstaculo.x--;
    if (obstaculo.x < PosicionX + 1) {
        crearObstaculo(obstaculo);
    }
    gotoxy(obstaculo.x, obstaculo.y);
    cout << CaracterObstaculo;
}

bool hayColision(Obstaculo obstaculo, int personajeY) {
    return (obstaculo.x == PosicionX + 4 && obstaculo.y == personajeY);
}

int main() {
    srand(static_cast<unsigned>(time(0)));
    string nombre;
    int opcion;
    int personajeY = Largo / 2;
    int s = 0;
    bool salir = false;
    Obstaculo obstaculo;

    cout << "Seleccione una opcion" << endl;
    cout << "1. Nuevo juego" << endl;
    cout << "2. Mostrar puntajes" << endl;
    cout << "3. Salir" << endl;

    while (!salir) {
        opcion = _getch() - '0';

        switch (opcion) {
        case 1:
            cout << "Cual es tu nombre?" << endl;
            cin >> nombre;
            system("cls");
            ocultarCursor();
            tablero(Ancho, Largo);
            puntaje(s);

            gotoxy(PosicionX + 4, personajeY);
            cout << char(220);

            while (true) {
                if (_kbhit()) {
                    char tecla = _getch();
                    if (tecla == 'w' && personajeY > 1) {
                        borrarX(PosicionX + 4, personajeY);
                        personajeY--;
                        s++;
                    } else if (tecla == 's' && personajeY < Largo - 2) {
                        borrarX(PosicionX + 4, personajeY);
                        personajeY++;
                        s++;
                    } else if (tecla == 27) {
                        system("cls");
                        cout << "Juego interrumpido, sus datos se guardaron";
                        guardarPuntaje(nombre, s);
                        salir = true;
                        break;
                    }
                    gotoxy(PosicionX + 4, personajeY);
                    cout << char(220);
                    puntaje(s);
                }

                moverObstaculo(obstaculo);

                if (hayColision(obstaculo, personajeY)) {
                    system("cls");
                    cout << "Juego terminado, obtuviste " << s << " puntos." << endl;
                    guardarPuntaje(nombre, s);
                    salir = true;
                    break;
                }

                Sleep(VelocidadObstaculos);
            }
            break;

        case 2:
            mostrarPuntajes();
            break;

        case 3:
            return 0;
            break;

        default:
            cout << "Opcion invalida" << endl;
        }
    }

    return 0;
}

