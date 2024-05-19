package org.grupo4.practica_integradora_g4.controller;

import jakarta.servlet.http.HttpSession;
import org.grupo4.practica_integradora_g4.extras.Colecciones;
import org.grupo4.practica_integradora_g4.model.entidades.Usuario;
import org.grupo4.practica_integradora_g4.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class ControladorLoginUsuarioAdministrador {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/loginAdmin")
    public String login() {
        return "loginAdmin/loginAdmin";
    }

    @PostMapping("/loginAdmin")
    public String loginUser(@RequestParam String email, @RequestParam String clave, HttpSession session, Model model) {
        Optional<Usuario> optionalUser = usuarioService.findByEmail(email);
        if (optionalUser.isPresent()) {
            Usuario usuario = optionalUser.get();
            if (clave.equals(usuario.getClave())) {
                session.setAttribute("usuario", usuario);
                return "redirect:/administrador/inicio";
            } else {
                model.addAttribute("errorClave", "Contraseña no válida");
                return "loginAdmin/loginAdmin";
            }
        } else {
            model.addAttribute("errorUsu", "No eres usuario Administrador");
            return "loginAdmin/loginAdmin";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/loginAdmin";
    }

}
