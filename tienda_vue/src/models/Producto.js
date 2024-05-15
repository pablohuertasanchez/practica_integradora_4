// models/Producto.js
export default class Producto {
    constructor(id, nombre, precio, imagen, descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.imagen = imagen;
        this.descripcion = descripcion;
    }
}

