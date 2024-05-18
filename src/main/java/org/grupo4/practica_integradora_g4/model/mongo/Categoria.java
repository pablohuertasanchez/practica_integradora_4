package org.grupo4.practica_integradora_g4.model.mongo;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString

@Document(collection = "categorias")
@Data
public class Categoria {
    @Id
    private String id;
    private String nombre;
    private String descripcion;
}
