<template>
  <div class="container mt-4">
    <!-- Producto grande -->
    <div class="row">
      <div class="col-lg-12 mb-4" >
        <div class="card" v-if="productosMostrados.length > 0">
          <div class="card-body">
            <h2>{{ productosMostrados[0].marca }}</h2>
            <h2>{{ productosMostrados[0].modelo }}</h2>
            <router-link :to="`/producto/${productosMostrados[0].id}`">
              <img :src="productosMostrados[0].imagen" class="img-fluid mb-2 expand-on-hover" :alt="productosMostrados[0].marca">
            </router-link>
            <p>{{ productosMostrados[0].categoria }}</p>
            <p>{{ productosMostrados[0].precio }}</p>
            <p class="d-none d-md-block">{{ productosMostrados[0].descripcion }}</p>
          </div>
        </div>
      </div>
    </div>

    <!-- Productos pequeños -->
    <div class="row">
      <div v-for="(producto, index) in productosMostrados.slice(1, 16)" :key="index" class="col-lg-6 col-md-6 mb-4">
        <div class="card">
          <div class="card-body">
            <h3>{{ producto.marca }}</h3>
            <h3>{{ producto.modelo }}</h3>
            <router-link :to="`/producto/${producto.id}`">
              <img :src="producto.imagen" class="img-fluid mb-2 expand-on-hover" :alt="producto.marca">
            </router-link>
            <p> {{ producto.categoria }}</p>
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

<style scoped>
.card{
  background-image: linear-gradient(to left, #c6c2c2 0%, #ffffff 100%);
}
img{
  border: 1px solid black;
  height: 50%;
  width: 50%;
}
.expand-on-hover {
  transition: transform 0.3s ease;
}

.expand-on-hover:hover {
  transform: scale(1.1); /* Puedes ajustar el factor de escala según tus preferencias */
}

</style>
