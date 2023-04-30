/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Concurso;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yelbetto
 */
public class Concurso extends javax.swing.JFrame {
    private ImageIcon client;
    private DefaultTableModel modelo;
    private DefaultTableModel modelo2;
    private volatile boolean ejecutandose = false;
    private Supermercado supermercado;

    /**
     * Creates new form Concurso
     */
    public Concurso() {
        initComponents();
        setTitle("Supermercados SUMA");
        iniciarImagenes();
    }

    public JTable getTablaProductos1() {
        return TablaProductos1;
    }

    public void setTablaProductos1(JTable TablaProductos1) {
        this.TablaProductos1 = TablaProductos1;
    }

    public JTable getTablaProductos2() {
        return TablaProductos2;
    }

    public void setTablaProductos2(JTable TablaProductos2) {
        this.TablaProductos2 = TablaProductos2;
    }
    
    

    public boolean isEjecutandose() {
        return ejecutandose;
    }

    public void setEjecutandose(boolean ejecutandose) {
        this.ejecutandose = ejecutandose;
    }

    public ImageIcon getClient() {
        return client;
    }

    public void setClient(ImageIcon client) {
        this.client = client;
    }
    
    public JLabel getTemporizador(){
        return LabelTemporizador;
    }

    public JPanel getPanelFila1() {
        return PanelFila1;
    }

    public void setPanelFila1(JPanel PanelFila1) {
        this.PanelFila1 = PanelFila1;
    }

    public JPanel getPanelFila2() {
        return PanelFila2;
    }

    public void setPanelFila2(JPanel PanelFila2) {
        this.PanelFila2 = PanelFila2;
    }

    public DefaultTableModel getModelo() {
        return modelo;
    }

    public void setModelo(DefaultTableModel modelo) {
        this.modelo = modelo;
    }

    public DefaultTableModel getModelo2() {
        return modelo2;
    }

    public void setModelo2(DefaultTableModel modelo2) {
        this.modelo2 = modelo2;
    }

    public JLabel getLabelAccion1() {
        return LabelAccion1;
    }

    public void setLabelAccion1(JLabel LabelAccion1) {
        this.LabelAccion1 = LabelAccion1;
    }

    public JLabel getLabelAccion2() {
        return LabelAccion2;
    }

    public void setLabelAccion2(JLabel LabelAccion2) {
        this.LabelAccion2 = LabelAccion2;
    }

    public JLabel getLabelAtendidos1() {
        return LabelAtendidos1;
    }

    public void setLabelAtendidos1(JLabel LabelAtendidos1) {
        this.LabelAtendidos1 = LabelAtendidos1;
    }

    public JLabel getLabelAtendidos2() {
        return LabelAtendidos2;
    }

    public void setLabelAtendidos2(JLabel LabelAtendidos2) {
        this.LabelAtendidos2 = LabelAtendidos2;
    }

    public JLabel getLabelProductos1() {
        return LabelProductos1;
    }

    public void setLabelProductos1(JLabel LabelProductos1) {
        this.LabelProductos1 = LabelProductos1;
    }

    public JLabel getLabelProductos2() {
        return LabelProductos2;
    }

    public void setLabelProductos2(JLabel LabelProductos2) {
        this.LabelProductos2 = LabelProductos2;
    }

    public Supermercado getSupermercado() {
        return supermercado;
    }

    public void setSupermercado(Supermercado supermercado) {
        this.supermercado = supermercado;
    }
    
