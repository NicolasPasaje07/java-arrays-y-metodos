/*
4.c.14.Realizar un programa que lea por teclado un array de 10 elementos numéricos enteros y una posición (entre 0 y 9). Eliminar el elemento situado en la posición dada sin dejar huecos.
 */
package Arreglos;

import java.util.Scanner;

/*
@author: Nicolas Andres Pasaje Gonzalez - 20261244286
 */
public class ejercicio7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numeros = new int[10];

        System.out.println("Ingrese 10 numeros enteros");
        for (int i = 0; i < 10; i++) {
            numeros[i] = sc.nextInt();

        }
        System.out.println("El arreglo ingresado es ");
        for (int i = 0; i < 10; i++) {
            System.out.println("Indice " + i + ": " + numeros[i]);

        }
        System.out.println("------------------");
        System.out.println("Que posicion desea borrar: ");
        int posicion = sc.nextInt();
        if (posicion >= 0 && posicion <= 9) {
            for (int i = posicion; i < 9; i++) {
                numeros[i] = numeros[i + 1];

            }

        } else {
            System.out.println("Valor fuera de rango!");
            System.out.println("Ingrese un dato valido! (0 a 9)");
        }
        System.out.println("El arreglo modificado es: ");
        for (int i = 0; i < 9; i++) {
            System.out.println("Indice " + i + ": " + numeros[i]);

        }

    }

}
