package org.grupo4.practica_integradora_g4.repositories.mongo;

import org.grupo4.practica_integradora_g4.model.mongo.Categoria;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoriaRepository extends MongoRepository<Categoria, String> {
//    @Override
//    public Categoria findCategoriaById (String id){
//        return
//    }
}
