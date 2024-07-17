#include <iostream>
using namespace std;

void recorrer(char *cad){   //hola
//void recorrer(char cad[]){	
	int i=0;
	while ( *cad!='\0' /* i<50*/){
		cout<< "Caracter "<<i<<": "<< *cad<<endl;
		i++;
		cad++;
	}
}

int main(){
	char cadena[50];
	cout <<"Ingrese una cadena de caracteres:";
	cin.getline(cadena,50);
	recorrer(cadena);
	return 0;
}