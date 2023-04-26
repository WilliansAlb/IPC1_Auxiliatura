/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hilos;

import java.util.Random;

/**
 *
 * @author willi
 */
public class Carrera {

    public void iniciar() {
        Caballo[] caballos = new Caballo[4];
        String[] nombres = {"Tiro al blanco", "Mclovin", "Neron", "Bronco"};
        for (int i = 0; i < caballos.length; i++) {
            caballos[i] = new Caballo(nombres[i]);
            caballos[i].start();
        }

        for (int i = 0; i < caballos.length; i++) {
            try {
                caballos[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Carrera terminada");
    }

    public class Caballo extends Thread {

        private String id = "";
        private int distancia = 0;
        private final int MAX_DISTANCE = 1000;
        private Random random = new Random();

        public Caballo(String id) {
            this.id = id;
        }

        @Override
        public void run() {
            while (distancia < MAX_DISTANCE) {
                distancia += random.nextInt(100);
                if (distancia < 1000) {
                    System.out.println("Caballo " + id + " ha recorrido " + distancia + " metros");
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Caballo " + id + " ha cruzado la meta!");
        }
    }
}
