package parcial1.recuperatorio;

import java.util.Scanner;

public class Main {

    static String[][] tablero = new String[10][10];
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        llenarTablero();
        mostrarTablero();

//      JUGADORES
        int bifurcacion = 0;
        while (true) {

            if (bifurcacion == 0) {
                movimientoJ1(0, 0);
                GANADOR();
                mostrarTablero();
                bifurcacion = 1;
            } else if (bifurcacion == 1) {
                movimientoJ2(0, 0);
                GANADOR();
                mostrarTablero();
                bifurcacion = 0;

            }

            if (GANADOR()) {
                mostrar_ganador(GANADOR());
                break;
            }

        }

    }

    public static boolean GANADOR() {
        boolean ganador = false;

        String J1 = "O";
        String J2 = "X";

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if ((tablero[0][0].equalsIgnoreCase(J1) || tablero[0][0].equalsIgnoreCase(J2)) || (tablero[0][9].equalsIgnoreCase(J1) || tablero[0][9].equalsIgnoreCase(J2)) || (tablero[9][0].equalsIgnoreCase(J1) || tablero[9][0].equalsIgnoreCase(J2)) || (tablero[9][9].equalsIgnoreCase(J1) || tablero[9][9].equalsIgnoreCase(J2))) {
                    ganador = ganadorEsquina();
                } else if ((tablero[9][j].equalsIgnoreCase(J1) || tablero[9][j].equalsIgnoreCase(J2) ) || (tablero[0][j].equalsIgnoreCase(J1) || tablero[0][j].equalsIgnoreCase(J2))) {
                    ganador = ganadorBordes();
                } else {
                    ganador = ganadorCentro();
                }

            }
        }

        return ganador;
    }

    public static void mostrar_ganador(boolean ganador) {
        if (ganador) {
            System.out.println("Ya hay un ganador!!");
        }
    }

    public static boolean ganadorCentro() {

        String J1 = "O";
        String J2 = "X";

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {

                if (tablero[i][j].equalsIgnoreCase(J1) && tablero[i - 1][j].equalsIgnoreCase(J1) && tablero[i + 1][j].equalsIgnoreCase(J1) || tablero[i][j].equalsIgnoreCase(J2) && tablero[i - 1][j].equalsIgnoreCase(J2) && tablero[i + 1][j].equalsIgnoreCase(J2)) {
                    return true;
                } else if (tablero[i][j].equalsIgnoreCase(J1) && tablero[i + 1][j].equalsIgnoreCase(J1) && tablero[i + 2][j].equalsIgnoreCase(J1) || tablero[i][j].equalsIgnoreCase(J2) && tablero[i + 1][j].equalsIgnoreCase(J2) && tablero[i + 2][j].equalsIgnoreCase(J2)) {
                    return true;
                } else if (tablero[i][j].equalsIgnoreCase(J1) && tablero[i - 1][j].equalsIgnoreCase(J1) && tablero[i - 2][j].equalsIgnoreCase(J1) || tablero[i][j].equalsIgnoreCase(J2) && tablero[i - 1][j].equalsIgnoreCase(J2) && tablero[i - 2][j].equalsIgnoreCase(J2)) {
                    return true;

                } else if (tablero[i][j].equalsIgnoreCase(J1) && tablero[i][j - 1].equalsIgnoreCase(J1) && tablero[i][j + 1].equalsIgnoreCase(J1) || tablero[i][j].equalsIgnoreCase(J2) && tablero[i][j - 1].equalsIgnoreCase(J2) && tablero[i][j + 1].equalsIgnoreCase(J2)) {
                    return true;
                } else if (tablero[i][j].equalsIgnoreCase(J1) && tablero[i][j + 1].equalsIgnoreCase(J1) && tablero[i][j + 2].equalsIgnoreCase(J1) || tablero[i][j].equalsIgnoreCase(J2) && tablero[i][j + 1].equalsIgnoreCase(J2) && tablero[i][j + 2].equalsIgnoreCase(J2)) {
                    return true;
                } else if (tablero[i][j].equalsIgnoreCase(J1) && tablero[i][j - 1].equalsIgnoreCase(J1) && tablero[i][j - 2].equalsIgnoreCase(J1) || tablero[i][j].equalsIgnoreCase(J2) && tablero[i][j - 1].equalsIgnoreCase(J2) && tablero[i][j - 2].equalsIgnoreCase(J2)) {
                    return true;

                }
            }
        }
        return false;
    }

    public static boolean ganadorEsquina() {
        String J1 = "O";
        String J2 = "X";

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {

                if (tablero[0][0].equalsIgnoreCase(J1) || tablero[0][0].equalsIgnoreCase(J2)) {
                    if (tablero[0][0].equalsIgnoreCase(J1) && tablero[1][0].equalsIgnoreCase(J1) && tablero[2][0].equalsIgnoreCase(J1) || tablero[0][0].equalsIgnoreCase(J2) && tablero[1][0].equalsIgnoreCase(J2) && tablero[2][0].equalsIgnoreCase(J2)) {
                        return true;
                    } else if (tablero[0][0].equalsIgnoreCase(J1) && tablero[0][1].equalsIgnoreCase(J1) && tablero[0][2].equalsIgnoreCase(J1) || tablero[0][0].equalsIgnoreCase(J2) && tablero[0][1].equalsIgnoreCase(J2) && tablero[0][2].equalsIgnoreCase(J2)) {
                        return true;
                    }
                }

                if (tablero[0][9].equalsIgnoreCase(J1) || tablero[0][9].equalsIgnoreCase(J2)) {
                    if (tablero[0][9].equalsIgnoreCase(J1) && tablero[1][9].equalsIgnoreCase(J1) && tablero[2][9].equalsIgnoreCase(J1) || tablero[0][9].equalsIgnoreCase(J2) && tablero[1][9].equalsIgnoreCase(J2) && tablero[2][9].equalsIgnoreCase(J2)) {
                        return true;
                    } else if (tablero[0][9].equalsIgnoreCase(J1) && tablero[0][8].equalsIgnoreCase(J1) && tablero[0][7].equalsIgnoreCase(J1) || tablero[0][9].equalsIgnoreCase(J2) && tablero[0][8].equalsIgnoreCase(J2) && tablero[0][7].equalsIgnoreCase(J2)) {
                        return true;
                    }
                }

                if (tablero[9][0].equalsIgnoreCase(J1) || tablero[9][0].equalsIgnoreCase(J2)) {
                    if (tablero[9][0].equalsIgnoreCase(J1) && tablero[8][0].equalsIgnoreCase(J1) && tablero[7][0].equalsIgnoreCase(J1) || tablero[9][0].equalsIgnoreCase(J2) && tablero[8][0].equalsIgnoreCase(J2) && tablero[7][0].equalsIgnoreCase(J2)) {
                        return true;
                    } else if (tablero[9][0].equalsIgnoreCase(J1) && tablero[9][1].equalsIgnoreCase(J1) && tablero[9][2].equalsIgnoreCase(J1) || tablero[9][0].equalsIgnoreCase(J2) && tablero[9][1].equalsIgnoreCase(J2) && tablero[9][2].equalsIgnoreCase(J2)) {
                        return true;
                    }
                }

                if (tablero[9][9].equalsIgnoreCase(J1) || tablero[9][9].equalsIgnoreCase(J2)) {
                    if (tablero[9][9].equalsIgnoreCase(J1) && tablero[8][9].equalsIgnoreCase(J1) && tablero[7][9].equalsIgnoreCase(J1) || tablero[9][9].equalsIgnoreCase(J2) && tablero[8][9].equalsIgnoreCase(J2) && tablero[7][9].equalsIgnoreCase(J2)) {
                        return true;
                    } else if (tablero[9][9].equalsIgnoreCase(J1) && tablero[9][8].equalsIgnoreCase(J1) && tablero[9][7].equalsIgnoreCase(J1) || tablero[9][9].equalsIgnoreCase(J2) && tablero[9][8].equalsIgnoreCase(J2) && tablero[9][7].equalsIgnoreCase(J2)) {
                        return true;
                    }
                }

            }
        }
        return false;
    }

    public static boolean ganadorBordes() {
        String J1 = "O";
        String J2 = "X";

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][0].equalsIgnoreCase(J1) || tablero[i][0].equalsIgnoreCase(J2)) {

                    if (tablero[i][0].equalsIgnoreCase(J1) && tablero[i - 1][0].equalsIgnoreCase(J1) && tablero[i + 1][0].equalsIgnoreCase(J1) || tablero[i][0].equalsIgnoreCase(J2) && tablero[i - 1][0].equalsIgnoreCase(J2) && tablero[i + 1][0].equalsIgnoreCase(J2)) {
                        return true;
                    } else if (tablero[i][0].equalsIgnoreCase(J1) && tablero[i + 1][0].equalsIgnoreCase(J1) && tablero[i + 2][0].equalsIgnoreCase(J1) || tablero[i][0].equalsIgnoreCase(J2) && tablero[i + 1][0].equalsIgnoreCase(J2) && tablero[i + 2][0].equalsIgnoreCase(J2)) {
                        return true;
                    } else if (tablero[i][0].equalsIgnoreCase(J1) && tablero[i - 1][0].equalsIgnoreCase(J1) && tablero[i - 2][0].equalsIgnoreCase(J1) || tablero[i][0].equalsIgnoreCase(J2) && tablero[i - 1][0].equalsIgnoreCase(J2) && tablero[i - 2][0].equalsIgnoreCase(J2)) {
                        return true;
                    } else if (tablero[i][0].equalsIgnoreCase(J1) && tablero[i][1].equalsIgnoreCase(J1) && tablero[i][2].equalsIgnoreCase(J1) || tablero[i][0].equalsIgnoreCase(J2) && tablero[i][1].equalsIgnoreCase(J2) && tablero[i][2].equalsIgnoreCase(J2)) {
                        return true;
                    }

                } else if (tablero[i][9].equalsIgnoreCase(J1) || tablero[i][9].equalsIgnoreCase(J2)) {

                    if (tablero[i][9].equalsIgnoreCase(J1) && tablero[i - 1][9].equalsIgnoreCase(J1) && tablero[i + 1][9].equalsIgnoreCase(J1) || tablero[i][9].equalsIgnoreCase(J2) && tablero[i - 1][9].equalsIgnoreCase(J2) && tablero[i + 1][9].equalsIgnoreCase(J2)) {
                        return true;
                    } else if (tablero[i][9].equalsIgnoreCase(J1) && tablero[i + 1][9].equalsIgnoreCase(J1) && tablero[i + 2][9].equalsIgnoreCase(J1) || tablero[i][9].equalsIgnoreCase(J2) && tablero[i + 1][9].equalsIgnoreCase(J2) && tablero[i + 2][9].equalsIgnoreCase(J2)) {
                        return true;
                    } else if (tablero[i][9].equalsIgnoreCase(J1) && tablero[i - 1][9].equalsIgnoreCase(J1) && tablero[i - 2][9].equalsIgnoreCase(J1) || tablero[i][9].equalsIgnoreCase(J2) && tablero[i - 1][9].equalsIgnoreCase(J2) && tablero[i - 2][9].equalsIgnoreCase(J2)) {
                        return true;
                    } else if (tablero[i][9].equalsIgnoreCase(J1) && tablero[i][8].equalsIgnoreCase(J1) && tablero[i][7].equalsIgnoreCase(J1) || tablero[i][9].equalsIgnoreCase(J2) && tablero[i][8].equalsIgnoreCase(J2) && tablero[i][7].equalsIgnoreCase(J2)) {
                        return true;
                    }

                } else if (tablero[0][j].equalsIgnoreCase(J1) || tablero[0][j].equalsIgnoreCase(J2)) {

                    if (tablero[0][j].equalsIgnoreCase(J1) && tablero[0][j + 1].equalsIgnoreCase(J1) && tablero[0][j - 1].equalsIgnoreCase(J1) || tablero[0][j].equalsIgnoreCase(J2) && tablero[0][j + 1].equalsIgnoreCase(J2) && tablero[0][j - 1].equalsIgnoreCase(J2)) {
                        return true;
                    } else if (tablero[0][j].equalsIgnoreCase(J1) && tablero[0][j + 1].equalsIgnoreCase(J1) && tablero[0][j + 2].equalsIgnoreCase(J1) || tablero[0][j].equalsIgnoreCase(J2) && tablero[0][j + 1].equalsIgnoreCase(J2) && tablero[0][j + 2].equalsIgnoreCase(J2)) {
                        return true;
                    } else if (tablero[0][j].equalsIgnoreCase(J1) && tablero[0][j - 1].equalsIgnoreCase(J1) && tablero[0][j - 2].equalsIgnoreCase(J1) || tablero[0][j].equalsIgnoreCase(J2) && tablero[0][j - 1].equalsIgnoreCase(J2) && tablero[0][j - 2].equalsIgnoreCase(J2)) {
                        return true;
                    } else if (tablero[0][j].equalsIgnoreCase(J1) && tablero[1][j].equalsIgnoreCase(J1) && tablero[2][j].equalsIgnoreCase(J1) || tablero[0][j].equalsIgnoreCase(J2) && tablero[1][j].equalsIgnoreCase(J2) && tablero[2][j].equalsIgnoreCase(J2)) {
                        return true;
                    }

                } else if (tablero[9][j].equalsIgnoreCase(J1) || tablero[9][j].equalsIgnoreCase(J2)) {

                    if (tablero[9][j].equalsIgnoreCase(J1) && tablero[9][j + 1].equalsIgnoreCase(J1) && tablero[9][j - 1].equalsIgnoreCase(J1) || tablero[9][j].equalsIgnoreCase(J2) && tablero[9][j + 1].equalsIgnoreCase(J2) && tablero[9][j - 1].equalsIgnoreCase(J2)) {
                        return true;
                    } else if (tablero[9][j].equalsIgnoreCase(J1) && tablero[9][j + 1].equalsIgnoreCase(J1) && tablero[9][j + 2].equalsIgnoreCase(J1) || tablero[9][j].equalsIgnoreCase(J2) && tablero[9][j + 1].equalsIgnoreCase(J2) && tablero[9][j + 2].equalsIgnoreCase(J2)) {
                        return true;
                    } else if (tablero[9][j].equalsIgnoreCase(J1) && tablero[9][j - 1].equalsIgnoreCase(J1) && tablero[9][j - 2].equalsIgnoreCase(J1) || tablero[9][j].equalsIgnoreCase(J2) && tablero[9][j - 1].equalsIgnoreCase(J2) && tablero[9][j - 2].equalsIgnoreCase(J2)) {
                        return true;
                    } else if (tablero[9][j].equalsIgnoreCase(J1) && tablero[8][j].equalsIgnoreCase(J1) && tablero[7][j].equalsIgnoreCase(J1) || tablero[9][j].equalsIgnoreCase(J2) && tablero[8][j].equalsIgnoreCase(J2) && tablero[7][j].equalsIgnoreCase(J2)) {
                        return true;
                    }

                }

            }
        }
        return false;
    }

    public static void movimientoJ1(int fila, int columna) {
        String pieza = "O";
        System.out.println("JUGADOR 1");
        System.out.print("INGRESE FILA: ");
        fila = validarPosicion();
        System.out.print("INGRESE COLUMNA: ");
        columna = validarPosicion();

        if (!tablero[fila][columna].equalsIgnoreCase("-")) {
            System.out.println("ESTA OCUPADA ESA CELDA");
            movimientoJ1(0, 0);
        }

        tablero[fila][columna] = pieza;

    }

    public static void movimientoJ2(int fila, int columna) {
        String pieza = "X";
        System.out.println("JUGADOR 2");
        System.out.print("INGRESE FILA: ");
        fila = validarPosicion();
        System.out.print("INGRESE COLUMNA: ");
        columna = validarPosicion();
        

        if (!tablero[fila][columna].equalsIgnoreCase("-")) {
            System.out.println("ESTA OCUPADA ESA CELDA");
            movimientoJ2(0, 0);
        }

        tablero[fila][columna] = pieza;

    }

    public static int validarPosicion() {
        int posicion = 0;
        while (true) {
            posicion = sc.nextInt();
            if (posicion >= 0 || posicion <= 9) {
                break;
            }
        }
        return posicion;
    }

    public static void llenarTablero() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tablero[i][j] = "-";
            }
        }
    }

    public static void mostrarTablero() {
        for (int i = 0; i < tablero.length; i++) {
            saltoDeLinea();
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j] + "\t");
            }
        }
        saltoDeLinea();
        saltoDeLinea();
    }

    public static void saltoDeLinea() {
        System.out.println("");
    }

}
