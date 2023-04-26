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
public class ListaSimple {

    private Nodo raiz;

    public ListaSimple() {

    }

    public void insertarInicio(int elemento) {
        Nodo nuevo = new Nodo(elemento);
        //Verificamos que la lista no esté vacia, si está vacia agregamos el elemento
        //al inicio
        if (raiz != null) {
            nuevo.setSiguiente(raiz);
        }
        raiz = nuevo;
    }

    public void insertarFinal(int elemento) {
        Nodo nuevo = new Nodo(elemento);
        //Lista vacia
        if (raiz == null) {
            raiz = nuevo;
        } else {
            //La lista no está vacia
            Nodo temp = raiz;
            //Se recorre hasta encontrar el final de la lista
            while (temp.getSiguiente() != null) {
                //Cambia el valor temporal por el siguiente en la lista
                temp = temp.getSiguiente();
            }
            //Agregamos el nuevo nodo al final de la lista
            temp.setSiguiente(nuevo);
        }
    }

    public void eliminarElemento(int elemento) {
        //La lista está vacia
        if (raiz == null) {
            System.out.println("La lista está vacía");
        } else {
            //Si el elemento es el primer nodo de la raiz, volvemos la nueva raiz al siguiente
            if (raiz.getElemento() == elemento) {
                raiz = raiz.getSiguiente();
            } else {
                Nodo temporal = raiz;
                //Recorremos toda la lista 
                while (temporal.getSiguiente() != null && temporal.getSiguiente().getElemento() != elemento) {
                    temporal = temporal.getSiguiente();
                }
                //Si se llega al final de la lista, significa que el elemento no existia en la misma
                if (temporal.getSiguiente() == null) {
                    System.out.println("Elemento no está en la lista");
                } else {
                    //Encontramos el nodo que tiene el elemento, nos quedamos en un nodo anterior y cambiamos la referencia del siguiente
                    temporal.setSiguiente(temporal.getSiguiente().getSiguiente());
                }

            }
        }
    }
    
    public void listarElementos(){
        Nodo actual = raiz;
        //recorremos la lista imprimiendo los elementos, hasta llegar al nodo final
        while (actual.getSiguiente()!=null){
            System.out.println(actual.getElemento());
            actual = actual.getSiguiente();
        }
        //imprimimos el nodo final
        System.out.println(actual.getElemento());
    }

    public class Nodo {

        private int elemento;
        private Nodo siguiente = null;

        public Nodo(int elemento) {
            this.elemento = elemento;
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
