#include <iostream>
#include <fstream>
#include <cstring>

using namespace std;

char* eliminarEspacios(char* cadena) {
    int len = strlen(cadena);
    char* sinEspacios = new char[len];
    int j = 0;
    for(int i = 0; i < len; i++) {
        if(cadena[i] != ' ') {
            sinEspacios[j++] = cadena[i];
            //*sinEspacios=cadena[i];
            //sinEspacios++;
        }
    }
    sinEspacios[j] = '\0';
    return sinEspacios;
}

bool esPalindroma(char* cadena) {
    int len = strlen(cadena);
    for(int i = 0; i < len/2; i++) {
        if(cadena[i] != cadena[len-i-1]) {
            return false;
        }
    }
    return true;
}

int contarPalindromos(char* rutaArchivo) {
    ifstream archivo(rutaArchivo);
    if(!archivo.is_open()) {
        cerr << "Error al abrir el archivo." << endl;
        return -1;
    }
    int contador = 0;
    char linea[256];
    while(archivo.getline(linea, 256)) {
        char* sinEspacios = eliminarEspacios(linea);
        if(esPalindroma(sinEspacios)) {
            contador++;
        }
        delete[] sinEspacios;
	}
	return contador++;
}

int main(){
	
	char rutaArchivo[20];
	int contador=0;
	strcpy(rutaArchivo,"palabras.txt");
	contador=contarPalindromos(rutaArchivo);
	cout<< "Palindromos:"<<contador;
	
	
	
}