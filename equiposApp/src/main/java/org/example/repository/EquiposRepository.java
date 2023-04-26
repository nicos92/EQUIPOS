package org.example.repository;

import java.sql.Connection;

public class EquiposRepository {

    private Connection connection = null;

    public EquiposRepository() throws Exception{

        Class.forName("com.mysql.cj.jdbc.Driver");
    }
}
