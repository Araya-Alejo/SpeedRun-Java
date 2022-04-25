package FINAL;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class ExamenFinal {

    static Scanner sc = new Scanner(System.in);
    static int[][] tablero;
    static int dimension = 0;
    static ArrayList<PromedioArray> PROMEDIO_ARREGLO = new ArrayList();

    public static void main(String[] args) {

        inicializarArreglo();
        cargarArreglo();

        MOSTRAR_TABLERO();

        double promedioSI = SuperiorIzquierdo() / 4;
        double promedioSD = SuperiorDerecho() / 4;
        double promedioII = InferiorIzquierdo() / 4;
        double promedioID = InferiorDerecho() / 4;
        double promedioC = Centro() / 4;

        PromedioArray promedioArraySI = new PromedioArray("Promedio Superior Izquierdo", promedioSI);
        PromedioArray promedioArraySD = new PromedioArray("Promedio Superior Derecho", promedioSD);
        PromedioArray promedioArrayII = new PromedioArray("Promedio Inferior Izquierdo", promedioII);
        PromedioArray promedioArrayID = new PromedioArray("Promedio Inferior Izquierdo", promedioID);
        PromedioArray promedioArrayC = new PromedioArray("Promedio Centro", promedioC);

        cargarArrayLists(promedioArraySI, promedioArraySD, promedioArrayII, promedioArrayID, promedioArrayC);
        ordenarArrayList();
        
        MOSTRAR_ARRAYLIST();
        System.out.println("\nEl promedio total es: " + calcularTotal());

    }

    public static void ordenarArrayList() {
        Collections.sort(PROMEDIO_ARREGLO, new PromedioArray());
    }

    public static void cargarArrayLists(PromedioArray promedioArraySI, PromedioArray promedioArraySD, PromedioArray promedioArrayII, PromedioArray promedioArrayID, PromedioArray promedioArrayC) {
        PROMEDIO_ARREGLO.add(promedioArraySI);
        PROMEDIO_ARREGLO.add(promedioArraySD);
        PROMEDIO_ARREGLO.add(promedioArrayII);
        PROMEDIO_ARREGLO.add(promedioArrayID);
        PROMEDIO_ARREGLO.add(promedioArrayC);
    }

    public static double calcularTotal() {
        double cont = 0;
        for (int i = 0; i < PROMEDIO_ARREGLO.size(); i++) {
            cont = cont + PROMEDIO_ARREGLO.get(i).getPromedio();
        }
        cont = cont / 5;
        return cont;
    }

    public static void MOSTRAR_ARRAYLIST() {
        saltoDeLinea();
        saltoDeLinea();
        for (int i = 0; i < PROMEDIO_ARREGLO.size(); i++) {
            System.out.println(PROMEDIO_ARREGLO.get(i).getPosición()+":  " +PROMEDIO_ARREGLO.get(i).getPromedio());
        }
    }

    public static double Centro() {
        double centro = 0;

        int x1 = (dimension / 2);
        int x2 = (dimension / 2) - 1;

        centro = tablero[x1][x2] + tablero[x2][x2] + tablero[x2][x1] + tablero[x1][x1];

        return centro;
    }

    public static double InferiorDerecho() {
        //        Inferior Derecho
        double inferiorDerecho = tablero[dimension - 1][dimension - 1] + tablero[dimension - 1][dimension - 2] + tablero[dimension - 2][dimension - 2] + tablero[dimension - 2][dimension - 3]; //0-1 0-2 1-1 1-2
        return inferiorDerecho;

    }

    public static double InferiorIzquierdo() {
        //        Inferior Izquierdo
        double inferiorIzquierdo = tablero[dimension - 1][0] + tablero[dimension - 1][1] + tablero[dimension - 2][0] + tablero[dimension - 2][1]; //-10 -11 -20 -21
        return inferiorIzquierdo;
    }

    public static double SuperiorDerecho() {
        //        Superior Derecho
        double superiorDerecho = tablero[0][dimension - 1] + tablero[0][dimension - 2] + tablero[1][dimension - 1] + tablero[1][dimension - 2]; //0-1 0-2 1-1 1-2
        return superiorDerecho;
    }

    public static double SuperiorIzquierdo() {
        double superiorIzquierdo = tablero[0][0] + tablero[0][1] + tablero[1][0] + tablero[1][1]; //00 01 10 11

        return superiorIzquierdo;
    }

    public static void inicializarArreglo() {
        dimension = validarDimension();
        tablero = new int[dimension][dimension];
    }

    public static void MOSTRAR_TABLERO() {
        for (int i = 0; i < tablero.length; i++) {
            saltoDeLinea();
            for (int j = 0; j < tablero.length; j++) {
                System.out.print(tablero[i][j] + "  ");
            }

        }
        saltoDeLinea();
        saltoDeLinea();
    }

    public static void saltoDeLinea() {
        System.out.println("");
    }

    public static void cargarArreglo() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                tablero[i][j] = (int) Math.floor(Math.random() * 10);
            }

        }
    }

    public static int validarDimension() {
        int aux = 0;
        while (true) {
            System.out.println("INGRESE LA DIMENSION DEL ARREGLO");
            aux = sc.nextInt();
            if (aux >= 4 && aux % 2 == 0) {
                break;
            }
        }
        return aux;
    }

}
