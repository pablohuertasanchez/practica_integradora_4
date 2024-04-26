package org.grupo4.practica_integradora_g4.model.entidades;


import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.grupo4.practica_integradora_g4.model.embebed.*;
import org.grupo4.practica_integradora_g4.model.extra.DatosContacto;
import org.grupo4.practica_integradora_g4.model.extra.DatosPersonales;
import org.grupo4.practica_integradora_g4.model.extra.DatosUsuario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString


public class Cliente {
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

    private String usuario;
    private Set<Direccion> direccionesEntrega;
    private Set<TarjetaCredito> tarjetasCredito;
    private BigDecimal gastoAcumuladoCliente;
    private String tipoCliente;
    private Set<Categoria> categoriasInteres;
    @NotBlank ( groups = DatosUsuario.class)
    private String comentarios;
    private boolean licencia;
    private Auditoria auditoria;

}