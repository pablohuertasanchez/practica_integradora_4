package org.grupo4.practica_integradora_g4.mongo.controller;

import org.grupo4.practica_integradora_g4.mongo.service.EjemploService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EjemploController {
    @Autowired
    private EjemploService ejemploService;

    @GetMapping("/insertar")
    public void insertar(@RequestBody String campo) {
        ejemploService.insertarEjemplo(campo);
    }
}
