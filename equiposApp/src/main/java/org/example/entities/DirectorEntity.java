package org.example.entities;

import lombok.Data;

@Data
public class DirectorEntity {
    private Integer id;
    private String nombreYapellido;
    private String equipo;

    @Override
    public String toString() {
        return
                "id: " + id +
                ", nombre Y apellido: " + nombreYapellido +
                ", equipo: " + equipo;
    }
}
