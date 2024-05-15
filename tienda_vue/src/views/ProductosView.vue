<template>
  <div>
    <div class="row">
      <div v-for="(producto, index) in productosMostrados.slice(0, 2)" :key="index" class="col-lg-6 col-md-12 mb-4">
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
    <div class="row">
      <div v-for="(producto, index) in productosMostrados.slice(2, 4)" :key="index" class="col-lg-6 col-md-12 mb-4">
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
    <div class="row">
      <div v-for="(producto, index) in productosMostrados.slice(4, 6)" :key="index" class="col-lg-6 col-md-12 mb-4">
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
import {mapActions, mapState} from 'vuex';

export default {
  name: 'ProductosView',
  components: {

  },
  computed: {
    ...mapState('productos', ['productos', 'productosFiltrados']),
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

<style>
/* Estilos */
.productos {
  display: flex;
  flex-wrap: wrap;
}
</style>
