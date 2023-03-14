/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author willi
 */
public class ListadoDirectorio {

    public static void main(String[] args) {
        File dir;
        String[] cd;
        Path ruta = Paths.get(System.getProperty("user.dir")).getParent();
        // para la ejecución es necesario especificar el directorio
        dir = new File(ruta.toString());
        // debe ser un directorio
        if (dir.exists() && dir.isDirectory()) {
            // se obtiene la lista de elementos
            cd = dir.list();
            System.out.println("Elementos del directorio " + ruta);
            for (int i = 0; i < cd.length; i++) {
                System.out.println(cd[i]);
            }
        } else {
            System.out.println("Directorio vacío");
        }
    }
}
