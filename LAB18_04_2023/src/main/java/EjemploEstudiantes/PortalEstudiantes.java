/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjemploEstudiantes;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author willi
 */
public class PortalEstudiantes extends javax.swing.JFrame {

    private Listado listado;

    /**
     * Creates new form PortalEstudiantes
     */
    public PortalEstudiantes() {
        initComponents();
        listado = new Listado();
        setTitle("Portal de Estudiantes");
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

        EspaciosApp = new javax.swing.JTabbedPane();
        PanelCarga = new javax.swing.JPanel();
        LabelCarga = new javax.swing.JLabel();
        LabelExplicacionCarga = new javax.swing.JLabel();
        BotonCarga = new javax.swing.JButton();
        ScrollTaArchivo = new javax.swing.JScrollPane();
        TaArchivo = new javax.swing.JTextArea();
        BotonIngresoEstudiantes = new javax.swing.JButton();
        PanelIngreso = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TfNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TfCarne = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        CbSeccion = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        CbMatematicas = new javax.swing.JCheckBox();
        CbBiologia = new javax.swing.JCheckBox();
        CbSociales = new javax.swing.JCheckBox();
        CbLiteratura = new javax.swing.JCheckBox();
        BotonIngresoEstudiante = new javax.swing.JButton();
        PanelListado = new javax.swing.JPanel();
        ScrollListado = new javax.swing.JScrollPane();
        TablaEstudiantes = new javax.swing.JTable();
        LabelListado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelCarga.setLayout(new javax.swing.BoxLayout(PanelCarga, javax.swing.BoxLayout.Y_AXIS));

        LabelCarga.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        LabelCarga.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelCarga.setText("Carga de Archivo");
        LabelCarga.setAlignmentX(Component.CENTER_ALIGNMENT);
        PanelCarga.add(LabelCarga);

        LabelExplicacionCarga.setText("Acá debes de ingresar un archivo para añadir dichos estudiantes al sistema");
        LabelExplicacionCarga.setAlignmentX(Component.CENTER_ALIGNMENT);
        PanelCarga.add(LabelExplicacionCarga);

        BotonCarga.setText("CARGAR ARCHIVO");
        BotonCarga.setAlignmentX(Component.CENTER_ALIGNMENT);
        BotonCarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCargaActionPerformed(evt);
            }
        });
        PanelCarga.add(BotonCarga);

        TaArchivo.setColumns(20);
        TaArchivo.setRows(5);
        TaArchivo.setEnabled(false);
        ScrollTaArchivo.setViewportView(TaArchivo);

        PanelCarga.add(ScrollTaArchivo);

        BotonIngresoEstudiantes.setText("INGRESAR ESTUDIANTES DEL ARCHIVO");
        BotonIngresoEstudiantes.setAlignmentX(Component.CENTER_ALIGNMENT);
        BotonIngresoEstudiantes.setEnabled(false);
        PanelCarga.add(BotonIngresoEstudiantes);

        EspaciosApp.addTab("Cargar Archivo", PanelCarga);

        PanelIngreso.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setText("Ingreso de estudiantes");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        PanelIngreso.add(jLabel1, gridBagConstraints);

        jLabel2.setText("Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        PanelIngreso.add(jLabel2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        PanelIngreso.add(TfNombre, gridBagConstraints);

        jLabel3.setText("Carne");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        PanelIngreso.add(jLabel3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        PanelIngreso.add(TfCarne, gridBagConstraints);

        jLabel4.setText("Seccion");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        PanelIngreso.add(jLabel4, gridBagConstraints);

        CbSeccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        PanelIngreso.add(CbSeccion, gridBagConstraints);

        jLabel5.setText("Cursos");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        PanelIngreso.add(jLabel5, gridBagConstraints);

        CbMatematicas.setText("Matematicas");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        PanelIngreso.add(CbMatematicas, gridBagConstraints);

        CbBiologia.setText("Biologia");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        PanelIngreso.add(CbBiologia, gridBagConstraints);

        CbSociales.setText("Sociales");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        PanelIngreso.add(CbSociales, gridBagConstraints);

        CbLiteratura.setText("Literatura");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        PanelIngreso.add(CbLiteratura, gridBagConstraints);

        BotonIngresoEstudiante.setText("Ingresar Estudiante");
        BotonIngresoEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonIngresoEstudianteActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 4;
        PanelIngreso.add(BotonIngresoEstudiante, gridBagConstraints);

        EspaciosApp.addTab("Ingreso Estudiante", PanelIngreso);

        PanelListado.setLayout(new java.awt.BorderLayout());

        TablaEstudiantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOMBRE", "CARNE", "SECCION", "CURSOS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ScrollListado.setViewportView(TablaEstudiantes);

        PanelListado.add(ScrollListado, java.awt.BorderLayout.CENTER);

        LabelListado.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        LabelListado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelListado.setText("Listado");
        PanelListado.add(LabelListado, java.awt.BorderLayout.PAGE_START);

        EspaciosApp.addTab("Listado Estudiantes", PanelListado);

        getContentPane().add(EspaciosApp, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonCargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCargaActionPerformed
        JFileChooser fc = new JFileChooser();
        int archivoCorrecto = fc.showDialog(this, "Subir");
        if (archivoCorrecto == 0) {
            try {
                File cargado = fc.getSelectedFile();
                BufferedReader br = null;
                br = new BufferedReader(new FileReader(cargado));
                String cadena = "";
                while ((cadena = br.readLine()) != null) {
                    if (TaArchivo.getText().isEmpty()) {
                        TaArchivo.setText(cadena);
                    } else {
                        TaArchivo.setText(TaArchivo.getText() + "\n" + cadena);
                    }
                }
                listado.leerArchivo(TaArchivo.getText());
                System.out.println("Numero total de estudiantes leidos " + listado.getEstudiantes().length);
                listado.modificarTabla(TablaEstudiantes);
                BotonIngresoEstudiantes.setEnabled(true);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(PortalEstudiantes.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(PortalEstudiantes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_BotonCargaActionPerformed

    private void BotonIngresoEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonIngresoEstudianteActionPerformed
        String mate = (CbMatematicas.isSelected()) ? "matematicas" : "";
        String biologia = (CbBiologia.isSelected()) ? "biologia" : "";
        String literatura = (CbLiteratura.isSelected()) ? "literatura" : "";
        String sociales = (CbSociales.isSelected()) ? "sociales" : "";
        String nombre = TfNombre.getText();
        int carne = Integer.parseInt(TfCarne.getText());
        char seccion = CbSeccion.getSelectedItem().toString().charAt(0);
        String[] cursos_check = {mate, biologia, literatura, sociales};
        String[] cursos = null;
        for (int i = 0; i < cursos_check.length; i++) {
            if (!cursos_check[i].isEmpty()) {
                if (cursos == null) {
                    cursos = new String[1];
                    cursos[0] = cursos_check[i];
                } else {
                    String[] temp = new String[cursos.length+1];
                    System.arraycopy(cursos, 0, temp, 0, cursos.length);
                    temp[cursos.length] = cursos_check[i];
                    cursos = temp;
                }
            }
        }
        Estudiante estudiante = new Estudiante(nombre, carne, seccion, cursos);
        listado.agregarEstudiante(estudiante);
        listado.modificarTabla(TablaEstudiantes);
        TfNombre.setText("");
        TfCarne.setText("");
        CbSeccion.setSelectedIndex(0);
        CbMatematicas.setSelected(false);
        CbBiologia.setSelected(false);
        CbLiteratura.setSelected(false);
        CbSociales.setSelected(false);
    }//GEN-LAST:event_BotonIngresoEstudianteActionPerformed

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
            java.util.logging.Logger.getLogger(PortalEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PortalEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PortalEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PortalEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PortalEstudiantes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonCarga;
    private javax.swing.JButton BotonIngresoEstudiante;
    private javax.swing.JButton BotonIngresoEstudiantes;
    private javax.swing.JCheckBox CbBiologia;
    private javax.swing.JCheckBox CbLiteratura;
    private javax.swing.JCheckBox CbMatematicas;
    private javax.swing.JComboBox<String> CbSeccion;
    private javax.swing.JCheckBox CbSociales;
    private javax.swing.JTabbedPane EspaciosApp;
    private javax.swing.JLabel LabelCarga;
    private javax.swing.JLabel LabelExplicacionCarga;
    private javax.swing.JLabel LabelListado;
    private javax.swing.JPanel PanelCarga;
    private javax.swing.JPanel PanelIngreso;
    private javax.swing.JPanel PanelListado;
    private javax.swing.JScrollPane ScrollListado;
    private javax.swing.JScrollPane ScrollTaArchivo;
    private javax.swing.JTextArea TaArchivo;
    private javax.swing.JTable TablaEstudiantes;
    private javax.swing.JTextField TfCarne;
    private javax.swing.JTextField TfNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
