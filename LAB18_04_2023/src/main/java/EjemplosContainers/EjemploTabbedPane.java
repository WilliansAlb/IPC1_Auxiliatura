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
public class EjemploTabbedPane extends JFrame {

    private JTabbedPane tabbedPane;

    public EjemploTabbedPane() {
        setTitle("Ejemplo JTabbedPane");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(600, 400));

        // Crear un panel con un botón
        JPanel panel1 = new JPanel();
        panel1.add(new JButton("Botón"));

        // Crear un panel con una etiqueta
        JPanel panel2 = new JPanel();
        panel2.add(new JLabel("Etiqueta"));

        // Crear un panel con un área de texto dentro de un JScrollPane
        JTextArea textArea = new JTextArea(10, 20);
        JScrollPane scrollPane = new JScrollPane(textArea);
        JPanel panel3 = new JPanel();
        panel3.add(scrollPane);

        // Crear un JTabbedPane y agregar los paneles
        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Pestaña 1", panel1);
        tabbedPane.addTab("Pestaña 2", panel2);
        tabbedPane.addTab("Pestaña 3", panel3);

        // Agregar el JTabbedPane al contenedor principal de la aplicación
        getContentPane().add(tabbedPane, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new EjemploTabbedPane().setVisible(true);
        });
    }
}
