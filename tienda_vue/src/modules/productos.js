import Producto from '../models/Producto';

const state = {
    productos: [
    new Producto(1, 'Tornillo', 10, 'https://via.placeholder.com/150', 'Tornillo de acero galvanizado'),
    new Producto(2, 'Taladro', 20, 'https://via.placeholder.com/150', 'Taladro eléctrico de alta potencia'),
    new Producto(3, 'Martillo', 30, 'https://via.placeholder.com/150', 'Martillo de carpintero de mango de madera'),
    new Producto(4, 'Destornillador', 40, 'https://via.placeholder.com/150', 'Destornillador Phillips magnético'),
    new Producto(5, 'Sierra', 50, 'https://via.placeholder.com/150', 'Sierra circular de corte fino'),
    new Producto(6, 'Llave Inglesa', 60, 'https://via.placeholder.com/150', 'Llave inglesa ajustable de 10 pulgadas'),
    new Producto(7, 'Cinta Métrica', 70, 'https://via.placeholder.com/150', 'Cinta métrica de 5 metros')
],
    query: '', // Variable para almacenar la consulta de búsqueda
    productosFiltrados: [] // Lista de productos filtrados por búsqueda
};

const actions = {
    fetchProductos({ commit, state }) {
        const productos = state.productos;
        commit('setProductos', productos);
        commit('setSearchProductos', productos); // También agregamos esta mutación aquí
    },
    searchProducto({ state, commit }, query) {
        // Verificar si query es una cadena antes de llamar a toLowerCase()
        if (typeof query === 'string') {
            const productosFiltrados = state.productos.filter(producto =>
                producto.nombre.toLowerCase().includes(query.toLowerCase())
            );
            commit('setSearchProductos', productosFiltrados);
            console.log('Productos filtrados después de la mutación:', state.productosFiltrados);
        }
    }
};


const mutations = {
    setProductos(state, productos) {
        state.productos = productos;
    },
    setSearchProductos(state, productosFiltrados) {
        state.productosFiltrados = productosFiltrados.length ? productosFiltrados : state.productos;
        console.log('Productos filtrados después de la mutación:', state.productosFiltrados);
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
