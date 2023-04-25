/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjemploEstudiantes;

/**
 *
 * @author willi
 */
public class Estudiante {
    private String nombre;
    private int carne;
    private char seccion;
    private String[] cursos;
    
    public Estudiante(String nombre, int carne, char seccion, String[] cursos){
        this.nombre = nombre;
        this.carne = carne;
        this.seccion = seccion;
        this.cursos = cursos;
    }
    
    public Estudiante(){
    
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCarne() {
        return carne;
    }

    public void setCarne(int carne) {
        this.carne = carne;
    }

    public char getSeccion() {
        return seccion;
    }

    public void setSeccion(char seccion) {
        this.seccion = seccion;
    }

    public String[] getCursos() {
        return cursos;
    }

    public void setCursos(String[] cursos) {
        this.cursos = cursos;
    }
    
    
}
