package org.grupo4.practica_integradora_g4.controller;

import jakarta.servlet.http.HttpSession;
import org.grupo4.practica_integradora_g4.extras.Colecciones;
import org.grupo4.practica_integradora_g4.model.entidades.Cliente;
import org.grupo4.practica_integradora_g4.model.extra.DatosContacto;
import org.grupo4.practica_integradora_g4.model.extra.DatosPersonales;
import org.grupo4.practica_integradora_g4.model.extra.DatosUsuario;
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
public class ControladorRegistroCliente {

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

    private boolean registroCompleto;


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
            @Validated({DatosPersonales.class})
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
                               Model model,
                                HttpSession sesion
    ){
        if (sesion.getAttribute("datos_contacto")!=null){
            cliente=(Cliente) sesion.getAttribute("datos_contacto");
            model.addAttribute("clientePlantilla", cliente);
        }else model.addAttribute("clientePlantilla",cliente);

        return "html/paso2";
    }
    @PostMapping("paso2")
    private String paso2Post(
            @Validated({DatosContacto.class})
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
                            Model model,
                            HttpSession sesion
    ){
        if (sesion.getAttribute("datos_usuario")!=null){
            cliente=(Cliente) sesion.getAttribute("datos_usuario");
            model.addAttribute("clientePlantilla", cliente);
        }else model.addAttribute("clientePlantilla",cliente);
        return "html/paso3";
    }

    @PostMapping("paso3")
    private String paso3Post(
            @Validated({DatosUsuario.class})
            @ModelAttribute("clientePlantilla")Cliente cliente,
            BindingResult posiblesErrores,
            HttpSession sesion
    ){
        if (posiblesErrores.hasErrors()) {
            System.out.println(posiblesErrores.getAllErrors());
            return "html/paso3";
        }
        else {
            sesion.setAttribute("datos_usuario", cliente);
            return "redirect:/grupo4/resumen";
        }
    }



    @GetMapping("resumen")
    private String resumenGet(Cliente cliente,
                              Model model,
                              HttpSession sesion
    ){
        int comprobador=0;
        if (sesion.getAttribute("datos_personales")!=null) {
            Cliente datos_personales = (Cliente) sesion.getAttribute("datos_personales");
            cliente.setGenero(datos_personales.getGenero());
            cliente.setFechaNacimiento(datos_personales.getFechaNacimiento());
            cliente.setPais(datos_personales.getPais());
            cliente.setTipoDocumentoCliente(datos_personales.getTipoDocumentoCliente());
            cliente.setDocumento(datos_personales.getDocumento());
            cliente.setNombre(datos_personales.getNombre());
            cliente.setApellidos(datos_personales.getApellidos());
            comprobador++;
        }
        if (sesion.getAttribute("datos_contacto")!=null) {
            Cliente datos_contacto = (Cliente) sesion.getAttribute("datos_contacto");
            cliente.setDirecciones(datos_contacto.getDirecciones());
            cliente.setTelefonoMovil(datos_contacto.getTelefonoMovil());
            comprobador++;
        }
        if (sesion.getAttribute("datos_usuario")!=null) {
            Cliente datos_usuario = (Cliente) sesion.getAttribute("datos_usuario");
            //cliente.setUsuario(datos_usuario.getUsuario());
            cliente.setComentarios(datos_usuario.getComentarios());
            //cliente.setLicencia(datos_usuario.isLicencia());
            comprobador++;
        }
        model.addAttribute("clientePlantilla", cliente);
        sesion.setAttribute("clienteFinal",cliente);
        if (comprobador==3){
            registroCompleto=true;
        }
        return "html/resumen";
    }

    @PostMapping("resumen")
    private String resumen(
            Model model,
            HttpSession sesion
    ){
        Cliente cliente = (Cliente) sesion.getAttribute("clienteFinal");
        model.addAttribute("clientePlantilla", cliente);

        if (registroCompleto) {
            registroCompleto=false;
            Colecciones.addCliente(cliente);
            sesion.invalidate();
            return "redirect:/grupo4/paso1";
        }
        else {
            return "html/resumen";
        }
    }

    @PostMapping("cerrar-sesion")
    private String cerrarSesion(HttpSession sesion){
        registroCompleto=false;
        sesion.invalidate();
        return "redirect:/grupo4/paso1";
    }

}
