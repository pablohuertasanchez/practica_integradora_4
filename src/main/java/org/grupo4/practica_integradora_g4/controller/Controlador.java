package org.grupo4.practica_integradora_g4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "grupo4")
public class Controlador {
    @GetMapping("registro")
    private String registroGet(
                                Model model
    ){

        return "html/paso1";
    }
}
