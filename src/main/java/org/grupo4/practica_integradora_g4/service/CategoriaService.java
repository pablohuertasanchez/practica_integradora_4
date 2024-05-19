package org.grupo4.practica_integradora_g4.service;

import org.grupo4.practica_integradora_g4.model.mongo.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {
    List<Categoria> findAll();
    Optional<Categoria> findById(String id); // Añadido este método
    Categoria save(Categoria categoria);
    void deleteById(String id);
}