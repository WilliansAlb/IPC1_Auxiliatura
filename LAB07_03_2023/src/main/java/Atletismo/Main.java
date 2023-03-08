/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Atletismo;

import java.util.Scanner;

/**
 *
 * @author willi
 */
public class Main {
    public static void main(String[] args) {
        Scanner escaner = new Scanner(System.in);
        int sumaTiempos;
        int promedio;
        int diasEntrenados;
        int tiemposMenores;
        boolean entrenamientoInterrumpido;
        boolean entrenamientoFinalizado;
        sumaTiempos = 0;
        promedio = 0;
        diasEntrenados = 0;
        tiemposMenores = 0;
        entrenamientoInterrumpido = false;
        entrenamientoFinalizado = true;
        System.out.println("Ingresa cuantos dias serán del entrenamiento");
        diasEntrenados = escaner.nextInt();
        for (int i = 0; i < diasEntrenados; i++) {
            System.out.println("Ingresa el tiempo del día");
            escaner = new Scanner(System.in);
            int tiempo = escaner.nextInt();
            if (tiempo > 20){
                entrenamientoInterrumpido = true;
                break;
            } else {
                if (tiempo < 15){
                    tiemposMenores++;
                }
                sumaTiempos+= tiempo;
            }
        }
        /**
        do {
            System.out.println("Ingresa el tiempo del día");
            escaner = new Scanner(System.in);
            int tiempo = escaner.nextInt();
            if (tiempo > 20){
                entrenamientoInterrumpido = true;
            } else {
                if (tiempo < 15){
                    tiemposMenores++;
                }
                sumaTiempos+= tiempo;
                diasEntrenados++;
                System.out.println("¿Continua el"
                        + " entrenamiento? s/n");
                String eleccionEntrenador = "";
                escaner = new Scanner(System.in);
                eleccionEntrenador = escaner.nextLine();
                System.out.println(eleccionEntrenador);
                if (eleccionEntrenador.equalsIgnoreCase("n")){
                    entrenamientoFinalizado = true;
                }
            }
        } while (!entrenamientoFinalizado &&
                !entrenamientoInterrumpido);
                * */
        promedio = sumaTiempos/diasEntrenados;
        if (!entrenamientoInterrumpido && 
                promedio <= 18 && tiemposMenores > 0){
            System.out.println("El atleta es apto para ir a las olimpiadas");
        } else {
            System.out.println("El atleta no es apto para ir a las olimpiadas");
        }
        
        System.out.println("Entrenamiento finalizado en "+diasEntrenados+ " días, con "+
                tiemposMenores + "días con tiempos menores a 15 y un promedio de "+ promedio);
    }
}
