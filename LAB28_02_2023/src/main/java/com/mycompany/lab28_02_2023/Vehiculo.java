/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab28_02_2023;

import java.util.Random;

/**
 *
 * @author willi
 */
public abstract class Vehiculo {
    private int velocidad;
    private double efectividad;
    private int posicion;
    private boolean estaEnCarrera;

    public Vehiculo(int velocidad, double efectividad, boolean estaEnCarrera) {
        this.velocidad = velocidad;
        this.efectividad = efectividad;
        this.posicion = 0;
        this.estaEnCarrera = estaEnCarrera;
    }

    public boolean estaEnCarrera() {
        return estaEnCarrera;
    }

    public void setEstaEnCarrera(boolean estaEnCarrera) {
        this.estaEnCarrera = estaEnCarrera;
    }
    
    public int getVelocidad(){
        return velocidad;
    }
    
    public void setVelocidad(int velocidad){
        this.velocidad = velocidad;
    }

    public double getEfectividad() {
        return efectividad;
    }

    public void setEfectividad(double efectividad) {
        this.efectividad = efectividad;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
    
    public abstract String paraImprimir();
    
    public void calcularNuevaPosicion(int tiempo){
        posicion = posicion + (int)(velocidad * efectividad * tiempo);
    }
    
    public abstract void avanzar(int tiempo);
}
