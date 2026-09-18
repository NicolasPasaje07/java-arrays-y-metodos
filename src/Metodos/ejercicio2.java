/*
5.b.11.Crear un método que recibe como parámetros dos tablas (arrays). La primera con los 6 números de una apuesta de la primitiva, y la segunda con los 6 números ganadores. El método debe devolver el número de aciertos.
 */
package Metodos;

import java.util.Scanner;
import java.util.Random;

/*
@author: Nicolas Andres Pasaje Gonzalez - 20261244286
 */
public class ejercicio2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int[] ganadores = new int[6];
        int[] miApuesta = new int[6];
        for (int i = 0; i < ganadores.length; i++) {
            int numeroGenerado;
            boolean yaExiste;
            do {
                numeroGenerado = rand.nextInt(101);
                yaExiste = false;
                for (int j = 0; j < i; j++) {
                    if (ganadores[j] == numeroGenerado) {
                        yaExiste = true;
                        break;

                    }

                }

            } while (yaExiste);
            ganadores[i] = numeroGenerado;

        }

        System.out.println("Ingrese los 6 numeros que va apostar (0 a 100): ");
        for (int i = 0; i < 6; i++) {
            miApuesta[i] = sc.nextInt();
        }
        int resultado = contarAciertos(miApuesta, ganadores);

        System.out.println("Tuviste " + resultado + " aciertos!");
        System.out.println("Los numeros ganadores fueron: ");
        for (int i = 0; i < ganadores.length; i++) {
            System.out.println(ganadores[i] + "");

        }
    }

    public static int contarAciertos(int[] miApuesta, int[] ganadores) {
        int aciertos = 0;
        for (int i = 0; i < miApuesta.length; i++) {
            for (int j = 0; j < ganadores.length; j++) {
                if (miApuesta[i] == ganadores[j]) {
                    aciertos++;

                }

            }

        }
        return aciertos; //Retorna el total al terminar la comparacion
    }

}
