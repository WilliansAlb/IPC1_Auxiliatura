/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjemplosContainers;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author willi
 */
public class EjemploDesktopPane extends JFrame {

    private JDesktopPane desktopPane;

    public EjemploDesktopPane() {
        setTitle("Ejemplo JDesktopPane");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(600, 400));

        desktopPane = new JDesktopPane();
        getContentPane().add(desktopPane, BorderLayout.CENTER);

        // Crear una ventana interna
        JInternalFrame ventanaInterna = new JInternalFrame("Ventana Interna", true, true, true, true);
        ventanaInterna.setBounds(50, 50, 200, 200);
        desktopPane.add(ventanaInterna);
        ventanaInterna.setVisible(true);
        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new EjemploDesktopPane().setVisible(true);
        });
    }
}
