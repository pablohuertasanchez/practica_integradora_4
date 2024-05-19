package org.grupo4.practica_integradora_g4.model.entidades;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Data


public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String siglas;
    private String nombre;

    public Pais(String siglas, String nombre){
        this.siglas = siglas;
        this.nombre = nombre;
    }
}
