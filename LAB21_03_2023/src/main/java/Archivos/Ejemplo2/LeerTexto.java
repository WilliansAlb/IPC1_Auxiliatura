/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos.Ejemplo2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author willi
 */
public class LeerTexto {

    public LeerTexto() {
    }
    
    public void leerTextoArchivo(String nombreArchivo){
        File f;
        BufferedReader br = null;
        String cadena;
        f = new File(nombreArchivo+".txt");
        if (f.exists()){
            int conteo = 1;
            try {
               br = new BufferedReader(new FileReader(f));
               while ((cadena = br.readLine())!=null){
                   System.out.println(cadena);
                   if (conteo%20 == 0){
                       System.out.println("Pulsa una tecla...");
                       System.in.read();
                   }
                   conteo++;
               }
            } catch (IOException e){
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Archivo inexistente");
        }
    }
}
