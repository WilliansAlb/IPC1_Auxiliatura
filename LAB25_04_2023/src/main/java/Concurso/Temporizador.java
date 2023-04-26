/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Concurso;

/**
 *
 * @author willi
 */
public class Temporizador extends Thread {

    private int duracion = 15;
    private int conteoSegundos = 0;
    private Concurso concurso;

    public Temporizador(Concurso concurso) {
        this.concurso = concurso;
    }

    @Override
    public void run() {
        while (conteoSegundos < duracion) {
            try {
                Thread.sleep(1000);
                conteoSegundos++;
                int minutos = conteoSegundos / 60;
                int segundos = conteoSegundos % 60;
                int decimas = segundos / 10;
                int segundos2 = segundos % 10;
                concurso.getTemporizador().setText("0" + minutos + ":" + decimas + "" + segundos2);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        concurso.setEjecutandose(false);
    }
}
