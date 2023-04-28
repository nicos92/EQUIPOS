package org.example.controller;

import org.example.entities.DirectorEntity;
import org.example.repository.DirectorRepository;

import java.util.List;
import java.util.Scanner;

public class DirectorController {

    private static final DirectorRepository directorRepository = new DirectorRepository();
    private static final Scanner scanner = new Scanner(System.in);
    public static void getDirectores() {
        try {

            List<DirectorEntity> directores =  directorRepository.getDirectores();
            for (DirectorEntity director :
                    directores) {
                System.out.println(director);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
    public static void getDirectoresxEquipo() {
        try {
            System.out.println("\nIngrese el Equipo");
            String equipo = scanner.nextLine();
            DirectorEntity director = directorRepository.getDirectorxEquipo(equipo);
            if (director.getId() != null){

                System.out.println(director + "\n");
            }else {
                System.out.println("No tiene Director Tecnico");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
