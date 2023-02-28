/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejemplofecha;

/**
 *
 * @author willi
 */
public class Fecha {

    private int dia;
    private int mes;
    private int anio;

    public Fecha() {

    }

    public Fecha(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    public void reiniciar(int d, int m, int a) {
        this.dia = d;
        this.mes = m;
        this.anio = a;
        normalizar();
    }

    public void adelantar(int d, int m, int a) {
        if (a < anio) {
            System.out.println("No se puede"
                    + " adelantar a una fecha"
                    + " anterior");
        } else {
            if (m < mes) {
                System.out.println("No se puede"
                        + " adelantar a una fecha"
                        + " anterior");
            } else {
                if (d < dia) {
                    System.out.println("No se puede"
                            + " adelantar a una fecha"
                            + " anterior");
                } else {
                    this.dia = d;
                    this.mes = m;
                    this.anio = a;
                    normalizar();
                }
            }
        }
    }

    public void normalizar() {
        if (dia > dias(mes)) {
            dia = dia - dias(mes);
            mes++;
        }

        if (mes > 0) {
            if (mes > 12) {
                mes = mes - 12;
                anio++;
            }
        } else {
            mes = 1;
        }

        if (anio <= 0) {
            anio = 1;
        }
    }

    public int dias(int mes) {
        int[] diasSegunMes;
        if (mes <= 0) {
            mes = 1;
        }
        if (mes > 12) {
            mes = 12;
        }
        if (anio % 400 == 0 || (anio % 4 == 0 && anio % 100 != 0)) {
            diasSegunMes = new int[]{31, 29, 31, 30, 31,
                30, 31, 31, 30, 31, 30, 31};
        } else {
            diasSegunMes = new int[]{31, 28, 31, 30, 31,
                30, 31, 31, 30, 31, 30, 31};
        }
        return diasSegunMes[mes - 1];
    }

    public void imprimir() {
        System.out.println("La fecha es el "
                + dia + " del mes " + mes + " del año "
                + anio);
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

}