    public void iniciarImagenes() {
        try {
            BufferedImage bufferedImage = ImageIO.read(this.getClass().getResource("/img/cajera.png"));
            Image image = bufferedImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            BufferedImage bi = ImageIO.read(this.getClass().getResource("/img/client.png"));
            Image imgClient = bi.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            client = new ImageIcon(imgClient);
            LabelCajera1.setIcon(new ImageIcon(image));
            LabelCajera2.setIcon(new ImageIcon(image));
            modelo = new DefaultTableModel();
            modelo.addColumn("Producto");
            modelo.addColumn("Precio");
            modelo.addColumn("Peso");
            TablaProductos1.setFont(new Font("Ubuntu Mono",Font.PLAIN,10));
            TablaProductos1.getTableHeader().setFont(new Font("Ubuntu Mono", Font.BOLD, 13));
            TablaProductos1.setModel(modelo);
            BufferedImage temp = ImageIO.read(this.getClass().getResource("/img/cronometro.png"));
            Image temporizador = temp.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            LabelTemporizador.setIcon(new ImageIcon(temporizador));
            LabelTemporizador.setHorizontalTextPosition(JLabel.CENTER);
            LabelTemporizador.setFont(new Font("Ubuntu Mono",Font.BOLD,20));
            modelo2 = new DefaultTableModel();
            modelo2.addColumn("Producto");
            modelo2.addColumn("Precio");
            modelo2.addColumn("Peso");
            TablaProductos2.setFont(new Font("Ubuntu Mono",Font.PLAIN,10));
            TablaProductos2.getTableHeader().setFont(new Font("Ubuntu Mono", Font.BOLD, 13));
            TablaProductos2.setModel(modelo2);
            
        } catch (IOException ex) {
            Logger.getLogger(Concurso.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        PanelControl = new javax.swing.JPanel();
        BotonIniciar = new javax.swing.JButton();
        LabelTemporizador = new javax.swing.JLabel();
        PanelCajero1 = new javax.swing.JPanel();
        LabelCajera1 = new javax.swing.JLabel();
        PanelControlCajera1 = new javax.swing.JPanel();
        LabelAtendidos1 = new javax.swing.JLabel();
        LabelProductos1 = new javax.swing.JLabel();
        LabelEstado1 = new javax.swing.JLabel();
        LabelAccion1 = new javax.swing.JLabel();
        ScrollPantalla1 = new javax.swing.JScrollPane();
        TablaProductos1 = new javax.swing.JTable();
        ScrollFila1 = new javax.swing.JScrollPane();
        PanelFila1 = new javax.swing.JPanel();
        PanelCajero2 = new javax.swing.JPanel();
        LabelCajera2 = new javax.swing.JLabel();
        PanelControlCajera2 = new javax.swing.JPanel();
        LabelAtendidos2 = new javax.swing.JLabel();
        LabelProductos2 = new javax.swing.JLabel();
        LabelEstado2 = new javax.swing.JLabel();
        LabelAccion2 = new javax.swing.JLabel();
        ScrollPantalla2 = new javax.swing.JScrollPane();
        TablaProductos2 = new javax.swing.JTable();
        ScrollFila2 = new javax.swing.JScrollPane();
        PanelFila2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        PanelControl.setLayout(new java.awt.GridLayout(1, 2));

        BotonIniciar.setText("Iniciar");
        BotonIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonIniciarActionPerformed(evt);
            }
        });
        PanelControl.add(BotonIniciar);

        LabelTemporizador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTemporizador.setText("00:15");
        PanelControl.add(LabelTemporizador);

        getContentPane().add(PanelControl);

        PanelCajero1.setLayout(new java.awt.GridBagLayout());
        PanelCajero1.add(LabelCajera1, new java.awt.GridBagConstraints());

