/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejemplofecha;

/**
 *
 * @author willi
 */
public class Main {
    public static void main(String[] args) {
        Fecha fecha1 = new Fecha();
        Fecha fecha2 = new Fecha(21,7,1960);
        Fecha fecha3 = new Fecha(23,2,1992);
        
        fecha1.reiniciar(15, 9, 1987);
        fecha2.adelantar(15, 7, 1960);
        fecha3.adelantar(32, 8, 1992);
        fecha1.reiniciar(29, 2, 2023);
        
        fecha1.imprimir();
        fecha2.imprimir();
        fecha3.imprimir();
    }
}
