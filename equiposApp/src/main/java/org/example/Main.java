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
        getListaJugadoresxequipo("banfield");
        getEquipos();
        getDirectores();
        getDirectoresxEquipo("Argentinos Junios");
        if (setJugador("4", "nicolas S", "si", "Boca Juniors")) {

            System.out.println("No se pudo guardar, revise que no esten repetidos");
        }else {
            System.out.println("Jugador guardado Correctamente");
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

    private static boolean setJugador(String camiseta, String nombre, String titular, String equipo){
        JugadoresRepository jugadoresRepository = new JugadoresRepository();
        try {
            return  jugadoresRepository.setJugador(camiseta,nombre,titular,equipo);
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }
        return true;
    }
}