/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab28_02_2023;

/**
 *
 * @author willi
 */
public class Main {

    public static void main(String[] args) {
        Vehiculo[] listado = new Vehiculo[3];
        listado[0] = new VehiculoDeportivo(50,0.6,5000);
        listado[1] = new VehiculoPesado(30,0.7,30);
        listado[2] = new VehiculoCarrera(45,0.65,50);
        
        for (int i = 0; i < listado.length; i++) {
            listado[i].setPosicion(0);
        }
        
        boolean estaCompletada = false;
        int horas = 0;
        while (!estaCompletada){
            for (int i = 0; i < listado.length; i++) {
                listado[i].avanzar(1);
                if (listado[i].getPosicion() >= 5000){
                    System.out.println("El " + listado[i].paraImprimir() + 
                            " completó la carrera en " + horas + " horas");
                    estaCompletada = true;
                    break;
                }
            }
            if (horas%50==0){
                System.out.println("Estado actual de " + horas + " horas.");
                for (int i = 0; i < listado.length; i++) {
                    System.out.println(listado[i].paraImprimir() + ": " +listado[i].getPosicion());
                }
                System.out.println("");
            }
            horas++;
        }
        //System.out.println(factorial(5));
    }
    
    public static int factorial(int numero){
        if (numero == 0){
            return 1;
        } else {
            return numero * factorial(numero-1);
        }
    }
}
