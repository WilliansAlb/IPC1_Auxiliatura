/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Concurso;

/**
 *
 * @author willi
 */
public class Producto {
    private Producto siguiente = null;
    private String nombre;
    private double precio;
    private int peso;

    public Producto(String nombre, double precio, int peso) {
        this.nombre = nombre;
        this.precio = precio;
        this.peso = peso;
    }
    
    public Producto getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Producto siguiente) {
        this.siguiente = siguiente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Producto{nombre=" + nombre + ", precio=" + precio + ", peso=" + peso + '}';
    }
    
}
