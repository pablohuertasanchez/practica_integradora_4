package org.grupo4.practica_integradora_g4.model.entidades;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import org.grupo4.practica_integradora_g4.model.extra.DatosContacto;
import org.grupo4.practica_integradora_g4.model.extra.DatosPersonales;
import org.grupo4.practica_integradora_g4.model.extra.DatosUsuario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor

@ToString
@Entity
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    //DATOS PERSONALES
    @ManyToOne
    @JoinColumn(
            name = "genero_gen",
            foreignKey = @ForeignKey(name = "FK_cli_genero_generoGen")

    )
    private Genero genero;
    private LocalDate fechaNacimiento;
    @ManyToOne
    @JoinColumn(
            name = "nombre_Pais",
            foreignKey = @ForeignKey(name = "FK_cli_pais_nombrePais")

    )
    private Pais pais;
    private String tipoDocumentoCliente;
    private String documento;
    @NotBlank( groups = DatosPersonales.class)
    private String nombre;
    private String apellidos;

    //DATOS DE CONTACTO
    @OneToOne
    @JoinColumn(
            name = "direccion_personal",
            foreignKey = @ForeignKey(name = "FK_cli_direccion_direccionPersonal")
    )
    private Direccion direcciones;
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Direccion> direccionesEntrega = new HashSet<>();
 //   @NotBlank ( groups = DatosContacto.class)
  //  private String telefonoMovil;

    //DATOS DE CLIENTE
    @OneToOne
    @JoinColumn(
            name = "email_usuario",
            foreignKey = @ForeignKey(name = "FK_cli_usuario_usuarioEmail")
    )
    private Usuario usuarioEmail;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<TarjetaCredito> tarjetasCredito = new HashSet<>(1) ;


    private BigDecimal gastoAcumuladoCliente;

    @ManyToOne
    @JoinColumn(
            name = "tipo_Cliente",
            foreignKey = @ForeignKey(name = "FK_cli_tipoCli_tipoCli")

    )
    private TipoCliente tipoCliente;


    private boolean licencia;
    @OneToOne
    @JoinColumn(
            name = "id_auditoria",
            foreignKey = @ForeignKey(name = "FK_cli_auditoria_idAuditoria")
    )
    private Auditoria auditoria;

    @NotBlank ( groups = DatosUsuario.class)
    private String comentarios;
    public Cliente() {
        this.tarjetasCredito = new HashSet<>();
        this.tarjetasCredito.add(new TarjetaCredito()); // Agregar una tarjeta por defecto
    }
}

