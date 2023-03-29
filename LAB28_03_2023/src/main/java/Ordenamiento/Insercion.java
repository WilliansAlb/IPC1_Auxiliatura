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
public class Insercion {

    public static void main(String[] args) {
        metodoInsercion(new int[]{50,20,40,80,30});
    }
    
    public static void metodoInsercion(int[] a) {
        int i, j;
        int aux;
        for (i = 1; i < a.length; i++) {
            /* indice j es para explorar la sublista a[i-1]..a[0] buscando la posicion correcta 
            del elemento destino */
            j = i;
            aux = a[i];
            // se localiza el punto de inserción explorando hacia abajo
            while (j > 0 && aux < a[j - 1]) {
                // desplazar elementos hacia arriba para hacer espacio 
                System.out.println("Intercambia "+a[j]+" con "+a[j-1]);
                a[j] = a[j - 1];
                j--;
            }
            a[j] = aux;
            System.out.println("Inserta "+a[j]);
        }
        Shell.imprimirArreglo(a);
    }
}
