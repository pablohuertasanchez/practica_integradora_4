package org.grupo4.practica_integradora_g4.repositories;

import org.grupo4.practica_integradora_g4.model.entidades.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface DireccionRepository extends JpaRepository<Direccion, UUID> {
    List<Direccion> findByClienteId(UUID clienteId);
    void deleteByClienteId(UUID clienteId);
}
