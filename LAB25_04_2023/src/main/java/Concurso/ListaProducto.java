/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Concurso;

import java.util.Random;

/**
 *
 * @author willi
 */
public class ListaProducto {
    private ParteLista raiz;
    private int cantidad;
    
    public ListaProducto(){
        this.raiz = null;
        this.cantidad = 0;
    }
    
    public void agregarAlFinal(Producto nuevo){
        ParteLista adicion = new ParteLista(nuevo);
        if (raiz==null){
            nuevo.setSiguiente(null);
            raiz = adicion;
        } else {
            ParteLista temporal = raiz;
            while (temporal.getSiguiente()!=null){
                temporal = temporal.getSiguiente();
            }
            temporal.setSiguiente(adicion);
        }
        cantidad++;
    }
    
    public Producto obtenerProductoAleatorio(){
        Random aleatorio = new Random();
        int productoAleatorio = aleatorio.nextInt(cantidad);
        ParteLista retorno = raiz;
        for (int i = 0; i < productoAleatorio; i++) {
            retorno = retorno.getSiguiente();
        }
        return retorno.getProducto();
    }
    
    public Producto obtenerPrimero(){
        if (raiz == null){
            return null;
        } else {
            Producto retorno = raiz.getProducto();
            raiz = raiz.getSiguiente();
            cantidad--;
            return retorno;
        }
    }
    
    public void imprimirCatalogo(){
        ParteLista temporal = raiz;
        while (temporal != null){
            System.out.println(temporal.getProducto().toString());
            temporal = temporal.getSiguiente();
        }
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    private class ParteLista{
        private Producto producto;
        private ParteLista siguiente = null;
        
        public ParteLista(Producto producto){
            this.producto = producto;
        }

        public Producto getProducto() {
            return producto;
        }

        public void setProducto(Producto producto) {
            this.producto = producto;
        }

        public ParteLista getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(ParteLista siguiente) {
            this.siguiente = siguiente;
        }
    }
    
}
