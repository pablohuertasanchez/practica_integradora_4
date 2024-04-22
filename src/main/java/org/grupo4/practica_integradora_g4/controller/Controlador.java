package org.grupo4.practica_integradora_g4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "grupo4")
public class Controlador {
    @GetMapping("usuario")
    private String registroGet(
    ){
        return "html/new";
    }
}
