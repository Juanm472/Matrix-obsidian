#include <iostream>
using namespace std;

/*
Esta es otra forma de envia un parametro por referencia.
Notese que dentro de la funcion ya no debo usar la notacion de apuntador
*/
void farenheitACentrigrados(float f, float &c){
    c= (f-32)*5/9;	
	cout<<"\nValor de c en la funcion 2:"<< c<<endl;
	cout <<"Dir Mem 'c' en la funcion :"<<&c<<endl;
}

int main (){
	float fahrenheit;
	float centigrados=0;
	cout <<"Ingrese grados en fahrenheit: ";
	cin >> fahrenheit;	
	cout <<"Dir Mem 'centigrados' en el main :"<<&centigrados<<endl;
	farenheitACentrigrados(fahrenheit, centigrados);	
	cout <<"Resultado  respuesta en el main:: "<<centigrados;
}