package org.grupo4.practica_integradora_g4.model.entidades;

import jakarta.validation.constraints.*;
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
    @NotBlank(message = "La descripción no puede estar vacía")
    private String descripcion;

    @NotNull(message = "El precio es obligatorio")
    @DecimalMin(value = "0.0", inclusive = false, message = "El precio debe ser mayor que 0")
    private BigDecimal precio;

    @NotNull(message = "Las unidades vendidas son obligatorias")
    @Min(value = 0, message = "Las unidades vendidas no pueden ser negativas")
    private Integer unidadesVendidas;

    @NotNull(message = "El gasto acumulado es obligatorio")
    @DecimalMin(value = "0.0",  message = "El gasto acumulado no puede ser negativo")
    private BigDecimal gastoAcumulado;

    @NotNull(message = "La cantidad en almacén es obligatoria")
    @Min(value = 0, message = "La cantidad en almacén no puede ser negativa")
    private Integer cantidadAlmacen;

    @NotNull(message = "El umbral de solicitud al proveedor es obligatorio")
    @Min(value = 0, message = "El umbral de solicitud al proveedor no puede ser negativo")
    private Integer umbralSolicitudProveedor;

    @NotNull(message = "El umbral oculto en tienda es obligatorio")
    @Min(value = 0, message = "El umbral oculto en tienda no puede ser negativo")
    private Integer umbralOcultoEnTienda;

    @NotNull(message = "El estado de oferta es obligatorio")
    private Boolean enOferta;

    @NotNull(message = "El descuento es obligatorio")
    @DecimalMin(value = "0.0",  message = "El descuento no puede ser negativo")
    @DecimalMax(value = "1.0", message = "El descuento no puede ser mayor que 1")
    private BigDecimal descuento;

    @NotNull(message = "El estado de novedad es obligatorio")
    private Boolean esNovedad;

    @NotNull(message = "La valoración del producto es obligatoria")
    @Min(value = 0, message = "La valoración del producto no puede ser negativa")
    @Max(value = 5, message = "La valoración del producto no puede ser mayor que 5")
    private Integer valoracionProducto;

    @NotBlank(message = "La marca no puede estar vacía")
    private String marca;

    @NotBlank(message = "El modelo no puede estar vacío")
    private String modelo;

    private Set<String> imagenes;

    @Size(max = 255, message = "Los comentarios no pueden tener más de 255 caracteres")
    private String comentarios;
}

