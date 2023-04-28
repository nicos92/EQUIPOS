package org.example.controller;

import org.example.entities.JugadorEntity;
import org.example.repository.JugadoresRepository;

import java.util.List;
import java.util.Scanner;

public class JugadorController {
    private static final Scanner scanner = new Scanner(System.in);
    static JugadoresRepository jugadoresRepository = new JugadoresRepository();

    public static boolean setJugador(){
        boolean opcConf = false;

        System.out.println("\nIngrese Numero de camiseta");
        int camiseta = 0;
        do {
            try {
                camiseta = Integer.parseInt(scanner.nextLine());
                opcConf = true;
            }catch (NumberFormatException e){
                System.out.println("No es un numero valido: " + e.getMessage());
            }
        }while (!opcConf);

        System.out.println("\nIngrese Nombre de Jugador");
        String nombre = scanner.nextLine();

        System.out.println("\n¿Es titular?");
        String titular = scanner.nextLine();

        System.out.println("\nIngrese el Equipo");
        String equipo = scanner.nextLine();

        return  jugadoresRepository.insertJugador(camiseta,nombre,titular,equipo);
    }

    public static void getListaJugadoresxequipo() {


        System.out.println("\nIngrese el Equipo");
        String equipo = scanner.nextLine();
        try {

            List<JugadorEntity> listaJugadores = jugadoresRepository.getJugadoresxEquipo(equipo);

            if (!listaJugadores.isEmpty()){

                for (JugadorEntity jugador :
                        listaJugadores) {
                    System.out.println(jugador);
                }
            }else {
                System.out.println("No tiene Jugadores");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
