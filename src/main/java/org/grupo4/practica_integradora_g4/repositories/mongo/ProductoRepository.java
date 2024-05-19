package org.grupo4.practica_integradora_g4.repositories.mongo;

import org.grupo4.practica_integradora_g4.model.mongo.Categoria;
import org.grupo4.practica_integradora_g4.model.mongo.Producto;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductoRepository extends MongoRepository<Producto, String> {
    List<Producto> findByCategoria(Categoria categoria);

    List<Producto> findByCategoriaId(String categoriaId);
}
