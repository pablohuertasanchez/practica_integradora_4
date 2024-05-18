package org.grupo4.practica_integradora_g4.controller;

import jakarta.servlet.http.HttpSession;
import org.grupo4.practica_integradora_g4.extras.Colecciones;
import org.grupo4.practica_integradora_g4.model.entidades.*;
import org.grupo4.practica_integradora_g4.model.extra.DatosContacto;
import org.grupo4.practica_integradora_g4.model.extra.DatosPersonales;
import org.grupo4.practica_integradora_g4.model.extra.DatosUsuario;
import org.grupo4.practica_integradora_g4.repositories.GeneroRepository;
import org.grupo4.practica_integradora_g4.repositories.PaisRepository;
import org.grupo4.practica_integradora_g4.services.GeneroService;
import org.grupo4.practica_integradora_g4.services.PaisService;
import org.grupo4.practica_integradora_g4.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;
import java.util.UUID;


@Controller
@RequestMapping(value = "registro")
public class ControladorRegistroCliente {
    @Autowired
    private PaisService paisService;
    @Autowired
    private GeneroService generoService;
    @Autowired
    private PaisRepository paisRepository;
    @Autowired
    private GeneroRepository generoRepository;

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
        // Cargar los países y guardarlos en el servicio de países
        Colecciones.getNacionalidades().forEach((siglas, nombre) -> {
            Pais pais = new Pais(nombre, siglas);
            paisService.save(pais);
        });
        Colecciones.getGeneros().forEach((siglas, gen) -> {
            Genero genero = new Genero(gen, siglas);
            generoService.save(genero);
        });

        // Añadir la lista de países al modelo
        model.addAttribute("listaP",paisRepository.findAll());
        model.addAttribute("listaG",generoRepository.findAll());
        if (sesion.getAttribute("datos_personales")!=null){
            cliente=(Cliente) sesion.getAttribute("datos_personales");
            model.addAttribute("clientePlantilla", cliente);
        }else model.addAttribute("clientePlantilla",cliente);

        return "paso1";
    }

    @PostMapping("paso1")
    private String paso1Post(
            @Validated({DatosPersonales.class})
            @ModelAttribute("clientePlantilla") Cliente cliente,
            BindingResult posiblesErrores,
            @RequestParam("pais") String siglaPais,
            @RequestParam("genero") String siglaGenero,
            HttpSession sesion,
            Model model
    ){
        // Añadir la lista de países y generos al modelo
        model.addAttribute("listaP", paisRepository.findAll());
        model.addAttribute("listaG", generoRepository.findAll());

        // Obtener la sigla del país  y genero seleccionado en el formulario

        System.out.println(siglaPais);
        String cadenaRotaPais = siglaPais.split(",")[0];
        System.out.println(siglaGenero);


        // Buscar el país y genero en la base de datos por su sigla
        Pais paisSeleccionado = paisRepository.findBySiglas(cadenaRotaPais);
        Genero generoSeleccionado = generoRepository.findBySiglas(siglaGenero);
        // Si se encuentra el país, asignarlo al cliente
        if (paisSeleccionado != null) {
            cliente.setPais(paisSeleccionado);
            sesion.setAttribute("datos_personales", cliente);
        } else {
            model.addAttribute("error", "Pais no existente");
        }
        if (generoSeleccionado != null) {
            cliente.setGenero(generoSeleccionado);
            sesion.setAttribute("datos_personales", cliente);
        } else {
            model.addAttribute("error", "Pais no existente");
        }

        if (posiblesErrores.hasErrors()) {
            System.out.println(posiblesErrores.getAllErrors());
            return "paso1";
        }
        else {
            System.out.println(cliente.toString());
            sesion.setAttribute("datos_personales", cliente);
            return "redirect:/registro/paso2";
        }
    }


    //PASO 2
    @GetMapping("paso2")
    private String paso2Get(Cliente cliente,
                               Model model,
                                HttpSession sesion
    ){
        System.out.println(cliente
                .toString());
        if (sesion.getAttribute("datos_contacto")!=null){
            cliente=(Cliente) sesion.getAttribute("datos_contacto");
            model.addAttribute("clientePlantilla", cliente);
        }else model.addAttribute("clientePlantilla",cliente);

        return "paso2";
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
            return "paso2";
        }
        else {
            System.out.println(cliente.toString());
            sesion.setAttribute("datos_contacto", cliente);
            return "redirect:/registro/paso3";
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

        return "paso3";
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
            return "paso3";
        }
        else {
            // Procesar las tarjetas de crédito y agregar al cliente

            Set<TarjetaCredito> tarjetasCredito = cliente.getTarjetasCredito();
            System.out.println(cliente.toString());

            if (tarjetasCredito != null) {
                for (TarjetaCredito tarjeta : tarjetasCredito) {
                    tarjeta.setCliente(cliente);
                }
            }

            // Guardar el cliente en la base de datos, si es necesario
            // clienteService.save(cliente);
            System.out.println(cliente.toString());
            sesion.setAttribute("datos_usuario", cliente);
            return "redirect:/registro/resumen";
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
            cliente.setPais(datos_personales.getPais());
            cliente.setFechaNacimiento(datos_personales.getFechaNacimiento());
            cliente.setTipoDocumentoCliente(datos_personales.getTipoDocumentoCliente());
            cliente.setDocumento(datos_personales.getDocumento());
            cliente.setNombre(datos_personales.getNombre());
            cliente.setApellidos(datos_personales.getApellidos());
            comprobador++;
        }
        if (sesion.getAttribute("datos_contacto")!=null) {
            Cliente datos_contacto = (Cliente) sesion.getAttribute("datos_contacto");
            cliente.setDirecciones(datos_contacto.getDirecciones());
//            cliente.setTelefonoMovil(datos_contacto.getTelefonoMovil());
            comprobador++;
        }
        if (sesion.getAttribute("datos_usuario")!=null) {

            Cliente datos_usuario = (Cliente) sesion.getAttribute("datos_usuario");
            //cliente.setUsuario(datos_usuario.getUsuario());
            cliente.setComentarios(datos_usuario.getComentarios());
            //cliente.setLicencia(datos_usuario.isLicencia());
            comprobador++;
        }
        Usuario usuAut = (Usuario) sesion.getAttribute("usuarioAut");
        cliente.setUsuarioEmail(usuAut);
        System.out.println(cliente.toString());
        model.addAttribute("clientePlantilla", cliente);
        sesion.setAttribute("clienteFinal",cliente);
        if (comprobador==3){
            registroCompleto=true;
        }
        return "resumen";
    }

    @PostMapping("resumen")
    private String resumen(
            Model model,
            HttpSession sesion
    ){
        Cliente cliente = (Cliente) sesion.getAttribute("clienteFinal");
        System.out.println(cliente.toString());
        model.addAttribute("clientePlantilla", cliente);

        if (registroCompleto) {
            registroCompleto=false;
            Colecciones.addCliente(cliente);
            sesion.invalidate();
            return "redirect:/registro/paso1";
        }
        else {
            return "resumen";
        }
    }

    @PostMapping("cerrar-sesion")
    private String cerrarSesion(HttpSession sesion){
        registroCompleto=false;
        sesion.invalidate();
        return "redirect:/registro/paso1";
    }

}
