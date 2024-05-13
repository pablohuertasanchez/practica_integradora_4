package org.grupo4.practica_integradora_g4.model.entidades;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.grupo4.practica_integradora_g4.model.embedded.*;
import org.grupo4.practica_integradora_g4.model.extra.DatosContacto;
import org.grupo4.practica_integradora_g4.model.extra.DatosPersonales;
import org.grupo4.practica_integradora_g4.model.extra.DatosUsuario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    //DATOS PERSONALES
    private String genero;
    private LocalDate fechaNacimiento;
    private String pais;
    private String tipoDocumentoCliente;
    private String documento;
    @NotBlank( groups = DatosPersonales.class)
    private String nombre;
    private String apellidos;

    //DATOS DE CONTACTO
    private String direccion;
    @NotBlank ( groups = DatosContacto.class)
    private String telefonoMovil;

    //DATOS DE CLIENTE
/*
    private String usuario;
    private Set<Direccion> direccionesEntrega;
    private Set<TarjetaCredito> tarjetasCredito;
    private BigDecimal gastoAcumuladoCliente;
    private String tipoCliente;
    private Set<Categoria> categoriasInteres;

    private boolean licencia;
    private Auditoria auditoria;
 */
    @NotBlank ( groups = DatosUsuario.class)
    private String comentarios;
}