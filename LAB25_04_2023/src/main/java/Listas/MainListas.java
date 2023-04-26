/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listas;

import java.util.Scanner;

/**
 *
 * @author willi
 */
public class MainListas {

    public static void main(String[] args) {
        menuListas();
    }

    public static void menuListas() {
        System.out.println("Menu contenidos vistos en el laboratorio del 25-04-203");
        Scanner scan = new Scanner(System.in);
        System.out.println("1.\tEjemplo lista simplemente enlazada");
        System.out.println("2.\tEjemplo lista doblemente enlazada");
        System.out.println("3.\tEjemplo lista circular simple");
        System.out.println("4.\tEjemplo lista circular doble");
        int opcion = scan.nextInt();
        switch (opcion) {
            case 1: {
                ListaSimple listaSimple = new ListaSimple();
                listaSimple.insertarInicio(1);
                listaSimple.insertarInicio(2);
                listaSimple.insertarFinal(0);
                listaSimple.insertarFinal(4);
                System.out.println("Listando elementos que fueron insertados");
                listaSimple.listarElementos();
                listaSimple.eliminarElemento(0);
                System.out.println("Listado elementos luego de eliminar elementos");
                listaSimple.listarElementos();
                break;
            }
            case 2: {
                ListaDoble listaDoble = new ListaDoble();
                listaDoble.insertarInicio(1);
                listaDoble.insertarInicio(2);
                listaDoble.insertarFinal(0);
                listaDoble.insertarFinal(4);
                System.out.println("Listando elementos que fueron insertados");
                listaDoble.listarElementos();
                listaDoble.eliminarFinal();
                listaDoble.eliminarInicio();
                System.out.println("Listado elementos luego de eliminar elementos");
                listaDoble.listarElementos();
                break;
            }
            case 3: {
                ListaCircularSimple listaCircular = new ListaCircularSimple();
                listaCircular.insertarInicio(1);
                listaCircular.insertarFinal(2);
                listaCircular.insertarInicio(3);
                listaCircular.insertarFinal(4);
                System.out.println("Listando elementos que fueron insertados");
                listaCircular.listarElementos();
                listaCircular.eliminarFinal();
                listaCircular.eliminarInicio();
                System.out.println("Listado elementos luego de eliminar elementos");
                listaCircular.listarElementos();
                break;
            }
            case 4: {
                ListaCircularDoble listaCircularDoble = new ListaCircularDoble();
                listaCircularDoble.insertarInicio(1);
                listaCircularDoble.insertarFinal(2);
                listaCircularDoble.insertarInicio(3);
                listaCircularDoble.insertarFinal(4);
                System.out.println("Listando elementos que fueron insertados");
                listaCircularDoble.listarElementos();
                listaCircularDoble.eliminarInicio();
                listaCircularDoble.eliminarFinal();
                System.out.println("Listado luego de eliminar elementos");
                listaCircularDoble.listarElementos();
                break;
            }
            default: {
                System.out.println("Elige un número valido");
                menuListas();
            }
        }
    }
}
