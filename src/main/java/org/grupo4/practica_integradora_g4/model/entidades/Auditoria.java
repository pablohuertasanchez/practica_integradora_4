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
@Entity
@Data
public class Auditoria {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private LocalDate fechaAltaEntidad;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "usuario_QueDaDeAlta",
            foreignKey = @ForeignKey(name = "FK_aud_usuario_usuarioQueDaDeAlta")

    )
    private Usuario usuarioAdminQueRealizaAlta;
    private LocalDate fechaUltimaModificacionEntidad;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "usuario_QueModifica",
            foreignKey = @ForeignKey(name = "FK_aud_usuario_usuarioQueModifica")

    )
    private Usuario usuarioAdminQueRealizaUltimaModf;
    private LocalDate fechaBorradoEntidad;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "usuario_QueBorra",
            foreignKey = @ForeignKey(name = "FK_aud_usuario_usuarioQueBorra")

    )
    private Usuario usuarioAdminQueRealizaBorrado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

}
