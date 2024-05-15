const state = {
    productos: [
        { id: 1, nombre: 'Tornillo', precio: 10, imagen: 'https://via.placeholder.com/150', descripcion: 'Tornillo de acero galvanizado' },
        { id: 2, nombre: 'Taladro', precio: 20, imagen: 'https://via.placeholder.com/150', descripcion: 'Taladro eléctrico de alta potencia' },
        { id: 3, nombre: 'Martillo', precio: 30, imagen: 'https://via.placeholder.com/150', descripcion: 'Martillo de carpintero de mango de madera' },
        { id: 4, nombre: 'Destornillador', precio: 40, imagen: 'https://via.placeholder.com/150', descripcion: 'Destornillador Phillips magnético' },
        { id: 5, nombre: 'Sierra', precio: 50, imagen: 'https://via.placeholder.com/150', descripcion: 'Sierra circular de corte fino' },
        { id: 6, nombre: 'Llave Inglesa', precio: 60, imagen: 'https://via.placeholder.com/150', descripcion: 'Llave inglesa ajustable de 10 pulgadas' },
        { id: 7, nombre: 'Cinta Métrica', precio: 70, imagen: 'https://via.placeholder.com/150', descripcion: 'Cinta métrica de 5 metros' },
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
