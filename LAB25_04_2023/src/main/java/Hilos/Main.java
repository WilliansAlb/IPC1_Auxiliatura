/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hilos;

import java.util.Scanner;

/**
 *
 * @author willi
 */
public class Main {

    public static void main(String[] args) {
        menuHilos();
    }

    public static void menuHilos() {
        System.out.println("Menu contenidos vistos en el laboratorio del 25-04-203");
        Scanner scan = new Scanner(System.in);
        System.out.println("1.\tEjemplo hilo creado mediante extender de la clase Thread");
        System.out.println("2.\tEjemplo hilo creado mediante implementar la interfaz Runnable");
        System.out.println("3.\tEjemplo que muestra los estados de dos hilos");
        System.out.println("4.\tEjemplo que muestra el uso de una variable volatile para controlar hilos");
        System.out.println("5.\tEjemplo que muestra el uso de interrumpt() para controlar hilos");
        System.out.println("6.\tEjemplo de una carrera de caballos, donde cada caballo avanza cierta distancia a cada intervalo de tiempo");
        int opcion = scan.nextInt();
        switch (opcion) {
            case 1: {
                ExtensionThread extension = new ExtensionThread();
                extension.start();
                break;
            }
            case 2: {
                ImplementacionRunnable implementacion = new ImplementacionRunnable();
                Thread implementacionHilo = new Thread(implementacion);
                implementacionHilo.start();
                break;
            }
            case 3: {
                Estados ejemploEstados = new Estados();
                ejemploEstados.ejecutar();
                break;
            }
            case 4: {
                EjemploVolatil ev = new EjemploVolatil();
                ev.ejecutar();
                break;
            }
            case 5: {
                new HiloInterrupt().ejecutar();
                break;
            }
            case 6: {
                new Carrera().iniciar();
                break;
            }
            default:{
                System.out.println("Elige un número valido");
                menuHilos();
            }
        }
    }
}
