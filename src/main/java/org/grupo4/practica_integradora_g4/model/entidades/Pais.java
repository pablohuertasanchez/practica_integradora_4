package org.grupo4.practica_integradora_g4.model.entidades;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
    private String nombre;
    private String siglas;

}
