<template>
  <div>
    <!-- Select para filtrar por categoría -->
    <select class="form-select form-select-lg" v-model="categoriaSeleccionada" @change="filtrarPorCategoria">
      <option value="">Todas las categorías</option>
      <option v-for="categoria in categoriasDisponibles" :value="categoria" :key="categoria">{{ categoria }}</option>
    </select>
    <!-- Select para ordenar por precio -->
    <select v-model="orden" @change="filtrarPorCategoria">
      <option value="">Ordenar por precio</option>
      <option value="asc">Precio ascendente</option>
      <option value="desc">Precio descendente</option>
    </select>

    <div class="row">
      <div v-for="(producto, index) in productosMostrados" :key="index" class="col-lg-6 col-md-12 mb-4">
        <div class="card">
          <div class="card-body">
            <h3>{{ producto.marca }}</h3>
            <h3>{{ producto.modelo }}</h3>
            <router-link :to="`/producto/${producto.id}`">
              <img :src="producto.imagen" class="img-fluid mb-2 expand-on-hover" :alt="producto.marca">
            </router-link>
            <p>{{ producto.categoria }}</p>
            <p class="d-none d-md-block">{{ producto.descripcion }}</p>
            <p>{{ producto.precio }}</p>
          </div>
        </div>
      </div>
    </div>

  </div>
</template>

<script>
import { mapState } from 'vuex';

export default {
  name: 'ProductosView',
  computed: {
    ...mapState('productos', ['productosFiltrados']),
    productosMostrados() {
      return this.productosFiltrados;
    },
    categoriasDisponibles() {
      return [...new Set(this.productosFiltrados.map(producto => producto.categoria))];
    },
  },
  data() {
    return {
      categoriaSeleccionada: '',
      orden: '' // Por defecto, orden ascendente
    };
  },
  methods: {
    filtrarPorCategoria() {
      // Esta función ya no será necesaria porque el filtrado se realiza en el backend
      // Pero puedes mantenerla para actualizar la categoría seleccionada
      // this.$store.dispatch('productos/filtrarPorCategoria', this.categoriaSeleccionada);
    },
  },
};
</script>

<style>
/* Estilos */
.card {
  background-image: linear-gradient(to left, #c6c2c2 0%, #ffffff 100%);
  height: 35em;
}
img {
  margin: 1em;
  border: 1px solid black;
  height: 50%;
  width: 50%;
}

select {
  margin : 1em;
}

.expand-on-hover {
  transition: transform 0.3s ease;
}

.expand-on-hover:hover {
  transform: scale(1.1); /* Puedes ajustar el factor de escala según tus preferencias */
}
</style>
