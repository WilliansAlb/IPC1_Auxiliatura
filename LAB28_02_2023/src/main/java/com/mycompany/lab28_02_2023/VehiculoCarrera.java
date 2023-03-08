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
public class VehiculoCarrera extends Vehiculo {

    private int turbo;
    
    public VehiculoCarrera(int velocidad, double efectividad, int turbo) {
        super(velocidad, efectividad,true);
        this.turbo = turbo;
    }

    public void setTurbo(int turbo) {
        this.turbo = turbo;
    }

    public int getTurbo() {
        return turbo;
    }
    
    @Override
    public String paraImprimir() {
        return "Vehiculo de Carreras";
    }

    @Override
    public void avanzar(int tiempo) {
        if (turbo > 0){
            super.setPosicion(super.getPosicion()+1);
            super.calcularNuevaPosicion(tiempo);
            turbo = turbo - 1;
        } else {
            super.calcularNuevaPosicion(tiempo);
        }
    }
    
}
