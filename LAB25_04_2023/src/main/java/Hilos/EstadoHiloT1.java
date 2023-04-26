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
public class EstadoHiloT1 implements Runnable{
    private Thread t1;

    public Thread getT1() {
        return t1;
    }

    public void setT1(Thread t1) {
        this.t1 = t1;
    }
    
    
    
    @Override
    public void run() {
        EstadoHiloT2 o2 = new EstadoHiloT2();
        //El hilo t2 está en el estado nuevo
        Thread t2 = new Thread(o2);
        o2.setT1(t1);
        t2.start();
        //El hilo es movido al estado de preparado gracias a start()
        System.out.println("Estado del hilo t2, despues de llamar al método start() es "+t2.getState());
        //Creamos un try-catch para colocar al hilo t1 en espera
        try{
            Thread.sleep(202);
        }catch (InterruptedException i2){
            i2.printStackTrace();
        }
        System.out.println("Estado del hilo t2 despues de invocar el método sleep() es "+t2.getState());
        try{
            t2.join();
            System.out.println("Estado del hilo t2 despues de join() es "+t2.getState());
        } catch(InterruptedException i){
            i.printStackTrace();
        }
        System.out.println("Estado del hilo t1 despues de completar su ejecución es "+t1.getState());
    }
    
}
