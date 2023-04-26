package org.example.repository;

import org.example.entities.EquipoEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EquiposRepository {

    private Connection connection;

    {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbequipos", "root", "38041304");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<EquipoEntity> getEquipos() throws Exception{

        List<EquipoEntity> equipos = new ArrayList<>();
        PreparedStatement psEquipos = connection.prepareStatement("select * from equipo");
        ResultSet rsEquipos = psEquipos.executeQuery();

        while (rsEquipos.next()){
            EquipoEntity equipo = new EquipoEntity();
            equipo.setNombreEquipo(rsEquipos.getString(1));
            equipos.add(equipo);
        }
        rsEquipos.close();
        psEquipos.close();

        return equipos;
    }

    public List<EquipoEntity> getTablaPosiciones() throws Exception{

        List<EquipoEntity> equipos = new ArrayList<>();

        PreparedStatement psEquipos = connection.prepareStatement("call dbequipos.getTablaPosiciones()");

        ResultSet rsEquipos = psEquipos.executeQuery();

        while (rsEquipos.next()){

            EquipoEntity equipo = new EquipoEntity();

            equipo.setNombreEquipo(rsEquipos.getString(1));
            equipo.setPuntaje(rsEquipos.getInt(2));

            equipos.add(equipo);

        }

        rsEquipos.close();
        psEquipos.close();

        return equipos;
    }


}
