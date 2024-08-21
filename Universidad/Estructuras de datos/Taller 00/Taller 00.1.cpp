/*
 * <><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>
 *  Taller 00 Ejercicio 1 
 *  Autor Juan Manuel Lopez
 *  Fecha: Agosto 2024
 *
 * <><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>
 */
 
#include <iostream>
#include <cstdlib> // Para rand() 
#include <ctime>   // Para time()

using namespace std;

// Función para generar números aleatorios entre 0 y 25
int generarNumeroAleatorio() {
    return rand() % 26; 
}

int main() {
  
    int array[10];

    // Inicializa la semilla 
    srand(time(0));

    // Llena el array con 10 números aleatorios
    for(int i = 0; i < 10; i++) {
        array[i] = generarNumeroAleatorio();
    }
	
    int *puntero = array;

    // Imprimir el contenido del array 
    cout << "Contenido del array:"<<  endl;
    for(int i = 0; i < 10; i++) {
        cout << *(puntero + i) << " "<< endl;
    }

    cout << endl;

    // Imprimir las direcciones del contenido del array usando el puntero
    cout << "Direcciones del contenido del array:"<<  endl;
    for(int i = 0; i < 10; i++) {
        cout << (puntero + i) << " "<<endl;
    }
    cout << endl;

    return 0;
}