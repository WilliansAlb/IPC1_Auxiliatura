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
public class ListaDoble {

    private NodoDoblemente raiz;
    private NodoDoblemente cola;

    public void insertarInicio(int elemento) {
        NodoDoblemente nuevo = new NodoDoblemente(elemento);
        //Si la lista está vacia
        if (raiz == null) {
            cola = nuevo;
        } else {
            //Si la lista tiene elementos, el nodo siguiente de nuevo apuntará a la anterior raiz, y la anterior raiz apuntará al nuevo
            nuevo.setSiguiente(raiz);
            raiz.setAnterior(nuevo);
        }
        //la nueva raiz será el nuevo nodo
        raiz = nuevo;
    }

    public void insertarFinal(int elemento) {
        NodoDoblemente nuevo = new NodoDoblemente(elemento);
        //Si la cola es igual a null, significa que la lista está vacia
        if (cola == null) {
            raiz = nuevo;
        } else {
            //Si la lista tiene elementos, hacemos que la anterior cola apunte al nuevo desde su siguiente, 
            //y el nuevo apuntará a la anterior cola desde su anterior
            nuevo.setAnterior(cola);
            cola.setSiguiente(nuevo);
        }
        //Vuelvo al nuevo nodo la nueva cola
        cola = nuevo;
    }

    public void eliminarElemento(int elemento) {
        if (raiz == null) {
            System.out.println("Lista vacia");
        } else {
            if (raiz.getElemento() == elemento) {
                raiz = raiz.getSiguiente();
                raiz.setAnterior(null);
            } else {
                NodoDoblemente temporal = raiz;
                while (temporal.getSiguiente() != null && temporal.getSiguiente().getElemento() != elemento) {
                    temporal = temporal.getSiguiente();
                }
                if (temporal.getSiguiente() == null) {
                    System.out.println("Elemento no encontrado");
                } else {
                    //Hacemos que el nodo anterior al nodo que tiene el elemento buscado apunte al siguiente del siguiente
                    temporal.setSiguiente(temporal.getSiguiente().getSiguiente());
                    //Dado que ya está apuntando al siguiente correcto, cambiamos su referencia del anterior al nodo en el que estamos
                    temporal.getSiguiente().setAnterior(temporal);
                }
            }
        }
    }
    
    public void eliminarInicio(){
        if (raiz!=null){
            raiz = raiz.getSiguiente();
            if (raiz==null){
                cola = null;
            } else {
                raiz.setAnterior(null);
            }
        }
    }
    
    public void eliminarFinal(){
        if (cola!=null){
            cola = cola.getAnterior();
            if (cola==null){
                raiz = null;
            } else {
                cola.setSiguiente(null);
            }
        }
    }

    public void listarElementos() {
        NodoDoblemente temporal = raiz;
        while (temporal.getSiguiente() != null) {
            System.out.println(temporal.getElemento());
            temporal = temporal.getSiguiente();
        }
        System.out.println(temporal.getElemento());
    }

    private class NodoDoblemente {

        private NodoDoblemente anterior = null;
        private NodoDoblemente siguiente = null;
        private int elemento;

        public NodoDoblemente(int elemento) {
            this.elemento = elemento;
        }

        public int getElemento() {
            return elemento;
        }

        public void setElemento(int elemento) {
            this.elemento = elemento;
        }

        public NodoDoblemente getAnterior() {
            return anterior;
        }

        public void setAnterior(NodoDoblemente anterior) {
            this.anterior = anterior;
        }

        public NodoDoblemente getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(NodoDoblemente siguiente) {
            this.siguiente = siguiente;
        }

    }
}
