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
public class EstadoHiloT2 implements Runnable{
    private Thread t1;

    public Thread getT1() {
        return t1;
    }

    public void setT1(Thread t1) {
        this.t1 = t1;
    }
    
    @Override
    public void run() {
        //se implementa un try-catch para dormir al hilo
        try {
            Thread.sleep(102);
        } catch (InterruptedException i){
            i.printStackTrace();
        }
        System.out.println("El estado del hilo t1 despues de invocar el join() en el hilo t2 "+t1.getState());
         try {
            Thread.sleep(202);
        } catch (InterruptedException i){
            i.printStackTrace();
        }
    }
    
}
