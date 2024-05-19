package org.grupo4.practica_integradora_g4.model.entidades;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.*;
import lombok.*;

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
@Data
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Datos personales (paso 1)
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "Los apellidos son obligatorios")
    private String apellidos;

    @NotBlank(message = "El género es obligatorio")
    private String genero;

    @ManyToOne
    @JoinColumn(name = "pais_nacimiento_id")
    @NotNull(message = "El país de nacimiento es obligatorio")
    private Pais paisNacimiento;

    @Past(message = "La fecha de nacimiento debe ser una fecha pasada")
    @NotNull(message = "La fecha de nacimiento es obligatoria")
    private LocalDate fechaNacimiento;

    @NotBlank(message = "El tipo de documento es obligatorio")
    private String tipoDocumentoCliente;

    @NotBlank(message = "El documento es obligatorio")
    private String documento;

    // Datos de contacto (paso 2)
    @NotBlank(message = "El teléfono móvil es obligatorio")
    private String telefonoMovil;

    @ManyToOne
    @JoinColumn(name = "direccion_id")
    @NotNull(message = "La dirección es obligatoria")
    private Direccion direccion;

    @OneToMany
    @JoinTable(
            name = "cliente_direcciones_entrega",
            joinColumns = @JoinColumn(name = "cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "direccion_id")
    )
    private Set<Direccion> direccionesEntrega;

    // Datos de cliente (paso 3)
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @NotNull(message = "El usuario es obligatorio")
    private Usuario usuario;

    @OneToMany
    @JoinTable(
            name = "cliente_tarjetas_credito",
            joinColumns = @JoinColumn(name = "cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "tarjeta_credito_id")
    )
    private Set<TarjetaCredito> tarjetasCredito;

    @DecimalMin(value = "0.0", inclusive = false, message = "El gasto acumulado debe ser mayor que 0")
    private BigDecimal gastoAcumuladoCliente;

    @NotBlank(message = "El tipo de cliente es obligatorio")
    private String tipoCliente;

    private String comentarios;

    @NotNull(message = "La aceptación de la licencia es obligatoria")
    private Boolean aceptacionLicencia;

    @Embedded
    private Auditoria auditoria;


}
