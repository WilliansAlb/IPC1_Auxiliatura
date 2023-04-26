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
public class HiloEscuchante extends Thread {

        EjemploVolatil ej;
        
        public HiloEscuchante(EjemploVolatil ej){
            this.ej = ej;
        }
    
        @Override
        public void run() {
            int valor_local = ej.INT_VOLATIL;
            while (valor_local < 5) {
                if (valor_local != ej.INT_VOLATIL) {
                    System.out.println(
                            "Capturado cambio en el valor de INT_VOLATIL : "
                            + ej.INT_VOLATIL);
                    valor_local = ej.INT_VOLATIL;
                }
            }
        }
    }
