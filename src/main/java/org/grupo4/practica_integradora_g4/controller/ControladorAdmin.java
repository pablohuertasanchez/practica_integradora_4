package org.grupo4.practica_integradora_g4.controller;

import org.grupo4.practica_integradora_g4.model.entidades.Producto;
import org.grupo4.practica_integradora_g4.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.List;

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

        List<Producto> productos = productoRepository.findAll();
        model.addAttribute("productosPrueba", productos);
        return "administrador/productos";
    }

}
