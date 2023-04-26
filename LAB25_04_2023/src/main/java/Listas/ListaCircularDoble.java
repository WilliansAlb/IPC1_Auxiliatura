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
public class ListaCircularDoble {

    private Nodo raiz;
    private int cantidad;

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public ListaCircularDoble() {

    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    public void insertarInicio(int elemento) {
        Nodo nuevo = new Nodo(elemento);
        if (raiz == null) {
            nuevo.setSiguiente(nuevo);
            nuevo.setAnterior(nuevo);
        } else {
            nuevo.setSiguiente(raiz);
            nuevo.setAnterior(raiz.getAnterior());
            raiz.setAnterior(nuevo);
            nuevo.getAnterior().setSiguiente(nuevo);
        }
        raiz = nuevo;
    }
    
    public void insertarFinal(int elemento){
        Nodo nuevo = new Nodo(elemento);
        if (raiz==null){
            nuevo.setSiguiente(nuevo);
            nuevo.setAnterior(nuevo);
            raiz = nuevo;
        } else {
            Nodo ultimo = raiz.getAnterior();
            ultimo.setSiguiente(nuevo);
            nuevo.setSiguiente(raiz);
            nuevo.setAnterior(ultimo);
            raiz.setAnterior(nuevo);
        }
        cantidad++;
    }
    
    public void eliminarInicio(){
        if (raiz!=null){
            if (raiz.getSiguiente()==raiz){
                raiz = null;
            } else {
                Nodo ultimo = raiz.getAnterior();
                raiz = raiz.getSiguiente();
                raiz.setAnterior(ultimo);
                ultimo.setSiguiente(raiz);
            }
            cantidad--;
        }
    }
    
    public void eliminarFinal(){
        if (raiz!=null){
            if (raiz.getSiguiente()==raiz){
                raiz = null;
            } else {
                Nodo ultimo = raiz.getAnterior();
                raiz.setAnterior(ultimo.getAnterior());
                ultimo.getAnterior().setSiguiente(raiz);
            }
            cantidad--;
        }
    }
    
    public void listarElementos(){
        if (raiz!=null){
            System.out.println(raiz.getElemento());
            Nodo actual = raiz.getSiguiente();
            while (actual!=raiz){
                System.out.println(actual.getElemento());
                actual = actual.getSiguiente();
            }
        } else {
            System.out.println("Lista vacia");
        }
    }

    public class Nodo {

        private Nodo siguiente;
        private Nodo anterior;
        private int elemento;

        public Nodo(int elemento) {
            this.elemento = elemento;
        }

        public Nodo(Nodo siguiente, Nodo anterior, int elemento) {
            this.siguiente = siguiente;
            this.anterior = anterior;
            this.elemento = elemento;
        }

        public Nodo getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo siguiente) {
            this.siguiente = siguiente;
        }

        public Nodo getAnterior() {
            return anterior;
        }

        public void setAnterior(Nodo anterior) {
            this.anterior = anterior;
        }

        public int getElemento() {
            return elemento;
        }

        public void setElemento(int elemento) {
            this.elemento = elemento;
        }

    }
}
