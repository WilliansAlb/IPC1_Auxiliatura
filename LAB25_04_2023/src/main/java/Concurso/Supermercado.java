/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Concurso;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author willi
 */
public class Supermercado extends Thread {

    private Concurso concurso;
    private final int tiempoMaximoClientes = 4;
    private final int tiempoMinimoClientes = 0;
    private ListaProducto catalogo;
    private Fila[] filas;

    public Supermercado(Concurso concurso) {
        this.concurso = concurso;
        this.filas = new Fila[]{new Fila(), new Fila()};
    }

    public void abastecerCatalogo() {
        String[] nombres = {"Papel higienico", "Arroz blanco", "Atun en aceite", "Agua mineral", "Spaguetti",
            "Manzanas", "Refresco de cola", "Pan", "Mermelada de fresa", "Aceite de oliva",
            "Patatas", "Sardinas en aceite", "Galletas de chocolate", "Te", "Vino tinto",
            "Cafe molido", "Salchichon", "Cereales", "Zanahorias", "Queso cheddar"};
        double[] precios = {3.50, 1.99, 1.20, 0.50, 0.85, 1.50, 0.50, 0.75, 1.20, 5.99,
            2.99, 0.99, 1.50, 2.50, 6.99, 2.99, 2.50, 2.99, 0.99, 2.50};
        int[] pesos = {200, 1000, 150, 1500, 500, 1000, 330, 500, 300, 1000,
            2000, 120, 300, 100, 750, 250, 200, 375, 1000, 250};
        catalogo = new ListaProducto();
        for (int i = 0; i < nombres.length; i++) {
            catalogo.agregarAlFinal(new Producto(nombres[i], precios[i], pesos[i]));
        }
        catalogo.imprimirCatalogo();
    }

    @Override
    public void run() {
        Random aleatorio = new Random();
        int tiempoDiferencia = tiempoMaximoClientes - tiempoMinimoClientes;
        Cajero c1 = new Cajero(this.concurso, "German", 0.15, 0.30, 1, 3, 1000, 1, this);
        c1.start();
        Cajero c2 = new Cajero(this.concurso, "Luis", 0.10, 0.35, 2, 2, 500, 2, this);
        c2.start();
        while (concurso.isEjecutandose()) {
            int segundosEntreClientes = aleatorio.nextInt(tiempoDiferencia) + tiempoMinimoClientes;
            try {
                Thread.sleep(segundosEntreClientes * 1000);
            } catch (InterruptedException ex) {
                System.out.println("Detenido");
                c1.interrupt();
                c2.interrupt();
            }
            crearCliente();
        }
    }

    public void crearCliente() {
        Cliente nuevo = new Cliente();
        nuevo.setIcon(concurso.getClient());
        nuevo.elegirPago();
        nuevo.comprar(catalogo);
        System.out.println("Imprimiendo nuevo cliente con " + nuevo.getCompra().getCantidad() + " productos");
        nuevo.getCompra().imprimirCatalogo();
        nuevo.setToolTipText("<html><body>Productos: " + nuevo.getCompra().getCantidad() + "<br>Pago con tarjeta: " + (nuevo.isPagoTarjeta() ? "Sí" : "No") + "<br></body></html>");
        System.out.println("");
        int eleccion = nuevo.elegirFila(filas);
        if (eleccion == 0) {
            concurso.getPanelFila1().add(nuevo);
        } else {
            concurso.getPanelFila2().add(nuevo);
        }
    }

    public Concurso getConcurso() {
        return concurso;
    }

    public void setConcurso(Concurso concurso) {
        this.concurso = concurso;
    }

    public Fila[] getFilas() {
        return filas;
    }

    public void setFilas(Fila[] filas) {
        this.filas = filas;
    }

}
