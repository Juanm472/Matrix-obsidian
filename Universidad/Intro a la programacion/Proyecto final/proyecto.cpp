#include <iostream>
#include <string>
#include <vector>
#include <windows.h>

using namespace std;

const int n = 6;
const int m = 8;

enum Jugador {
	JUGADOR_1,
	JUGADOR_2
};

enum Casilla {
	ESPACIO_VACIO,
	FICHA_JUGADOR_1,
	FICHA_JUGADOR_2
};

struct Posicion {
	int fila;
	int columna;
};

struct Juego {
	string jugador1;
	string jugador2;
	string ganador;
	int numJugadas;
	Casilla tablero[n][m];
};

bool hayEspaciosLibres(Casilla tablero[n][m])
{
	for(int i = 0; i < n; i++)
	{
		for(int j = 0; j < m; j++)
		{
			if(tablero[i][j] == ESPACIO_VACIO)
			{return true;
			}
		}
	}
	return false;
}

void inicializarTablero(Casilla tablero[n][m])
{
	for(int i = 0; i < n; i++)
	{
		for(int j = 0; j < m; j++)
		{
			tablero[i][j] = ESPACIO_VACIO;
		}
	}
}

void imprimirTablero(Casilla tablero[n][m])
{
	// Imprimir números de columna
	for(int j = 0; j < m; j++)
	{
		cout << j << " ";
	}
	cout << endl;
	
	for(int i = 0; i < n; i++)
	{
		for(int j = 0; j < m; j++)
		{
			if(tablero[i][j] == ESPACIO_VACIO)
			{
				cout << "_ ";
			}
			else if(tablero[i][j] == FICHA_JUGADOR_1)
			{
				cout << "X ";
			}
			else if(tablero[i][j] == FICHA_JUGADOR_2)
			{
				cout << "O ";
			}
		}
		cout << endl;
	}
	cout << endl;
}

bool columnaLlena(Casilla tablero[n][m], int columna)
{
	for(int i = 0; i < n; i++)
	{
		if(tablero[i][columna] == ESPACIO_VACIO)
		{
			return false;
		}
	}
	return true;
}

bool validarJugada(Casilla tablero[n][m], int columna)
{
	if(columna < 0 || columna >= m)
	{
		return false;
	}
	if(columnaLlena(tablero, columna))
	{
		return false;
	}
	return true;
}

void realizarJugada(Casilla tablero[n][m], Jugador jugador, int columna)
{
	Casilla ficha = (jugador == JUGADOR_1) ? FICHA_JUGADOR_1 : FICHA_JUGADOR_2;
	for(int i = n - 1; i >= 0; i--)
	{
		if(tablero[i][columna] == ESPACIO_VACIO)
		{
			tablero[i][columna] = ficha;
			break;
		}
	}
}

bool verificarGanador(Casilla tablero[n][m], Jugador jugador)
{
	Casilla ficha = (jugador == JUGADOR_1) ? FICHA_JUGADOR_1 : FICHA_JUGADOR_2;
	// Verificar en horizontal
	for(int i = 0; i < n; i++)
	{
		for(int j = 0; j < m - 3; j++)
		{
			if(tablero[i][j] == ficha && tablero[i][j+1] == ficha && tablero[i][j+2] == ficha && tablero[i][j+3] == ficha)
			{
				return true;
			}
		}
	}
	// Verificar en vertical
	for(int i = 0; i < n - 3; i++)
	{
		for(int j = 0; j < m; j++)
		{
			if(tablero[i][j] == ficha && tablero[i+1][j] == ficha && tablero[i+2][j] == ficha && tablero[i+3][j] == ficha)
			{
				return true;
			}
		}
	}
	// Verificar en diagonal hacia la derecha
	for(int i = 0; i < n - 3; i++)
	{
		for(int j = 0; j < m - 3; j++)
		{
			if(tablero[i][j] == ficha && tablero[i+1][j+1] == ficha && tablero[i+2][j+2] == ficha && tablero[i+3][j+3] == ficha)
			{
				return true;
			}
		}
	}
	// Verificar en diagonal hacia la izquierda
	for(int i = 0; i< n - 3; i++)
	{
		for(int j = 3; j < m; j++)
		{
			if(tablero[i][j] == ficha && tablero[i+1][j-1] == ficha && tablero[i+2][j-2] == ficha && tablero[i+3][j-3] == ficha)
			{
				return true;
			}
		}
	}
	return false;
}

Jugador alternarJugador(Jugador jugadorActual)
{
	return (jugadorActual == JUGADOR_1) ? JUGADOR_2 : JUGADOR_1;
}

void jugar()
{
	Juego juego;
	juego.numJugadas = 0;
	inicializarTablero(juego.tablero);
	
	cout << "Ingrese el nombre del jugador 1: ";
	getline(cin, juego.jugador1);
	
	cout << "Ingrese el nombre del jugador 2: ";
	getline(cin, juego.jugador2);
	
	Jugador jugadorActual = JUGADOR_1;
	
	while(hayEspaciosLibres(juego.tablero))
	{
		imprimirTablero(juego.tablero);
		
		int columna;
		do {
			cout << "Jugador " << ((jugadorActual == JUGADOR_1) ? juego.jugador1 : juego.jugador2) << ", ingrese la columna donde desea jugar (0-" << m-1 << "): ";
			cin >> columna;
		} while(!validarJugada(juego.tablero, columna));
		
		realizarJugada(juego.tablero, jugadorActual, columna);
		juego.numJugadas++;
		
		if(verificarGanador(juego.tablero, jugadorActual))
		{
			juego.ganador = (jugadorActual == JUGADOR_1) ? juego.jugador1 : juego.jugador2;
			imprimirTablero(juego.tablero);
			cout << "El ganador es: " << juego.ganador << endl;
			return;
		}
		
		jugadorActual = alternarJugador(jugadorActual);
	}
	
	imprimirTablero(juego.tablero);
	cout << "El juego terminó en empate." << endl;
}

int main()
{
	jugar();
	return 0;
}