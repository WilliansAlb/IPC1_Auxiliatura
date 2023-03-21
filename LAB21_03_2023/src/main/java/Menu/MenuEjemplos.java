/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Archivos.Ejemplo1.Garabitas;
import Archivos.Ejemplo2.EscribirTexto;
import Archivos.Ejemplo2.LeerTexto;
import Ordenacion.Seleccion;
import java.util.Scanner;

/**
 *
 * @author willi
 */
public class MenuEjemplos {

    public static void main(String[] args) {
        System.out.println("Bienvenido a los ejemplos del laboratorio del día 21 de marzo de 2023");
        System.out.println("1. Ejemplo 1: escritura de datos con DataOutputStream");
        System.out.println("2. Ejemplo 1: lectura de datos con DataInputStream");
        System.out.println("3. Ejemplo 2: lectura de archivo de texto con BufferedReader");
        System.out.println("4. Ejemplo 2: escritura de archivo de texto con PrintWriter");
        System.out.println("5. Ejemplo 3: algoritmo de ordenación por selección");
        Scanner s = new Scanner(System.in);
        int seleccion = s.nextInt();

        Garabitas meteorologico = new Garabitas();
        LeerTexto lectura = new LeerTexto();
        EscribirTexto escritura = new EscribirTexto();
        switch (seleccion) {
            case 1:
                meteorologico.escribirDatos(s);
                break;
            case 2:
                meteorologico.leerDatos();
                break;
            case 3:
                lectura.leerTextoArchivo("ejemplo2");
                break;
            case 4:
                escritura.escribirDistancia("distancias");
                break;
            case 5:
                Seleccion algoritmoSeleccion = new Seleccion();
                int[] aOrdenar = {51,21,39,80,36};
                algoritmoSeleccion.ordenar(aOrdenar);
                break;
            default:
                System.out.println("Ingresa una opción valida");
        }
    }
}
