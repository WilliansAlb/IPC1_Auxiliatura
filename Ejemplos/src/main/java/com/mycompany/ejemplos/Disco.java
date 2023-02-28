/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejemplos;

/**
 *
 * @author willi
 */
public class Disco {
    private String disco;
    private int tamanio;

    public Disco(int tamanio) {
        this.tamanio = tamanio;
        String imagenDisco = "";
        for (int i = 1; i <= 5; i++) {
            if (i <= tamanio) {
                imagenDisco += "x";
            } else {
                imagenDisco += " ";
            }
        }
        this.disco = imagenDisco;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public String getDisco() {
        return disco;
    }
}
