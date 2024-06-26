package org.grupo4.practica_integradora_g4.model.entidades;

import jakarta.persistence.*;
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
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