        PanelControlCajera1.setBackground(new java.awt.Color(0, 0, 0));
        PanelControlCajera1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 3, true));
        PanelControlCajera1.setForeground(new java.awt.Color(255, 255, 255));
        PanelControlCajera1.setPreferredSize(new java.awt.Dimension(400, 200));
        PanelControlCajera1.setLayout(new java.awt.GridBagLayout());

        LabelAtendidos1.setFont(new java.awt.Font("Ubuntu Mono", 1, 12)); // NOI18N
        LabelAtendidos1.setForeground(new java.awt.Color(255, 255, 255));
        LabelAtendidos1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelAtendidos1.setText("Atendidos: 0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 25;
        gridBagConstraints.ipady = 10;
        PanelControlCajera1.add(LabelAtendidos1, gridBagConstraints);

        LabelProductos1.setFont(new java.awt.Font("Ubuntu Mono", 1, 12)); // NOI18N
        LabelProductos1.setForeground(new java.awt.Color(255, 255, 255));
        LabelProductos1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelProductos1.setText("Productos Cobrados: 0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 25;
        gridBagConstraints.ipady = 10;
        PanelControlCajera1.add(LabelProductos1, gridBagConstraints);

        LabelEstado1.setFont(new java.awt.Font("Ubuntu Mono", 1, 12)); // NOI18N
        LabelEstado1.setForeground(new java.awt.Color(255, 255, 255));
        LabelEstado1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelEstado1.setText("Estado:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        PanelControlCajera1.add(LabelEstado1, gridBagConstraints);

        LabelAccion1.setFont(new java.awt.Font("Ubuntu Mono", 1, 12)); // NOI18N
        LabelAccion1.setForeground(new java.awt.Color(255, 255, 255));
        LabelAccion1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        PanelControlCajera1.add(LabelAccion1, gridBagConstraints);

        ScrollPantalla1.setPreferredSize(new java.awt.Dimension(350, 100));

        TablaProductos1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        ScrollPantalla1.setViewportView(TablaProductos1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        PanelControlCajera1.add(ScrollPantalla1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        PanelCajero1.add(PanelControlCajera1, gridBagConstraints);

        ScrollFila1.setPreferredSize(new java.awt.Dimension(600, 100));

        PanelFila1.setLayout(new javax.swing.BoxLayout(PanelFila1, javax.swing.BoxLayout.X_AXIS));
        ScrollFila1.setViewportView(PanelFila1);

        PanelCajero1.add(ScrollFila1, new java.awt.GridBagConstraints());

        getContentPane().add(PanelCajero1);

        PanelCajero2.setLayout(new java.awt.GridBagLayout());
        PanelCajero2.add(LabelCajera2, new java.awt.GridBagConstraints());

        PanelControlCajera2.setBackground(new java.awt.Color(0, 0, 0));
        PanelControlCajera2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 3, true));
        PanelControlCajera2.setForeground(new java.awt.Color(255, 255, 255));
        PanelControlCajera2.setPreferredSize(new java.awt.Dimension(400, 200));
        PanelControlCajera2.setLayout(new java.awt.GridBagLayout());

        LabelAtendidos2.setFont(new java.awt.Font("Ubuntu Mono", 1, 12)); // NOI18N
        LabelAtendidos2.setForeground(new java.awt.Color(255, 255, 255));
        LabelAtendidos2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelAtendidos2.setText("Atendidos: 0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 25;
        gridBagConstraints.ipady = 10;
        PanelControlCajera2.add(LabelAtendidos2, gridBagConstraints);

        LabelProductos2.setFont(new java.awt.Font("Ubuntu Mono", 1, 12)); // NOI18N
        LabelProductos2.setForeground(new java.awt.Color(255, 255, 255));
        LabelProductos2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelProductos2.setText("Productos Cobrados: 0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 25;
        gridBagConstraints.ipady = 10;
        PanelControlCajera2.add(LabelProductos2, gridBagConstraints);

        LabelEstado2.setFont(new java.awt.Font("Ubuntu Mono", 1, 12)); // NOI18N
        LabelEstado2.setForeground(new java.awt.Color(255, 255, 255));
        LabelEstado2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelEstado2.setText("Estado:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        PanelControlCajera2.add(LabelEstado2, gridBagConstraints);

        LabelAccion2.setFont(new java.awt.Font("Ubuntu Mono", 1, 12)); // NOI18N
        LabelAccion2.setForeground(new java.awt.Color(255, 255, 255));
        LabelAccion2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        PanelControlCajera2.add(LabelAccion2, gridBagConstraints);

        ScrollPantalla2.setPreferredSize(new java.awt.Dimension(350, 100));

        TablaProductos2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        ScrollPantalla2.setViewportView(TablaProductos2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        PanelControlCajera2.add(ScrollPantalla2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        PanelCajero2.add(PanelControlCajera2, gridBagConstraints);

        ScrollFila2.setPreferredSize(new java.awt.Dimension(600, 100));

        PanelFila2.setLayout(new javax.swing.BoxLayout(PanelFila2, javax.swing.BoxLayout.X_AXIS));
        ScrollFila2.setViewportView(PanelFila2);

        PanelCajero2.add(ScrollFila2, new java.awt.GridBagConstraints());

        getContentPane().add(PanelCajero2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonIniciarActionPerformed
//        PanelFila1.add(new JButton(client));
//        PanelFila1.revalidate();
//        PanelFila1.repaint();
//        modelo.addRow(new Object[]{"Producto1","Precio1","Peso1"});
        ejecutandose = true;
        supermercado = new Supermercado(this);
        supermercado.abastecerCatalogo();
        Temporizador temporizador = new Temporizador(this);
        temporizador.start();
        supermercado.start();
//        Cajero c1 = new Cajero(this,"German",0.15,0.30,1,3);
//        c1.start();
//        Cajero c2 = new Cajero(this,"Luis",0.10,0.35,2,2);
//        c2.start();
    }//GEN-LAST:event_BotonIniciarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Concurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Concurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Concurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Concurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Concurso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonIniciar;
    private javax.swing.JLabel LabelAccion1;
    private javax.swing.JLabel LabelAccion2;
    private javax.swing.JLabel LabelAtendidos1;
    private javax.swing.JLabel LabelAtendidos2;
    private javax.swing.JLabel LabelCajera1;
    private javax.swing.JLabel LabelCajera2;
    private javax.swing.JLabel LabelEstado1;
    private javax.swing.JLabel LabelEstado2;
    private javax.swing.JLabel LabelProductos1;
    private javax.swing.JLabel LabelProductos2;
    private javax.swing.JLabel LabelTemporizador;
    private javax.swing.JPanel PanelCajero1;
    private javax.swing.JPanel PanelCajero2;
    private javax.swing.JPanel PanelControl;
    private javax.swing.JPanel PanelControlCajera1;
    private javax.swing.JPanel PanelControlCajera2;
    private javax.swing.JPanel PanelFila1;
    private javax.swing.JPanel PanelFila2;
    private javax.swing.JScrollPane ScrollFila1;
    private javax.swing.JScrollPane ScrollFila2;
    private javax.swing.JScrollPane ScrollPantalla1;
    private javax.swing.JScrollPane ScrollPantalla2;
    private javax.swing.JTable TablaProductos1;
    private javax.swing.JTable TablaProductos2;
    // End of variables declaration//GEN-END:variables
}
