#include <iostream>
#include <fstream>
#include <string>
using namespace std;

// Definimos la estructura Cliente
struct Cliente {
    string nombre;
    int cedula;
    int cantidad;
    double precio;
    string nombreProducto;
};

// Función para crear un nuevo cliente
Cliente* crearCliente(string nombre, int cedula, int cantidad, double precio, string nombreProducto) {
    Cliente* nuevoCliente = new Cliente;
    nuevoCliente->nombre = nombre;
    nuevoCliente->cedula = cedula;
    nuevoCliente->cantidad = cantidad;
    nuevoCliente->precio = precio;
    nuevoCliente->nombreProducto = nombreProducto;
    
    return nuevoCliente;
}

// Función para imprimir la factura en un fichero de texto
void imprimirFactura(Cliente* cliente, string nombreArchivo) {
    ofstream fichero(nombreArchivo);
    
    if (!fichero.is_open()) {
        cerr << "Error al abrir el fichero." << endl;
        return;
    }
    
    fichero << "Factura" << endl;
    fichero << "========" << endl;
    fichero << "Nombre del Cliente: " << cliente->nombre << endl;
    fichero << "Cédula: " << cliente->cedula << endl;
    fichero << "Nombre del Producto: " << cliente->nombreProducto << endl;
    fichero << "Cantidad: " << cliente->cantidad << endl;
    fichero << "Precio Unitario: $" << cliente->precio << endl;
    fichero << "Total: $" << cliente->cantidad * cliente->precio << endl;
    
    fichero.close();
    cout << "Factura impresa en el archivo " << nombreArchivo << "." << endl;
}

// Función para liberar la memoria del cliente
void liberarCliente(Cliente* cliente) {
    delete cliente;
}

int main() {
    // Captura de datos del cliente
    string nombre, nombreProducto;
    int cedula, cantidad;
    double precio;
    
    cout << "Ingrese el nombre del cliente: ";
    getline(cin, nombre);

    cout << "Ingrese la cédula del cliente: ";
    cin >> cedula;

    cout << "Ingrese el nombre del producto: ";
    cin.ignore(); // Ignorar el salto de línea residual del cin anterior
    getline(cin, nombreProducto);

    cout << "Ingrese la cantidad del producto: ";
    cin >> cantidad;

    cout << "Ingrese el precio unitario del producto: ";
    cin >> precio;
    
    // Crear un cliente usando los datos capturados
    Cliente* cliente = crearCliente(nombre, cedula, cantidad, precio, nombreProducto);
    
    // Imprimir la factura en un fichero de texto
    imprimirFactura(cliente, "factura.txt");
    
    // Liberar la memoria asignada al cliente
    liberarCliente(cliente);
    
    return 0;
}
