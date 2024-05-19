package org.grupo4.practica_integradora_g4.services;

import org.grupo4.practica_integradora_g4.model.entidades.Cliente;
import org.grupo4.practica_integradora_g4.model.entidades.Pais;
import org.grupo4.practica_integradora_g4.repositories.ClienteRepository;
import org.grupo4.practica_integradora_g4.repositories.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    public void save(Cliente cliente){
        clienteRepository.save(cliente);
    }
}
