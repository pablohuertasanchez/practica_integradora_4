// models/Producto.js
export default class Producto {
    constructor(id, modelo, marca, categoria, precio, cantidad, imagen, descripcion) {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.categoria = categoria;
        this.precio = precio;
        this.cantidad = cantidad;
        this.imagen = imagen;
        this.descripcion = descripcion;
    }
}

