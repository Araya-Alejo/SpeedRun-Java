package FINAL_FEBRERO;

import java.util.Scanner;

public class Main {

    static String[][] insumos;
    static Scanner sc = new Scanner(System.in);
    static int dimension = 0;
    static double total = 0;

    public static void main(String[] args) {

        ProductoManufacturado producto = new ProductoManufacturado();

        System.out.println("INSTANCIA: CREACION DEL PRODUCTO");
        producto.setCodigo(validarCodigo());

        System.out.print("DENOMINACION: ");
        producto.setDenominacion(validarString());

        System.out.print("TIEMPO DE FABRICACION: ");
        producto.setTiempoFabricacion(validarInt());

        System.out.print("MARGEN DE GANANCIA (0,##)");
        producto.setMargenGanancia(validarDouble());

        saltoDeLinea();
        System.out.println("INSTANCIA: PETICION DE LOS INSUMOS");
        System.out.print("CANTIDAD DE INSUMOS A CARGAR: ");
        inicializarArreglo();
        encabezadoArray();
        int vacio = 1;
        while (true) {
            System.out.println("    INGRESE");
            int codigo = validarCodigo();
            String Scodigo;
            Scodigo = String.valueOf(codigo);

            for (int i = 0; i < RecetaProducto.listaInsumos.length; i++) {
                if (Scodigo.equalsIgnoreCase(RecetaProducto.listaInsumos[i][0])) {

                    System.out.print("CANTIDAD DE INSUMOS A UTILIZAR: ");
                    int cantidad = validarCantidad();

                    agregarFila(vacio, i, cantidad);
                    vacio++;

                }
            }

            if (vacio - 1 == dimension) { //me va a faltar uno
                break;
            }

        }

        MOSTRAR_ARREGLO(producto);
    }

    public static String validarString() {
        String texto;
        while (true) {
            texto = sc.nextLine();
            if (!texto.isEmpty()) {
                return texto;
            }
        }
    }

    public static void MOSTRAR_ARREGLO(ProductoManufacturado producto) {

        saltoDeLinea();
        saltoDeLinea();
        System.out.println("CODIGO: " + producto.getCodigo());
        System.out.println("PRODUCTO: " + producto.getDenominacion());
        System.out.println("TIEPO DE ELABORACION: " + producto.getTiempoFabricacion());
        System.out.println("INSUMOS: ");
        for (int i = 0; i < insumos.length; i++) {
            saltoDeLinea();
            for (int j = 0; j < insumos[i].length; j++) {
                System.out.print(insumos[i][j] + "\t");
            }

        }
        saltoDeLinea();
        saltoDeLinea();
        System.out.println("COSTO TOTAL DEL PRODUCTO: " + costoTotalProducto());
        System.out.println("MARGEN DE GANACIA: " + producto.getMargenGanancia());
        System.out.println("PRECIO FINAL: " + precioVentaProducto(producto));
        saltoDeLinea();
        saltoDeLinea();
        
//        producto.setCodigo(validarCodigo());
    }

    public static int validarInt() {
        int aux = 0;
        while (true) {
            aux = sc.nextInt();
            if (aux > 0) {
                return aux;
            }
        }
    }

    public static double validarDouble() {
        double aux = 0;
        while (true) {
            aux = sc.nextDouble();
            if (aux > 0) {
                return aux;
            }
        }
    }

    public static double precioVentaProducto(ProductoManufacturado producto) {

        double porcentaje = 0;

        porcentaje = producto.getMargenGanancia() * costoTotalProducto();

        return porcentaje + total;
    }

    public static double costoTotalProducto() {

        return total;
    }

    public static void agregarFila(int k, int j, int cantidad) {
        int aux = Integer.parseInt(RecetaProducto.listaInsumos[j][3]) * cantidad;
        total = total + aux;

        insumos[k][0] = RecetaProducto.listaInsumos[j][0];
        insumos[k][1] = RecetaProducto.listaInsumos[j][1];
        insumos[k][2] = String.valueOf(cantidad) +" " +RecetaProducto.listaInsumos[j][2];
        insumos[k][3] = String.valueOf(aux);
    }

    public static int validarCantidad() {
        int cantidad = 0;

        while (true) {
            cantidad = sc.nextInt();
            if (cantidad > 0) {
                return cantidad;
            }
        }
    }

    public static int validarCodigo() {
        System.out.print("CODIGO: ");
        int aux = 0;
        while (true) {
            aux = sc.nextInt();
            if (aux >= 1000 || aux <= 1012) {
                return aux;
            }
        }
    }

    public static void inicializarArreglo() {
        dimension = validarConsumo();
        insumos = new String[dimension + 1][4];
    }

    public static int validarConsumo() {
        int consumo = 0;
        while (true) {
            consumo = sc.nextInt();
            if (consumo > 1 || consumo <= 13) {
                return consumo;
            }
        }
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
