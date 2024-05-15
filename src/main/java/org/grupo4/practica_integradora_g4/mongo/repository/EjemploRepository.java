package org.grupo4.practica_integradora_g4.mongo.repository;

import org.grupo4.practica_integradora_g4.mongo.model.Ejemplo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EjemploRepository extends MongoRepository <Ejemplo,String>{
}
