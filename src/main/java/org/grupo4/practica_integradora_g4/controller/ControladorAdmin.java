package org.grupo4.practica_integradora_g4.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.grupo4.practica_integradora_g4.model.entidades.Usuario;
import org.grupo4.practica_integradora_g4.model.mongo.Categoria;
import org.grupo4.practica_integradora_g4.model.mongo.Producto;
import org.grupo4.practica_integradora_g4.repositories.UsuarioRepository;
import org.grupo4.practica_integradora_g4.repositories.mongo.ProductoRepository;
import org.grupo4.practica_integradora_g4.repositories.mongo.CategoriaRepository;
import org.grupo4.practica_integradora_g4.service.CategoriaService;
import org.grupo4.practica_integradora_g4.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping(value = "administrador")
public class ControladorAdmin {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private UsuarioRepository usuarioRepository;


    @GetMapping("/inicio")
    public String getAdministracion(HttpSession session, Model model) {
        if (session.getAttribute("usuario") == null) {
            return "administrador/errorAcceso";
        }
        model.addAttribute("usuario", session.getAttribute("usuario"));
        return "loginAdmin/administracion";
    }

    //PRODUCTOS
    @GetMapping("/productos")
    public String listarProductos(HttpSession session, Model model,
                                  @RequestParam(required = false) String sortField,
                                  @RequestParam(required = false) String sortDir) {
        if (session.getAttribute("usuario") == null) {
            return "administrador/errorAcceso";
        }
        Sort sort = Sort.by("cantidadAlmacen"); // default sort
        if (sortField != null && sortDir != null) {
            sort = sortDir.equals("asc") ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();
        }
        model.addAttribute("productos", productoService.findAll(sort));
        model.addAttribute("categorias", categoriaService.findAll());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);

        model.addAttribute("usuario", session.getAttribute("usuario"));
        return "administrador/productos";
    }
    @GetMapping("/productos/add")
    public String getAgregarProducto(HttpSession session,Model model) {
        if (session.getAttribute("usuario") == null) {
            return "administrador/errorAcceso";
        }
        model.addAttribute("nuevoProducto", new Producto());
        model.addAttribute("categorias", categoriaService.findAll());
        model.addAttribute("usuario", session.getAttribute("usuario"));
        return "administrador/addProducto";
    }
    @PostMapping("/productos")
    public String agregarProducto(HttpSession session, @Valid @ModelAttribute("nuevoProducto") Producto producto, BindingResult result, Model model) {
        if (session.getAttribute("usuario") == null) {
            return "administrador/errorAcceso";
        }
        if (result.hasErrors()) {
            model.addAttribute("categorias", categoriaService.findAll());
            model.addAttribute("usuario", session.getAttribute("usuario"));
            return "administrador/addProducto";
        }
        productoService.save(producto);

        model.addAttribute("usuario", session.getAttribute("usuario"));
        return "redirect:/administrador/productos";
    }
    @GetMapping("/productos/eliminar")
    public String eliminarProducto(HttpSession session,Model model, @RequestParam String id) {
        if (session.getAttribute("usuario") == null) {
            return "administrador/errorAcceso";
        }
        productoService.deleteById(id);

        model.addAttribute("usuario", session.getAttribute("usuario"));
        return "redirect:/administrador/productos";
    }

    @GetMapping("/productos/categoria/{id}")
    public String listarProductosPorCategoria(HttpSession session, @PathVariable String id, Model model) {
        if (session.getAttribute("usuario") == null) {
            return "administrador/errorAcceso";
        }
        Categoria categoria = categoriaService.findById(id).orElse(null);
        if (categoria != null) {
            List<Producto> productos = productoService.findByCategoriaId(id);
            model.addAttribute("productos", productos);
            model.addAttribute("categoria", categoria);
        } else {
            model.addAttribute("productos", List.of());
            model.addAttribute("categoria", null);
        }

        model.addAttribute("usuario", session.getAttribute("usuario"));
        return "administrador/productosPorCategoria";
    }

    //CATEGORIAS
    @GetMapping("/categorias")
    public String listarCategorias(HttpSession session, Model model) {
        if (session.getAttribute("usuario") == null) {
            return "administrador/errorAcceso";
        }
        model.addAttribute("categorias", categoriaService.findAll());

        model.addAttribute("usuario", session.getAttribute("usuario"));
        return "administrador/listarCategorias";
    }
    @GetMapping("/categorias/add")
    public String getAgregarCategoria(HttpSession session, Model model) {
        if (session.getAttribute("usuario") == null) {
            return "administrador/errorAcceso";
        }
        model.addAttribute("nuevaCategoria", new Categoria());

        model.addAttribute("usuario", session.getAttribute("usuario"));
        return "administrador/addCategoria";
    }
    @PostMapping("/categorias")
    public String agregarCategoria(HttpSession session, @ModelAttribute Categoria categoria, Model model) {
        if (session.getAttribute("usuario") == null) {
            return "administrador/errorAcceso";
        }
        categoriaService.save(categoria);

        model.addAttribute("usuario", session.getAttribute("usuario"));
        return "redirect:/administrador/categorias";
    }
    @GetMapping("/categorias/eliminar")
    public String eliminarCategoria(HttpSession session, @RequestParam String id, Model model) {
        if (session.getAttribute("usuario") == null) {
            return "administrador/errorAcceso";
        }
        categoriaService.deleteById(id);

        model.addAttribute("usuario", session.getAttribute("usuario"));
        return "redirect:/administrador/categorias";
    }

    //USUARIOS ADMINISTRADORES
    @GetMapping("/addAdmin")
    public String getAgregarAdministrador(HttpSession session, Model model){
        if (session.getAttribute("usuario") == null) {
            return "administrador/errorAcceso";
        }
        model.addAttribute("administrador", new Usuario());
        model.addAttribute("usuario", session.getAttribute("usuario"));
        return "administrador/registroAdministrador";
    }
    @PostMapping("/addAdmin")
    public String postAgregarAdministrador(Usuario administrador,HttpSession session, Model model){
        if (session.getAttribute("usuario") == null) {
            return "administrador/errorAcceso";
        }
        if (usuarioRepository.findByEmail(administrador.getEmail()).isPresent()) {
            model.addAttribute("error", "Ya estás registrado");
            model.addAttribute("usuario", session.getAttribute("usuario"));
            return "administrador/registroAdministrador";
        }
        usuarioRepository.save(administrador);
        model.addAttribute("usuario", session.getAttribute("usuario"));
        return "redirect:/administrador/inicio";

    }


    //CERRAR SESION
    @GetMapping("/cerrar_sesion")
    public String cerrarSesion(HttpSession sesion) {
        sesion.invalidate();
        return "redirect:/loginAdmin";
    }
}
