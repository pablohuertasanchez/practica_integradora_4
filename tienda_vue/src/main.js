import { createApp } from 'vue';
import App from './App.vue';

import {createRouter, createWebHistory} from 'vue-router';


const router = createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: '/',
            name: 'home',
            component: App
        },
        {
            path: '/tienda/loginUsuario',
            redirect: () => window.location.href = 'http://localhost:8080/tienda/loginUsuario'
        }
    ]

})
const app = createApp(App);
app.use(router);

app.mount('#app');