package org.grupo4.practica_integradora_g4.model.entidades;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Data
public class TarjetaCredito {
    @Id
    Integer numero;
    String tipoTarjetaCredito;
    String cvv;
    LocalDate fechaCad;
}
