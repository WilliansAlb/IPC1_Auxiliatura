/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Totito;

import java.util.Scanner;

/**
 *
 * @author willi
 */
public class Totito {

    public static void main(String[] args) {
        Casilla[][] tab = new Casilla[3][3];
        String turno = "X";
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                tab[i][j] = new Casilla("-", (i * 3 + j + 1));
            }
        }
        imprimirTablero(tab);
        while (true) {
            System.out.println("¿Donde quieres colocar la " + turno + "?");
            Scanner escaner = new Scanner(System.in);
            int eleccion = escaner.nextInt();
            int posX = (eleccion - 1) % 3;
            int posY = (eleccion - 1) / 3;
            if (tab[posY][posX].getCasila().equalsIgnoreCase("-")) {
                tab[posY][posX].setCasila(turno);
                imprimirTablero(tab);
                if (comprobarLineas(tab, turno)) {
                    System.out.println("Ganaste " + turno);
                    break;
                }
                turno = (turno.equalsIgnoreCase("X")) ? "O" : "X";
            } else {
                System.out.println("Elige una posición vacía");
            }
        }
    }

    public static boolean comprobarLineas(Casilla[][] tab, String turno) {
        //comprobacion lineas verticales
        for (int i = 0; i < 3; i++) {
            if (tab[0][i].getCasila().equalsIgnoreCase(turno) && tab[1][i].getCasila().equalsIgnoreCase(turno)
                    && tab[2][i].getCasila().equalsIgnoreCase(turno)) {
                return true;
            }
        }
        //comprobacion lineas verticales
        for (int i = 0; i < 3; i++) {
            if (tab[i][0].getCasila().equalsIgnoreCase(turno) && tab[i][1].getCasila().equalsIgnoreCase(turno)
                    && tab[i][2].getCasila().equalsIgnoreCase(turno)) {
                return true;
            }
        }
        //comprobacion lineas diagonales
        if (tab[0][0].getCasila().equalsIgnoreCase(turno) && tab[1][1].getCasila().equalsIgnoreCase(turno)
                && tab[2][2].getCasila().equalsIgnoreCase(turno)) {
            return true;
        } else if (tab[0][2].getCasila().equalsIgnoreCase(turno) && tab[1][1].getCasila().equalsIgnoreCase(turno)
                && tab[2][0].getCasila().equalsIgnoreCase(turno)) {
            return true;
        }
        return false;
    }

    public static void imprimirTablero(Casilla[][] tab) {
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                tab[i][j].imprimirPrimeraUltimaFila();
                System.out.print(" ");
            }
            System.out.println("");
            for (int j = 0; j < tab[i].length; j++) {
                tab[i][j].imprimirCasilla();
                System.out.print(" ");
            }
            System.out.println("");
            for (int j = 0; j < tab[i].length; j++) {
                tab[i][j].imprimirPrimeraUltimaFila();
                System.out.print(" ");
            }
            System.out.println("");
            System.out.println("");
        }
    }
}
