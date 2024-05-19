package org.grupo4.practica_integradora_g4.service;

import org.grupo4.practica_integradora_g4.model.entidades.TipoCliente;
import org.grupo4.practica_integradora_g4.repositories.TipoClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoClienteService {
    @Autowired
    private TipoClienteRepository tipoClienteRepository;
    public void save(TipoCliente tipoCliente) {tipoClienteRepository.save(tipoCliente);
    }
}
