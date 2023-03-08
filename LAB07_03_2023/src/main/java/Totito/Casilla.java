/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Totito;

/**
 *
 * @author willi
 */
public class Casilla {

    private String casila;
    private int id;
    public final String PRIMERA_ULTIMA_FILA = "---";

    public Casilla(String casila, int id) {
        this.casila = casila;
        this.id = id;
    }

    public String getCasila() {
        return casila;
    }

    public void setCasila(String casila) {
        this.casila = casila;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void imprimirPrimeraUltimaFila() {
        System.out.print("---");
    }

    public void imprimirCasilla() {
        if (casila.equalsIgnoreCase("-")) {
            System.out.print("-" + id + "-");
        } else {
            System.out.print("-" + casila + "-");
        }
    }
}
