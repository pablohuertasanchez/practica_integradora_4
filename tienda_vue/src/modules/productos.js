import Producto from '../models/Producto';

const state = {
    productos: [
        new Producto(1, "Clase B", "Mercedes-Benz", "Familiar", 120.52, 50, "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fwww.topgear.com%2Fsites%2Fdefault%2Ffiles%2Fcars-car%2Fcarousel%2F2016%2F08%2Frpbclass.jpg&f=1&nofb=1&ipt=ecc1374b770b51c0a39e99791ad6c18b28c7f0b1207471644428862d09688bd3&ipo=images", "Compacto y versátil, ideal para la ciudad y viajes cortos."),
        new Producto(2, "Serie 1", "BMW", "Compacto", 140.71, 50, "https://cdn.bmwblog.com/wp-content/uploads/2017/05/BMW-1-Series-Facelift-20.jpg", "Diseño deportivo y rendimiento excepcional."),
        new Producto(3, "Qashqai", "Nissan", "Familiar", 194.16, 50, "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fmediacloud.carbuyer.co.uk%2Fimage%2Fprivate%2Fs--LcdpCh_v--%2Fv1579621488%2Fcarbuyer%2F2017%2F03%2Fnissan_qashqai_2017_faceliftqqfl01.jpg&f=1&nofb=1&ipt=1c70376171a8977c73d9c74bb2168ee85859f150d312d97b2c5cde37b6d06700&ipo=images", "Espacioso y cómodo, perfecto para aventuras familiares."),
        new Producto(4, "Giulietta", "Alfa Romeo", "Deportivo", 167.47, 50, "https://media.autoexpress.co.uk/image/private/s--ajyiZ007--/v1562242159/autoexpress/2016/02/160225_alfa-romeo_nuova-giulietta_05.jpg", "Estilo italiano y rendimiento dinámico."),
        new Producto(5, "E-Tron", "Audi", "Lujo", 373.34, 50, "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fperformancedrive.com.au%2Fwp-content%2Fuploads%2F2018%2F09%2F2019-Audi-e-tron.jpg&f=1&nofb=1&ipt=551c96c4170d8f8029ebde63719ec5bb53a829ddea6a174b848dd2ecf1d41eb3&ipo=images", "Vehículo eléctrico de alta gama con tecnología innovadora."),
        new Producto(6, "Clase S", "Mercedes-Benz", "Lujo", 457.72, 50, "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fmediacloud.carbuyer.co.uk%2Fimage%2Fprivate%2Fs--XdNY7oiw--%2Fv1579632369%2Fcarbuyer%2F2017%2F07%2F17c521_010.jpg&f=1&nofb=1&ipt=b643933b35c475b67a1ff2086d570c733b395312de39cec52ae2f34471468fe5&ipo=images", "Elegancia y confort supremo para los viajes más exclusivos."),
        new Producto(7, "Focus", "Ford", "Compacto", 155.99, 30, "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fst.motortrendenespanol.com%2Fuploads%2Fsites%2F45%2F2014%2F02%2F2015-Ford-Focus-hatchback-front-view.jpg&f=1&nofb=1&ipt=6d1a82baf1d570f5b4148d9e8d6046601962643a47d8b16897a2811af09b5303&ipo=images", "Equilibrio perfecto entre rendimiento y eficiencia."),
        new Producto(8, "Civic", "Honda", "Compacto", 170.25, 40, "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fimages.hgmsites.net%2Fhug%2F2019-honda-civic-sdn_100677004_h.jpg&f=1&nofb=1&ipt=d498a4d6cd7641bb3766c85d9d0200cb55b6b6161e2dbb70443ecaa07d7069d6&ipo=images", "Estilo deportivo y fiabilidad honda."),
        new Producto(9, "Corolla", "Toyota", "Compacto", 180.50, 25, "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fwww.autocentrum.pl%2Fac-file%2Fcar-version%2F62ff64ae277d1a1baa7d5ee5.jpg&f=1&nofb=1&ipt=efb45c9ec25a02783619074b1829ff2d6b9a8bf9ad071aaada762ce572dc084d&ipo=images", "Icono de confiabilidad y eficiencia."),
        new Producto(10, "Camry", "Toyota", "Sedan", 210.75, 35, "https://cleanfleetreport.com/wp-content/uploads/2016/07/NO-1-CAMRY-HYBRID.jpg", "Elegante y espacioso, ideal para viajes largos."),
        new Producto(11, "Accord", "Honda", "Sedan", 200.00, 45, "https://www.automobilemag.com/uploads/sites/11/2013/06/2014-Honda-Accord-Hybrid-front-three-quarters1.jpg", "Confort y seguridad para toda la familia."),
        new Producto(12, "X5", "BMW", "SUV", 350.80, 20, "https://www.bmw.com.au/content/dam/bmw/common/all-models/x-series/x5/2018/mperformance/bmw-g05-x5-m-performance-exterior-gallery-wallpaper-04.jpg.asset.1526634134384.jpg", "Potencia y lujo combinados en un SUV versátil."),
        new Producto(13, "Tucson", "Hyundai", "SUV", 190.30, 30, "https://images.autodaily.com.au/2021/01/Hyundai-Tucson-PHEV.jpg", "Diseño moderno y comodidad para la aventura."),
        new Producto(14, "CR-V", "Honda", "SUV", 220.45, 35, "https://images.carexpert.com.au/resize/3000/-/app/uploads/2023/03/2024-Honda-CR-V-THAILAND-HERO-3x2-1.jpg", "Espacio y versatilidad para el día a día."),
        new Producto(15, "CX-5", "Mazda", "SUV", 205.60, 25, "https://cdn.drivek.it/configurator-covermobile/cars/es/$original$/MAZDA/CX-5/39095_SUV-5-DOORS/mazda-cx-5-my19-cover-mobile.jpg", "Compacto y versátil, ideal para la ciudad y viajes cortos."),
    ],
    query: '', // Variable para almacenar la consulta de búsqueda
    productosFiltrados: [] // Lista de productos filtrados por búsqueda
};

const actions = {
    fetchProductos({commit, state}) {
        const productos = state.productos;
        commit('setProductos', productos);
        commit('setSearchProductos', productos); // También agregamos esta mutación aquí
    },
    searchProducto({state, commit}, query) {
        // Verificar si query es una cadena antes de llamar a toLowerCase()
        if (typeof query === 'string') {
            const productosFiltrados = state.productos.filter(producto =>
                producto.marca.toLowerCase().includes(query.toLowerCase())
            );
            commit('setSearchProductos', productosFiltrados);
            console.log('Productos filtrados después de la mutación:', state.productosFiltrados);
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
        console.log('Productos filtrados después de la mutación:', state.productosFiltrados);
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
