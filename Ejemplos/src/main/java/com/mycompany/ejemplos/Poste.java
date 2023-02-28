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
public class Poste {
    private Disco[] discos;
    
    public Poste(int numeroDiscos){
        this.discos = new Disco[numeroDiscos];
    }
    
    public int obtenerTamanioUltimoDisco(){
        int tamanioUltimo = discos.length+1;
        for (int i = (discos.length-1); i >= 0; i--) {
            if (discos[i] != null){
                tamanioUltimo = discos[i].getTamanio();
                break;
            }
        }
        return tamanioUltimo;
    }
    
    public boolean verificarDisco(Disco aColocar){
        int ultimo = obtenerTamanioUltimoDisco();
        return aColocar.getTamanio() < ultimo;
    }
    
    public void colocarDisco(Disco aColocar){
        for (int i = 0; i < discos.length; i++) {
            if (discos[i] == null){
                discos[i] = aColocar;
                break;
            }
        }
    }
    
    public Disco sacarDisco(){
        Disco disco = null;
        for (int i = (discos.length-1); i >= 0; i--) {
            if (discos[i] != null){
                disco = discos[i];
                discos[i] = null;
                break;
            }
        }
        return disco;
    }
    
    public void imprimirFila(int numero){
        if (discos[numero]!=null){
            System.out.print(discos[numero].getDisco());
        } else {
            for (int i = 0; i < discos.length; i++) {
                System.out.print("-");
            }
        }
    }

    public Disco[] getDiscos() {
        return discos;
    }

    public void setDiscos(Disco[] discos) {
        this.discos = discos;
    }
    
    
}
