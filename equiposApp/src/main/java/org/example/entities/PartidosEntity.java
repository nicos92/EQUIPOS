package org.example.entities;

import lombok.Data;

@Data
public class PartidosEntity {
    private Integer id;
    private String resultadoA;
    private String equipoA;
    private Integer golEquipoA;
    private String resultadoB;
    private String equipoB;
    private Integer golEquipoB;

    @Override
    public String toString() {
        return
                "Parido: " + id +
                ", \"" + resultadoA + " "+ equipoA  +
                " con " + golEquipoA +
                " goles\", contra el \"" + resultadoB  +
                " " + equipoB  +
                " con " + golEquipoB  + " goles\".";
    }
}
