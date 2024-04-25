package org.grupo4.practica_integradora_g4.controller;

import jakarta.servlet.http.HttpSession;
import org.grupo4.practica_integradora_g4.extras.Colecciones;
import org.grupo4.practica_integradora_g4.model.entidades.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;


@Controller
@RequestMapping(value = "grupo4")
public class Controlador {

    @ModelAttribute("listaGeneros")
    private Map<String, String> getGeneros(){return Colecciones.getGeneros();}

    @ModelAttribute("listaPrefijos")
    private Map<String, String> getPrefijos(){return Colecciones.getGPrefijos();}

    @ModelAttribute("listaPaises")
    private Map<String, String> getNacionalidades(){return Colecciones.getNacionalidades();}

    @ModelAttribute("listaDepartamentos")
    private Map<String, String> getDepartamentos(){return Colecciones.getDepartamentos();}

    @ModelAttribute("listaTiposDocumento")
    private Map<String, String> getTipoDocumento(){return Colecciones.getTipoDocumento();}


    //PASO 1
    @GetMapping("paso1")
    private String paso1Get(Cliente cliente,
                                Model model,
                                HttpSession sesion
    ){

        if (sesion.getAttribute("datos_personales")!=null){
            cliente=(Cliente) sesion.getAttribute("datos_personales");
            model.addAttribute("clientePlantilla", cliente);
        }else model.addAttribute("clientePlantilla",cliente);

        return "html/paso1";
    }
    @PostMapping("paso1")
    private String paso1Post(
            @Validated
            @ModelAttribute("clientePlantilla")Cliente cliente,
            BindingResult posiblesErrores,
            HttpSession sesion
    ){
        if (posiblesErrores.hasErrors()) {
            System.out.println(posiblesErrores.getAllErrors());
            return "html/paso1";
        }
        else {
            sesion.setAttribute("datos_personales", cliente);
            return "redirect:/grupo4/paso2";
        }
    }

    //PASO 2
    @GetMapping("paso2")
    private String paso2Get(Cliente cliente,
                               Model model
    ){
        model.addAttribute("clientePlantilla", cliente);
        return "html/paso2";
    }
    @PostMapping("paso2")
    private String paso2Post(
            @Validated
            @ModelAttribute("clientePlantilla")Cliente cliente,
            BindingResult posiblesErrores,
            HttpSession sesion
    ){
        if (posiblesErrores.hasErrors()) {
            System.out.println(posiblesErrores.getAllErrors());
            return "html/paso2";
        }
        else {
            sesion.setAttribute("datos_contacto", cliente);
            return "redirect:/grupo4/paso3";
        }
    }

    //PASO 3
    @GetMapping("paso3")
    private String paso3Get(Cliente cliente,
                            Model model
    ){
        model.addAttribute("clientePlantilla", cliente);
        return "html/paso3";
    }
    @GetMapping("resumen")
    private String resumenGet(Cliente cliente,
                              Model model
    ){
        model.addAttribute("clientePlantilla", cliente);
        return "html/resumen";
    }

}
