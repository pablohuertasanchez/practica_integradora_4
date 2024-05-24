package org.grupo4.practica_integradora_g4.repositories;

import org.grupo4.practica_integradora_g4.model.entidades.Auditoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditoriaRepository extends JpaRepository<Auditoria, Long> {
    // Aquí puedes agregar métodos de consulta adicionales si los necesitas
}
