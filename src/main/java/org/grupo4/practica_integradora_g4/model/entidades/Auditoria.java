package org.grupo4.practica_integradora_g4.model.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter


@Embeddable
public class Auditoria {
    private LocalDate fechaAltaEntidad;

    @ManyToOne
    @JoinColumn(name = "usuario_alta_id")
    private Usuario usuarioAdministradorQueRealizaAlta;

    private LocalDate fechaUltimaModificacionEntidad;

    @ManyToOne
    @JoinColumn(name = "usuario_modificacion_id")
    private Usuario usuarioAdministradorQueRealizaUltimaModificacion;

    private LocalDate fechaBorradoEntidad;

    @ManyToOne
    @JoinColumn(name = "usuario_borrado_id")
    private Usuario usuarioAdministradorQueRealizaBorrado;

    // Getters y setters
    // ...
}

