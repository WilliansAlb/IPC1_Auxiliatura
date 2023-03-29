/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

/**
 *
 * @author yelbetto
 */
public class Casilla extends JButton {

    boolean bomb = false;
    boolean flag = false;
    static final String WATER = "fts/water2.png";
    static final String BOMB = "fts/bomb1.png";
    static final String FLAG = "fts/buoy.png";
    static final String EXPLOTE = "fts/explosion.png";
    int id;
    int alrededor;
    boolean revelada = false;
    int dimensionx;
    int dimensiony;

    public Casilla(int dimension) throws IOException {
        this.id = -1;
        this.setPreferredSize(new Dimension(dimension, dimension));
        this.dimensionx = dimension;
        this.dimensiony = dimension;
        this.alrededor = 0;
        cambiarIcono(Casilla.WATER, true);
        //this.setOpaque(false);
        this.setBackground(Color.blue);
        //this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setFont(new Font("SansSerif", Font.PLAIN, (int) (dimensionx * 0.8)));
    }

    public void cambiarIcono(String rutaImagen, boolean inicio) throws IOException {
        BufferedImage myPicture = ImageIO.read(new File(rutaImagen));
        Image newimg = myPicture.getScaledInstance(dimensionx, dimensiony, java.awt.Image.SCALE_SMOOTH);
        if (inicio) {
            super.setIcon(new ImageIcon(newimg));
            super.setEnabled(true);
            super.revalidate();
            super.repaint();
        } else {
            super.setEnabled(true);
            if (revelada) {
                if (alrededor != 0) {
                    super.setText(alrededor + "");
                    super.setHorizontalTextPosition(SwingConstants.CENTER);
                    super.setFont(new Font("Arial", Font.PLAIN, (int) (dimensionx * 0.8)));
                }
                if (!bomb) {
                    super.setEnabled(false);
                }
            }
            super.setIcon(new ImageIcon(newimg));
            super.revalidate();
            super.repaint();
        }
    }

    public boolean bomb(Casilla[][] casillas) throws IOException {
        if (bomb) {
            revelada = true;
            cambiarIcono(Casilla.BOMB, false);
        } else {
            revelando(casillas);
        }
        return bomb;
    }

    public void revelando(Casilla[][] casillas) throws IOException {
        revelada = true;
        cambiarIcono(Casilla.WATER, false);
        super.setEnabled(false);
        Casilla[] temp = new Casilla[]{casillaValida(casillas, id - casillas.length),
            casillaValida(casillas, id - 1),
            casillaValida(casillas, id + 1),
            casillaValida(casillas, id + casillas.length)};
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] != null) {
                if (!temp[i].bomb) {
                    int x1 = id % casillas[0].length;
                    int y1 = id / casillas[0].length;
                    int x2 = temp[i].getId() % casillas[0].length;
                    int y2 = temp[i].getId() / casillas[0].length;
                    if (x1 == x2 || y2 == y1) {
                        if (temp[i].flag == false) {
                            if (temp[i].alrededor == 0 && temp[i].revelada == false) {
                                temp[i].revelando(casillas);
                            } else {
                                temp[i].revelada = true;
                                temp[i].cambiarIcono(WATER, false);
                                temp[i].setEnabled(false);
                            }
                        }

                    }
                }
            }
        }
    }

    public Casilla casillaValida(Casilla[][] casillas, int posicion) {
        if ((posicion >= 0 && posicion < casillas.length * casillas[0].length)) {
            return casillas[posicion / casillas.length][posicion % casillas.length];
        }
        return null;
    }

    public void setBomb(Casilla[][] casillas, boolean bomb) {
        int actual = id;
        this.bomb = bomb;
        if (this.bomb) {
            for (int i = 0; i < 3; i++) {
                int firstLineOne = actual - (casillas.length - 1 + i);
                int firstLineTwo = actual - 1 + i;
                int firstLineThree = actual + (casillas.length - 1) + i;
                if ((firstLineOne >= 0 && firstLineOne < casillas.length * casillas[0].length
                        && ((actual-casillas.length)/casillas.length)==(firstLineOne/casillas.length))) {
                    casillas[firstLineOne / casillas.length][firstLineOne % casillas.length].agregarAlrededor();
                }
                if ((firstLineTwo >= 0 && firstLineTwo < casillas.length * casillas[0].length
                        && (actual/casillas.length)==(firstLineTwo/casillas.length))) {
                    casillas[firstLineTwo / casillas.length][firstLineTwo % casillas.length].agregarAlrededor();
                }
                if ((firstLineThree >= 0 && firstLineThree < casillas.length * casillas[0].length
                        && ((actual+casillas.length)/casillas.length)==(firstLineThree/casillas.length))) {
                    casillas[firstLineThree / casillas.length][firstLineThree % casillas.length].agregarAlrededor();
                }
            }
        }
    }

    public boolean flag() throws IOException {
        if (!revelada) {
            flag = !flag;
            if (flag) {
                cambiarIcono(Casilla.FLAG, false);
            } else {
                cambiarIcono(Casilla.WATER, false);
            }
            return flag;
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isBomb() {
        return bomb;
    }

    public void setBomb(boolean bomb) {
        this.bomb = bomb;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getAlrededor() {
        return alrededor;
    }

    public void setAlrededor(int alrededor) {
        this.alrededor = alrededor;
    }

    public void agregarAlrededor() {
        if (bomb) {
            this.alrededor = 0;
        } else {
            this.alrededor++;
        }
    }
}
