package Evaluacion;

import java.util.Scanner;

public class MonitorClimaticoRegional {

    public static void main(String[] args) {
        // 1. Declaración de los tres arreglos de tipo double con 12 posiciones[cite: 1].
        double[] rivera = new double[12];
        double[] neiva = new double[12];
        double[] campoalegre = new double[12];

        // 2. Llenado de los arreglos con datos simulados (automáticos en este caso)[cite: 1].
        rivera = procesarTemperaturas(true, 21, 31);
        neiva = procesarTemperaturas(true, 22, 35);
        campoalegre = procesarTemperaturas(true, 23, 33);

        // 3. Comparación del comportamiento climático entre subestaciones[cite: 1].
        System.out.println("Comparando Rivera vs Neiva: " + compararSubestaciones(rivera, neiva));

        // Simulación de alteraciones para probar la detección de anomalías
        double[] copia = rivera.clone(); // Se usa .clone() para no modificar el arreglo original por referencia
        copia[1] = 15; // Temperatura inusualmente baja para probar anomalía
        copia[10] = 35; // Temperatura inusualmente alta para probar anomalía

        // 4. Detectar anomalías[cite: 1].
        System.out.println("\nAnomalías detectadas en la copia de Rivera (Índices de meses):");
        int anomalias[] = detectarAnomalias(copia);
        for (int j = 0; j < anomalias.length; j++) {
            // Filtramos los -1 para imprimir únicamente los meses que sí son anomalías reales
            if (anomalias[j] != -1) {
                System.out.println("Mes índice: " + anomalias[j]);
            }
        }

        System.out.println("\n------------------------------------------------");
        // 5. Imprimir resumen estadístico por subestación[cite: 1].
        reporteMensual("Rivera", rivera);
    }

    /**
     * Llena el arreglo de forma aleatoria o manual basándose en el booleano.
     * Requiere las temperaturas máximas y mínimas permitidas[cite: 1].
     */
    public static double[] procesarTemperaturas(boolean tipoGenerador, double tempMin, double tempMax) {
        double[] temperaturas = new double[12];

        if (tipoGenerador) {
            // Generación automática mediante Math.random
            for (int i = 0; i < temperaturas.length; i++) {
                temperaturas[i] = (Math.random() * (tempMax + 1 - tempMin) + tempMin);
            }
        } else {
            // Corrección: Implementación del Scanner para ingreso manual real
            Scanner scanner = new Scanner(System.in);
            for (int i = 0; i < temperaturas.length; i++) {
                System.out.print("Ingrese la temperatura para el mes " + (i + 1) + ": ");
                temperaturas[i] = scanner.nextDouble();
            }
        }
        return temperaturas;
    }

    /**
     * Compara dos subestaciones basándose en su promedio anual[cite: 1].
     * Retorna 1 si t1 es mayor, 2 si t2 es mayor, 0 si son iguales.
     */
    public static int compararSubestaciones(double[] t1, double[] t2) {
        double prom1 = promedioArreglos(t1);
        double prom2 = promedioArreglos(t2);

        if (prom1 > prom2) {
            return 1;
        } else if (prom1 < prom2) {
            return 2;
        } else {
            return 0;
        }
    }

    // Calcula el promedio matemático básico sumando los elementos y dividiendo por la longitud.
    public static double promedioArreglos(double[] arreglo) {
        double suma = 0;
        for (int i = 0; i < arreglo.length; i++) {
            suma += arreglo[i];
        }
        return suma / arreglo.length;
    }

    /**
     * Una anomalía se determina cuando un mes está +/- 20% fuera del promedio
     * anual[cite: 1]. Retorna un arreglo int con los índices anómalos[cite: 1].
     */
    public static int[] detectarAnomalias(double[] temperaturas) {
        int[] anomalias = new int[12];
        // Inicializar en -1 para que el índice 0 (Enero) no se marque por error
        for (int i = 0; i < anomalias.length; i++) {
            anomalias[i] = -1;
        }

        int indAnomalias = 0;
        double prom = promedioArreglos(temperaturas);

        for (int i = 0; i < temperaturas.length; i++) {
            // +20% equivale a multiplicar por 1.2, -20% equivale a multiplicar por 0.8
            if ((temperaturas[i] >= (prom * 1.2)) || (temperaturas[i] <= (prom * 0.8))) {
                anomalias[indAnomalias] = i;
                indAnomalias++;
            }
        }
        return anomalias;
    }

    /**
     * Muestra el registro de todos los meses, los nombres de los meses con
     * mayor y menor temperatura, y el promedio[cite: 1].
     */
    public static void reporteMensual(String nombre, double[] temperaturas) {
        String[] meses = {"ENE", "FEB", "MAR", "ABR", "MAY", "JUN", "JUL", "AGO", "SEP", "OCT", "NOV", "DIC"};
        double prom = promedioArreglos(temperaturas);

        System.out.println("Informe Temperaturas Estacion: " + nombre);
        System.out.println("Mes      Promedio Mes");
        for (int k = 0; k < temperaturas.length; k++) {
            // Se utiliza String.format para redondear a 2 decimales y visualizar mejor
            System.out.printf("%s      %.2f\n", meses[k], temperaturas[k]);
        }

        // Corrección: Llamar a la función correcta para el mes más frío
        System.out.println("Mes mas calido: " + meses[mesMayorTemp(temperaturas)]);
        System.out.println("Mes menos calido: " + meses[mesMenorTemp(temperaturas)]);
        System.out.printf("Promedio del año: %.2f\n", prom);
    }

    // Encuentra el índice con el valor máximo
    public static int mesMayorTemp(double[] estacion) {
        int mesAlto = 0;
        double tempAlta = estacion[0];
        for (int k = 0; k < estacion.length; k++) {
            // Corrección lógica: Si encontramos una temperatura MAYOR, actualizamos la variable
            if (estacion[k] > tempAlta) {
                tempAlta = estacion[k];
                mesAlto = k;
            }
        }
        return mesAlto;
    }

    // Encuentra el índice con el valor mínimo
    public static int mesMenorTemp(double[] estacion) {
        int mesBajo = 0;
        double tempMenor = estacion[0];
        for (int k = 0; k < estacion.length; k++) {
            // Corrección lógica: Si encontramos una temperatura MENOR, actualizamos la variable
            if (estacion[k] < tempMenor) {
                tempMenor = estacion[k];
                mesBajo = k;
            }
        }
        return mesBajo;
    }
}
