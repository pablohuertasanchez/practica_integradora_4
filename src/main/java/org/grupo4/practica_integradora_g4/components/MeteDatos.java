package org.grupo4.practica_integradora_g4.components;

import org.grupo4.practica_integradora_g4.model.entidades.Usuario;
import org.grupo4.practica_integradora_g4.model.mongo.Categoria;
import org.grupo4.practica_integradora_g4.model.mongo.Producto;
import org.grupo4.practica_integradora_g4.repositories.UsuarioRepository;
import org.grupo4.practica_integradora_g4.repositories.mongo.CategoriaRepository;
import org.grupo4.practica_integradora_g4.repositories.mongo.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

import java.math.BigDecimal;
import java.util.Arrays;

@Component
public class MeteDatos {

    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;


    @PostConstruct
    public void creaUsuariosAdmin() {
//        usuarioRepository.deleteAll();
        if (usuarioRepository.count() == 0) {
            Usuario admin = new Usuario();
            admin.setEmail("root@email.com");
            admin.setClave("admin");
            admin.setConfirmarClave("admin");
            admin.setPregRec("hola");
            admin.setRespRec("adios");
            Usuario admin2 = new Usuario();
            admin2.setEmail("pablo@email.com");
            admin2.setClave("huerta");
            admin2.setConfirmarClave("huerta");
            admin2.setPregRec("que tal");
            admin2.setRespRec("bien");
            usuarioRepository.save(admin);
            usuarioRepository.save(admin2);
        }
    }
    @PostConstruct
    public void init() {
        // Inicializar categorías por defecto
        Categoria compacto = new Categoria("1","Compacto","Mejor coche para la familia");
        Categoria deportivo = new Categoria("2","Deportivo","Para los más atrevidos");
        Categoria lujo = new Categoria("3","Lujo","Experimenta la comodidad en movimiento");
        Categoria suv = new Categoria("4","SUV","Más grande es mejor");

        categoriaRepository.save(compacto);
        categoriaRepository.save(suv);
        categoriaRepository.save(deportivo);
        categoriaRepository.save(lujo);

        // Verificar si ya existen productos en la base de datos
        if (productoRepository.count() == 0) {
            // Inicializar productos por defecto
            Producto producto1 = new Producto();
            producto1.setDescripcion("Volkswagen Golf");
            producto1.setPrecio(new BigDecimal("23000.00"));
            producto1.setUnidadesVendidas(100);
            producto1.setGastoAcumulado(new BigDecimal("2300000.00"));
            producto1.setCantidadAlmacen(50);
            producto1.setUmbralSolicitudProveedor(10);
            producto1.setUmbralOcultoEnTienda(5);
            producto1.setEnOferta(false);
            producto1.setDescuento(BigDecimal.ZERO);
            producto1.setEsNovedad(true);
            producto1.setValoracionProducto(4);
            producto1.setMarca("Volkswagen");
            producto1.setModelo("Golf");
            producto1.setCategoria(compacto); // Asociar categoría
            producto1.setComentarios("Compacto confiable y eficiente.");

            Producto producto2 = new Producto();
            producto2.setDescripcion("BMW Serie 3");
            producto2.setPrecio(new BigDecimal("41000.00"));
            producto2.setUnidadesVendidas(60);
            producto2.setGastoAcumulado(new BigDecimal("2460000.00"));
            producto2.setCantidadAlmacen(30);
            producto2.setUmbralSolicitudProveedor(5);
            producto2.setUmbralOcultoEnTienda(3);
            producto2.setEnOferta(false);
            producto2.setDescuento(BigDecimal.ZERO);
            producto2.setEsNovedad(true);
            producto2.setValoracionProducto(5);
            producto2.setMarca("BMW");
            producto2.setModelo("Serie 3");
            producto2.setCategoria(deportivo); // Asociar categoría
            producto2.setComentarios("Sedán de lujo con excelente desempeño.");

            Producto producto3 = new Producto();
            producto3.setDescripcion("Porsche 911");
            producto3.setPrecio(new BigDecimal("115000.00"));
            producto3.setUnidadesVendidas(20);
            producto3.setGastoAcumulado(new BigDecimal("2300000.00"));
            producto3.setCantidadAlmacen(10);
            producto3.setUmbralSolicitudProveedor(2);
            producto3.setUmbralOcultoEnTienda(1);
            producto3.setEnOferta(true);
            producto3.setDescuento(new BigDecimal("0.05"));
            producto3.setEsNovedad(false);
            producto3.setValoracionProducto(5);
            producto3.setMarca("Porsche");
            producto3.setModelo("911");
            producto3.setCategoria(deportivo); // Asociar categoría
            producto3.setComentarios("Deportivo icónico con alto rendimiento.");

            Producto producto4 = new Producto();
            producto4.setDescripcion("Mercedes-Benz Clase S");
            producto4.setPrecio(new BigDecimal("130000.00"));
            producto4.setUnidadesVendidas(15);
            producto4.setGastoAcumulado(new BigDecimal("1950000.00"));
            producto4.setCantidadAlmacen(8);
            producto4.setUmbralSolicitudProveedor(2);
            producto4.setUmbralOcultoEnTienda(1);
            producto4.setEnOferta(false);
            producto4.setDescuento(BigDecimal.ZERO);
            producto4.setEsNovedad(false);
            producto4.setValoracionProducto(5);
            producto4.setMarca("Mercedes-Benz");
            producto4.setModelo("Clase S");
            producto4.setCategoria(lujo); // Asociar categoría
            producto4.setComentarios("Sedán de lujo con tecnología avanzada y confort.");

            productoRepository.save(producto1);
            productoRepository.save(producto2);
            productoRepository.save(producto3);
            productoRepository.save(producto4);
        }
    }
}