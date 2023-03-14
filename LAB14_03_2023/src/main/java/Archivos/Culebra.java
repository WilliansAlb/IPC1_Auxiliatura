/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author willi
 */
public class Culebra {

    public static void main(String[] args) {
        Tablero nuevo = new Tablero(8, 8, 3, 10);
        nuevo.iniciarTableroVacio();
        nuevo.agregarObstaculos();
        nuevo.agregarPremios();
        nuevo.agregarCulebra();
        guardarHistorial(nuevo);
        nuevo.imprimirTablero();
        jugar(nuevo);
        System.out.println("Tablero guardado, se mostraran todos");
        imprimirHistorial();
    }

    public static void jugar(Tablero nuevo) {
        nuevo.getPlayer().setJugando(true);
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Llevas "+nuevo.getPlayer().getManzanasComidas()+" manzanas comidas");
            System.out.println("¿Hacia donde te quieres mover?");
            System.out.print(" (a) izquierda");
            System.out.print(" (w) arriba");
            System.out.print(" (s) abajo");
            System.out.print(" (d) derecha");
            System.out.println("");
            String opcion = sc.nextLine();
            nuevo.getPlayer().mover(nuevo.getCasillas(), opcion.charAt(0));
            if (!nuevo.getPlayer().isJugando()) {
                System.out.println("PERDISTE!");
                break;
            } else if (nuevo.getPlayer().getManzanasComidas() == nuevo.getNumeroObstaculos()){
                System.out.println("GANASTE!");
                break;
            }
            nuevo.imprimirTablero();
        }
    }

    public static void guardarHistorial(Tablero guardar) {
        FileOutputStream fos = null;
        ObjectOutputStream escribir = null;
        Tablero[] anterior = obtenerHistorial();
        Tablero[] nuevo;
        if (anterior == null) {
            nuevo = new Tablero[1];
            nuevo[0] = guardar;
        } else {
            nuevo = new Tablero[anterior.length + 1];
            nuevo[0] = guardar;
            System.arraycopy(anterior, 0, nuevo, 1, anterior.length);
        }
        try {
            // Para poder escribir utilizaremos un FileOutputStream pasandole
            // como referencia el archivo de tipo File.
            fos = new FileOutputStream(obtenerArchivo());

            // Y crearemos también una instancia del tipo ObjectOutputStream
            // al que le pasaremos por parámetro
            // el objeto de tipo FileOutputStream
            escribir = new ObjectOutputStream(fos);

            // Escribimos los objetos en el archivo.
            escribir.writeObject(nuevo);
            // Cerramos los objetos para no consumir recursos.

        } catch (Exception e) {
            System.out.println("Error al escribir en el archivo. "
                    + e.getMessage());
        } finally {
            try {
                escribir.close();
                fos.close();
            } catch (IOException ex) {
                Logger.getLogger(ArchivoSerializable.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static File obtenerArchivo() {
        Path directorio = Paths.get(System.getProperty("user.dir")).getParent();
        File archivo = new File(directorio + "\\historial.dat");
        return archivo;
    }

    public static Tablero[] obtenerHistorial() {
        Tablero[] historial = null;
        try {
            // Para poder leer utilizaremos un FileInputStream pasandole
            // como referencia el archivo de tipo File.
            FileInputStream fis = new FileInputStream(obtenerArchivo());
            // Declaramos una variable objeto del tipo ObjectInputStream
            ObjectInputStream leer;
            // Creamos un bucle para leer la información
            // Mientras haya bytes en el archivo.
            while (fis.available() > 0) {
                leer = new ObjectInputStream(fis);
                // En una arreglo de estudiantes guardaremos el objeto leido
                historial = (Tablero[]) leer.readObject();
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo. "
                    + e.getMessage());
        }
        return historial;
    }

    public static void imprimirHistorial() {
        Tablero[] historial = obtenerHistorial();
        for (int i = 0; i < historial.length; i++) {
            System.out.println("Tablero #" + (i + 1));
            historial[i].imprimirTablero();
        }
    }
}
