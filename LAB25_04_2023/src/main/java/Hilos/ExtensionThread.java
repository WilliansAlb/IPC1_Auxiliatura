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
public class ExtensionThread extends Thread {
    public void run(){
        System.out.println("El hilo empezó y se dormirá 1 segundo...");
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        System.out.println("El hilo se despertó y terminó su ejecución");
    }
}
