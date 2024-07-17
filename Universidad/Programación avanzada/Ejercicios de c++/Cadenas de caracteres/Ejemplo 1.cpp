#include <iostream>
#include <string.h>
using namespace std;
int main (){
	char cad1[20]={'h','o','l','a',' ','m','u','n','d','o','\0'};
	char cad2[]={'h','o','l','a',' ','m','u','n','d','o','\0'};
	char cad3[]="hola mundo";
	char *auxiliar;
	char cad4[20]= "hola mundo cruel";
	char *ptrCad1="hola mundo";
	string strCad1="hola mundo";
	string strCad2="esta es una cadena muy larga declarada como variable string y no como arreglo de char";
	string strCad3;
	strCad3 = strCad1+" "+strCad2;
	
	cout<<"cad1 :"<<cad1<<endl;
	cout<<"cad2 :"<<cad2<<endl;
	cout<<"cad3 :"<<cad3<<endl;
	cout<<"cad4 :"<<cad4<<endl;
	cout<<"ptrCad1 :"<<ptrCad1<<endl;
	cout<<"strCad1 :"<<strCad1<<endl;
	cout<<"strCad2 :"<<strCad2<<endl;
	cout<<"strCad3 :"<<strCad3<<endl;
	system("pause");
	cout<<endl;

	cout<<"longitud cad1 :"<<sizeof(cad1)<<endl;
	cout<<"longitud cad2 :"<<sizeof(cad2)<<endl;
	cout<<"longitud cad3 :"<<sizeof(cad3)<<endl;
	cout<<"longitud cad4 :"<<sizeof(cad4)<<endl;
	cout<<"longitud ptrCad1 :"<<sizeof(ptrCad1)<<endl;
	system("pause");
	cout<<endl;

	
	/*Funciones para manejo de arreglos de caracteres*/
	cout <<"strcmp cad1 vs cad3: "<<strcmp(cad1,cad3)<<endl;
	cout <<"strcmp cad1 vs cad2:  "<<strcmp(cad1,cad2)<<endl;
	cout <<"strcmp cad1 vs cad4: "<<strcmp(cad1,cad4)<<endl;
	system("pause");
	cout<<endl;

	strcat(cad1," ");
	auxiliar=strcat(cad1,cad2);
	cout <<"strcat cad1:"<<cad1<<endl;
	cout <<"strcat auxiliar:"<<auxiliar<<endl;
	system("pause");
	auxiliar=strchr(cad1,'l');
	cout <<"strchr cad1: "<<cad1<<endl;
	cout <<"strchr auxiliar: "<<auxiliar<<endl;
	system("pause");
	cout<<endl;
	char cad5[200];
	strcpy(cad5, cad4);
	cout<<"cad5 :"<<cad5<<endl;
	auxiliar=strcpy(cad5, strchr(cad1,'a'));
	cout <<"strcpy cad5: "<<cad5<<endl;
	cout <<"strcpy auxiliar: "<<auxiliar<<endl;
	
	cout <<"strlen de Cad2:"<<strlen(cad2)<<endl;
	cout <<"longitud de cad5:"<<strlen (cad5)<<endl;
	cout <<"strlen de ptrCad1:"<<strlen (ptrCad1)<<endl;
	
	system("pause");
	cout<<endl;
	char cad7[]="ESTO ESTABA EN MAYUSCULAS";
	
	auxiliar=strlwr(cad7);
	cout <<"strlwr cad7: "<<cad7<<endl;
	cout <<"strlwr auxiliar: "<<auxiliar<<endl;
	char cad8[]="esto estaba en minusculas";
	auxiliar=strupr(cad8);
	cout <<"strupr cad8: "<<cad8<<endl;
	cout <<"strlwr auxiliar: "<<auxiliar<<endl;
	system("pause");
	cout<<endl;
	auxiliar=strrchr(cad7, 'a');
	cout <<"strrchr cad7:"<<cad7<<endl;
	cout <<"strrchr auxiliar:"<<auxiliar<<endl;
	
	auxiliar=strrev(cad7);
	cout <<"strrev cad7:"<<cad7<<endl;
	cout <<"strrev axuliar:"<<auxiliar<<endl;
	char cad10[]="como encontrar una cadena en otra";
	char cad11[]="una";
	
	auxiliar=strstr(cad10,cad11);
	cout <<"strstr cad10"<<cad10<<endl;
	cout <<"strstr auxiliar"<<auxiliar<<endl;
	
	
	
	
	
	
	
	
}