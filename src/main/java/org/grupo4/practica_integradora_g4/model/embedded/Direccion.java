package org.grupo4.practica_integradora_g4.model.embedded;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
//@RequiredArgsConstructor
@Getter
@Setter

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
