package org.grupo4.practica_integradora_g4.model.entidades;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString

@Document(collection = "productos")
public class Producto {
    @Id
    private String id;
    private String descripcion;
    private BigDecimal precio;
    private Integer unidadesVendidas;
    private BigDecimal gastoAcumulado;
    private Integer cantidadAlmacen;
    private Integer umbralSolicitudProveedor;
    private Integer umbralOcultoEnTienda;
    private Boolean enOferta;
    private BigDecimal descuento;
    private Boolean esNovedad;
    private Integer valoracionProducto;
    private String marca;
    private String modelo;
    private Set<String> imagenes;
    private String comentarios;
}
