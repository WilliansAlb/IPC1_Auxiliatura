/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjemplosContainers;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author willi
 */
public class EjemploScrollPane extends JFrame {

    private JPanel panel;

    public EjemploScrollPane() {
        setTitle("Ejemplo JScrollPane");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 300));

        // Crear un panel con un GridLayout
        panel = new JPanel(new GridLayout(10, 10));

        // Agregar botones al panel
        for (int i = 0; i < 100; i++) {
            JButton button = new JButton("Botón " + (i + 1));
            panel.add(button);
        }

        // Crear un JScrollPane y agregar el panel a él
        JScrollPane scrollPane = new JScrollPane(panel);

        // Agregar el JScrollPane al contenedor principal de la aplicación
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new EjemploScrollPane().setVisible(true);
        });
    }
}
