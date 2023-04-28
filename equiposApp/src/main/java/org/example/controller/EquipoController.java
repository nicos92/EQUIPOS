package org.example.controller;

import org.example.entities.EquipoEntity;
import org.example.repository.EquiposRepository;

import java.util.List;
import java.util.Scanner;

public class EquipoController {

    private static final EquiposRepository equiposRepository = new EquiposRepository();

    private static final Scanner scanner = new Scanner(System.in);
    
    public static void getTabladePosiciones() {
        try {
            int contador = 1;
            List<EquipoEntity> tablaPosiciones = equiposRepository.getTablaPosiciones();
            for (EquipoEntity equipo : tablaPosiciones) {
                System.out.println((contador++) + ": " + equipo);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void getEquipos() {
        try {

            List<EquipoEntity> equipos = equiposRepository.getEquipos();
            for (EquipoEntity equipo :
                    equipos) {
                System.out.println(equipo.getNombreEquipo());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean setEquipo(){
        System.out.println("ingrese el nombre del equipo: ");

        String nombreEquipo = scanner.nextLine();

        return equiposRepository.setEquipo(nombreEquipo);
    }
    public static boolean deleteEquipo() {
        System.out.println("ingrese el nombre del equipo a eliminar: ");
        String nombreEquipo = scanner.nextLine();

        return equiposRepository.existEquipo(nombreEquipo);
    }
}
