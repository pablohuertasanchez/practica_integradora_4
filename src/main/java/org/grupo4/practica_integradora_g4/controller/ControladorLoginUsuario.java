package org.grupo4.practica_integradora_g4.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.grupo4.practica_integradora_g4.extras.Colecciones;
import org.grupo4.practica_integradora_g4.model.entidades.Usuario;
import org.grupo4.practica_integradora_g4.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ControladorLoginUsuario {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/loginUsuario")
    public String log1(@ModelAttribute("usuario") Usuario u, Model modelo) {
        List<String> emailUsu = Colecciones.obtenerEmailUsuarios();
        modelo.addAttribute("emailUsuarios", emailUsu);
        return "loginUsuario/loginUsuario";
    }

    @PostMapping("/loginUsuario-post")
    public String log1P(@ModelAttribute("usuario") Usuario u, Model modelo, HttpSession sesion) {
        List<String> emailUsu = Colecciones.obtenerEmailUsuarios();
        modelo.addAttribute("emailUsuarios", emailUsu);
        List<Usuario> listaUsuarios = Colecciones.devuelveUsu();
        Usuario usuarioAut = null;
        for (Usuario usu : listaUsuarios) {
            if (usu.getEmail().equals(u.getEmail())) {
                usuarioAut = usu;
            }
        }
        System.out.println(u.toString());
        if (usuarioAut != null) {
            sesion.setAttribute("usuarioAut", usuarioAut);
            return "redirect:/loginUsuario2";
        } else {
            modelo.addAttribute("error", "Usuario no existente");
            return "loginUsuario/loginUsuario";
        }
    }

    @GetMapping("/registroUsuario")
    public String reg1(@ModelAttribute("usuario") Usuario u, Model modelo, HttpSession sesion) {
        Usuario uS = (Usuario) sesion.getAttribute("usuario");
        modelo.addAttribute("usuario", u);
        if (uS != null) {
            modelo.addAttribute("usuario", uS);
            System.out.println(uS.toString());
        }
        return "loginUsuario/registroUsuario";
    }

    @PostMapping("/registroUsuario-post")
    public String reg1P(@Valid @ModelAttribute("usuario") Usuario u, BindingResult result, Model modelo, HttpSession sesion) {
        if (result.hasErrors()) {
            modelo.addAttribute("errors", result.getAllErrors());
            System.out.println(result.getAllErrors());
            return "loginUsuario/registroUsuario";
        }

        System.out.println(u.toString());
        sesion.setAttribute("usuario", u);

        // Guardar el usuario en la base de datos
        usuarioService.save(u);
        Colecciones.agregarUsuario(u);
        // Limpiar la sesión y redirigir al login
        sesion.removeAttribute("usuario");
        return "redirect:/loginUsuario";
    }

    @GetMapping("/loginUsuario2")
    public String aut2(@ModelAttribute("usuario") Usuario u, Model modelo) {
        return "loginUsuario/loginUsuario2";
    }

    @PostMapping("/loginUsuario2-post")
    public String aut2P(@ModelAttribute("usuario") Usuario u, Model modelo, HttpSession sesion) {
        Usuario usuAut = (Usuario) sesion.getAttribute("usuarioAut");
        if (usuAut != null) {
            if (usuAut.getClave().equals(u.getClave())) {
                sesion.setAttribute("usuarioAutenticado", usuAut);
                return "redirect:/registro/paso1";
            } else {
                modelo.addAttribute("error", "Clave incorrecta");
                return "loginUsuario/loginUsuario2";
            }
        } else {
            modelo.addAttribute("error", "No se ha iniciado sesión");
            return "loginUsuario/loginUsuario2";
        }
    }
}
