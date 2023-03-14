/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import java.io.Serializable;

/**
 *
 * @author willi
 */
public class Casilla implements Serializable {
    private Elemento tipo;
    private boolean tieneJugador;

    public Elemento getTipo() {
        return tipo;
    }
    
    public String getCaracter(){
        if (tipo!=null){
            return tipo.getCaracter();
        } else if (tieneJugador){
            return "C";
        } else {
            return "-";
        }
    }

    public void setTipo(Elemento tipo) {
        this.tipo = tipo;
    }

    public boolean isTieneJugador() {
        return tieneJugador;
    }

    public void setTieneJugador(boolean tieneJugador) {
        this.tieneJugador = tieneJugador;
    }

    public Casilla(Elemento tipo) {
        this.tipo = tipo;
        this.tieneJugador = false;
    }
}
