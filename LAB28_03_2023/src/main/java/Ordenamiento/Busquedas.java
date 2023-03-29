/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ordenamiento;

/**
 *
 * @author willi
 */
public class Busquedas {

    public static void main(String[] args) {
        int valor = 40;
        int[] arreglo = {-8, 4, 5, 9, 12, 18, 25, 40, 60};
        int[] arreglo2 = {17, 2, 0, 19, 22, 40, 20, 15, 11};
        System.out.println("Busqueda secuencial");
        System.out.println("¿Está el valor " + 40 + " en el siguiente arreglo?");
        Shell.imprimirArreglo(arreglo2);
        System.out.println(busquedaSecuencial(valor,arreglo));
        System.out.println("Busqueda binaria");
        System.out.println("¿Está el valor " + 40 + " en el siguiente arreglo?");
        Shell.imprimirArreglo(arreglo);
        System.out.println(busquedaBinaria(valor,arreglo));
    }

    public static boolean busquedaSecuencial(int elemento, int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            if (elemento==arreglo[i]){
                return true;
            }
        }
        return false;
    }

    public static boolean busquedaBinaria(int elemento, int[] arreglo) {
        int central, bajo, alto;
        int valorCentral;
        bajo = 0;
        alto = arreglo.length - 1;
        while (bajo <= alto) {
            central = (bajo + alto) / 2; // índice de elemento central 
            valorCentral = arreglo[central]; // valor del índice central 
            if (elemento == valorCentral) {
                return true; // encontrado, devuelve posición 
            } else if (elemento < valorCentral) {
                alto = central - 1; // ir a sublista inferior 
            } else {
                bajo = central + 1; // ir a sublista superior 
            }
        }
        return false;
    }
}
