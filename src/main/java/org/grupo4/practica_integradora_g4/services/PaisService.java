package org.grupo4.practica_integradora_g4.services;

import org.grupo4.practica_integradora_g4.model.entidades.Pais;
import org.grupo4.practica_integradora_g4.model.entidades.Usuario;
import org.grupo4.practica_integradora_g4.repositories.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaisService {
    @Autowired
    private PaisRepository paisRepository;
    public void save(Pais pais){
        paisRepository.save(pais);
    }
}
