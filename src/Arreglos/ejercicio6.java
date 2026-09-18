/*
4.c.3. Hacer un programa que muestre un menú de este tipo:
"1.- Introducir nota"
"2.- Mostrar nota media"
"3.- Mostrar notas extremas"
"4.- Mostrar notas"
"0.- Salir"
De modo que si se opta por:
✤ la opción 1 pide por teclado una nueva nota, y se guarda en un array
✤ la opción 2 muestra la nota media de todas las introducidas hasta ese momento
✤ la opción 3 muestra la menor y la mayor de todas las notas introducidas hasta ese momento
✤ la opción 4 muestra todas las notas introducidas hasta ese momento
✤ la opción 0 acaba el programa
MEJORA 1: Al ejercicio anterior, añadirle una opción "5.- Eliminar nota” que nos pedirá un número, y eliminara la nota que tenga en el array ese número como índice
 */
package Arreglos;

import java.util.Scanner;

/*
@author: Nicolas Andres Pasaje Gonzalez - 20261244286
 */
public class ejercicio6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] notas = new double[100]; //Capacidad maxima
        int cantidad = 0; //Controla el numero de notas guardadas
        int opcion;

        do {
            System.out.println("\n---MENU---");
            System.out.println("1.- Introducir nota");
            System.out.println("2.- Mostrar nota media");
            System.out.println("3.- Mostrar notas extremas");
            System.out.println("4.- Mostrar notas");
            System.out.println("5.- Eliminar nota");
            System.out.println("0.- Salir");
            System.out.println("Elige una opcion");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    if (cantidad <= notas.length) {
                        System.out.println("Ingrese una nota: ");
                        notas[cantidad] = sc.nextDouble();
                        cantidad++;
                        System.out.println("Nota guardada con exito");
                    } else {
                        System.out.println("El arreglo esta lleno.");
                    }
                    break;
                case 2: //Nota media
                    if (cantidad == 0) {
                        System.out.println("No hay notas registradas");

                    } else {
                        double suma = 0;
                        for (int i = 0; i < cantidad; i++) {
                            suma += notas[i];

                        }
                        System.out.println("La nota media es: " + (suma / cantidad));
                    }
                    break;
                case 3: //Notas extremas
                    if (cantidad == 0) {
                        System.out.println("No hay notas registradas");

                    } else {
                        double min = notas[0], max = notas[0];
                        for (int i = 0; i < cantidad; i++) {
                            if (notas[i] < min) {
                                min = notas[i];
                            }
                            if (notas[i] > max) {
                                max = notas[i];

                            }

                        }
                        System.out.println("Nota minima: " + min + " | Nota maxima: " + max);

                    }
                    break;
                case 4:
                    if (cantidad == 0) {
                        System.out.println("No hay notas registradas");

                    } else {
                        System.out.println("Listado de notas:");
                        for (int i = 0; i < cantidad; i++) {
                            System.out.println("Indice [" + i + "]: " + notas[i]);

                        }
                    }

                    break;
                case 5:
                    if (cantidad == 0) {
                        System.out.println("No hay notas registradas");

                    } else {
                        System.out.println("Ingresa el indice de la nota a eliminar ( 0 a " + (cantidad - 1) + "}: ");
                        int idx = sc.nextInt();

                        if (idx >= 0 && idx < cantidad) {
                            // Desplazar a la izquierda para cubrir el hueco
                            for (int i = idx; i < cantidad - 1; i++) {
                                notas[i] = notas[i + 1];

                            }
                            cantidad--; //Reducimos la cantidad de elementos activos
                            System.out.println("Nota eliminada correctamente!.");

                        } else {
                            System.out.println("Indice no valido.");
                        }
                    }
                    break;
            }

        } while (opcion != 0);

    }

}
