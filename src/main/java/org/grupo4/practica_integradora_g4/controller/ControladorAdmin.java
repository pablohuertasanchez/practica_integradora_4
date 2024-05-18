package org.grupo4.practica_integradora_g4.controller;

import jakarta.validation.Valid;
import org.grupo4.practica_integradora_g4.model.entidades.Producto;
import org.grupo4.practica_integradora_g4.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping(value = "administrador")
public class ControladorAdmin {

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping("/inicio")
    public String getAdministracion(){
        return "loginAdmin/administracion";
    }

    @GetMapping("/productos")
    public String listarProductos(Model model) {
        model.addAttribute("productos", productoRepository.findAll());
        return "administrador/productos";
    }

    @GetMapping("/productos/add")
    public String getAgregarProducto(@ModelAttribute("nuevoProducto") Producto producto, Model model) {
        model.addAttribute("nuevoProducto", new Producto());
        return "administrador/addProducto";
    }

    @PostMapping("/productos")
    public String agregarProducto(@Valid @ModelAttribute("nuevoProducto") Producto producto, BindingResult result) {
        if (result.hasErrors()) {
            return "administrador/addProducto";
        }
        productoRepository.save(producto);
        return "redirect:/administrador/productos";
    }

    @GetMapping("/productos/eliminar")
    public String eliminarProducto(@RequestParam String id) {
        productoRepository.deleteById(id);
        return "redirect:/administrador/productos";
    }
}
