/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listas;

/**
 *
 * @author willi
 */
public class ListaCircularSimple {
    private Nodo raiz;
    private int cantidad;
    
    public ListaCircularSimple(){
        this.raiz = null;
        this.cantidad = 0;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public void insertarInicio(int elemento){
        Nodo nuevo = new Nodo(elemento);
        //La lista está vacia
        if (raiz == null){
            //Se vuelve al nuevo la nueva raiz, y se apunta con el siguiente a el mismo
            raiz = nuevo;
            nuevo.setSiguiente(nuevo);
        } else {
            //La lista tiene elementos
            Nodo actual = raiz;
            //Recorremos la lista hasta llegar al elemento final
            while (actual.getSiguiente()!=raiz){
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
            nuevo.setSiguiente(raiz);
            raiz = nuevo;
        }
        cantidad++;
    }
    
    public void insertarFinal(int elemento){
        Nodo nuevo = new Nodo(elemento);
        if (raiz==null){
            raiz = nuevo;
            nuevo.setSiguiente(raiz);
        } else {
            Nodo actual = raiz;
            while (actual.getSiguiente()!=raiz){
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
            nuevo.setSiguiente(raiz);
        }
        cantidad++;
    }
    
    public void eliminarInicio(){
        if (raiz!=null){
            Nodo actual = raiz;
            while (actual.getSiguiente()!=raiz){
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(raiz.getSiguiente());
            raiz = raiz.getSiguiente();
            cantidad--;
        }
    }
    
    public void eliminarFinal(){
        if (raiz!=null){
            Nodo actual = raiz;
            Nodo anterior = null;
            while (actual.getSiguiente()!=raiz){
                anterior = actual;
                actual = actual.getSiguiente();
            }
            anterior.setSiguiente(raiz);
            cantidad--;
        }
    }
    
    public void listarElementos(){
        Nodo actual = raiz.getSiguiente();
        System.out.println(raiz.getElemento());
        while (actual!=raiz){
            System.out.println(actual.getElemento());
            actual = actual.getSiguiente();
        }
    }
    
    public class Nodo{
        private int elemento;
        private Nodo siguiente;

        public Nodo(int elemento) {
            this.elemento = elemento;
        }

        public Nodo(int elemento, Nodo siguiente) {
            this.elemento = elemento;
            this.siguiente = siguiente;
        }

        public int getElemento() {
            return elemento;
        }

        public void setElemento(int elemento) {
            this.elemento = elemento;
        }

        public Nodo getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo siguiente) {
            this.siguiente = siguiente;
        }
        
    }
}
