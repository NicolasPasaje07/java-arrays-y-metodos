package Evaluacion;
/*
@author: Nicolas Andres Pasaje Gonzalez - 20261244286
*/

import java.util.Scanner;
import java.util.ArrayList;

// Clase principal solicitada en la estructura del programa
public class solucionEvaluacion {

    /**
     * Llena un arreglo con 12 temperaturas (una por mes).
     *
     * @param aleatorio Si es true, genera datos al azar. Si es false, los pide
     * por consola.
     * @param min Temperatura mínima permitida.
     * @param max Temperatura máxima permitida.
     */
    public double[] generarTemperaturas(boolean aleatorio, double min, double max) {
        // Se crea el arreglo de 12 posiciones que almacenará los meses
        double[] temperaturas = new double[12];
        Scanner sc = new Scanner(System.in);

        // Recorremos las 12 posiciones del arreglo
        for (int i = 0; i < 12; i++) {
            if (aleatorio) {
                // Genera un número aleatorio entre el rango min y max
                temperaturas[i] = min + (Math.random() * (max - min));
            } else {
                // Solicita el ingreso manual por consola
                System.out.print("Ingrese la temperatura manual para el mes " + (i + 1) + ": ");
                temperaturas[i] = sc.nextDouble();
            }
        }
        return temperaturas;
    }

    /**
     * Método auxiliar para calcular el promedio anual de un arreglo de
     * temperaturas.
     */
    private double calcularPromedio(double[] temperaturas) {
        double suma = 0;
        for (double t : temperaturas) {
            suma += t; // Suma todas las temperaturas
        }
        return suma / temperaturas.length; // Divide por la cantidad de meses (12)
    }

    /**
     * Compara dos subestaciones y devuelve un mensaje indicando cuál fue más
     * cálida. El criterio es el promedio de temperatura anual.
     */
    public String compararSubestaciones(double[] t1, double[] t2, String nombre1, String nombre2) {
        // Obtenemos los promedios de ambas subestaciones
        double promedio1 = calcularPromedio(t1);
        double promedio2 = calcularPromedio(t2);

        // Comparamos los promedios para determinar la más cálida
        if (promedio1 > promedio2) {
            return nombre1;
        } else if (promedio2 > promedio1) {
            return nombre2;
        } else {
            return "Ambas tienen el mismo promedio";
        }
    }

    /**
     * Devuelve un arreglo con los índices de los meses (0 a 11) que presentan
     * anomalias. Una anomalía es estar +/- 20% del promedio del año.
     */
    public int[] detectarAnomalias(double[] temperaturas) {
        double promedio = calcularPromedio(temperaturas);
        // Calculamos los límites: 80% (límite inferior) y 120% (límite superior)
        double limiteInferior = promedio * 0.80;
        double limiteSuperior = promedio * 1.20;

        // Usamos una lista dinámica porque no sabemos cuántas anomalías habrá
        ArrayList<Integer> indicesAnomalos = new ArrayList<>();

        for (int i = 0; i < temperaturas.length; i++) {
            // Si la temperatura sale del rango permitido, es una anomalía
            if (temperaturas[i] < limiteInferior || temperaturas[i] > limiteSuperior) {
                indicesAnomalos.add(i);
            }
        }

        // Convertimos la lista dinámica a un arreglo primitivo de int, como pide el requerimiento
        int[] resultado = new int[indicesAnomalos.size()];
        for (int i = 0; i < indicesAnomalos.size(); i++) {
            resultado[i] = indicesAnomalos.get(i);
        }
        return resultado;
    }

    /**
     * Imprime un resumen estadístico detallado por subestación.
     */
    public void reporteMensual(String nombre, double[] temperaturas) {
        System.out.println("--- Reporte Estadistico: " + nombre + " ---");

        // Inicializamos las variables asumiendo que el primer mes es el mayor y menor
        double maxTemp = temperaturas[0];
        double minTemp = temperaturas[0];
        int mesMax = 0;
        int mesMin = 0;

        // Imprimimos el registro de todos los meses y buscamos max/min
        for (int i = 0; i < temperaturas.length; i++) {
            System.out.printf("Mes %d: %.2f°C\n", (i + 1), temperaturas[i]);

            if (temperaturas[i] > maxTemp) {
                maxTemp = temperaturas[i];
                mesMax = i; // Guardamos el índice del mes más caluroso
            }
            if (temperaturas[i] < minTemp) {
                minTemp = temperaturas[i];
                mesMin = i; // Guardamos el índice del mes más frío
            }
        }

        // Imprimimos los resultados finales calculados
        double promedio = calcularPromedio(temperaturas);
        System.out.printf("Promedio anual: %.2f°C\n", promedio);
        System.out.printf("Mes con mayor temperatura: Mes %d (%.2f°C)\n", (mesMax + 1), maxTemp);
        System.out.printf("Mes con menor temperatura: Mes %d (%.2f°C)\n", (mesMin + 1), minTemp);
        System.out.println("----------------------------------------\n");
    }

    public static void main(String[] args) {
        // Se instancia la clase principal
        solucionEvaluacion monitor = new solucionEvaluacion();

        // 1. Declarar tres arreglos de tipo double con 12 posiciones
        double[] rivera;
        double[] neiva;
        double[] campoalegre;

        // 2. Llenar los arreglos con datos simulados aleatoriamente
        // Se asumen rangos de temperatura realistas para la región del Huila
        System.out.println("Generando datos climaticos...\n");
        rivera = monitor.generarTemperaturas(true, 22.0, 34.0);
        neiva = monitor.generarTemperaturas(true, 24.0, 38.0);
        campoalegre = monitor.generarTemperaturas(true, 23.0, 36.0);

        // 3. Aplicar métodos de análisis (Reportes)
        monitor.reporteMensual("Rivera", rivera);
        monitor.reporteMensual("Neiva", neiva);
        monitor.reporteMensual("Campoalegre", campoalegre);

        // Detección de anomalias en una estación de ejemplo
        int[] anomaliasNeiva = monitor.detectarAnomalias(neiva);
        System.out.print("Anomalías detectadas en Neiva (Meses): ");
        if (anomaliasNeiva.length == 0) {
            System.out.print("Ninguna");
        } else {
            for (int mesIndex : anomaliasNeiva) {
                System.out.print((mesIndex + 1) + " ");
            }
        }
        System.out.println("\n");

        // 4. Mostrar resultados comparativos entre subestaciones
        String masCalidaRN = monitor.compararSubestaciones(rivera, neiva, "Rivera", "Neiva");
        System.out.println("Comparacion Rivera vs Neiva -> La mas calida fue: " + masCalidaRN);

        String masCalidaNC = monitor.compararSubestaciones(neiva, campoalegre, "Neiva", "Campoalegre");
        System.out.println("Comparacion Neiva vs Campoalegre -> La mas calida fue: " + masCalidaNC);
    }
}
