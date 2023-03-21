/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author willi
 */
public class CrearArchivo {
    
    public void crearArchivo(String nombreArchivo) {
        try {
            File miArchivo = new File(nombreArchivo + ".txt");
            if (miArchivo.createNewFile()) {
                System.out.println("Archivo creado: " + miArchivo.getName());
            } else {
                System.out.println("El archivo ya existe.");
            }
        } catch (IOException e) {
            System.out.println("Un error ha ocurrido.");
            e.printStackTrace();
        }
    }
}
