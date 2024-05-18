package org.grupo4.practica_integradora_g4.components;

import org.grupo4.practica_integradora_g4.model.mongo.Categoria;
import org.grupo4.practica_integradora_g4.repositories.mongo.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

import java.util.Arrays;

@Component
public class MeteCategorias implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public void run(String... args) throws Exception {
//        if (categoriaRepository.count() == 0) {
//            categoriaRepository.saveAll(Arrays.asList(
//                    new Categoria("1","Compacto","Mejor coche para la familia"),
//                    new Categoria("2","Deportivo","Para los más atrevidos"),
//                    new Categoria("3","Lujo","Experimenta la comodidad en movimiento"),
//                    new Categoria("4","SUV","Más grande es mejor")
//            ));
//        }
    }
}
