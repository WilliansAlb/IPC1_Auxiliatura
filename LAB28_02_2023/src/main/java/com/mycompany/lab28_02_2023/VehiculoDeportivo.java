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
public class VehiculoDeportivo extends Vehiculo {

    private int alertaKilometros;

    public VehiculoDeportivo(int velocidad, double efectividad, int alertaKilometros) {
        super(velocidad, efectividad, true);
        this.alertaKilometros = alertaKilometros;
    }

    @Override
    public String paraImprimir() {
        return "Vehiculo Deportivo";
    }

    @Override
    public void avanzar(int tiempo) {
        if (super.estaEnCarrera()) {
            if (alertaKilometros <= super.getPosicion()) {
                System.out.println("Al Vehiculo Deportivo se le fundio el motor");
                super.setEstaEnCarrera(false);
            } else if (alertaKilometros > super.getPosicion()) {
                super.calcularNuevaPosicion(tiempo);
            }
        }
    }

    public int getAlertaKilometros() {
        return alertaKilometros;
    }

    public void setAlertaKilometros(int alertaKilometros) {
        this.alertaKilometros = alertaKilometros;
    }

}
