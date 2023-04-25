/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjemploEstudiantes;

import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author willi
 */
public class Listado {

    private Estudiante[] estudiantes;

    public Listado() {

    }

    public void leerArchivo(String archivo) {
        String[] lineas = archivo.split("\n");
        for (int i = 0; i < lineas.length; i++) {
            if (lineas[i].contains("ESTUDIANTE-----------------------------")) {
                if (estudiantes != null) {
                    Estudiante[] temp = new Estudiante[estudiantes.length + 1];
                    for (int j = 0; j < estudiantes.length; j++) {
                        temp[j] = estudiantes[j];
                    }
                    estudiantes = temp;
                } else {
                    estudiantes = new Estudiante[1];
                }
                estudiantes[estudiantes.length - 1] = new Estudiante();
            } else {
                if (estudiantes != null) {
                    if (lineas[i].contains("NOMBRE")) {
                        String stemp = "";
                        String[] partes = lineas[i].split(" ");
                        for (int j = 1; j < partes.length; j++) {
                            if (j != partes.length - 1) {
                                stemp += partes[j] + " ";
                            } else {
                                stemp += partes[j];
                            }
                        }
                        estudiantes[estudiantes.length - 1].setNombre(stemp);
                    } else if (lineas[i].contains("CARNE")) {
                        estudiantes[estudiantes.length - 1].setCarne(Integer.parseInt(lineas[i].split(" ")[1]));
                    } else if (lineas[i].contains("CURSOS")) {
                        String[] partes = lineas[i].split(" ");
                        String stemp = "";
                        for (int j = 1; j < partes[1].length() - 1; j++) {
                            stemp += partes[1].charAt(j) + "";
                        }
                        estudiantes[estudiantes.length - 1].setCursos(stemp.split(","));
                    } else if (lineas[i].contains("SECCION")) {
                        estudiantes[estudiantes.length - 1].setSeccion(lineas[i].split(" ")[1].charAt(0));
                    }
                } else {
                    JOptionPane.showConfirmDialog(null, "Archivo mal estructurado", "Error", 0, 0);
                    break;
                }
            }
        }
    }

    public void modificarTabla(JTable tabla) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("Carne");
        modelo.addColumn("Seccion");
        modelo.addColumn("Cursos");
        for (int i = 0; i < estudiantes.length; i++) {
            modelo.addRow(new Object[]{estudiantes[i].getNombre(),
                estudiantes[i].getCarne(), estudiantes[i].getSeccion(),
                Arrays.toString(estudiantes[i].getCursos())});
        }
        tabla.setModel(modelo);
    }

    public void agregarEstudiante(Estudiante nuevo) {
        Estudiante[] temp = new Estudiante[estudiantes.length + 1];
        System.arraycopy(estudiantes, 0, temp, 0, estudiantes.length);
        temp[estudiantes.length] = nuevo;
        estudiantes = temp;
    }

    public Estudiante[] getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(Estudiante[] estudiantes) {
        this.estudiantes = estudiantes;
    }
}
