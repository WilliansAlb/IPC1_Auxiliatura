/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Swing;

import java.awt.Toolkit;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author yelbetto
 */
public class Tablero {

    private int x;
    private int y;
    private boolean bombasAleatorias;
    private Casilla[][] casillas;
    private int numeroBombas;

    public Tablero(int x, int y) {
        this.x = x;
        this.y = y;
        this.casillas = new Casilla[y][x];
        numeroBombas = 0;
    }

    public Tablero(int x, int y, boolean bombasAleatorias, Casilla[][] casillas) {
        this.x = x;
        this.y = y;
        this.bombasAleatorias = bombasAleatorias;
        this.casillas = casillas;
    }

    public Tablero(int x, int y, boolean bombasAleatorias) {
        this.x = x;
        this.y = y;
        this.bombasAleatorias = bombasAleatorias;
    }

    public boolean crearTablero(String[] lineas) throws IOException {
        try {
            for (int i = 0; i < lineas.length; i++) {
                String[] caracteres = lineas[i].split(",");
                for (int j = 0; j < caracteres.length; j++) {
                    casillas[i][j] = new Casilla(((int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / casillas.length)) * 2 / 3);
                    casillas[i][j].setId(i * y + j);
                    casillas[i][j].setCoordenadaX(j);
                    casillas[i][j].setCoordenadaY(i);
                    casillas[i][j].bomb = caracteres[j].equalsIgnoreCase("O");
                }
            }
        } catch (IndexOutOfBoundsException ie) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un problema con las dimensiones");
            return false;
        }
        return true;
    }

    public void crearTableroVacio() throws IOException {
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                casillas[i][j] = new Casilla(((int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / casillas.length)) * 2 / 3);
                casillas[i][j].setId(i * y + j);
                casillas[i][j].setCoordenadaX(j);
                casillas[i][j].setCoordenadaY(i);
                casillas[i][j].bomb = false;
                casillas[i][j].flag = false;
            }
        }
    }

    public boolean agregarLinea(String linea, int posicion) throws IOException {
        String[] lineas = linea.split(",");
        if (lineas.length <= x) {
            if (posicion <= y) {
                for (int i = 0; i < lineas.length; i++) {
                    if (lineas[i].equalsIgnoreCase("O")) {
                        casillas[posicion][i].setBomb(casillas, true);
                        numeroBombas++;
                    }
                }
                return true;
            }
        }
        return false;
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

    public boolean isBombasAleatorias() {
        return bombasAleatorias;
    }

    public void setBombasAleatorias(boolean bombasAleatorias) {
        this.bombasAleatorias = bombasAleatorias;
    }

    public Casilla[][] getCasillas() {
        return casillas;
    }

    public void setCasillas(Casilla[][] casillas) {
        this.casillas = casillas;
    }

    public int getNumeroBombas() {
        return numeroBombas;
    }

    public void setNumeroBombas(int numeroBombas) {
        this.numeroBombas = numeroBombas;
    }

}
