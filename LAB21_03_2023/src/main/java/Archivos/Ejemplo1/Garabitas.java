/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos.Ejemplo1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author willi
 */
public class Garabitas {

    public Garabitas() {}
    
    public void escribirDatos(Scanner s){
        System.out.println("Se escribiran los datos del centro meteorologico Garabitas");
        System.out.println("¿de qué día escribiras los datos?");
        s = new Scanner(System.in);
        String dia = s.nextLine();
        DataOutputStream data = null;
        try {
            data = new DataOutputStream(new FileOutputStream("SeptGara.tmp"));
            data.writeUTF(dia);
            for (int hora = 0; hora < 24; hora++) {
                double temperatura, presion;
                presion = presionAleatoria();
                temperatura = temperaturaAleatoria();
                data.writeInt(hora);
                data.writeDouble(presion);
                data.writeDouble(temperatura);
            }
            System.out.println("Se escribieron los datos");
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no existente "+ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Problema en el flujo de salida "+ ex.getMessage());
        } finally {
            try {
                data.close();
            } catch (IOException er){
                er.printStackTrace();
            }
        }
    }
    
    public double presionAleatoria(){
        Random r = new Random();
        return r.nextInt(101)+ 680; // 680 - 780
    }
    
    public double temperaturaAleatoria(){
        Random r = new Random();
        return r.nextInt(36) + 5.00; 
    }
    
    public void leerDatos(){
        String dia;
        double max = 0;
        double min = 100;
        FileInputStream f;
        DataInputStream data = null;
        try {
            f = new FileInputStream("SeptGara.tmp");
            data = new DataInputStream(f);
        } catch (IOException io){
            System.out.println("Problema al crear el flujo de entrada");
        }
        try {
            int hora;
            double presion;
            double temperatura;
            dia = data.readUTF();
            System.out.println(dia);
            while (true){
                hora = data.readInt();
                presion = data.readDouble();
                temperatura = data.readDouble();
                if (min > temperatura){
                    min = temperatura;
                }
                if (max < temperatura){
                    max = temperatura;
                }
                System.out.println("Hora: "+hora+"\tPresión: "+presion+"\tTemperatura: "+temperatura);
            }
        } catch (EOFException eof){
            System.out.println("Fin de la lectura");
        } catch (IOException ex) {
            System.out.println("Problema al leer");
        } finally {
            try {
                data.close();
            } catch (IOException er){
                er.printStackTrace();
            }
        }
        System.out.println("La temperatura maxima: " +max);
        System.out.println("La temperatura minima: " +min);
    }
}
