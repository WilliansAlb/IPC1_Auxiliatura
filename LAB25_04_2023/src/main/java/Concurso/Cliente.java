/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Concurso;

import java.util.Random;
import javax.swing.JButton;

/**
 *
 * @author willi
 */
public class Cliente extends JButton{
    private boolean pagoTarjeta = false;
    private final int PORCENTAJE_TARJETA = 60;
    private ListaProducto compra;
    
    public Cliente(){
        this.compra = new ListaProducto();
    }
    
    public int elegirFila(Fila[] filas){
        int diferencia = Math.abs(filas[0].getNumeroFilas()-filas[1].getNumeroFilas());
        if (diferencia<=2){
            Random aleatorio = new Random();
            if (aleatorio.nextBoolean()){
                filas[0].agregarALaFila(this);
                return 0;
            } else {
                filas[1].agregarALaFila(this);
                return 1;
            }
        } else {
            if (filas[0].getNumeroFilas()<filas[1].getNumeroFilas()){
                filas[0].agregarALaFila(this);
                return 0;
            } else {
                filas[1].agregarALaFila(this);
                return 1;
            }
        }
    }
    
    public void elegirPago(){
        Random aleatorio = new Random();
        pagoTarjeta = (aleatorio.nextInt(100)+1) < PORCENTAJE_TARJETA;
    }
    
    public void comprar(ListaProducto catalogo){
        Random aleatorio = new Random();
        int articulosCompra = aleatorio.nextInt(25)+1;
        for (int i = 0; i < articulosCompra; i++) {
            compra.agregarAlFinal(catalogo.obtenerProductoAleatorio());
        }
    }

    public boolean isPagoTarjeta() {
        return pagoTarjeta;
    }

    public void setPagoTarjeta(boolean pagoTarjeta) {
        this.pagoTarjeta = pagoTarjeta;
    }

    public ListaProducto getCompra() {
        return compra;
    }

    public void setCompra(ListaProducto compra) {
        this.compra = compra;
    }
    
    
}
