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
public class Jugador implements Serializable{

    private String caracter;
    private int posicionX;
    private int posicionY;
    private int manzanasComidas;
    private boolean jugando;

    public boolean isJugando() {
        return jugando;
    }

    public void setJugando(boolean jugando) {
        this.jugando = jugando;
    }
    

    public String getCaracter() {
        return caracter;
    }

    public void setCaracter(String caracter) {
        this.caracter = caracter;
    }

    public int getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }

    public int getManzanasComidas() {
        return manzanasComidas;
    }

    public void setManzanasComidas(int manzanasComidas) {
        this.manzanasComidas = manzanasComidas;
    }

    public Jugador(String caracter, int posicionX, int posicionY) {
        this.caracter = caracter;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.jugando = false;
    }

    public void mover(Casilla[][] tablero, char direccion) {
        tablero[posicionY][posicionX].setTieneJugador(false);
        switch (direccion) {
            case 'w':
                if ((posicionY - 1) >= 0) {
                    posicionY--;
                }
                break;
            case 's':
                if ((posicionY + 1) < tablero.length) {
                    posicionY++;
                }
                break;
            case 'a':
                if ((posicionX - 1) >= 0) {
                    posicionX--;
                }
                break;
            case 'd':
                if ((posicionX + 1) < tablero[posicionY].length) {
                    posicionX++;
                }
                break;
            default:
                System.out.println("Elige bien");
                break;
        }
        if (tablero[posicionY][posicionX].getTipo() != null) {
            tablero[posicionY][posicionX].getTipo().pasar(this);
            tablero[posicionY][posicionX].setTipo(null);
            if (manzanasComidas < 0) {
                jugando = false;
            }
        }
        tablero[posicionY][posicionX].setTieneJugador(true);
    }
}
