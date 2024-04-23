package org.grupo4.practica_integradora_g4.model;


import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString


public class Cliente {


    private Usuario usuario;
    private String genero;
    private LocalDate fechaNacimiento;
    private Pais pais;
    private String tipoDocumentoCliente;
    private String documento;
    private String telefonoMovil;
    private String nombre;
    private String apellidos;
    private Direccion direccion;
    private Set<Direccion> direccionesEntrega;
    private Set<TarjetaCredito> tarjetasCredito;
    private BigDecimal gastoAcumuladoCliente;
    private String tipoCliente;
    private Set<Categoria> categoriasInteres;
    private String comentarios;
    private boolean licencia;
    private Auditoria auditoria;

}