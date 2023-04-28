package org.example;

import org.example.controller.DirectorController;
import org.example.controller.EquipoController;
import org.example.controller.JugadorController;
import org.example.controller.PartidoController;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {



        System.out.println("EQUIPOS APP");
        int opc;
        do {
            System.out.println(("""
                                    Ingrese una opcion
                                    1) Equipos
                                    2) Jugadores
                                    3) Directores Tecnicos
                                    4) Partidos
                                    0) Salir"""));
            opc = validarOpc();
            switch (opc){
                case 1 -> switchEquipos();
                case 2 -> switchJugadores();
                case 3 -> switchDirecTec();
                case 4 -> switchPartidos();

                default -> {
                    if (opc != 0) {
                        System.out.println("Opcion no valida");
                    }
                }

            }
        }while (opc != 0);
        System.out.println("Adios");

    }

    private static void switchPartidos() {
        int opc;
        do {
            System.out.println(("""
                                - Directores Tecnicos -
                                Ingrese una opcion
                                1) Ver Partidos
                                2) ingresar partido
                                                                    
                                0) volver"""));
            opc = validarOpc();

            switch (opc){
                case 1 -> PartidoController.getPartidos();
                case 2 -> {
                        if (PartidoController.insertPartido()) {
                            System.out.println("No se pudo ingresar el partido");
                        } else {
                            System.out.println("Partido ingresado correctamente");
                        }
                    }
                default -> System.out.println("opcion no valida");
            }
        }while (opc != 0);
    }

    private static void switchDirecTec() {
        int opc;
        do {
            System.out.println(("""
                                - Directores Tecnicos -
                                Ingrese una opcion
                                1) Todos los directores tecnicos
                                2) ver Director Tecnico por equipo
                                                                    
                                0) volver"""));
            opc = validarOpc();

            switch (opc){
                case 1 -> DirectorController.getDirectores();
                case 2 -> DirectorController.getDirectoresxEquipo();
                default -> System.out.println("opcion no valida");
            }
        }while (opc != 0);
    }

    private static void switchJugadores() {
        int opc;
        do {
            System.out.println(("""
                                    - Jugadores -
                                    Ingrese una opcion
                                    1) ver jugadores por equipo
                                    2) ingresar Jugador
                                    
                                    0) volver"""));
            opc = validarOpc();
            switch (opc){
                case 1-> JugadorController.getListaJugadoresxequipo();
                case 2-> {
                    if (JugadorController.setJugador()) {
                        System.out.println("No se pudo ingresar el jugador\n");
                    }else {
                        System.out.println("Jugador ingresado correctamente\n");
                    }
                }
            }

        }while (opc != 0);
    }

    private static void switchEquipos() {


        int opc;

        do {
            System.out.println(("""
                                    Ingrese una opcion
                                    1) Ver Tabla de Posiciones
                                    2) Equipos
                                    3) Ingresar Equipo
                                    4) Eliminar Equipo
                                    0) volver"""));
            opc = validarOpc();

            switch (opc){
                case 1-> EquipoController.getTabladePosiciones();
                case 2-> EquipoController.getEquipos();
                case 3 -> {
                    if(EquipoController.setEquipo()){
                        System.out.println("no se pudo ingresar el equipo, revise que no este repetido");
                    }else {
                        System.out.println("Equipo agregado correctamente");
                    }
                }
                case 4 -> {
                    if(EquipoController.deleteEquipo()){
                        System.out.println("no se pudo eliminar el equipo, verifique su nombre");
                    }else {
                        System.out.println("Equipo eliminado correctamente");
                    }

                }
            }
            System.out.println(" ");
        }while (opc != 0);
    }

    public static int validarOpc(){
        boolean opcConf = false;
        int opc = 0;
        do {
            try {
                opc = Integer.parseInt(scanner.nextLine());
                opcConf = true;
            }catch (NumberFormatException e){
                System.out.println("No es un numero valido: " + e.getMessage());
            }
        }while (!opcConf);
        return opc;
    }
}