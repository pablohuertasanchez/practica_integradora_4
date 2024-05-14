import { createApp } from 'vue';
import App from './App.vue';
// Importamos bootstrap
import '@/assets/css/bootstrap.min.css';
/* eslint-disable */
// eslint-disable-next-line
import '@/assets/js/bootstrap.bundle.min.js';
import {createRouter, createWebHistory} from 'vue-router';
import ProductosView from './views/ProductosView.vue';
import HomeView from "@/views/HomeView.vue";



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
        }

    ]

})
const app = createApp(App);
app.use(router);

app.mount('#app');