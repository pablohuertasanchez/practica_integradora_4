package org.grupo4.practica_integradora_g4.repositories;

import org.grupo4.practica_integradora_g4.model.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ClienteRepository extends JpaRepository <Cliente, UUID> {
    Optional<Cliente> findById(UUID id);
}
