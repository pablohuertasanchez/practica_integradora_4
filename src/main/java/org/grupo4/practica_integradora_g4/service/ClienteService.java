package org.grupo4.practica_integradora_g4.service;

import jakarta.transaction.Transactional;
import org.grupo4.practica_integradora_g4.model.entidades.Cliente;
import org.grupo4.practica_integradora_g4.repositories.ClienteRepository;
import org.grupo4.practica_integradora_g4.repositories.DireccionRepository;
import org.grupo4.practica_integradora_g4.specifications.ClienteSpecifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private DireccionRepository direccionRepository;
    public void save(Cliente cliente){
        clienteRepository.save(cliente);
    }
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }
    @Transactional
    public void deleteById(UUID id) {
        direccionRepository.deleteByClienteId(id);
        clienteRepository.deleteById(id);
    }
    public Optional<Cliente> findById(UUID id) {
        return clienteRepository.findById(id);
    }
//
//    public List<Cliente> buscarClientes(String apellido, Date fechaInicio, Date fechaFin, Double salarioMin, Double salarioMax, List<String> nacionalidades) {
//        return clienteRepository.findAll(ClienteSpecifications.withFilters(apellido, fechaInicio, fechaFin, salarioMin, salarioMax, nacionalidades));
//    }
}
