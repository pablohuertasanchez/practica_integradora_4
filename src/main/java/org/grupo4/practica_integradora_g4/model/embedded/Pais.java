package org.grupo4.practica_integradora_g4.model.embedded;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Embeddable
@Data
public class Pais implements Serializable {
    private String siglas;
    private String nombre;
}
