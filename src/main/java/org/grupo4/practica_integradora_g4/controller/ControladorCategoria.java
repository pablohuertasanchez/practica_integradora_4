package org.grupo4.practica_integradora_g4.controller;

import org.grupo4.practica_integradora_g4.model.mongo.Categoria;
import org.grupo4.practica_integradora_g4.repositories.mongo.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categorias")
public class ControladorCategoria {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public String listarCategorias(Model model) {
        model.addAttribute("categorias", categoriaRepository.findAll());
        return "administrador/listarCategorias";
    }

    @GetMapping("/add")
    public String getAgregarCategoria(Model model) {
        model.addAttribute("nuevaCategoria", new Categoria());
        return "administrador/addCategoria";
    }

    @PostMapping
    public String agregarCategoria(@ModelAttribute Categoria categoria) {
        categoriaRepository.save(categoria);
        return "redirect:/categorias";
    }

    @GetMapping("/eliminar")
    public String eliminarCategoria(@RequestParam String id) {
        categoriaRepository.deleteById(id);
        return "redirect:/categorias";
    }
}
