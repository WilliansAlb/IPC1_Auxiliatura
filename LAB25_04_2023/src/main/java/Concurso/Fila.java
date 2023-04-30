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
public class Fila {

    private ParteFila primero;
    private volatile int numeroFilas;

    public void agregarALaFila(Cliente nuevo) {
        ParteFila clienteFila = new ParteFila(nuevo);
        if (primero == null) {
            primero = clienteFila;
        } else {
            ParteFila temporal = primero;
            while (temporal.getSiguiente() != null) {
                temporal = temporal.getSiguiente();
            }
            temporal.setSiguiente(clienteFila);
        }
        numeroFilas++;
    }

    public Cliente atenderPrimero() {
        if (primero != null) {
            Cliente retorno = primero.getCliente();
            primero = primero.getSiguiente();
            numeroFilas--;
            return retorno;
        } else {
            return null;
        }
    }

    public int getNumeroFilas() {
        return numeroFilas;
    }

    public void setNumeroFilas(int numeroFilas) {
        this.numeroFilas = numeroFilas;
    }

    private class ParteFila {

        private Cliente cliente;
        private ParteFila siguiente = null;

        public ParteFila(Cliente cliente) {
            this.cliente = cliente;
        }

        public Cliente getCliente() {
            return cliente;
        }

        public void setCliente(Cliente cliente) {
            this.cliente = cliente;
        }

        public ParteFila getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(ParteFila siguiente) {
            this.siguiente = siguiente;
        }

    }
}
