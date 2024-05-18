package org.grupo4.practica_integradora_g4.controller;

import jakarta.servlet.http.HttpSession;
import org.grupo4.practica_integradora_g4.extras.Colecciones;
import org.grupo4.practica_integradora_g4.model.entidades.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ControladorLoginUsuarioAdministrador {

    @GetMapping("/loginAdmin")
    public String getLoginAdmin(){
        return "loginAdmin/loginAdmin.html";
    }
    @PostMapping("/loginAdmin")
    public String postLoginAdmin(@RequestParam(name = "email", required = false)String email,
                                 @RequestParam(name = "clave", required = false) String clave,
                                 HttpSession sesion){
        if (Colecciones.getUsuariosAdmin().containsKey(email)) {
            if (Colecciones.getUsuariosAdmin().get(email).getClave().equals(clave)) {
                return "redirect:/administrador/inicio";
            }
        }
        return "loginAdmin/loginAdmin.html";
    }

}
