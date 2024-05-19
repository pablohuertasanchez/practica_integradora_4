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
    public String getAdministracion(HttpSession session, Model model) {
        if (session.getAttribute("usuario") == null) {
            return "redirect:/registro/paso1";
        }
        model.addAttribute("usuario", session.getAttribute("usuario"));
        return "loginAdmin/administracion";
    }

    @GetMapping("/productos")
    public String listarProductos(HttpSession session,Model model) {
        if (session.getAttribute("usuario") == null) {
            return "redirect:/registro/paso1";
        }
        model.addAttribute("productos", productoRepository.findAll());
        model.addAttribute("usuario", session.getAttribute("usuario"));
        return "administrador/productos";
    }

    @GetMapping("/productos/add")
    public String getAgregarProducto(HttpSession session,Model model) {
        if (session.getAttribute("usuario") == null) {
            return "redirect:/registro/paso1";
        }
        model.addAttribute("nuevoProducto", new Producto());
        model.addAttribute("categorias", categoriaRepository.findAll());
        model.addAttribute("usuario", session.getAttribute("usuario"));
        return "administrador/addProducto";
    }

    @PostMapping("/productos")
    public String agregarProducto(HttpSession session, @Valid @ModelAttribute("nuevoProducto") Producto producto, BindingResult result, Model model) {
        if (session.getAttribute("usuario") == null) {
            return "redirect:/registro/paso1";
        }
        if (result.hasErrors()) {
            model.addAttribute("categorias", categoriaRepository.findAll());
            model.addAttribute("usuario", session.getAttribute("usuario"));
            return "administrador/addProducto";
        }
        productoRepository.save(producto);
        model.addAttribute("usuario", session.getAttribute("usuario"));
        return "redirect:/administrador/productos";
    }

    @GetMapping("/productos/eliminar")
    public String eliminarProducto(HttpSession session,Model model, @RequestParam String id) {
        if (session.getAttribute("usuario") == null) {
            return "redirect:/registro/paso1";
        }
        productoRepository.deleteById(id);
        model.addAttribute("usuario", session.getAttribute("usuario"));
        return "redirect:/administrador/productos";
    }

    @GetMapping("/cerrar_sesion")
    public String cerrarSesion(HttpSession sesion) {
        sesion.invalidate();
        return "redirect:/loginAdmin";
    }
}
