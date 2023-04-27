package org.example;

import org.example.entities.DirectorEntity;
import org.example.entities.EquipoEntity;
import org.example.entities.JugadorEntity;
import org.example.repository.DirectorRepository;
import org.example.repository.EquiposRepository;
import org.example.repository.JugadoresRepository;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        getTabladePosiciones();
        getListaJugadoresxequipo("Argentinos Junios");
        getEquipos();
        getDirectores();
        getDirectoresxEquipo("Argentinos Junios");
        if(setEquipo("asd")){
            System.out.println("no se pudo ingresar el equipo, revise que no este repetido");
        }else {
            System.out.println("Equipo agregado correctamente");
        }
         ;
        if(deleteEquipo("asd")){
            System.out.println("no se pudo eliminar el equipo");
        }else {
            System.out.println("Equipo eliminado correctamente");
        }


    }

    private static void getListaJugadoresxequipo(String equipo) {
        JugadoresRepository jugadoresRepository = new JugadoresRepository();
        List<JugadorEntity> listaJugadores = new ArrayList<>();
        try {
            listaJugadores = jugadoresRepository.getJugadoresxEquipo(equipo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        for (JugadorEntity jugador :
                listaJugadores) {
            System.out.println(jugador);
        }
    }

    private static void getTabladePosiciones() {
        EquiposRepository equiposRepository = new EquiposRepository();
        List<EquipoEntity> tablaPosiciones = new ArrayList<>();
        try {
            tablaPosiciones = equiposRepository.getTablaPosiciones();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        for (EquipoEntity equipo :
                tablaPosiciones) {
            System.out.println(equipo);
        }
    }
    private static void getEquipos() {
        EquiposRepository equiposRepository = new EquiposRepository();
        List<EquipoEntity> equipos = new ArrayList<>();
        try {
            equipos = equiposRepository.getEquipos();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        for (EquipoEntity equipo :
                equipos) {
            System.out.println(equipo.getNombreEquipo());
        }
    }
    private static void getDirectores() {
        DirectorRepository directorRepository = new DirectorRepository();
        List<DirectorEntity> directores = new ArrayList<>();
        try {
            directores = directorRepository.getDirectores();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        for (DirectorEntity director :
                directores) {
            System.out.println(director);
        }
    }
    private static void getDirectoresxEquipo(String equipo) {
        DirectorRepository directorRepository = new DirectorRepository();
        DirectorEntity director = new DirectorEntity()
                ;
        try {
            director = directorRepository.getDirectorxEquipo(equipo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


            System.out.println(director);

    }

    private static boolean setEquipo(String nombreEquipo){
        EquiposRepository equiposRepository = new EquiposRepository();
        return equiposRepository.setEquipo(nombreEquipo);
    }
    private static boolean deleteEquipo(String nombreEquipo){
        EquiposRepository equiposRepository = new EquiposRepository();
        return equiposRepository.existEquipo(nombreEquipo);
    }
}