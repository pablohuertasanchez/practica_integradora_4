// store/index.js

import { createStore } from 'vuex';
import productosModule from "@/modules/productos";

export default createStore({
    modules: {
        productos: productosModule
    },
    state: {
        productosFiltrados: [] // Lista de productos filtrados por búsqueda
    },
    mutations: {
        setSearchProductos(state, productosFiltrados) {
            state.productosFiltrados = productosFiltrados;
        }
    },
    actions: {
        searchProducto({ state, commit }, query) {
            const productos = state.productos.productos;
            const productosFiltrados = productos.filter(producto =>
                producto.nombre.toLowerCase().includes(query.toLowerCase())
            );
            commit('setSearchProductos', productosFiltrados);
        }
    }
});
