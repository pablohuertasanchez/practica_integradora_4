package org.grupo4.practica_integradora_g4.components;

import org.grupo4.practica_integradora_g4.model.entidades.Producto;
import org.grupo4.practica_integradora_g4.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

import java.math.BigDecimal;

@Component
public class MeteDatos {

    @Autowired
    private ProductoRepository productoRepository;

    @PostConstruct
    public void init() {
        productoRepository.deleteAll();
        Producto producto1 = new Producto();
        producto1.setDescripcion("coche");
        producto1.setPrecio(new BigDecimal("19.99"));
        producto1.setUnidadesVendidas(100);
        producto1.setGastoAcumulado(new BigDecimal("1999.00"));
        producto1.setCantidadAlmacen(500);
        producto1.setUmbralSolicitudProveedor(200);
        producto1.setUmbralOcultoEnTienda(50);
        producto1.setEnOferta(false);
        producto1.setDescuento(BigDecimal.ZERO);
        producto1.setEsNovedad(true);
        producto1.setValoracionProducto(4);
        producto1.setMarca("Marca1");
        producto1.setModelo("Modelo1");
        producto1.setImagenes(null);
        producto1.setComentarios("Este es un comentario sobre el producto 1");

        Producto producto2 = new Producto();
        producto2.setDescripcion("Pantalón");
        producto2.setPrecio(new BigDecimal("29.99"));
        producto2.setUnidadesVendidas(50);
        producto2.setGastoAcumulado(new BigDecimal("1499.50"));
        producto2.setCantidadAlmacen(200);
        producto2.setUmbralSolicitudProveedor(100);
        producto2.setUmbralOcultoEnTienda(20);
        producto2.setEnOferta(true);
        producto2.setDescuento(new BigDecimal("0.2"));
        producto2.setEsNovedad(false);
        producto2.setValoracionProducto(3);
        producto2.setMarca("Marca2");
        producto2.setModelo("Modelo2");
        producto2.setImagenes(null);
        producto2.setComentarios("Este es un comentario sobre el producto 2");
        productoRepository.save(producto1);
        productoRepository.save(producto2);
    }
}
