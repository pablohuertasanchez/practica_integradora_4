<template>
  <div class="container mt-4">
    <!-- Producto grande -->
    <div class="row">
      <div class="col-lg-6 col-md-12 mb-4">
        <div class="card" v-if="productosMostrados.length > 0">
          <div class="card-body">
            <h2>{{ productosMostrados[0].nombre }}</h2>
            <img :src="productosMostrados[0].imagen" class="img-fluid mb-2" :alt="productosMostrados[0].nombre">
            <p>{{ productosMostrados[0].precio }}</p>
            <p class="d-none d-md-block">{{ productosMostrados[0].descripcion }}</p>
          </div>
        </div>
      </div>
      <div class="col-lg-6 col-md-12 mb-4">
        <div class="card" v-if="productosMostrados.length > 1">
          <div class="card-body">
            <h2>{{ productosMostrados[1].nombre }}</h2>
            <img :src="productosMostrados[1].imagen" class="img-fluid mb-2" :alt="productosMostrados[1].nombre">
            <p>{{ productosMostrados[1].precio }}</p>
            <p class="d-none d-md-block">{{ productosMostrados[1].descripcion }}</p>
          </div>
        </div>
      </div>
    </div>

    <!-- Productos pequeños -->
    <div class="row">
      <div v-for="(producto, index) in productosMostrados.slice(2, 5)" :key="index" class="col-lg-4 col-md-6 mb-4">
        <div class="card">
          <div class="card-body">
            <h3>{{ producto.nombre }}</h3>
            <img :src="producto.imagen" class="img-fluid mb-2" :alt="producto.nombre">
            <p class="d-none d-md-block">{{ producto.descripcion }}</p>
            <p>{{ producto.precio }}</p>
          </div>
        </div>
      </div>
      <div v-for="(producto, index) in productosMostrados.slice(5, 8)" :key="index" class="col-lg-4 col-md-6 mb-4">
        <div class="card">
          <div class="card-body">
            <h3>{{ producto.nombre }}</h3>
            <img :src="producto.imagen" class="img-fluid mb-2" :alt="producto.nombre">
            <p class="d-none d-md-block">{{ producto.descripcion }}</p>
            <p>{{ producto.precio }}</p>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState, mapActions } from 'vuex';

export default {
  name: 'HomeView',
  computed: {
    ...mapState('productos', ['productosFiltrados']),
    productosMostrados() {
      return this.productosFiltrados.length > 0 ? this.productosFiltrados : this.productos;
    }
  },
  methods: {
    ...mapActions('productos', ['fetchProductos', 'searchProducto'])
  },
  created() {
    this.fetchProductos();
  }
};
</script>

<style scoped>
/* Estilos */
</style>
