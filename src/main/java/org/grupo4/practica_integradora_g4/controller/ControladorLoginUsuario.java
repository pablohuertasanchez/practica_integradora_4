package org.grupo4.practica_integradora_g4.controller;

import org.grupo4.practica_integradora_g4.entidades.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControladorLoginUsuario {

    @GetMapping("/loginUsuario")
    public String log1(@ModelAttribute("usuario")Usuario u,
                       Model modelo){
        return "loginUsuario.html";
    }

    @PostMapping("/loginUsuario-post")
    public String log1P(@ModelAttribute("usario") Usuario u,
                        Model modelo){
        return "redirect:/registro";
    }

    @GetMapping("/registroUsuario")
    public String reg1(@ModelAttribute("usuario")Usuario u,
                       Model modelo){

        return "registroUsuario.html";
    }

    @PostMapping("/registroUsuario-post")
    public String reg1P(@ModelAttribute("usuario")Usuario u,
                        Model modelo){
        return "redirect:/loginUsuario";
    }

}
