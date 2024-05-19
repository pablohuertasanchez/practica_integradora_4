import axios from 'axios';

const state = {
    productos: [],
    query: '', // Variable para almacenar la consulta de búsqueda
    productosFiltrados: [] // Lista de productos filtrados por búsqueda
};

const actions = {
    async fetchProductos({ commit }) {
        try {
            const response = await axios.get('http://localhost:8081/api/productos');
            commit('setProductos', response.data);
            commit('setSearchProductos', response.data); // También agregamos esta mutación aquí
        } catch (error) {
            console.error("Error fetching productos:", error);
        }
    },
    searchProducto({ state, commit }, query) {
        if (typeof query === 'string') {
            const productosFiltrados = state.productos.filter(producto =>
                producto.marca.toLowerCase().includes(query.toLowerCase())
            );
            commit('setSearchProductos', productosFiltrados);
        }
    },
    filtrarPorCategoria({ state, commit }, categoria) {
        const productosFiltrados = state.productos.filter(producto => producto.categoria.toLowerCase() === categoria.toLowerCase());
        commit('setProductosFiltrados', productosFiltrados);
    }
};

const mutations = {
    setProductos(state, productos) {
        state.productos = productos;
    },
    setSearchProductos(state, productosFiltrados) {
        state.productosFiltrados = productosFiltrados.length ? productosFiltrados : state.productos;
    },
    setProductosFiltrados(state, productosFiltrados) {
        state.productosFiltrados = productosFiltrados;
    }
};

const getters = {
    getProductos(state) {
        return state.productos;
    }
};

export default {
    namespaced: true,
    state,
    mutations,
    actions,
    getters
};
