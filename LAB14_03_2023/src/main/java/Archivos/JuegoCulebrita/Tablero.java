/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos.JuegoCulebrita;

import java.io.Serializable;
import java.util.Random;

/**
 *
 * @author willi
 */
public class Tablero implements Serializable {

    private Casilla[][] casillas;
    private int tamanioX;
    private int tamanioY;
    private int dificultad;
    private int numeroObstaculos;
    private int[] posicionesDisponibles;
    private Jugador player;

    public Casilla[][] getCasillas() {
        return casillas;
    }

    public void setCasillas(Casilla[][] casillas) {
        this.casillas = casillas;
    }

    public Jugador getPlayer() {
        return player;
    }

    public void setPlayer(Jugador player) {
        this.player = player;
    }

    
    
    /**
     * Constructor de tablero al que se le envian las dimensiones del tablero,
     * la dificultad y los obstaculos
     *
     * @param tamanioX
     * @param tamanioY
     * @param dificultad
     * @param numeroObstaculos
     */
    public Tablero(int tamanioX, int tamanioY, int dificultad, int numeroObstaculos) {
        casillas = new Casilla[tamanioY][tamanioX];
        this.dificultad = dificultad;
        this.numeroObstaculos = numeroObstaculos;
        this.posicionesDisponibles = new int[tamanioX * tamanioY];
        this.player = new Jugador("W",-1,-1);
    }

    public void iniciarTableroVacio() {
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                casillas[i][j] = new Casilla(null);
                posicionesDisponibles[i * casillas[i].length + j] = i * casillas[i].length + j;
            }
        }
    }

    public void agregarObstaculos() {
        for (int i = 0; i < numeroObstaculos; i++) {
            agregar(new Obstaculo(),false);
        }
    }

    public void agregar(Elemento caracter, boolean tieneJugador) {
        Random aleatorio = new Random();
        int posicion = aleatorio.nextInt(posicionesDisponibles.length);
        int lugar = posicionesDisponibles[posicion];
        int posicionX = lugar % casillas.length;
        int posicionY = lugar / casillas.length;
        if (tieneJugador) {
            casillas[posicionY][posicionX].setTieneJugador(true);
            player.setPosicionX(posicionX);
            player.setPosicionY(posicionY);
            
        } else {
            casillas[posicionY][posicionX].setTipo(caracter);
        }
        borrarElementoDisponibles(posicion);
    }

    public void agregarPremios() {
        for (int i = 0; i < dificultad * 2; i++) {
            agregar(new Manzana("O"),false);
        }
    }

    public void agregarCulebra() {
        agregar(null,true);
    }

    public void borrarElementoDisponibles(int posicion) {
        int[] nuevoDisponibles;
        if (posicionesDisponibles.length > 1) {
            nuevoDisponibles = new int[posicionesDisponibles.length - 1];
        } else {
            nuevoDisponibles = null;
        }
        int conteo = 0;
        for (int i = 0; i < posicionesDisponibles.length; i++) {
            if (i != posicion) {
                nuevoDisponibles[conteo] = posicionesDisponibles[i];
                conteo++;
            }
        }
        posicionesDisponibles = nuevoDisponibles;
    }

    public void imprimirTablero() {
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                System.out.print(" ");
                System.out.print(casillas[i][j].getPrimeraUltimaFila());
                System.out.print(" ");
            }
            System.out.println("");
            for (int j = 0; j < casillas[i].length; j++) {
                System.out.print(" ");
                System.out.print(casillas[i][j].getCaracter());
                System.out.print(" ");
            }
            System.out.println("");
            for (int j = 0; j < casillas[i].length; j++) {
                System.out.print(" ");
                System.out.print(casillas[i][j].getPrimeraUltimaFila());
                System.out.print(" ");
            }
            System.out.println("");
            System.out.println("");
        }
    }

    public int getTamanioX() {
        return tamanioX;
    }

    public void setTamanioX(int tamanioX) {
        this.tamanioX = tamanioX;
    }

    public int getTamanioY() {
        return tamanioY;
    }

    public void setTamanioY(int tamanioY) {
        this.tamanioY = tamanioY;
    }

    public int getDificultad() {
        return dificultad;
    }

    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }

    public int getNumeroObstaculos() {
        return numeroObstaculos;
    }

    public void setNumeroObstaculos(int numeroObstaculos) {
        this.numeroObstaculos = numeroObstaculos;
    }
    
    
}
