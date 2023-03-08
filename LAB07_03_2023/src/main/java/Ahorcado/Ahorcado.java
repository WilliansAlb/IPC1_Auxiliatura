/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ahorcado;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author willi
 */
public class Ahorcado {

    public static void main(String[] args) {
        Scanner escaner = new Scanner(System.in);
        String[] palabras = {"programacion", "objetos", "java", "polimorfismo"};
        Random aleatorio = new Random();
        String elegida = palabras[aleatorio.nextInt(palabras.length)];
        char[] descubiertas = new char[elegida.length()];
        for (int i = 0; i < descubiertas.length; i++) {
            descubiertas[i] = '*';
        }
        int errores = 0;
        System.out.println("Bienvenido al juego del Ahorcado");
        boolean juegoTerminado = false;
        imprimirEstado(descubiertas);
        while (errores < 6 && !juegoTerminado) {
            System.out.println("Ingresa una letra");
            escaner = new Scanner(System.in);
            char letra = escaner.nextLine().charAt(0);
            boolean letraEnPalabra = false;
            for (int i = 0; i < elegida.length(); i++) {
                if (elegida.charAt(i) == letra) {
                    descubiertas[i] = letra;
                    letraEnPalabra = true;
                }
            }
            if (letraEnPalabra) {
                int incognitas = 0;
                for (int i = 0; i < descubiertas.length; i++) {
                    if (descubiertas[i] == '*') {
                        incognitas++;
                    }
                }
                System.out.println("");
                imprimirEstado(descubiertas);
                imprimirErrores(errores);
                if (incognitas == 0) {
                    juegoTerminado = true;
                    System.out.println("Ganaste! :)");
                }
            } else {
                errores++;
                if (errores < 6) {
                    System.out.println("");
                    System.out.println("Errores: " + errores);
                    imprimirErrores(errores);
                    imprimirEstado(descubiertas);
                } else {
                    juegoTerminado = true;
                    System.out.println("");
                    System.out.println("Perdiste :( la palabra era " + elegida);
                    imprimirErrores(errores);
                }
            }
        }
    }

    public static void imprimirErrores(int errores) {
        String ahorcado = "_________________\n|               |";
        if (errores >= 1) {
            ahorcado += "\n|               o";
        }
        if (errores == 2) {
            ahorcado += "\n|               |";
        }
        if (errores == 3) {
            ahorcado += "\n|              /|";
        }
        if (errores >= 4) {
            ahorcado += "\n|              /|\\";
        }
        if (errores == 5) {
            ahorcado += "\n|              / ";
        }
        if (errores == 6) {
            ahorcado += "\n|              / \\";
        }
        for (int i = 0; i < 3; i++) {
            ahorcado += "\n|               ";
        }

        ahorcado += "\n|_______________";
        System.out.println(ahorcado);
    }

    public static void imprimirEstado(char[] descubiertas) {
        System.out.println("Estado de la palabra");
        for (int i = 0; i < descubiertas.length; i++) {
            System.out.print(descubiertas[i]);
        }
        System.out.println("");
    }
}
