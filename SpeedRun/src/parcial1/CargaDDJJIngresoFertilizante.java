package parcial1;

import java.util.Scanner;

public class CargaDDJJIngresoFertilizante {

    static String[][] fertilizantesPermitidos = {{"101", "UREA", "BS"}, {"102", "SULFATO AMONIACO", "BS"}, {"103", "NITRATO AMONIACO", "BS"}, {"104", "NITRATO DE CALCIO", "BS"}, {"105", "SUPERFOSFATO SIMPLE", "BD"}, {"106", "SUPERFOSFATO TRIPLE", "BD"}, {"107", "NITRATO AMONIACO", "BS"}, {"108", "CLORURO DE POTASIO", "BD"}, {"109", "SULFATO DE POTASIO", "BS"}, {"110", "NITROGENO LIQUIDO", "BD"}};
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        DDJJIngresoFertilizante DDJJIF = new DDJJIngresoFertilizante();

        DDJJIF.setEmpresa(validarEmpresa());
        DDJJIF.setCuitEmpresa(validarCuit());
        DDJJIF.setAnioDeclaracion(validarAnio());
        DDJJIF.setMesDeclaracion(validarMes());

        int aux = 0;
        int cantidadDeFertilizantes = validarCantidadDeFertilizantes();
        String[][] detallesFertilizantes = new String[cantidadDeFertilizantes + 1][6];
        crearEncabezado(detallesFertilizantes);
        int vacio = 1;
        while (true) {

            int codigo = validarCodigo();
            String SCodigo = String.valueOf(codigo);

            for (int i = 0; i < fertilizantesPermitidos.length; i++) {
                if (SCodigo.equals(fertilizantesPermitidos[i][0])) {
                    if (fertilizantesPermitidos[i][2].equals("BS")) {
                        int capacidad = validarCapacidadBolsa();
                        int cantidad = cantidadBolsa();
                        int subtotal = SubtotalBolsa(capacidad, cantidad);

                        String SCapacidad = String.valueOf(capacidad);
                        String SCantidad = String.valueOf(cantidad);
                        String SSubtotal = String.valueOf(subtotal);

                        agregarFila(detallesFertilizantes, i, vacio, SCapacidad, SCantidad, SSubtotal);
                        vacio++;

                    } else {
                        int cantidad = cantidadBidon();
                        int subTotal = cantidad * 12;

                        String SCantidad = String.valueOf(cantidad);
                        String SSubtotal = String.valueOf(subTotal);

                        agregarFila(detallesFertilizantes, i, vacio, "5", SCantidad, SSubtotal);
                        vacio++;
                    }
                }
            }
            aux++;
            if (aux == cantidadDeFertilizantes) {
                break;
            }

        }
        DDJJIF.setDetallesFertilizantes(detallesFertilizantes);
        DDJJIF.setMontoXIngreso(calcularTotalAbonoIngreso(detallesFertilizantes));
        mostrarArray(detallesFertilizantes, DDJJIF);
    }

    public static int calcularTotalAbonoIngreso(String[][] detallesFertilizantes) {
        int acumulador = 0;
        for (int i = 1; i < detallesFertilizantes.length; i++) {
            int aux = Integer.parseInt(detallesFertilizantes[i][5]);

            acumulador += aux;
        }
        return acumulador;
    }

    public static void saltoDeLinea(){
        System.out.println("");
    }
    
    public static void mostrarArray(String[][] detallesFertilizantes, DDJJIngresoFertilizante DDJJIF) {
        saltoDeLinea();
        System.out.println("EMPRESA: "+DDJJIF.getEmpresa());
        System.out.println("CUIT: "+DDJJIF.getCuitEmpresa());
        System.out.println("MES: "+DDJJIF.getMesDeclaracion());
        System.out.println("AÑIO: "+DDJJIF.getAnioDeclaracion());
        saltoDeLinea();
        
        for (int i = 0; i < detallesFertilizantes.length; i++) {
            System.out.println("");
            for (int j = 0; j < detallesFertilizantes[i].length; j++) {

                System.out.print(detallesFertilizantes[i][j] + "\t");

            }
        }
        System.out.println("\nEL TOTAL ES: "+ DDJJIF.getMontoXIngreso());
    }

    public static int SubtotalBolsa(int bolsa, int cantidadBolsa) {
        int subtotal;

        if (bolsa == 5) {
            subtotal = 5 * cantidadBolsa;
        } else if (bolsa == 10) {
            subtotal = 8 * cantidadBolsa;
        } else if (bolsa == 25) {
            subtotal = 20 * cantidadBolsa;
        } else {
            subtotal = 36 * cantidadBolsa;
        }
        return subtotal;
    }

    public static String[][] crearEncabezado(String[][] detallesFertilizantes) {
        detallesFertilizantes[0][0] = "Codigo fertilizante";
        detallesFertilizantes[0][1] = "Nombre fertilizante";
        detallesFertilizantes[0][2] = "Tipo de envase";
        detallesFertilizantes[0][3] = "Capacidad envase";
        detallesFertilizantes[0][4] = "Cantidad envase";
        detallesFertilizantes[0][5] = "Subtotal";

        return detallesFertilizantes;
    }

    public static int cantidadBolsa() {
        int cantidad;
        do {
            System.out.println("Ingrese la cantidad de BOLSAS: ");
            cantidad = sc.nextInt();
        } while (cantidad < 0);

        return cantidad;
    }

    public static String[][] agregarFila(String[][] detallesFertilizantes, int i, int vacio, String capacidad, String cantidad, String subtotal) {
        detallesFertilizantes[vacio][0] = fertilizantesPermitidos[i][0];
        detallesFertilizantes[vacio][1] = fertilizantesPermitidos[i][1];
        detallesFertilizantes[vacio][2] = fertilizantesPermitidos[i][2];
        detallesFertilizantes[vacio][3] = capacidad;
        detallesFertilizantes[vacio][4] = cantidad;
        detallesFertilizantes[vacio][5] = subtotal;

        return detallesFertilizantes;
    }

    public static String validarEmpresa() {
        String empresa;
        do {
            System.out.println("Ingrese el nombre de la EMPRESA: ");
            empresa = sc.nextLine();
        } while (empresa.isEmpty());

        return empresa;
    }

    public static long validarCuit() {
        long cuit;
        String cuitString;
        do {
            System.out.println("Ingrese el CUIT: ");
            cuit = sc.nextLong();
            cuitString = String.valueOf(cuit);
        } while (cuitString.length() != 11);

        return cuit;
    }

    public static int validarAnio() {
        int anio;
        do {
            System.out.println("Ingrese el AÑO: ");
            anio = sc.nextInt();
        } while (anio != 2022);

        return anio;
    }

    public static int validarMes() {
        int mes;
        do {
            System.out.println("Ingrese el MES: ");
            mes = sc.nextInt();
        } while (mes != 4);

        return mes;
    }

    public static int validarCantidadDeFertilizantes() {
        int aux;
        do {
            System.out.println("Ingrese la cantidad de fertilizantes discriminado que quiere ingresar a la provincia: ");
            aux = sc.nextInt();
        } while (aux <= 0);

        return aux;
    }

    public static int validarCodigo() {
        int codigoFertilizante;
        do {
            System.out.println("Ingrese el CODIGO: ");
            codigoFertilizante = sc.nextInt();

        } while (codigoFertilizante <= 100 || codigoFertilizante >= 111);
        return codigoFertilizante;
    }

    public static int validarCapacidadBolsa() {
        int bolsa;

        while (true) {
            System.out.println("Ingrese la CAPACIDAD de la BOLSA: ");
            bolsa = sc.nextInt();

            if (bolsa == 5 || bolsa == 10 || bolsa == 25 || bolsa == 50) {
                break;
            }
        }
        return bolsa;
    }

    public static int cantidadBidon() {
        int bidon;
        do {
            System.out.println("Ingrese la cantidad de bidones: ");
            bidon = sc.nextInt();
        } while (bidon < 0);

        return bidon;
    }

}
