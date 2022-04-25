package parcial2;

import java.util.ArrayList;
import java.util.Scanner;

public class Alumno {
    
    static Scanner sc = new Scanner(System.in);

    private long legajo;
    private String nombreCompleto;
    private double promedioNotas;
    private String estado;
    private ArrayList<Nota> notas;
    private ArrayList<Nota> notasRecuperatorios;
    private ArrayList<Nota> notasFinales;

    public Alumno() {
    }

    public long getLegajo() {
        return legajo;
    }

    public void setLegajo(long legajo) {
        this.legajo = legajo;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public double getPromedioNotas() {
        return promedioNotas;
    }

    public void setPromedioNotas(double promedioNotas) {
        this.promedioNotas = promedioNotas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ArrayList<Nota> getNotas() {
        return notas;
    }

    public void setNotas(ArrayList<Nota> notas) {
        this.notas = notas;
    }

    public ArrayList<Nota> getNotasRecuperatorios() {
        return notasRecuperatorios;
    }

    public void setNotasRecuperatorios(ArrayList<Nota> notasRecuperatorios) {
        this.notasRecuperatorios = notasRecuperatorios;
    }

    public ArrayList<Nota> getNotasFinales() {
        return notasFinales;
    }

    public void setNotasFinales(ArrayList<Nota> notasFinales) {
        this.notasFinales = notasFinales;
    }

    
    
}
