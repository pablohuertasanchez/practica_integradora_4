package org.grupo4.practica_integradora_g4.model.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import org.grupo4.practica_integradora_g4.model.embedded.Auditoria;
import org.grupo4.practica_integradora_g4.validaciones.ComprobarClaves;
import org.grupo4.practica_integradora_g4.validaciones.ComprobarEmail;
import org.grupo4.practica_integradora_g4.validaciones.ComprobarNombreEmail;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.util.UUID;

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
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotNull
    @NotBlank
    @ComprobarEmail
    @ComprobarNombreEmail
    private String email;
    @NotNull
    @NotBlank
    @Size(min=6, max=12)
    //@Pattern(regexp ="(?=.*[0-9])(?=.*[a-zñ])(?=.*[A-ZÑ])(?=.*[!#$%&]).*")
    private String clave;
    @NotNull
    private String confirmarClave;
    @NotNull
    @NotBlank
    private String pregRec;
    @NotNull
    @NotBlank
    private String respRec;
    private LocalDate fechaUltimaConexion=LocalDate.now();
    private Integer numeroAccesos=0;
  //  private Auditoria auditoria;
}

