/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos.Ejemplo2;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 *
 * @author willi
 */
public class EscribirTexto {
    public EscribirTexto(){}
    
    public void escribirDistancia(String archivoEscribir){
        File f;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter escritor = null;
        String cadena;
        boolean existe;
        f = new File(archivoEscribir+".txt");
        try {
            escritor = new PrintWriter(new DataOutputStream(new FileOutputStream(f,false)));
            System.out.println("Ingresa la distancia con el siguiente formato ->PUEBLOA distancia PUEBLOB");
            while ((cadena = entrada.readLine())!=null && (cadena.length() > 0)){
                if (datosCorrectos(cadena)){
                    escritor.println(cadena);
                }
            }
            escritor.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    
    public boolean datosCorrectos(String cadena){
        String[] partes = cadena.split(" ");
        if (partes.length == 3){
            try {
                if (Integer.parseInt(partes[1])>0){
                    return true;
                }
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        return false;
    }
}
