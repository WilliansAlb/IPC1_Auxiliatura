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
public class Posicion implements Serializable{
    private int x;
    private int y;
    
    public Posicion(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public void setPosicionNueva(Casilla[][] tablero, Posicion nueva){
        tablero[y][x].setTieneJugador(false);
        y = nueva.getY();
        x = nueva.getX();
        tablero[y][x].setTieneJugador(true);
    }
    
}
