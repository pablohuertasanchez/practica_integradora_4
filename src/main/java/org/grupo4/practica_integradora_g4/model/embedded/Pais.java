package org.grupo4.practica_integradora_g4.model.embedded;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Pais {
    private String siglas;
    private String nombre;
}
