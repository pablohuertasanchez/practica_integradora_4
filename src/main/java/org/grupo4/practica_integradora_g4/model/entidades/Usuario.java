package org.grupo4.practica_integradora_g4.model.entidades;

import jakarta.persistence.*;
import lombok.*;

import org.grupo4.practica_integradora_g4.validaciones.ComprobarClaves;
import org.grupo4.practica_integradora_g4.validaciones.ComprobarEmail;
import org.grupo4.practica_integradora_g4.validaciones.ComprobarNombreEmail;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Validated
@ComprobarClaves


@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email(message = "El correo electrónico debe ser válido")
    @NotBlank(message = "El correo electrónico es obligatorio")
    private String email;

    @NotBlank(message = "La clave es obligatoria")
    private String clave;

    private LocalDate fechaUltimaConexion;

    @Min(value = 0, message = "El número de accesos debe ser un valor positivo")
    private Integer numeroAccesos;

    @Embedded
    private Auditoria auditoria;

}
