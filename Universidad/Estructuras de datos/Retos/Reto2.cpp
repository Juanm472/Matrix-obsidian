/*
 * <><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>
 * 
 *  Proyecto Reto 2 Operaciones recursividad 
 *  Autor Juan Manuel Lopez
 *  Fecha Julio 2024
 *
 *  Descripción:
 *  Distintas operaciones para el entendimiento y 
 *  practica de recursion 
 
 * <><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>
 */

#include <iostream>
#include <string>
#include <cmath>

using namespace std;

int sumaRecursiva(int n) { // calcula la suma factorial de n
	if (n <= 1) {
		return n;
	} else {
		return n + sumaRecursiva(n - 1);
	}
}

int cuadradosPares(int n) { // calcula la suma de los cuadrados de todos los números pares desde n hasta 0
	if (n == 0) {
		return n;
	} else if (n % 2 == 0) {
		return n * n + cuadradosPares(n - 1);
	} else {
		return cuadradosPares(n - 1);
	}
}

int cuadradosPares2(int n) { //
	if (n == 0) {
		return n;
	} else {
		return pow(n + n, 2) + cuadradosPares2(n - 1);
	}
}

int fibNumero(int n) {
	if (n <= 1) {
		return n;
	} else {
		return fibNumero(n - 1) + fibNumero(n - 2);
	}
}

bool lineal(string s, char c, int l) {
	if (l < 0) {
		return false;
	} else if (s[l] == c) {
		return true;
	} else {
		return lineal(s, c, l - 1);
	}
}

int main() {
	cout << "Ingrese que operacion desea realizar:" << endl;
	cout << "1. Suma factorial" << endl;
	cout << "2. Suma de cuadrados de números pares" << endl;
	cout << "3. Suma de cuadrados de números pares (alternativa)" << endl;
	cout << "4. N-ésimo número de Fibonacci" << endl;
	cout << "5. Buscar caracter en una cadena" << endl;

	int option;
	cin >> option;

	switch (option) { // Selección de operación
		case 1:
			cout << "Ingrese el número al que le desea hacer una suma factorial: " << endl;
			int numcase1;
			cin >> numcase1;
			cout << "Suma: " << sumaRecursiva(numcase1) << endl;
			break;
		case 2:
			cout << "Ingrese el número para calcular la suma de los cuadrados de todos los números pares desde n hasta 0:" << endl;
			int numcase2;
			cin >> numcase2;
			cout << "Resultado: " << cuadradosPares(numcase2) << endl;
			break;
		case 3:
			cout << "Ingrese el número para calcular la suma de los cuadrados de todos los números pares (opcion 2):" << endl;
			int numcase3;
			cin >> numcase3;
			cout << "Resultado: " << cuadradosPares2(numcase3) << endl;
			break;
		case 4:
			cout << "Ingrese el número para calcular el N-ésimo número de Fibonacci:" << endl;
			int numcase4;
			cin >> numcase4;
			cout << "Resultado: " << fibNumero(numcase4) << endl;
			break;
		case 5:
			cout << "Ingrese la cadena en la que desea buscar:" << endl;
			string palabra;
			cin >> palabra;
			cout << "Ingrese el caracter que desea buscar:" << endl;
			char caracter;
			cin >> caracter;
			cout << "Resultado: " << (lineal(palabra, caracter, palabra.length() - 1) ? "Encontrado" : "No encontrado") << endl;
			break;
		default:
			cout << "Opción no válida" << endl;
	}

	return 0;
} 
