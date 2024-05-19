package org.grupo4.practica_integradora_g4.model.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor

@RequiredArgsConstructor
public class TipoCliente {
    @Id
    private String tipo;
    private String siglas;
    private BigDecimal gastoUmbral;
    private BigDecimal porcentajeDescuento;
}
