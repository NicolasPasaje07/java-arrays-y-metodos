/*
4.a.3. Temperaturas. Se piden por teclado la temperatura de cada uno de los 7 días de una semana y se almacenan en un array de 7 elementos. Posteriormente, se pide por teclado una nueva temperatura, y se compara con las leídas anteriormente para decir si tal nueva temperatura se dio en algún día de la semana (si tal nueva temperatura existe en el array de temperaturas de la semana).
MEJORA 1: Decir en que día o días se dio dicha temperatura 
 */
package Arreglos;

import java.util.Scanner;

/*
@author: Nicolas Andres Pasaje Gonzalez - 20261244286
 */

public class ejercicio5 {

    public static void main(String[] args) {
        ejercicio();

    }

    public static void ejercicio() {
        Scanner sc = new Scanner(System.in);
        String[] dias = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};
        double[] temperatura = new double[7];
        double nuevaTemperatura;

        for (int i = 0; i < dias.length; i++) {
            System.out.println("Ingrese la temperatura del dia " + dias[i]);
            temperatura[i] = sc.nextDouble();

        }
        System.out.println("-----------------------");

        System.out.println("Ingrese una nueva temperatura");
        nuevaTemperatura = sc.nextDouble();

        // Variable bandera
        boolean encontrada = false;

        for (int i = 0; i < dias.length; i++) {
            if (nuevaTemperatura == temperatura[i]) {
                System.out.println("La nueva temperatura ingresada es igual a la del dia " + dias[i]);
                encontrada = true; // Si hay coincidencia, cambiamos la bandera

            }
        }
        // Evaluamos fuera del ciclo una sola vez
        if (!encontrada) {
            System.out.println("La nueva temperatura no coincide con ninguna de las anteriores");

        }

    }

}
