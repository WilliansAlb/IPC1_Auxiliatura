/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejemplos;

import java.io.IOException;
import java.util.Random;

/**
 *
 * @author willi
 */
public class Principal {

    public static void main(String[] args) {
        Lampara lampara1 = new Lampara("LED");
        Lampara lampara2 = new Lampara("INCANDESCENTE");
        Lampara[] lamparas = {lampara1, lampara2};
        Random aleatorio = new Random();
        int elegida = aleatorio.nextInt(2);
        lamparas[elegida].encender();
        System.out.println("LA LAMPARA QUE EL DESTINO ELIGIO ES");
        System.out.println(lamparas[elegida].getEstadoLampara());
        lamparas[elegida].apagar();
        System.out.println(lamparas[elegida].getEstadoLampara());
        //Hanoi juego = new Hanoi(5);
        //juego.iniciar();
    }
}
