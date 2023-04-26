/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hilos;

/**
 *
 * @author willi
 */
public class HiloModificador extends Thread {

    EjemploVolatil ej;

    public HiloModificador(EjemploVolatil ej) {
        this.ej = ej;
    }

    @Override
    public void run() {
        int valor_local = ej.INT_VOLATIL;
        while (ej.INT_VOLATIL < 5) {
            System.out.println(
                    "Incrementando el valor de INT_VOLATIL a "
                    + (valor_local + 1));
            ej.INT_VOLATIL = ++valor_local;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
