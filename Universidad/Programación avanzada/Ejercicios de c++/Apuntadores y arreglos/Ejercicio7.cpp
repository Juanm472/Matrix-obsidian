 #include <iostream>
 #include <stdio.h>      
 #include <stdlib.h>
 using namespace std;
 

 int main(){
 	
 	int a[3][4]={{10,20,30,40},{50,60,70,80},{90,100,110,120}};
 	int *p[3] ;
 	
 	cout <<"valor de a:"<<a<<endl;
 	cout <<"valor de a[0]:"<<a[0]<<endl;
 	cout <<"valor de a[1][0]:"<<a[1][0]<<endl;
	cout <<"valor de a[1]:"<<a[1]<<endl<<endl;
   system("pause");
 	for (int i =0; i<3; i++  ){
 		//p[i]=a[i]; Linea 17 y 18 funcionan igual
 		cout<<"*(a+i):"<<*(a+i)<<" (a+i):"<<(a+i)<<endl;
 		p[i]=*(a+i);//La sintaxis logica p[i]=(a+i), no funciona (a pesar de que visualmente muestran la misma 
 		  //direccion de memoria porque p[i] es un apuntador a entero y (a+i) es un apuntador a una arreglo de enteros
 		
 		//Aqui el valor que se suma a la direccion de m es la longitud de cada fila * la posicion
 		//Ejemplo para i=2
 		//Longitud de una fila = 4 posiciones de 4bytes = 16bytes, posicion 2
		//resultado=16*2=, 32 bytes = 20, es decir a la direccion de M,se suman 20 en hexadecimal
 		cout<<" Fila "<< i<< " ["<<i<<"][0]:" << p[i]<<"    ["<<i<<"][1]:"<<(p[i]+1)<<"    ["<<i<<"][2]:"<<(p[i]+2)<<"    ["<<i<<"][3]:"<<(p[i]+3)<< endl;
 		cout<<" Fila "<< i<< " ["<<i<<"][0]:" << a[i][0]<<"           ["<<i<<"][1]:"<<*(p[i]+1)<<"           ["<<i<<"][2]:"<<*(a[i]+2)<<"           ["<<i<<"][3]:"<<*((p[i])+3)<< endl<<endl;
	}
	system("pause");
	//asi mostramos el valor de la primera columna

	cout<< "\nValores almacenados en el vector p:"<<endl;
	for (int j=0;j<3;j++){
 			cout<< "Direccion de p["<<j<<"]:"<<(p+j)<< " apuntando a "<<     p[j]<<" => "<<*p[j]<<endl;
	}
 	system("pause");
 	cout<< endl;

 	cout<< "Matriz completa usando a 'p' "<<"Direccion de *p "<<*p<<endl;
 	for (int i=0;i<3;i++){
	 
 		for (int j=0;j<4;j++){
 			//cout<< p[i][j]<<",";
 			cout<< *(*(p+i)+j)<<",";
 			
		 }
		 cout<<endl;
 	}
 	system("pause");
	cout<< "Matriz completa usando a 'a' "<<endl;
 	for (int i=0;i<3;i++){
	 
 		for (int j=0;j<4;j++){
 			cout<<"data["<<i<<"]["<<j<<"]:"<<(*(a+i)+j)<<"="<< *(*(a+i)+j)<<",";
 			
		 }
		 cout<<endl;
 	}

 	
			  	
}
