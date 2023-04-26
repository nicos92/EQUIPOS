package org.example.entities;

import lombok.Data;

@Data
public class EquipoEntity {
    private String nombreEquipo;
    private Integer puntaje;

    @Override
    public String toString() {
        return "Equipo: " + nombreEquipo + ", puntaje: " + puntaje;
    }
}
