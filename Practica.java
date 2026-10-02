
import java.util.Scanner;

public class Practica {

    public static void main(String[] args) {
        // Inicializamos el Scanner para leer datos por teclado
        Scanner teclado = new Scanner(System.in);
        int opcion;

        // Declaramos los arreglos paralelos vacíos al inicio
        String[] placas = new String[0];
        double[] kilometros = new double[0];
        double[] galones = new double[0];

        // Variable para controlar si ya se registraron vehículos
        boolean datosRegistrados = false;

        // Ciclo do-while para el menú interactivo
        do {
            System.out.println("\n=== SISTEMA DE FLOTA: RUTA RÁPIDA ===");
            System.out.println("1. Registrar/Sobrescribir datos de la flota");
            System.out.println("2. Consultar el rendimiento promedio general");
            System.out.println("3. Filtrar y mostrar vehículos ineficientes");
            System.out.println("4. Mostrar vehículo con mayor recorrido");
            System.out.println("5. Estadísticas");
            System.out.println("6. Salir");
            System.out.print("Elija una opción: ");

            opcion = teclado.nextInt();
            teclado.nextLine(); // Limpiamos el salto de línea del búfer (muy importante después de un nextInt)

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la cantidad de vehículos en la flota: ");
                    int n = teclado.nextInt();
                    teclado.nextLine(); // Limpiar el búfer de nuevo

                    // Damos el tamaño a los arreglos paralelos según la cantidad de vehículos ingresada
                    placas = new String[n];
                    kilometros = new double[n];
                    galones = new double[n];

                    // Ciclo para llenar los datos de cada vehículo
                    for (int i = 0; i < n; i++) {
                        System.out.println("\n--- Vehículo #" + (i + 1) + " ---");
                        System.out.print("Placa: ");
                        placas[i] = teclado.nextLine();

                        // Usamos un método de apoyo para validar que los datos sean positivos
                        kilometros[i] = leerDatoPositivo(teclado, "Kilómetros recorridos: ");
                        galones[i] = leerDatoPositivo(teclado, "Galones consumidos: ");
                    }
                    datosRegistrados = true; // Confirmamos que ya hay datos para usar las otras opciones
                    System.out.println("Datos registrados con éxito.");
                    break;

                case 2:
                    if (datosRegistrados) {
                        double prom = calcularRendimientoPromedio(kilometros, galones);
                        System.out.println("\nEl rendimiento promedio de toda la flota es: " + prom + " km/galón");
                    } else {
                        System.out.println("\nError: Primero debe registrar los vehículos (Opción 1).");
                    }
                    break;

                case 3:
                    if (datosRegistrados) {
                        double limite = leerDatoPositivo(teclado, "Ingrese el límite mínimo de rendimiento (km/galón): ");
                        mostrarVehiculosIneficientes(placas, kilometros, galones, limite);
                    } else {
                        System.out.println("\nError: Primero debe registrar los vehículos (Opción 1).");
                    }
                    break;

                case 4:
                    if (datosRegistrados) {
                        int indiceMaximo = buscarVehiculoMasRecorrido(kilometros);
                        System.out.println("\nVehículo con mayor recorrido -> Placa: " + placas[indiceMaximo] + " | Recorrió: " + kilometros[indiceMaximo] + " km");
                    } else {
                        System.out.println("\nError: Primero debe registrar los vehículos (Opción 1).");
                    }
                    break;

                case 5:
                    if (datosRegistrados) {
                        generarEstadisticass(placas, kilometros, galones);
                    } else {
                        System.out.println("\nError: Primero debe registrar los vehículos (Opción 1).");
                    }
                    break;

                case 6:
                    System.out.println("\nSaliendo del sistema... ¡Hasta pronto!");
                    break;

                default:
                    System.out.println("\nOpción no válida. Intente de nuevo.");
            }
        } while (opcion != 6);
    }

    // =========================================================================
    // MÉTODOS SOLICITADOS EN EL TALLER
    // =========================================================================
    // Método extra para validar que los valores sean positivos (km y galones)
    public static double leerDatoPositivo(Scanner teclado, String mensaje) {
        double valor;
        do {
            System.out.print(mensaje);
            valor = teclado.nextDouble();
            if (valor <= 0) {
                System.out.println("Error: El valor debe ser mayor a cero.");
            }
        } while (valor <= 0);

        teclado.nextLine(); // Limpiar el búfer para evitar problemas con la lectura del próximo String
        return valor;
    }

    // Método que calcula el rendimiento global (total km / total galones)
    public static double calcularRendimientoPromedio(double[] kilometros, double[] galones) {
        double sumaKilometros = 0;
        double sumaGalones = 0;

        // Sumamos todos los km y galones usando un ciclo
        for (int i = 0; i < kilometros.length; i++) {
            sumaKilometros = sumaKilometros + kilometros[i];
            sumaGalones = sumaGalones + galones[i];
        }

        // Retornamos el resultado de la división
        return sumaKilometros / sumaGalones;
    }

    // Método para imprimir vehículos por debajo de un límite dado
    public static void mostrarVehiculosIneficientes(String[] placas, double[] kilometros, double[] galones, double limiteRendimiento) {
        System.out.println("\n--- Vehículos Ineficientes ---");
        boolean encontrado = false; // Bandera para saber si encontramos alguno

        for (int i = 0; i < placas.length; i++) {
            double rendimientoIndividual = kilometros[i] / galones[i];

            if (rendimientoIndividual < limiteRendimiento) {
                System.out.println("Placa: " + placas[i] + " | Rendimiento: " + rendimientoIndividual + " km/gal");
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron vehículos por debajo del límite.");
        }
    }

    // Método para encontrar qué posición tiene el vehículo que más recorrió
    public static int buscarVehiculoMasRecorrido(double[] kilometros) {
        int posicionMax = 0;
        double mayorRecorrido = kilometros[0]; // Asumimos que el primero es el mayor inicialmente

        for (int i = 1; i < kilometros.length; i++) {
            if (kilometros[i] > mayorRecorrido) {
                mayorRecorrido = kilometros[i]; // Actualizamos el mayor
                posicionMax = i; // Guardamos su índice
            }
        }
        return posicionMax;
    }

    // Método para generar el reporte de estadísticas general
    // Nota: Nombrado exactamente "generarEstadisticass" como pide el documento.
    public static void generarEstadisticass(String[] placas, double[] kilometros, double[] galones) {
        System.out.println("\n--- REPORTE DE ESTADÍSTICAS ---");

        // 1. Listado general
        System.out.println("1. Listado General de Vehículos:");
        double sumaKm = 0;
        double sumaGal = 0;
        int posicionMaxConsumo = 0;

        for (int i = 0; i < placas.length; i++) {
            System.out.println("   Placa: " + placas[i] + " | Km: " + kilometros[i] + " | Galones: " + galones[i]);

            sumaKm += kilometros[i];
            sumaGal += galones[i];

            // Aprovechamos el ciclo para ir buscando también el que gastó más galones
            if (galones[i] > galones[posicionMaxConsumo]) {
                posicionMaxConsumo = i;
            }
        }

        // 2. Datos del vehículo con mayor recorrido (reutilizamos el método anterior)
        int posicionMaxRecorrido = buscarVehiculoMasRecorrido(kilometros);
        System.out.println("\n2. Vehículo con mayor recorrido:");
        System.out.println("   Placa: " + placas[posicionMaxRecorrido] + " | Km: " + kilometros[posicionMaxRecorrido]);

        // 3. Datos del vehículo con mayor consumo (calculado dentro del ciclo for)
        System.out.println("\n3. Vehículo con mayor consumo de combustible:");
        System.out.println("   Placa: " + placas[posicionMaxConsumo] + " | Galones: " + galones[posicionMaxConsumo]);

        // 4. Promedios (Suma total / Cantidad de vehículos)
        double promedioRecorrido = sumaKm / placas.length;
        double promedioConsumo = sumaGal / placas.length;

        System.out.println("\n4. Promedios Generales:");
        System.out.println("   Recorrido promedio: " + promedioRecorrido + " km");
        System.out.println("   Consumo promedio: " + promedioConsumo + " galones");
    }
}
