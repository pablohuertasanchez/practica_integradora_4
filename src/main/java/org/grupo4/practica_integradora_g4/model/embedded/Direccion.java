package org.grupo4.practica_integradora_g4.model.embedded;

import jakarta.persistence.Embeddable;
import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter

@Embeddable
@Data
public class Direccion {
    private Long tipoVia;
    private Integer numero;
    private String portal;
    private String planta;
    private String puerta;
    private String localidad;
    private String region;
    private String codigoPostal;
}
