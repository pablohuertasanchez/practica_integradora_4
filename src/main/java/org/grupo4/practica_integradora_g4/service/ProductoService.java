package org.grupo4.practica_integradora_g4.service;

import org.grupo4.practica_integradora_g4.model.mongo.Producto;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    List<Producto> findAll();
    List<Producto> findAll(Sort sort); // Añadido este método
    Optional<Producto> findById(String id);
    Producto save(Producto producto);
    void deleteById(String id);
    List<Producto> findByCategoriaId(String categoriaId);
}
