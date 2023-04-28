package org.example.controller;

import org.example.entities.PartidosEntity;
import org.example.repository.PartidosRepo;

import java.util.List;
import java.util.Scanner;

public class PartidoController {

    private static final PartidosRepo partidosRepo = new PartidosRepo();
    private static final Scanner scanner = new Scanner(System.in);

    public static boolean insertPartido() {

        boolean opcConf = false;

        System.out.println("Ingrese Resultado del primer equipo: ");

        String resultA = scanner.nextLine();
        System.out.println("Ingrese nombre del primer equipo: ");

        String equipoA = scanner.nextLine();
        System.out.println("Ingrese la cantidad de goles del primer equipo: ");

        int golesA = 0;
        do {
            try {
                golesA = Integer.parseInt(scanner.nextLine());
                opcConf = true;
            }catch (NumberFormatException e){
                System.out.println("No es un numero valido: " + e.getMessage());
            }
        }while (!opcConf);
        opcConf = false;

        System.out.println("Ingrese Resultado del primer equipo: ");
        String resultB = scanner.nextLine();

        System.out.println("Ingrese nombre del segundo equipo: ");
        String equipoB = scanner.nextLine();

        System.out.println("Ingrese la cantidad de goles del primer equipo: ");
        int golesB = 0;
        do {
            try {
                golesB = Integer.parseInt(scanner.nextLine());
                opcConf = true;
            }catch (NumberFormatException e){
                System.out.println("No es un numero valido: " + e.getMessage());
            }
        }while (!opcConf);

        return partidosRepo.insertPartido(resultA, equipoA, golesA, resultB, equipoB, golesB);
    }

    public static void getPartidos() {
        try{
            List<PartidosEntity> partidos = partidosRepo.getPartidos();
            for (PartidosEntity partido :
                    partidos) {
                System.out.println(partido);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
