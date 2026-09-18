/*
4.a.5. Dados estos arrays

String [] nombreDeCadaAlumno = {"Eva","Jose","Pepa","Ana","Juanjo"}
int[] notasDeCadaAlumno = {8,2,5,4,9};

donde cada posición de un alumno corresponde con la posición de su nota, hacer un bucle que nos diga los nombres de los alumnos que han aprobado y su nota, esto es, debe escribir en la consola:

Eva ha aprobado con un 8
Pepa ha aprobado con un 5
Juanjo ha aprobado con un 9

MEJORA 1: Crear los arrays sin contenido y pedir los datos al usuario por teclado. Las notas pueden tener decimales.

MEJORA 2: Además de lo anterior, al final se muestran los nombres de los alumnos suspendidos, separados por comas. La salida entonces puede ser algo así:

Luis ha aprobado con un 8
Carlos ha aprobado con un 5
Juanjo ha aprobado con un 9
Han suspendido: Jose, Pedro
 */
package Arreglos;

import java.util.Scanner;

/*
@author: Nicolas Andres Pasaje Gonzalez - 20261244286
 */
public class ejercicio3 {

    public static void main(String[] args) {
        ejercicio();
        mejora1y2();

    }

    public static void ejercicio() {
        String[] nombreDeCadaAlumno = {"Eva", "Jose", "Pepa", "Ana", "Juanjo"};
        int[] notasDeCadaAlumno = {8, 2, 5, 4, 9};
        for (int i = 0; i < nombreDeCadaAlumno.length; i++) {
            // Evaluamos si la nota es mayor o igual a 5 (Aprobado)
            if (notasDeCadaAlumno[i] >= 5) {
                System.out.println(nombreDeCadaAlumno[i] + " ha aprobado con " + notasDeCadaAlumno[i]);

            } else {
                System.out.println(nombreDeCadaAlumno[i] + " ha reprobado con " + notasDeCadaAlumno[i]);
            }

        }
        System.out.println("------------------------");

    }

    public static void mejora1y2() {
        Scanner sc = new Scanner(System.in);
        int cantidad = 5;
        String suspendidos = "";
        String[] nombres = new String[cantidad];
        double[] notas = new double[cantidad]; // Permite notas decimales

        for (int i = 0; i < cantidad; i++) { //Se piden nombre y nota de cada estudiante
            System.out.println("Nombre del alumno " + (i + 1) + ": ");
            nombres[i] = sc.next();

            System.out.println("Nota del alumno " + (i + 1) + ": ");
            notas[i] = sc.nextDouble();

        }
        for (int i = 0; i < nombres.length; i++) {
            if (notas[i] >= 5.0) { //Se comprueba que halla aprobado con la nota minima
                System.out.println(nombres[i] + " ha aprobado con: " + notas[i]);

            } else {
                // Si la cadena esta vacia, agregamos solo el nombre
                // Si ya tiene nombres, le anteponemos una coma y espacio
                if (suspendidos.isEmpty()) {
                    suspendidos = nombres[i];

                } else {
                    suspendidos += ", " + nombres[i];
                }

            }

        }
        //Al final del ciclo imprimimos la lista acumulada
        if (!suspendidos.isEmpty()) {
            System.out.println("Han suspendido: " + suspendidos);

        }
        System.out.println("-----------------------");
    }
}
