package org.grupo4.practica_integradora_g4.service.impl;

import org.grupo4.practica_integradora_g4.model.mongo.Producto;
import org.grupo4.practica_integradora_g4.repositories.mongo.ProductoRepository;
import org.grupo4.practica_integradora_g4.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    @Override
    public List<Producto> findAll(Sort sort) {
        return productoRepository.findAll(sort);
    }

    @Override
    public Optional<Producto> findById(String id) {
        return productoRepository.findById(id);
    }

    @Override
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public void deleteById(String id) {
        productoRepository.deleteById(id);
    }

    @Override
    public List<Producto> findByCategoriaId(String categoriaId) {
        return productoRepository.findByCategoriaId(categoriaId);
    }
}