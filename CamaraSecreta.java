package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class CamaraSecreta {

    public static void juegoCamaraSecreta() {
        Scanner input = new Scanner(System.in);
        System.out.print("\nIntroduzca la longitud de la clave: "); // Pedir por consola la longitud de la clave
        int longitud = input.nextInt();

        System.out.print("\n"); // Salto de línea

        int[] clave = new int[longitud];
        int[] clave_descifrada = new int[longitud];
        String[] resultados = new String[longitud];
        int intentos = 0;

        for (int i = 0; i < clave.length; i++) { // generar números aleatorios para la clave
            clave[i] = (int) (Math.random()*10);
        }

        while (!Arrays.equals(clave_descifrada, clave)) { // Pedir por consola los números
            for (int i = 0; i < clave.length; i++) {
                Scanner input_clave = new Scanner(System.in);
                System.out.print("Introduzca el digito " + (i + 1) + ": ");
                int clave_secreta = input.nextInt();

                clave_descifrada[i] = clave_secreta;
            }

            for (int i = 0; i < clave.length; i++) { // Indicar si la posición de la clave es igual, mayor o menor
                if (clave_descifrada[i] == clave[i]) {
                    resultados[i] = "ok";
                } else if (clave_descifrada[i] > clave[i]) {
                    resultados[i] = "-";
                } else if (clave_descifrada[i] < clave[i]){
                    resultados[i] = "+";
                }
            }

            String r = Arrays.toString(resultados);
            System.out.println("\n" + r + "\n");
            intentos++; // Incrementar el número de intentos
        }
        System.out.println("HAS DESBLOQUEADO LA CÁMARA");
        System.out.println("INTENTOS: " + intentos);
    }

    public static void main(String[] args) {
        juegoCamaraSecreta();
    }
}