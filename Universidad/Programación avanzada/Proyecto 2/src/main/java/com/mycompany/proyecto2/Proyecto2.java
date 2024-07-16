
package com.mycompany.proyecto2;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Proyecto2 {
static List<Aeronave> aeronaves = new ArrayList<>();
    static List<Viaje> viajes = new ArrayList<>();
    static List<Tiquete> tiquetes = new ArrayList<>();
    static Random random = new Random();

    public static void main(String[] args) {
        cargarDatosDesdeArchivos();

        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("Menú:");
            System.out.println("1. Registrar Aeronave");
            System.out.println("2. Registrar Programación de Viajes");
            System.out.println("3. Registrar Tiquete");
            System.out.println("4. Mostrar Programación");
            System.out.println("0. Salir");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea después de nextInt

            switch (opcion) {
                case 1:
                    registrarAeronave(scanner);
                    break;
                case 2:
                    registrarProgramacion(scanner);
                    break;
                case 3:
                    registrarTiquete(scanner);
                    break;
                case 4:
                    mostrarProgramacion(scanner);
                    break;
                case 0:
                    guardarDatosEnArchivos();
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        } while (opcion != 0);
    }

    private static void registrarAeronave(Scanner scanner) {
        System.out.print("Ingrese el código de la aeronave: ");
        String codigo = scanner.next();
        scanner.nextLine(); // Consumir la nueva línea después de next

        // Verificar si ya existe la aeronave con el mismo código
        if (existeAeronave(codigo)) {
            System.out.println("Ya existe una aeronave con el mismo código.");
            return;
        }

        System.out.print("Ingrese la marca de la aeronave: ");
        String marca = scanner.nextLine();

        System.out.print("Ingrese el fabricante de la aeronave: ");
        String fabricante = scanner.nextLine();

        Aeronave nuevaAeronave = new Aeronave(codigo, marca, fabricante);
        aeronaves.add(nuevaAeronave);

        System.out.println("Aeronave registrada correctamente.");
    }

    private static boolean existeAeronave(String codigo) {
        for (Aeronave a : aeronaves) {
            if (a.codigo.equals(codigo)) {
                return true;
            }
        }
        return false;
    }

    private static void registrarProgramacion(Scanner scanner) {
        System.out.print("Ingrese el código de la aeronave: ");
        String aeronaveCodigo = scanner.next();
        scanner.nextLine(); // Consumir la nueva línea después de next

        if (!existeAeronave(aeronaveCodigo)) {
            System.out.println("No existe una aeronave con ese código.");
            return;
        }

        System.out.print("Ingrese la fecha del viaje: ");
        String fecha = scanner.nextLine();

        System.out.print("Ingrese el origen del viaje: ");
        String origen = scanner.nextLine();

        System.out.print("Ingrese el destino del viaje: ");
        String destino = scanner.nextLine();

        System.out.print("Ingrese el valor del viaje: ");
        double valor = scanner.nextDouble();
        scanner.nextLine(); // Consumir la nueva línea después de nextDouble

        System.out.print("Ingrese reglas particulares del viaje: ");
        String reglas = scanner.nextLine();

        int codigoViaje = viajes.size() + 1;
        Viaje nuevoViaje = new Viaje(codigoViaje, aeronaveCodigo, fecha, origen, destino, valor, reglas);
        viajes.add(nuevoViaje);

        System.out.println("Viaje registrado correctamente. Código del viaje: " + codigoViaje);
    }

    private static void registrarTiquete(Scanner scanner) {
        System.out.print("Ingrese el código del viaje para el tiquete: ");
        int codigoViaje = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea después de nextInt

        Viaje viajeSeleccionado = obtenerViajePorCodigo(codigoViaje);
        if (viajeSeleccionado == null) {
            System.out.println("No existe un viaje con ese código.");
            return;
        }

        mostrarDetallesViaje(viajeSeleccionado);

        System.out.print("¿Es este el viaje que desea comprar? (S/N): ");
        String respuesta = scanner.nextLine();

        if (respuesta.equalsIgnoreCase("S")) {
            System.out.print("Ingrese el número de viajeros: ");
            int numeroViajeros = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea después de nextInt

            for (int i = 0; i < numeroViajeros; i++) {
                System.out.println("Datos del Viajero #" + (i + 1));
                System.out.print("Nombre: ");
                String nombre = scanner.nextLine();

                System.out.print("Apellido: ");
                String apellido = scanner.nextLine();

                System.out.print("Número de identificación: ");
                String identificacion = scanner.nextLine();

                int numeroTiquete = generarNumeroTiquete();
                Tiquete nuevoTiquete = new Tiquete(codigoViaje, nombre, apellido, identificacion, numeroTiquete);
                tiquetes.add(nuevoTiquete);
            }

            System.out.println("Registro de tiquetes completado.");
        } else {
            System.out.println("Operación cancelada. No se ha realizado la compra.");
        }
    }

    private static void mostrarProgramacion(Scanner scanner) {
        System.out.print("Ingrese el código del viaje que desea consultar (0 para salir): ");
        int codigoViaje = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea después de nextInt

        if (codigoViaje == 0) {
            return;
        }

        Viaje viajeConsultado = obtenerViajePorCodigo(codigoViaje);
        if (viajeConsultado == null) {
            System.out.println("No existe un viaje con ese código.");
        } else {
            mostrarDetallesViaje(viajeConsultado);
        }
    }

    private static Viaje obtenerViajePorCodigo(int codigoViaje) {
        for (Viaje v : viajes) {
            if (v.codigo == codigoViaje) {
                return v;
            }
        }
        return null;
    }

    private static void mostrarDetallesViaje(Viaje viaje) {
        System.out.println("Detalles del Viaje:");
        System.out.println("Código del Viaje: " + viaje.codigo);
        System.out.println("Código de la Aeronave: " + viaje.aeronaveCodigo);
        System.out.println("Fecha: " + viaje.fecha);
        System.out.println("Origen: " + viaje.origen);
        System.out.println("Destino: " + viaje.destino);
        System.out.println("Valor Total: " + viaje.valor);

        System.out.println("Listado de Viajeros:");
        for (Tiquete t : tiquetes) {
            if (t.codigoViaje == viaje.codigo) {
                System.out.println("Nombre: " + t.nombre + " " + t.apellido);
                System.out.println("Número de Tiquete: " + t.numeroTiquete);
            }
        }
    }

    private static int generarNumeroTiquete() {
        return 1000 + random.nextInt(9000);
    }

    private static void cargarDatosDesdeArchivos() {
        cargarDatosAeronavesDesdeArchivo();
        cargarDatosViajesDesdeArchivo();
        cargarDatosTiquetesDesdeArchivo();
    }

    private static void cargarDatosAeronavesDesdeArchivo() {
        try (BufferedReader readerAeronaves = new BufferedReader(new FileReader("aeronaves.txt"))) {
            String line;
            while ((line = readerAeronaves.readLine()) != null) {
                String[] parts = line.split(",");
                Aeronave aeronave = new Aeronave(parts[0], parts[1], parts[2]);
                aeronaves.add(aeronave);
            }
        } catch (IOException e) {
            System.out.println("No se pudo cargar la información de aeronaves desde el archivo.");
        }
    }

    private static void cargarDatosViajesDesdeArchivo() {
        try (BufferedReader readerViajes = new BufferedReader(new FileReader("viajes.txt"))) {
            String line;
            while ((line = readerViajes.readLine()) != null) {
                String[] parts = line.split(",");
                int codigo = Integer.parseInt(parts[0]);
                double valor = Double.parseDouble(parts[5]);
                Viaje viaje = new Viaje(codigo, parts[1], parts[2], parts[3], parts[4], valor, parts[6]);
                viajes.add(viaje);
            }
        } catch (IOException e) {
            System.out.println("No se pudo cargar la información de viajes desde el archivo.");
        }
    }

    private static void cargarDatosTiquetesDesdeArchivo() {
        try (BufferedReader readerTiquetes = new BufferedReader(new FileReader("tiquetes.txt"))) {
            String line;
            while ((line = readerTiquetes.readLine()) != null) {
                String[] parts = line.split(",");
                int codigoViaje = Integer.parseInt(parts[0]);
                int numeroTiquete = Integer.parseInt(parts[4]);
                Tiquete tiquete = new Tiquete(codigoViaje, parts[1], parts[2], parts[3], numeroTiquete);
                tiquetes.add(tiquete);
            }
        } catch (IOException e) {
            System.out.println("No se pudo cargar la información de tiquetes desde el archivo.");
        }
    }

    private static void guardarDatosEnArchivos() {
        guardarDatosAeronavesEnArchivo();
        guardarDatosViajesEnArchivo();
        guardarDatosTiquetesEnArchivo();
    }

    private static void guardarDatosAeronavesEnArchivo() {
        try (BufferedWriter writerAeronaves = new BufferedWriter(new FileWriter("aeronaves.txt"))) {
            for (Aeronave a : aeronaves) {
                writerAeronaves.write(String.format("%s,%s,%s\n", a.codigo, a.marca, a.fabricante));
            }
        } catch (IOException e) {
            System.out.println("No se pudo guardar la información de aeronaves en el archivo.");
        }
    }

    private static void guardarDatosViajesEnArchivo() {
        try (BufferedWriter writerViajes = new BufferedWriter(new FileWriter("viajes.txt"))) {
            for (Viaje v : viajes) {
                writerViajes.write(String.format("%d,%s,%s,%s,%s,%.2f,%s\n", v.codigo, v.aeronaveCodigo, v.fecha,
                        v.origen, v.destino, v.valor, v.reglas));
            }
        } catch (IOException e) {
            System.out.println("No se pudo guardar la información de viajes en el archivo.");
        }
    }

    private static void guardarDatosTiquetesEnArchivo() {
        try (BufferedWriter writerTiquetes = new BufferedWriter(new FileWriter("tiquetes.txt"))) {
            for (Tiquete t : tiquetes) {
                writerTiquetes.write(String.format("%d,%s,%s,%s,%d\n", t.codigoViaje, t.nombre, t.apellido,
                        t.identificacion, t.numeroTiquete));
            }
        } catch (IOException e) {
            System.out.println("No se pudo guardar la información de tiquetes en el archivo.");
        }
    }
}
   

