package org.grupo4.practica_integradora_g4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/tienda")
    public String index() {
        return "redirect:/tienda";
    }
}
