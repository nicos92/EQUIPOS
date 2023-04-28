package org.example.repository;

import org.example.entities.DirectorEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DirectorRepository {
    private Connection connection;

    {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbequipos", "root", "38041304");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<DirectorEntity> getDirectores() throws Exception{

        List<DirectorEntity> directores = new ArrayList<>();
        PreparedStatement psDirectores = connection.prepareStatement("select * from directores_tecnicos;");
        ResultSet rsDirectores = psDirectores.executeQuery();

        while (rsDirectores.next()){
            DirectorEntity director = new DirectorEntity();
            director.setId(rsDirectores.getInt(1));
            director.setNombreYapellido(rsDirectores.getString(2));
            director.setEquipo(rsDirectores.getString(3));
            directores.add(director);
        }
        rsDirectores.close();
        psDirectores.close();

        return directores;
    }

    public DirectorEntity getDirectorxEquipo(String equipo) throws Exception{

        DirectorEntity director = new DirectorEntity();
        PreparedStatement psDirector = connection.prepareStatement("select * from directores_tecnicos where nombre_equipo = ?");
        psDirector.setString(1, equipo);
        ResultSet rsDirector= psDirector.executeQuery();

        while (rsDirector.next()){
            director.setId(rsDirector.getInt(1));
            director.setNombreYapellido(rsDirector.getString(2));
            director.setEquipo(rsDirector.getString(3));

        }
        rsDirector.close();
        psDirector.close();

        return director;
    }

}
