/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab28_02_2023;

/**
 *
 * @author willi
 */
public class VehiculoPesado extends Vehiculo {

    private int peso;

    public VehiculoPesado(int velocidad, double efectividad, int peso) {
        super(velocidad, efectividad, true);
        this.peso = peso;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    @Override
    public String paraImprimir() {
        return "Vehiculo Pesado";
    }

    @Override
    public void avanzar(int tiempo) {
        if (super.estaEnCarrera()) {
            if (peso >= 50 && super.getPosicion() > 400) {
                System.out.println("El Vehiculo Pesado ya no puede avanzar más");
                super.setEstaEnCarrera(false);
            } else {
                super.calcularNuevaPosicion(tiempo);
            }
        }
    }
}
