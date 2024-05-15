<template>
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
<!--    <a class="navbar-brand" href="#">Navbar</a>-->
<!--    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">-->
<!--      <span class="navbar-toggler-icon"></span>-->
<!--    </button>-->

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav mr-auto">
<!--        Boton de redireccion a home-->
        <li class="nav-item active">
          <a class="nav-link" href="/">Home <span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            Dropdown
          </a>
          <div class="dropdown-menu" aria-labelledby="navbarDropdown">
            <a class="dropdown-item" href="#">Action</a>
            <a class="dropdown-item" href="#">Another action</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">Something else here</a>
          </div>
        </li>
      </ul>
<!--      Botones de redireccion-->
      <router-link to="/loginUsuario">
        <button class="btn btn-success">Ir a login de usuario</button>
      </router-link>
      <router-link to="/">
        <button class="btn btn-success">Ir a inicio</button>
      </router-link>
      <router-link to="/productos">
        <button class="btn btn-success">Ir a productos</button>
      </router-link>

      <!-- Mover el SearchBarComponent aquí -->
      <SearchBarComponent @search="searchProducto" />


      <router-link to="/carrito">
        <button class="btn btn-success">Ir a carrito</button>
      </router-link>
    </div>
  </nav>
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
    }
  }
};
</script>

<style scoped>
/* Estilos */
</style>
