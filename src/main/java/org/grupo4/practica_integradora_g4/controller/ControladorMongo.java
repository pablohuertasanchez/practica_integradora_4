package org.grupo4.practica_integradora_g4.controller;

import org.grupo4.practica_integradora_g4.model.entidades.Producto;
import org.grupo4.practica_integradora_g4.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ControladorMongo {

    @Autowired
    private ProductoRepository tuRepositorioMongo; // Reemplaza con tu repositorio

    @GetMapping("/datos")

    public List<Producto> obtenerDatos() {
        return tuRepositorioMongo.findAll(); // Devuelve todos los documentos en la colección
    }
}
