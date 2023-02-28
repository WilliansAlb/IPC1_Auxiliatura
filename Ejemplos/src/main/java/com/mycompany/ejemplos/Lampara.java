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
public class Lampara {

    private String estadoLampara;
    private final String tipo;

    public Lampara(String tipo) {
        this.tipo = tipo;
    }

    public void encender() {
        String colorLampara;
        String reset = "\033[0m";
        if (tipo.equalsIgnoreCase("LED")) {
            colorLampara = "\033[36m";
        } else {
            colorLampara = "\033[33m";
        }
        this.estadoLampara = "  xx  "
                + "\n x" + colorLampara + "oo" + reset + "x "
                + "\nx" + colorLampara + "oooo" + reset + "x"
                + "\n x" + colorLampara + "oo" + reset + "x "
                + "\n  xx  "
                + "\n  ||  "
                + "\n__||__";
    }

    public void apagar() {
        this.estadoLampara = "  xx  "
                + "\n xoox "
                + "\nxoooox"
                + "\n xoox "
                + "\n  xx  "
                + "\n  ||  "
                + "\n__||__";
    }
    
    public String getEstadoLampara(){
        return this.estadoLampara;
    }
}
