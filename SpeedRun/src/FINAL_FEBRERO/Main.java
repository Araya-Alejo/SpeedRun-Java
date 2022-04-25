package FINAL_FEBRERO;

import java.util.Scanner;

public class Main {

    static String[][] insumos;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        encabezadoArray();
        ProductoManufacturado producto = new ProductoManufacturado();

        System.out.println("    INGRESE");
        System.out.print("CODIGO: ");

        producto.setCodigo(sc.nextInt());
        System.out.print("DENOMINACION: ");

        producto.setDenominacion(sc.nextLine());

        System.out.print("TIEMPO DE FABRICACION: ");
        producto.setTiempoFabricacion(sc.nextInt());

        System.out.print("MARGEN DE GANANCIA");
        producto.setMargenGanancia(sc.nextDouble());
        
        System.out.print("CANTIDAD DE INSUMOS A CARGAR: ");
        int cantInsumos = 0;

    }

    public static void saltoDeLinea() {
        System.out.println("");
    }

    public static void encabezadoArray() {
        insumos[0][0] = "Codigo Consumo";
        insumos[0][1] = "Denominacion Insumo";
        insumos[0][2] = "Cantidad Insumo";
        insumos[0][3] = "Precio Costo";
    }
}
