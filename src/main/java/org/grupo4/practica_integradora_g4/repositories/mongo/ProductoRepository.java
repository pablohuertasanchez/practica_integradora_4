package org.grupo4.practica_integradora_g4.repositories.mongo;

import org.grupo4.practica_integradora_g4.model.mongo.Producto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductoRepository extends MongoRepository<Producto, String> {
}
