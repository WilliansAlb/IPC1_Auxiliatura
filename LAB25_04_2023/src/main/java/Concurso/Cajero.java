/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Concurso;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author willi
 */
public class Cajero extends Thread{
    private final Concurso concurso;
    private final int tiempoProductoLiviano;
    private final int tiempoProductoPesado;
    private final int tiempoPagoTarjeta;
    private final int tiempoPagoEfectivo;
    private int productos;
    private final String nombre;

    public Cajero(Concurso concurso, String nombre, double tiempoProductoLiviano, double tiempoProductoPesado,
            double tiempoPagoTarjeta, double tiempoPagoEfectivo) {
        this.concurso = concurso;
        this.nombre = nombre;
        this.tiempoProductoLiviano = (int)(1000*tiempoProductoLiviano);
        this.tiempoProductoPesado = (int)(1000*tiempoProductoPesado);
        this.tiempoPagoTarjeta = (int)(1000*tiempoPagoTarjeta);
        this.tiempoPagoEfectivo = (int)(1000*tiempoPagoEfectivo);
    }

    @Override
    public void run() {
        while (concurso.isEjecutandose()){
            Random r = new Random();
            if (r.nextInt(2)==0){
                try {
                    Thread.sleep(tiempoProductoLiviano);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Cajero.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    Thread.sleep(tiempoProductoPesado);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Cajero.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            productos++;
        }
        System.out.println("El Cajero "+nombre+" juntó "+productos);
    }
    
    
}
