/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos.JuegoCulebrita;

import java.io.Serializable;

/**
 *
 * @author willi
 */
public abstract class Elemento implements Serializable{
    private String caracter;
    private String nombre;

    public Elemento(String caracter) {
        this.caracter = caracter;
    }

    public String getCaracter() {
        return caracter;
    }

    public void setCaracter(String caracter) {
        this.caracter = caracter;
    }

    public abstract void pasar(Jugador j);

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
