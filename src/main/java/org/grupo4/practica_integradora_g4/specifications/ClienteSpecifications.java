package org.grupo4.practica_integradora_g4.specifications;

import jakarta.persistence.criteria.Predicate;
import org.grupo4.practica_integradora_g4.model.entidades.Cliente;
import org.springframework.data.jpa.domain.Specification;


import java.util.Date;
import java.util.List;

public class ClienteSpecifications {
    public static Specification<Cliente> withFilters(String apellido, Date fechaInicio, Date fechaFin, Double salarioMin, Double salarioMax, List<String> nacionalidades) {
        return (root, query, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();

            if (apellido != null && !apellido.isEmpty()) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(root.get("apellido"), "%" + apellido + "%"));
            }
            if (fechaInicio != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.greaterThanOrEqualTo(root.get("fechaNacimiento"), fechaInicio));
            }
            if (fechaFin != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.lessThanOrEqualTo(root.get("fechaNacimiento"), fechaFin));
            }
            if (salarioMin != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.greaterThanOrEqualTo(root.get("salario"), salarioMin));
            }
            if (salarioMax != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.lessThanOrEqualTo(root.get("salario"), salarioMax));
            }
            if (nacionalidades != null && !nacionalidades.isEmpty()) {
                predicate = criteriaBuilder.and(predicate, root.get("nacionalidad").in(nacionalidades));
            }

            return predicate;
        };
    }
}

