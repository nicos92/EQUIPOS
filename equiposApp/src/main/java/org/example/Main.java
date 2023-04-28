package org.example;

import org.example.entities.DirectorEntity;
import org.example.entities.EquipoEntity;
import org.example.entities.JugadorEntity;
import org.example.entities.PartidosEntity;
import org.example.repository.DirectorRepository;
import org.example.repository.EquiposRepository;
import org.example.repository.JugadoresRepository;
import org.example.repository.PartidosRepo;

import java.util.List;

public class Main {
    public static void main(String[] args) {
/*        getTabladePosiciones();
        getListaJugadoresxequipo("banfield");
        getEquipos();
        getDirectores();
        getDirectoresxEquipo("Argentinos Junios");
        getPartidos();

        if(setEquipo("asdd")){
            System.out.println("no se pudo ingresar el equipo, revise que no este repetido");
        }else {
            System.out.println("Equipo agregado correctamente");
        }

        if(deleteEquipo("asd")){
            System.out.println("no se pudo eliminar el equipo");
        }else {
            System.out.println("Equipo eliminado correctamente");
        }

        if (setJugador("4", "nicolas S", "si", "Boca Juniors")) {
            System.out.println("No se pudo guardar, revise que no esten repetidos");
        }else {
            System.out.println("Jugador guardado Correctamente");
        }*/

        System.out.println("main Insert PArtido: " + insertPartido("ganador","Boca Juniors", 3, "perdedor", "Velez Sarsfield", 2));



    }

    private static boolean insertPartido(String resultA, String equipoA, int golesA, String resultB, String equipoB, int golesB) {
        PartidosRepo partidosRepo = new PartidosRepo();
        return partidosRepo.insertPartido(resultA, equipoA, golesA, resultB, equipoB, golesB);
    }

    private static void getPartidos() {
        try{
            PartidosRepo partidosRepo = new PartidosRepo();
            List<PartidosEntity> partidos = partidosRepo.getPartidos();
            for (PartidosEntity partido :
                    partidos) {
                System.out.println(partido);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean setJugador(String camiseta, String nombre, String titular, String equipo){
        JugadoresRepository jugadoresRepository = new JugadoresRepository();
        return  jugadoresRepository.insertJugador(camiseta,nombre,titular,equipo);
    }

    private static void getListaJugadoresxequipo(String equipo) {
        try {
            JugadoresRepository jugadoresRepository = new JugadoresRepository();
            List<JugadorEntity> listaJugadores = jugadoresRepository.getJugadoresxEquipo(equipo);
            for (JugadorEntity jugador :
                    listaJugadores) {
                System.out.println(jugador);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

    private static void getTabladePosiciones() {
        try {
            EquiposRepository equiposRepository = new EquiposRepository();
            List<EquipoEntity> tablaPosiciones = equiposRepository.getTablaPosiciones();
            for (EquipoEntity equipo :
                    tablaPosiciones) {
                System.out.println(equipo);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
    private static void getEquipos() {
        try {
            EquiposRepository equiposRepository = new EquiposRepository();
            List<EquipoEntity> equipos = equiposRepository.getEquipos();
            for (EquipoEntity equipo :
                    equipos) {
                System.out.println(equipo.getNombreEquipo());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

    private static boolean setEquipo(String nombreEquipo){
        EquiposRepository equiposRepository = new EquiposRepository();
        return equiposRepository.setEquipo(nombreEquipo);
    }
    private static boolean deleteEquipo(String nombreEquipo) {
        EquiposRepository equiposRepository = new EquiposRepository();
        return equiposRepository.existEquipo(nombreEquipo);
    }
    private static void getDirectores() {
        try {
            DirectorRepository directorRepository = new DirectorRepository();
            List<DirectorEntity> directores =  directorRepository.getDirectores();
            for (DirectorEntity director :
                    directores) {
                System.out.println(director);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
    private static void getDirectoresxEquipo(String equipo) {
        try {
            DirectorRepository directorRepository = new DirectorRepository();
            DirectorEntity director = directorRepository.getDirectorxEquipo(equipo);
            System.out.println(director);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }



}