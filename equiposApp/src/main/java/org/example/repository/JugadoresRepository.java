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

        PreparedStatement psJugadores = connection.prepareStatement("Select idCamiseta, nombre\n" +
                "From jugadores\n" +
                "where nombre_Equipo =  ? ");
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
}
