package org.grupo4.practica_integradora_g4.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.grupo4.practica_integradora_g4.entidades.Usuario;
import org.springframework.beans.BeanMetadataAttributeAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

        return "registroUsuario.html";
    }

    @PostMapping("/registroUsuario-post")
    public String reg1P(@Valid @ModelAttribute("usuario")Usuario u,
                        Model modelo,
                        BindingResult result,
                        HttpSession sesion){

        if (result.hasErrors()){
            modelo.addAttribute("errors",result.getAllErrors());
            System.out.println(result.getAllErrors());
            return "registroUsuario.html";
        }

            sesion.setAttribute("usuario",u);
            return "redirect:/loginUsuario";



    }

}
