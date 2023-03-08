/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Buscaminas;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author willi
 */
public class Buscaminas {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ANSI_BLUE = "\u001B[34m";
        String ANSI_RESET = "\u001B[0m";
        String[][] tab = new String[5][5];
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                tab[i][j] = ANSI_BLUE + "~" + ANSI_RESET;
                System.out.print(tab[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("--------");
        for (int i = 0; i < 10; i++) {
            Random aleatorio = new Random();
            int posicion = aleatorio.nextInt(5 * 5);
            int posicionY = posicion / 5;
            int posicionX = posicion % 5;
            tab[posicionY][posicionX] = "\u001B[31m" + "O" + ANSI_RESET;
        }
        imprimir(tab);
        for (int i = 0; i < 10; i++) {
            System.out.println("¿Qué casilla quieres verificar?");
            int posicionElegida = sc.nextInt();
            int posicionY = posicionElegida / 5;
            int posicionX = posicionElegida % 5;
            if (tab[posicionY][posicionX].equalsIgnoreCase("\u001B[31m" + "O" + ANSI_RESET)) {
                System.out.println("Encontraste una bomba");
            }
        }
    }

    public static void imprimir(String[][] tab) {
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                System.out.print(tab[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
