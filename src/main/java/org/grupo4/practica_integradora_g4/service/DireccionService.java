package org.grupo4.practica_integradora_g4.service;

import org.grupo4.practica_integradora_g4.model.entidades.Direccion;
import org.grupo4.practica_integradora_g4.repositories.DireccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DireccionService {
    @Autowired
    private DireccionRepository direccionRepository;
    public void save(Direccion direccion){
        direccionRepository.save(direccion);
    }
}
