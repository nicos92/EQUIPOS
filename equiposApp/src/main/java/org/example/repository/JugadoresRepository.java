package org.example.repository;

import org.example.entities.JugadorEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JugadoresRepository {
    private Connection connection;

    {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbequipos", "root", "38041304");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<JugadorEntity> getJugadoresxEquipo(String nombreEquipo) throws Exception{



        List<JugadorEntity> jugadores = new ArrayList<>();

        PreparedStatement psJugadores = connection.prepareStatement("""
                                                                        Select idCamiseta, nombre
                                                                        From jugadores
                                                                        where nombre_Equipo =  ?""");
        psJugadores.setString(1, nombreEquipo);

        ResultSet rsJugadores = psJugadores.executeQuery();

        while (rsJugadores.next()){

            JugadorEntity jugador = new JugadorEntity();

            jugador.setCamiseta(rsJugadores.getInt(1));
            jugador.setNombre(rsJugadores.getString(2));

            jugadores.add(jugador);

        }

        rsJugadores.close();
        psJugadores.close();

        return jugadores;
    }

    public boolean insertJugador(int camiseta, String nombre, String titular, String equipo) {

        try {

            PreparedStatement psJugador = connection.prepareStatement("INSERT INTO `dbequipos`.`jugadores` (`idCamiseta`, `nombre`, `titular`, `nombre_equipo`) VALUES (?, ?, ?, ?)");
            psJugador.setInt(1, camiseta);
            psJugador.setString (2, nombre);
            psJugador.setString (3, titular);
            psJugador.setString (4, equipo);

            return psJugador.execute();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return true;
    }
}
