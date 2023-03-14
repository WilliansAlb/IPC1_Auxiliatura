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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author willi
 */
public class ArchivoSerializable {

    public static void main(String[] args) {
        Path directorio = Paths.get(System.getProperty("user.dir")).getParent();
        File archivo = new File(directorio + "\\estudiantes.dat");
        //escribirEstudiantes(archivo);
        leerEstudiantes(archivo);
    }

    public static void escribirEstudiantes(File archivo) {
        Estudiante[] estudiantes = {new Estudiante("Juan", "2020221", 20), 
            new Estudiante("Pedro", "2020183", 25), new Estudiante("Pascal", "2010183", 26)};
        FileOutputStream fos = null;
        ObjectOutputStream escribir = null;
        try {
            // Para poder escribir utilizaremos un FileOutputStream pasandole
            // como referencia el archivo de tipo File.
            fos = new FileOutputStream(archivo);

            // Y crearemos también una instancia del tipo ObjectOutputStream
            // al que le pasaremos por parámetro
            // el objeto de tipo FileOutputStream
            escribir = new ObjectOutputStream(fos);

            // Escribimos los objetos en el archivo.
            escribir.writeObject(estudiantes);
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

    public static void leerEstudiantes(File archivo) {
        Estudiante[] estudiantes = null;
        try {
            // Para poder leer utilizaremos un FileInputStream pasandole
            // como referencia el archivo de tipo File.
            FileInputStream fis = new FileInputStream(archivo);
            // Declaramos una variable objeto del tipo ObjectInputStream
            ObjectInputStream leer;
            // Creamos un bucle para leer la información
            // Mientras haya bytes en el archivo.
            while (fis.available() > 0) {
                leer = new ObjectInputStream(fis);
                // En una arreglo de estudiantes guardaremos el objeto leido
                estudiantes = (Estudiante[]) leer.readObject();
            }
            if (estudiantes != null) {
                for (int i = 0; i < estudiantes.length; i++) {
                    System.out.println("Estudiante #" + (i + 1));
                    System.out.println(estudiantes[i].getNombre());
                    System.out.println(estudiantes[i].getCarne());
                    System.out.println(estudiantes[i].getEdad());
                    System.out.println("");
                }
            } else {
                System.out.println("Aun no hay estudiantes");
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo. "
                    + e.getMessage());
        }
    }
}
