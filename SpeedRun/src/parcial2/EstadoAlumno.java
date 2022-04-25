package parcial2;

import java.util.ArrayList;
import java.util.Scanner;

public class EstadoAlumno {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Nota> notas = new ArrayList();
    static ArrayList<Nota> recuperatorio = new ArrayList();
    static ArrayList<Nota> notasFinales = new ArrayList();
    static Alumno alumno = new Alumno();
    static double promedio;

    public static void main(String[] args) {

        crearAlumno();
        ingresarNotas();
        alumno.setNotas(notas);

        valirdarNotas_Recuperatorios();
        ingresarNotas_Recuperatorio();
        alumno.setNotasRecuperatorios(recuperatorio);

        agregarNotasFinales();
        alumno.setNotasFinales(notasFinales);

        estadoDelAlumno();

        MOSTRAR_DATOS_ALUMNO();
    }

    public static void estadoDelAlumno() {
        if (validarLibre()) {
            alumno.setEstado("LIBRE");
        } else {
            promedio = calcularPromedio();

            if (promedio < 4.0) {
                alumno.setEstado("LIBRE");
            } else if (promedio >= 4.0 && promedio < 6.0) {
                alumno.setEstado("REGULAR");
            } else if (promedio > 6.0) {
                alumno.setEstado("PROMOCIONADO");
            } else {
                System.out.println("ERROR DE VALIDACION.");
            }
        }
    }

    public static void MOSTRAR_DATOS_ALUMNO() {
        saltoDeLinea();
        System.out.println("Alumno: " + alumno.getNombreCompleto());
        System.out.println("Legajo: " + alumno.getLegajo());

        System.out.println("Notas finales:");

        System.out.print("[ ");
        for (Nota n : notasFinales) {
            System.out.print(n.getValorNota() + ", ");
        }
        System.out.println(" ]");

        System.out.print("El promedio de las notas es:" + promedio + " --> estas " + alumno.getEstado());
        saltoDeLinea();
        saltoDeLinea();
    }

    public static boolean validarLibre() {
        boolean libre = false;
        for (int i = 0; i < notasFinales.size(); i++) {
            libre = notasFinales.get(i).equals("A"); // ALUMNO LIBRE
        }
        return libre;
    }

    public static void saltoDeLinea() {
        System.out.println("");
    }

    public static double calcularPromedio() {
        double promedio = 0;
        int cont = 0;
        for (int i = 0; i < notasFinales.size(); i++) {
            cont = cont + Integer.parseInt(notasFinales.get(i).getValorNota());
        }
        promedio = cont / notasFinales.size();
        return promedio;
    }

    public static void agregarNotasFinales() {
        for (int i = 0; i < recuperatorio.size(); i++) {
            notasFinales.add(alumno.getNotasRecuperatorios().get(i));
        }

        for (int i = 0; i < notas.size(); i++) {

            if (!alumno.getNotas().get(i).getValorNota().equals("A") && !alumno.getNotas().get(i).getValorNota().equals("N") && !alumno.getNotas().get(i).getValorNota().equals("1") && !alumno.getNotas().get(i).getValorNota().equals("2") && !alumno.getNotas().get(i).getValorNota().equals("3") && !alumno.getNotas().get(i).getValorNota().equals("4") && !alumno.getNotas().get(i).getValorNota().equals("5")) {
                notasFinales.add(alumno.getNotas().get(i));
            }

        }
    }

    public static void ingresarNotas_Recuperatorio() {
        for (int i = 0; i < recuperatorio.size(); i++) {
            Nota nota = new Nota();
            System.out.println("INGRESE LAS NOTAS LOS RECUPERATORIO");
            recuperatorio.remove(i);

            nota.setValorNota(validarNota());
            System.out.println("INGRESE LA FECHA DEL EXAMEN: (dd/mm/yyyy)");
            nota.setFechaExamen(sc.nextLine());
            recuperatorio.add(nota);
        }
    }

    public static void valirdarNotas_Recuperatorios() {
        for (int i = 0; i < alumno.getNotas().size(); i++) {
            if (alumno.getNotas().get(i).getValorNota().equals("A") || alumno.getNotas().get(i).getValorNota().equals("N") || alumno.getNotas().get(i).getValorNota().equals("1") || alumno.getNotas().get(i).getValorNota().equals("2") || alumno.getNotas().get(i).getValorNota().equals("3") || alumno.getNotas().get(i).getValorNota().equals("4") || alumno.getNotas().get(i).getValorNota().equals("5")) {
                recuperatorio.add(alumno.getNotas().get(i));
            }
        }
    }

    public static void ingresarNotas() {
        while (true) {
            Nota nota = new Nota();
            nota.setValorNota(validarNota());
            System.out.println("INGRESE LA FECHA DEL EXAMEN: (dd/mm/yyyy)");
            nota.setFechaExamen(sc.nextLine());
            notas.add(nota);

            if (salir()) {
                break;
            }
        }
    }

    public static void crearAlumno() {
        System.out.println("Ingrese nombre completo: ");
        alumno.setNombreCompleto(sc.nextLine());
        System.out.println("Ingrese legajo: ");
        alumno.setLegajo(sc.nextLong());
    }

    public static boolean salir() {
        boolean salir = false;
        String aux;

        aux = validarSalir();

        salir = !aux.equalsIgnoreCase("S");

        return salir;
    }

    public static String validarSalir() {
        String aux = "";

        while (true) {
            System.out.println("DESEA INGRESAR OTRA NOTA");
            System.out.println("INGRESE S / N  :  ");
            aux = sc.nextLine();

            if (aux.equalsIgnoreCase("S") || aux.equalsIgnoreCase("N")) {
                return aux;
            }
            System.out.println("\nVALOR ERRONEO");
        }
    }

    public static String validarNota() {
        String nota = "";

        while (true) {
            System.out.println("INGRESE LA NOTA: ");
            nota = sc.nextLine();

            if ("0".equals(nota) || "1".equals(nota) || "2".equals(nota) || "3".equals(nota) || "4".equals(nota) || "5".equals(nota) || "6".equals(nota) || "7".equals(nota) || "8".equals(nota) || "9".equals(nota) || "10".equals(nota) || "A".equals(nota) || "N".equals(nota)) {
                break;
            }

        }

        return nota;
    }

}
