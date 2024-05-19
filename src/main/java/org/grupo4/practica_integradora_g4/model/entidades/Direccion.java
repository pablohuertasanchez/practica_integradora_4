package org.grupo4.practica_integradora_g4.model.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter


@Entity
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long tipoVia;
    private Integer numero;
    private String portal;
    private String planta;
    private String puerta;
    private String localidad;
    private String region;
    private String codigoPostal;

    // Getters y setters
    // ...
}
