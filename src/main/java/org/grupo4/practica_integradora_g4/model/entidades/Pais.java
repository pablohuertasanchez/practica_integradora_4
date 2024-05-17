package org.grupo4.practica_integradora_g4.model.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;


@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Data
public class Pais {
    @Id

    private String nombre;
    private String siglas;

    public Pais(String nombre, String siglas) {
        this.nombre = nombre;
        this.siglas = siglas;
    }
}