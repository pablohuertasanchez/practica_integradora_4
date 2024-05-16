package org.grupo4.practica_integradora_g4.controller;

import org.grupo4.practica_integradora_g4.extras.Colecciones;
import org.grupo4.practica_integradora_g4.model.entidades.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class ControladorLoginUsuarioAdministrador {

    @GetMapping("/loginAdmin")
    public String log1(){

        return "loginAdmin/loginAdmin.html";
    }
}
