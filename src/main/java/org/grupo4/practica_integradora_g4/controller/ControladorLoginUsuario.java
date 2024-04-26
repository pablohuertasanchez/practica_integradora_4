package org.grupo4.practica_integradora_g4.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.grupo4.practica_integradora_g4.Colecciones;
import org.grupo4.practica_integradora_g4.entidades.Usuario;
import org.springframework.beans.BeanMetadataAttributeAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ControladorLoginUsuario {

    @GetMapping("/loginUsuario")
    public String log1(@ModelAttribute("usuario")Usuario u,
                       Model modelo){
        List<String> emailUsu = Colecciones.obtenerEmailUsuarios();
        modelo.addAttribute("emailUsuarios",emailUsu);
        return "html/loginUsuario.html";
    }

    @PostMapping("/loginUsuario-post")
    public String log1P(@ModelAttribute("usuario") Usuario u,
                        Model modelo){
        return "redirect:/registro";
    }

    @GetMapping("/registroUsuario")
    public String reg1(@ModelAttribute("usuario")Usuario u,
                       Model modelo,
                       HttpSession sesion){

        Usuario uS = (Usuario) sesion.getAttribute("usuario");
        modelo.addAttribute("usuario",u);
        if (uS !=null){
            modelo.addAttribute("usuario",uS);
            System.out.println(uS.toString());
        }

        return "html/registroUsuario.html";
    }

    @PostMapping("/registroUsuario-post")
    public String reg1P(@Valid @ModelAttribute("usuario")Usuario u,
                        BindingResult result,
                        Model modelo,

                        HttpSession sesion){

        if (result.hasErrors()){
            modelo.addAttribute("errors",result.getAllErrors());
            System.out.println(result.getAllErrors());
            return "html/registroUsuario.html";
        }

        System.out.println(u.toString());
            sesion.setAttribute("usuario",u);
            Colecciones.agregarUsuario(u);
            sesion.removeAttribute("usuario");
            return "redirect:/loginUsuario";



    }

}
