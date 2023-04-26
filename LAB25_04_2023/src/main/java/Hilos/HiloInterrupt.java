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
public class HiloInterrupt {
    
    public void ejecutar(){
        Hilo t1 = new Hilo();
        try {
            t1.start();
            Thread.sleep(1);
            t1.interrupt();
            Thread.sleep(5);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Saliendo del hilo principal");
    }
    
    public class Hilo extends Thread{
        @Override
        public void run(){
            while (!Thread.interrupted()){
                System.out.println("El hilo esta corriendo");
            }
            System.out.println("Hilo detenido");
        }
    }
}
