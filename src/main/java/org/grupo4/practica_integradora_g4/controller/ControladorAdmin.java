package org.grupo4.practica_integradora_g4.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.grupo4.practica_integradora_g4.model.mongo.Producto;
import org.grupo4.practica_integradora_g4.repositories.mongo.ProductoRepository;
import org.grupo4.practica_integradora_g4.repositories.mongo.CategoriaRepository;
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
    @Autowired
    private CategoriaRepository categoriaRepository;

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
    public String getAgregarProducto(Model model) {
        model.addAttribute("nuevoProducto", new Producto());
        model.addAttribute("categorias", categoriaRepository.findAll());
        return "administrador/addProducto";
    }

    @PostMapping("/productos")
    public String agregarProducto(@Valid @ModelAttribute("nuevoProducto") Producto producto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("categorias", categoriaRepository.findAll());
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

    @GetMapping("/cerrar_sesion")
    public String cerrarSesion(HttpSession sesion) {
        sesion.invalidate();
        return "redirect:/loginAdmin";
    }
}
