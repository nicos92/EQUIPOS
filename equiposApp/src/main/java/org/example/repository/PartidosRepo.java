package org.example.repository;

import org.example.entities.PartidosEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PartidosRepo {
    private Connection connection;

    {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbequipos", "root", "38041304");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<PartidosEntity> getPartidos() {

        try {
            List<PartidosEntity> equipos = new ArrayList<>();
            PreparedStatement psEquipos = connection.prepareStatement("call dbequipos.getPartidos()");


            ResultSet rsEquipos = psEquipos.executeQuery();

            while (rsEquipos.next()){
                PartidosEntity equipo = new PartidosEntity();
                equipo.setId(rsEquipos.getInt(1));
                equipo.setResultadoA(rsEquipos.getString(2));
                equipo.setEquipoA(rsEquipos.getString(3));
                equipo.setGolEquipoA(rsEquipos.getInt(4));
                equipo.setResultadoB(rsEquipos.getString(5));
                equipo.setEquipoB(rsEquipos.getString(6));
                equipo.setGolEquipoB(rsEquipos.getInt(7));
                equipos.add(equipo);
            }
            rsEquipos.close();
            psEquipos.close();

            return equipos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int getIdPartido(){

        try{
            PreparedStatement psMaxId= connection.prepareStatement("select max(idpartido) from partidos");
            ResultSet rsId = psMaxId.executeQuery();
            int id = 0;
            while (rsId.next()){
                id = rsId.getInt(1) + 1;
            }


        }catch (SQLException e){
            System.out.println("get ID Partido: " + e.getMessage());
        }

        return 0;
    }

    public boolean insertPartido(String resultA, String equipoA, int golesA, String resultB, String equipoB, int golesB){
        int id = getIdPartido();
        System.out.println("insertPartido ID: " + id);
        try{
            PreparedStatement psPartido = connection.prepareStatement("call dbequipos.insertPartido(?, ?, ?, ?, ?, ?, ?)");
            psPartido.setInt(1, id);
            psPartido.setString(2, resultA);
            psPartido.setString(3, equipoA);
            psPartido.setInt(4, golesA);
            psPartido.setString(5, resultB);
            psPartido.setString(6, equipoB);
            psPartido.setInt(7, golesB);

            return psPartido.execute();
        }catch (SQLException e){
            System.out.println("Insert Partido: " + e.getMessage());
        }
        return true;
    }


}
