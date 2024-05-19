package org.grupo4.practica_integradora_g4.services;

import org.grupo4.practica_integradora_g4.model.entidades.Cliente;
import org.grupo4.practica_integradora_g4.repositories.ClienteRepository;
import org.grupo4.practica_integradora_g4.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Cliente saveStep1(Cliente cliente, BindingResult result) {
        if (result.hasErrors()) {
            return cliente;
        }
        // Validación y lógica de negocio para el paso 1
        return clienteRepository.save(cliente);
    }

    public Cliente saveStep2(Cliente cliente, BindingResult result) {
        if (result.hasErrors()) {
            return cliente;
        }
        // Validación y lógica de negocio para el paso 2
        return clienteRepository.save(cliente);
    }

    public Cliente saveStep3(Cliente cliente, BindingResult result) {
        if (result.hasErrors()) {
            return cliente;
        }
        // Validación y lógica de negocio para el paso 3
        return clienteRepository.save(cliente);
    }

    public Cliente findBySession(String sessionId) {
        // Buscar cliente por sesión (implementar lógica según cómo manejes las sesiones)
        return null;
    }
}