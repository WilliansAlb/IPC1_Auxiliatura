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
public class EjemploLayeredPane extends JFrame {

    private JLayeredPane layeredPane;

    public EjemploLayeredPane() {
        setTitle("Ejemplo JLayeredPane");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(600, 400));

        // Crear un panel rojo en la capa inferior
        JPanel panelRojo = new JPanel();
        panelRojo.setBackground(Color.RED);
        panelRojo.setBounds(50, 50, 200, 200);

        // Crear un panel verde en la capa intermedia
        JPanel panelVerde = new JPanel();
        panelVerde.setBackground(Color.GREEN);
        panelVerde.setBounds(100, 100, 200, 200);

        // Crear un panel azul en la capa superior
        JPanel panelAzul = new JPanel();
        panelAzul.setBackground(Color.BLUE);
        panelAzul.setBounds(150, 150, 200, 200);

        // Crear un JLayeredPane y agregar los paneles en diferentes capas
        layeredPane = new JLayeredPane();
        layeredPane.add(panelRojo, 1);
        layeredPane.add(panelVerde, 2);
        layeredPane.add(panelAzul, 0);

        // Agregar el JLayeredPane al contenedor principal de la aplicación
        getContentPane().add(layeredPane, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new EjemploLayeredPane().setVisible(true);
        });
    }
}