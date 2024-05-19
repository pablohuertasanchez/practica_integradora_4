package org.grupo4.practica_integradora_g4.controller;

import jakarta.validation.Valid;
import org.grupo4.practica_integradora_g4.model.entidades.Cliente;
import org.grupo4.practica_integradora_g4.model.entidades.Pais;
import org.grupo4.practica_integradora_g4.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/registro")
@SessionAttributes("cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @ModelAttribute("cliente")
    public Cliente setupCliente() {
        return new Cliente();
    }

    @GetMapping("/paso1")
    public String showStep1(Model model) {
        model.addAttribute("paises", getPaises());
        return "registro/paso1";
    }

    @PostMapping("/paso1")
    public String processStep1(@Valid @ModelAttribute("cliente") Cliente cliente, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("paises", getPaises());
            return "registro/paso1";
        }
        clienteService.saveStep1(cliente, result);
        return "redirect:/registro/paso2";
    }

    @GetMapping("/paso2")
    public String showStep2(Model model) {
        model.addAttribute("tiposVia", getTiposVia());
        return "registro/paso2";
    }

    @PostMapping("/paso2")
    public String processStep2(@Valid @ModelAttribute("cliente") Cliente cliente, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("tiposVia", getTiposVia());
            return "registro/paso2";
        }
        clienteService.saveStep2(cliente, result);
        return "redirect:/registro/paso3";
    }

    @GetMapping("/paso3")
    public String showStep3(Model model) {
        model.addAttribute("tiposCliente", getTiposCliente());
        return "registro/paso3";
    }

    @PostMapping("/paso3")
    public String processStep3(@Valid @ModelAttribute("cliente") Cliente cliente, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("tiposCliente", getTiposCliente());
            return "registro/paso3";
        }
        clienteService.saveStep3(cliente, result);
        return "redirect:/registro/resumen";
    }

    @GetMapping("/resumen")
    public String showSummary(@ModelAttribute("cliente") Cliente cliente) {
        return "registro/resumen";
    }

    @PostMapping("/finalizar")
    public String finalizeRegistration(@ModelAttribute("cliente") Cliente cliente) {
        // Lógica para finalizar el registro, si es necesario
        return "redirect:/registro/completado";
    }

    @GetMapping("/completado")
    public String showCompleted() {
        return "registro/completado";
    }

    private List<Pais> getPaises() {
        // Lógica para obtener la lista de países
        return List.of(new Pais("ES", "España"), new Pais("FR", "Francia"));
    }

    private List<String> getTiposVia() {
        // Lógica para obtener la lista de tipos de vía
        return List.of("Calle", "Avenida", "Plaza", "Glorieta", "Paseo");
    }

    private List<String> getTiposCliente() {
        // Lógica para obtener la lista de tipos de cliente
        return List.of("Bronce", "Plata", "Oro", "Platino");
    }
}