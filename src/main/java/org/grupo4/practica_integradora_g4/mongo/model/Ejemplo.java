package org.grupo4.practica_integradora_g4.mongo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Document(collection = "ejemplo")
public class Ejemplo {
    @Id
    private String id;
    private String campo;

}
