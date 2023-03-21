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
public class Manzana extends Elemento implements Serializable{

    public Manzana(String caracter) {
        super(caracter);
    }
    
    @Override
    public void pasar(Jugador j) {
        j.setManzanasComidas(j.getManzanasComidas()+1);
    }
    
}
