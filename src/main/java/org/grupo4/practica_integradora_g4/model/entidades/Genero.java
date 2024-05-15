package org.grupo4.practica_integradora_g4.model.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Data
public class Genero {
    @Id
    private String gen;
    private String siglas;
}
