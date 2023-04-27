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

    public boolean setEquipo( String nombre){

        try {
            PreparedStatement psEquipo = connection.prepareStatement("INSERT INTO `dbequipos`.`equipo` (`nombre`) " +
                    "VALUES (?)");
            psEquipo.setString(1, nombre);
            return psEquipo.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return true;
    }

    public boolean existEquipo(String nombreEquipo){

        try {
            EquipoEntity equipo= new EquipoEntity();
            PreparedStatement psExistEquipo = connection.prepareStatement("""
                                                        SELECT  nombre
                                                        FROM equipo
                                                        WHERE nombre = ?""");
            psExistEquipo.setString(1, nombreEquipo);
            ResultSet rsExistEquipo = psExistEquipo.executeQuery();
            while (rsExistEquipo.next()){
                equipo.setNombreEquipo(rsExistEquipo.getString(1));
            }
            if (equipo.getNombreEquipo() != null){
                deleteEquipo(nombreEquipo);
                return false;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public void deleteEquipo(String nombreEquipo){

        try {
            PreparedStatement psEquipo = connection.prepareStatement("DELETE FROM `dbequipos`.`equipo` WHERE " +
                    "(`nombre` = ?)");
            psEquipo.setString(1, nombreEquipo);
            psEquipo.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
