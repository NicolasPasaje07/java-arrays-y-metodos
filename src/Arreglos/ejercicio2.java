/*
4.b.4. Realiza un programa que termine cuando el usuario haya metido todos los números comprendidos entre el 1 y el 10. 
 */
package Arreglos;

import java.util.Scanner;

/*
@author: Nicolas Andres Pasaje Gonzalez - 20261244286
 */
public class ejercicio2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[] ingresados = new boolean[10];
        int contador = 0;

        while (contador < 10) {
            System.out.println("Digite un numero del 1 al 10");
            int num = sc.nextInt();

            if (num >= 1 && num <= 10) {

            } else {
                System.out.println("El numero ingresado esta fuera de rango. Debe ser entre 1 y 10");
            }
            int indice = num - 1;
            if (!ingresados[indice]) {
                ingresados[indice] = true;
                contador++;
                System.out.println("Llevas " + contador + " de 10 numeros");

            }

        }
    }

}
