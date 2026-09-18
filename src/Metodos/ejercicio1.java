/*
5.b.10.Crear un método que recibe dos enteros (A y C) y calcula y devuelve A elevado a C
 */
package Metodos;

import java.util.Scanner;

/*
@author: Nicolas Andres Pasaje Gonzalez - 20261244286
*/
public class ejercicio1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a;
        int c;
        System.out.println("Ingrese la base: ");
        a = sc.nextInt();
        System.out.println("Ingrese el exponente: ");
        c = sc.nextInt();
        int respuesta = elevar(a, c);
        System.out.println("El resultado es " + respuesta);
    }

    public static int elevar(int base, int exponente) {
        int resultado = 1;
        for (int i = 0; i < exponente; i++) {
            resultado = resultado * base;
        }
        return resultado;
    }
}
