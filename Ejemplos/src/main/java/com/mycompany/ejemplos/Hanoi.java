/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejemplos;

import java.util.Scanner;

/**
 *
 * @author willi
 */
public class Hanoi {

    private Poste[] postes;
    private int numeroDiscos;

    public Hanoi(int numeroDiscos) {
        this.postes = new Poste[3];
        for (int i = 0; i < postes.length; i++) {
            postes[i] = new Poste(numeroDiscos);
        }
        this.numeroDiscos = numeroDiscos;
    }

    public void iniciar() {
        for (int i = 0; i < numeroDiscos; i++) {
            this.postes[0].colocarDisco(new Disco(this.numeroDiscos - i));
        }
        imprimirEstado();
        boolean jugando = true;
        while (jugando) {
            Scanner entrada = new Scanner(System.in);
            System.out.println("¿De que poste quieres mover un disco (1,2,3)?");
            int posteOrigen = entrada.nextInt();
            if (postes[posteOrigen - 1].obtenerTamanioUltimoDisco() < postes[posteOrigen - 1].getDiscos().length) {
                System.out.println("¿A que poste quieres mover el disco (1,2,3)?");
                int posteDestino = entrada.nextInt();
                Disco temporal = postes[posteOrigen - 1].sacarDisco();
                if (postes[posteDestino - 1].verificarDisco(temporal)) {
                    postes[posteDestino - 1].colocarDisco(temporal);
                } else {
                    postes[posteOrigen - 1].colocarDisco(temporal);
                    System.out.println("Movimiento no valido");
                }
                imprimirEstado();
                entrada = new Scanner(System.in);
                System.out.println("¿Deseas continuar (S/N)?");
                String decision = entrada.nextLine();
                jugando = decision.equalsIgnoreCase("S");
            } else {
                System.out.println("El poste que elegiste no tiene discos que mover");
            }
        }
    }

    public void imprimirEstado() {
        for (int j = (numeroDiscos - 1); j >= 0; j--) {
            for (int i = 0; i < postes.length; i++) {
                postes[i].imprimirFila(j);
                System.out.print("  ");
            }
            System.out.println("");
        }
    }
}
