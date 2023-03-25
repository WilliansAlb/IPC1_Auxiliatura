/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Buscaminas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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

/**
 *
 * @author yelbetto
 */
public class Casilla extends JButton {

    boolean bomba = false;

    public Casilla() throws IOException {
        cambiarIcono();
        this.setPreferredSize(new Dimension(70, 70));
        //this.setOpaque(false);
        this.setBackground(Color.blue);
        //this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setFont(new Font("SansSerif", Font.PLAIN, 10));
    }

    public void cambiarIcono() throws IOException {
        String imagePath = "fts/water1.png";
        if (bomba) {
            imagePath = "fts/bomb1.png";
        }
        BufferedImage myPicture = ImageIO.read(new File(imagePath));
        Image newimg = myPicture.getScaledInstance(65, 65, java.awt.Image.SCALE_SMOOTH);
        super.setIcon(new ImageIcon(newimg));
        super.revalidate();
        super.repaint();
    }
}
