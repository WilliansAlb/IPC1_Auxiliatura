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
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author willi
 */
public class CopiarArchivo {

    public static void main(String[] args) {
        FileInputStream origen = null;
        FileOutputStream destino = null;
        Path directorio = Paths.get(System.getProperty("user.dir")).getParent();
        File f1 = new File(directorio+"\\jardines.txt");
        File f2 = new File(directorio+"\\jardinOld.txt");
        try {
            origen = new FileInputStream(f1);
            destino = new FileOutputStream(f2);
            int c;
            while ((c = origen.read()) != -1) {
                destino.write((byte) c);
            }
            destino.write("\nEsta es una copia del archivo jardines.txt".getBytes());
            System.out.println("Se copió el archivo");
        } catch (IOException er) {
            System.out.println("Excepción en los flujos "
                    + er.getMessage());
        } finally {
            try {
                origen.close();
                destino.close();
            } catch (IOException er) {
                er.printStackTrace();
            }
        }
    }
}
