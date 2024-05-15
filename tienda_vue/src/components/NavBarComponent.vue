<template>
  <div class="header">
  <nav class="navbar navbar-expand-lg navbar-light bg-custom">
    <!-- Botón para activar el menú desplegable en dispositivos móviles -->
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <!-- Logo de la empresa -->
    <router-link class="navbar-brand" to="/">
      <img src="../assets/logo.png" height="100px" width="100px" alt="Logo">
    </router-link>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item">
          <router-link class="nav-link" to="/">Inicio</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/productos">Productos</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/carrito">Carrito</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/loginUsuario">Login</router-link>
        </li>
      </ul>

      <!-- Mover el SearchBarComponent aquí -->
      <SearchBarComponent @search="searchProducto"/>

      <!-- Botón para limpiar la búsqueda -->
      <button class="btn btn-success" @click="limpiarBusqueda">Limpiar búsqueda</button>
    </div>
  </nav>
  </div>
</template>

<script>
import SearchBarComponent from '@/components/SearchBarComponent.vue';

export default {
  components: {
    SearchBarComponent
  },
  methods: {
    searchProducto(query) {
      // Emitir el evento de búsqueda
      this.$emit('search', query);
    },
    limpiarBusqueda() {
      // Llamar a la acción para limpiar la búsqueda
      this.searchProducto('');
    }
  }
};
</script>

<style scoped>
/* Estilos personalizados */
.navbar {
  background-color: #959292; /* Color de fondo del navbar */
}

.bg-custom {
  background-color: #959292; /* Color de fondo personalizado */
}

.nav-item{
  background-color: #ededed;
  border: 1px solid black;
  margin: 1em;
}

</style>
