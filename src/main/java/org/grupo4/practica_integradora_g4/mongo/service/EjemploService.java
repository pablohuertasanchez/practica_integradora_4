package org.grupo4.practica_integradora_g4.mongo.service;

import org.grupo4.practica_integradora_g4.mongo.model.Ejemplo;
import org.grupo4.practica_integradora_g4.mongo.repository.EjemploRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class EjemploService {
    @Autowired
    private EjemploRepository ejemploRepository;

    public void insertarEjemplo(String campo) {
        Ejemplo ejemplo = new Ejemplo();
        ejemplo.setCampo(campo);
        ejemploRepository.save(ejemplo);
    }
}
