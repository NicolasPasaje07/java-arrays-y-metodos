/*
5.c.4. Crear un método que muestre en binario un número entre 0 y 255.
 */
package Metodos;

import java.util.Scanner;

/*
@author: Nicolas Andres Pasaje Gonzalez - 20261244286
 */
public class ejercicio3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un numero");
        int numero = sc.nextInt();
        System.out.println("El numero en binario es: ");

        mostrarBinario(numero);

    }

    public static void mostrarBinario(int numero) {
        if (numero < 0 || numero > 255) {
            System.out.println("Error: El numero debe estar enre 0 y 255!");
            return;
        }
        int[] binario = new int[8];
        for (int i = 7; i >= 0; i--) {
            binario[i] = numero % 2;
            numero = numero / 2;

        }
        for (int i = 0; i < binario.length; i++) {
            System.out.println(binario[i]);

        }
        System.out.println();

    }
}
