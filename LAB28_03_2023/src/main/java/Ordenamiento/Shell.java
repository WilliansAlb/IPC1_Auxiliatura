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
public class Shell {

    public static void main(String[] args) {
        metodoShell(new int[]{6, 1, 5, 2, 3, 4, 0});
    }

    public static void metodoShell(int[] arreglo) {
        int n = arreglo.length;
        for (int salto = n / 2; salto > 0; salto /= 2) {
            System.out.println("Salto "+salto);
            for (int i = salto; i < n; i++) {
                int temporal = arreglo[i];
                int j;
                for (j = i; j >= salto && arreglo[j - salto] > temporal; j -= salto) {
                    System.out.println("Intercambia " + arreglo[j] + " por " + arreglo[j - salto]);
                    arreglo[j] = arreglo[j - salto];
                }
                arreglo[j] = temporal;
                System.out.println("Inserta "+arreglo[j]);
            }
        }
    }

    public static void imprimirArreglo(int[] a) {
        System.out.print("arreglo = {");
        for (int i = 0; i < a.length; i++) {
            if (i < a.length - 1) {
                System.out.print(a[i] + ", ");
            } else {
                System.out.print(a[i]);
            }
        }
        System.out.println("}");
    }
}
