/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepcion;

/**
 *
 * @author willi
 */
public class DivisionPorCero {

    public static void main(String[] args) {
        //dividir(10, 0);
        dividirConExcepcion(10, 0);
    }

    public static void dividir(int numerador, int denominador) {
        int resultado = numerador / denominador; // intentando dividir por cero
        System.out.println("El resultado es: " + resultado);
    }

    public static void dividirConExcepcion(int numerador, int denominador) {
        try {
            int resultado = numerador / denominador; // intentando dividir por cero
            System.out.println("El resultado es: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("Error: no se puede dividir por cero "+e.getMessage());
        }
        System.out.println("--");
    }
}
