package org.example.entities;

import lombok.Data;

@Data
public class JugadorEntity {
    private Integer camiseta;
    private String nombre;
    private String titular;

    @Override
    public String toString() {
        return "Nombre: " + nombre +
                ", Camiseta: " + camiseta ;
    }
}
