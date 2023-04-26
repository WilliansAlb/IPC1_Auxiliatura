/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hilos;

import java.util.logging.Logger;

/**
 *
 * @author willi
 */
public class EjemploVolatil {

    public volatile int INT_VOLATIL = 0;

    public void ejecutar() {
        HiloEscuchante t1 = new HiloEscuchante(this);
        HiloModificador t2 = new HiloModificador(this);
        t1.start();
        t2.start();
    }
}
