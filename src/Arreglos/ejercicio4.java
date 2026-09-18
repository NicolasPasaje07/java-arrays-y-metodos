/*
4.a.2. Hacer un bucle que pida por teclado 10 números enteros y los almacene en un array, y que se calcule posteriormente la suma de los números que sean pares y la suma de los números que sean impares, y que nos diga por pantalla cual de las dos sumas es mayor
 */
package Arreglos;

import java.util.Scanner;

/*
@author: Nicolas Andres Pasaje Gonzalez - 20261244286
 */
public class ejercicio4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numeros = new int[10];
        int sumaPares = 0;
        int sumaImpares = 0;

        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Ingresa el numero " + (i + 1) + ": ");
            numeros[i] = sc.nextInt();

        }
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] % 2 == 0) {
                sumaPares += numeros[i]; //Es par, se suma a sumaPares

            } else {
                sumaImpares += numeros[i]; //Es impar, se suma a sumaImpares
            }

        }
        System.out.println("Suma pares: " + sumaPares);
        System.out.println("Suma impares: " + sumaImpares);
        if (sumaPares > sumaImpares) {
            System.out.println("La suma de los numeros pares es mayor.");
        } else if (sumaImpares > sumaPares) {
            System.out.println("La suma de los numeros impares es mayor");
        } else {
            System.out.println("Ambas sumas son iguales.");
        }
    }

}
