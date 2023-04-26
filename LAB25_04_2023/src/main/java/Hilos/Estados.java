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
public class Estados {
    public Thread t1;
    public EstadoHiloT1 o1;
    
    public void ejecutar(){
        o1 = new EstadoHiloT1();
        t1 = new Thread(o1);
        o1.setT1(t1);
        System.out.println("Estado de t1 es "+ t1.getState());
        //invocamos el método start() para t1
        t1.start();
        //ahora, el hilo t1 se movió al estado de preparado o runnable
        System.out.println("Después de invocar el método de start(), el estado de t1 es "+t1.getState());
    }
}
