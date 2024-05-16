import {createApp} from 'vue';
import App from './App.vue'
// Importamos bootstrap
import '@/assets/css/bootstrap.min.css';
/* eslint-disable */
// eslint-disable-next-line
import '@/assets/js/bootstrap.bundle.min.js';
import store from './store'; // Importa tu tienda Vuex
import {createRouter, createWebHistory} from 'vue-router';
import ProductosView from './views/ProductosView.vue';
import HomeView from "@/views/HomeView.vue";
import Carrito from "@/views/CarritoView.vue";
import ProductDetail from "@/views/ProductDetailView.vue";

const router = createRouter({
    history: createWebHistory('/tienda'),
    routes: [
        // {
        //     path: '/',
        //     name: 'App',
        //     component: App
        // },
        {
            path: "/",
            name: 'HomeView',
            component: HomeView
        },
        {
            path: '/loginUsuario',
            redirect: () => window.location.href = 'http://localhost:8080/loginUsuario'
        },
        {
            path: '/productos',
            name: 'productos',
            component: ProductosView,
        },
        {
            path: '/producto/:id',
            name: 'ProductDetail',
            component: ProductDetail,
        },
        {
            path: '/carrito',
            name: 'carrito',
            component: Carrito
        },

    ]
});

const app = createApp(App);
app.use(router);
app.use(store); // Usa tu tienda Vuex

app.mount('#app');


