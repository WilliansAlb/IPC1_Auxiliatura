/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Concurso;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

/**
 *
 * @author willi
 */
public class Cajero extends Thread {

    private final Concurso concurso;
    private final int tiempoProductoLiviano;
    private final int tiempoProductoPesado;
    private final int tiempoPagoTarjeta;
    private final int tiempoPagoEfectivo;
    private final int limiteGramos;
    private int productos = 0;
    private final String nombre;
    private final int noCajero;
    private final Supermercado supermercado;
    private int atendidos = 0;

    public Cajero(Concurso concurso, String nombre, double tiempoProductoLiviano, double tiempoProductoPesado,
            double tiempoPagoTarjeta, double tiempoPagoEfectivo, int limiteGramos, int noCajero, Supermercado supermercado) {
        this.concurso = concurso;
        this.nombre = nombre;
        this.tiempoProductoLiviano = (int) (1000 * tiempoProductoLiviano);
        this.tiempoProductoPesado = (int) (1000 * tiempoProductoPesado);
        this.tiempoPagoTarjeta = (int) (1000 * tiempoPagoTarjeta);
        this.tiempoPagoEfectivo = (int) (1000 * tiempoPagoEfectivo);
        this.noCajero = noCajero;
        this.supermercado = supermercado;
        this.limiteGramos = limiteGramos;
    }

    @Override
    public void run() {
        while (concurso.isEjecutandose()) {
            Cliente atendiendo = recibirCliente();
            if (atendiendo != null) {
                escribiendoAccion("Atendiendo nuevo cliente");
                int productosCompra = atendiendo.getCompra().getCantidad();
                reiniciandoFactura();
                sacandoCliente(atendiendo);
                for (int i = 0; i < productosCompra; i++) {
                    Producto actual = atendiendo.getCompra().obtenerPrimero();
                    escribiendoAccion("Cobrando " + actual.getNombre());
                    if (actual.getPeso() <= limiteGramos) {
                        try {
                            Thread.sleep(tiempoProductoLiviano);
                        } catch (InterruptedException ex) {
                            escribiendoAccion("Detenido mientras pasaba un producto");
                        }
                    } else {
                        try {
                            Thread.sleep(tiempoProductoPesado);
                        } catch (InterruptedException ex) {
                            escribiendoAccion("Detenido mientras pasaba un producto");
                        }
                    }
                    agregandoFactura(actual);
                }
                escribiendoAccion("Cobrando " + (atendiendo.isPagoTarjeta() ? "Tarjeta" : "Efectivo"));
                if (atendiendo.isPagoTarjeta()) {
                    try {
                        Thread.sleep(tiempoPagoTarjeta);
                    } catch (InterruptedException ex) {
                        escribiendoAccion("Detenido mientras cobraba");
                    }
                } else {
                    try {
                        Thread.sleep(tiempoPagoEfectivo);
                    } catch (InterruptedException ex) {
                        escribiendoAccion("Detenido mientras cobraba");
                    }
                }
                mostrarAtendidos();
            } else {
                escribiendoAccion("Esperando clientes");
            }
        }
    }
    
    public void mostrarAtendidos(){
        atendidos++;
        if (noCajero == 1){
            concurso.getLabelAtendidos1().setText("Clientes atendidos: "+atendidos);
        } else {
            concurso.getLabelAtendidos2().setText("Clientes atendidos: "+atendidos);
        }
    }

    public void reiniciandoFactura() {
        if (noCajero == 1) {
            concurso.getModelo().setRowCount(0);
        } else {
            concurso.getModelo2().setRowCount(0);
        }
    }

    public void agregandoFactura(Producto producto) {
        productos++;
        JTable tabla;
        if (noCajero == 1) {
            concurso.getLabelProductos1().setText("Productos Cobrados: "+productos);
            concurso.getModelo().addRow(new Object[]{producto.getNombre(), producto.getPrecio(), producto.getPeso()});
            tabla = concurso.getTablaProductos1();
        } else {
            concurso.getLabelProductos2().setText("Productos Cobrados: "+productos);
            concurso.getModelo2().addRow(new Object[]{producto.getNombre(), producto.getPrecio(), producto.getPeso()});
            tabla = concurso.getTablaProductos2();
        }
        tabla.scrollRectToVisible(tabla.getCellRect(tabla.getRowCount()-1, 0, true));
    }

    public void escribiendoAccion(String accion) {
        if (noCajero == 1) {
            concurso.getLabelAccion1().setText(accion);
        } else {
            concurso.getLabelAccion2().setText(accion);
        }
    }

    public Cliente recibirCliente() {
        Cliente retorno;
        if (noCajero == 1) {
            retorno = supermercado.getFilas()[0].atenderPrimero();
        } else {
            retorno = supermercado.getFilas()[1].atenderPrimero();
        }
        return retorno;
    }

    public void sacandoCliente(Cliente cliente) {
        if (noCajero == 1) {
            concurso.getPanelFila1().remove(cliente);
        } else {
            concurso.getPanelFila2().remove(cliente);
        }
    }

}
