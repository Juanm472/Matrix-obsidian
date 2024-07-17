#include <iostream>

using namespace std;

char* eliminarEspacios(char* cadena) {
    int len = strlen(cadena);
    char* sinEspacios = new char[len];
    int j = 0;
    for(int i = 0; i < len; i++) {
        if(cadena[i] != ' ') {
            sinEspacios[j++] = cadena[i];
        }
    }
    sinEspacios[j] = '\0';
    return sinEspacios;
}

int main() {
    char cadena[] = "Hola Mundo";
    char* sinEspacios = eliminarEspacios(cadena);
    cout << "Cadena sin espacios: " << sinEspacios << endl;
    delete[] sinEspacios;
    return 0;
}