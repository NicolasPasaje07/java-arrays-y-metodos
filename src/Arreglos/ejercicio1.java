/*
4.b.1. Escribe un programa que lea 5 números por teclado y que los almacene en un array. Rota los elementos de ese array, es decir, el elemento de la posición 0 debe pasar a la posición 1, el de la 1 a la 2, etc. El número que se encuentra en la última posición debe pasar a la posición 0. Finalmente, muestra el contenido del array.
 */
package Arreglos;

import java.util.Scanner;


/*
@author: Nicolas Andres Pasaje Gonzalez - 20261244286
 */
public class ejercicio1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite 5 numeros: ");
        int[] numeros = new int[5]; //Pide 5 numeros estableciendo el limite del arreglo en 5
        for (int i = 0; i < 5; i++) { //Va a pedir un numero 5 veces
            System.out.println("Digite el numero " + (i + 1));
            numeros[i] = sc.nextInt();

        }
        int ultimo = numeros[4]; //Hace la reorganizacion de los numeros ingresados
        for (int i = 3; i >= 0; i--) {
            numeros[i + 1] = numeros[i];

        }
        numeros[0] = ultimo;
        System.out.println("Arreglo rotado: ");
        for (int i = 0; i < 5; i++) {
            System.out.println(numeros[i]);

        }

    }

}
