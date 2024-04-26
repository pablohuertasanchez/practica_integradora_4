package org.grupo4.practica_integradora_g4.entidades;

import lombok.*;
import org.grupo4.practica_integradora_g4.embedded.Auditoria;
import org.grupo4.practica_integradora_g4.validaciones.ComprobarEmail;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class Usuario {
    @NotNull
    @NotBlank
    @ComprobarEmail
    private String email;
    private String clave;
    private String confirmarClave;
    private LocalDate fechaUltimaConexion;
    private Integer numeroAccesos;
    private Auditoria auditoria;
}
