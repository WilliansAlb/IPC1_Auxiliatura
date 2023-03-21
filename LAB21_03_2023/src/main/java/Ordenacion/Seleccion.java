/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ordenacion;

/**
 *
 * @author willi
 */
public class Seleccion {

    public Seleccion() {
    }

    public void ordenar(int[] aOrdenar) {
        int indiceMenor;
        int temporal;
        for (int i = 0; i < aOrdenar.length - 1; i++) {
            indiceMenor = i;
            for (int j = i + 1; j < aOrdenar.length; j++) {
                if (aOrdenar[j] < aOrdenar[indiceMenor]) {
                    indiceMenor = j;
                }
            }
            if (i != indiceMenor) {
                temporal = aOrdenar[i];
                aOrdenar[i] = aOrdenar[indiceMenor];
                aOrdenar[indiceMenor] = temporal;
            }
        }
        System.out.print("El arreglo queda: {");
        for (int i = 0; i < aOrdenar.length; i++) {
            if (i != (aOrdenar.length - 1)) {
                System.out.print(" " + aOrdenar[i] + ",");
            } else {
                System.out.print(" " + aOrdenar[i] + "}");
            }
        }
    }
}
