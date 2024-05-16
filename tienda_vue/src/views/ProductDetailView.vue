<!-- ProductDetail.vue -->
<template>
  <div class="card" v-if="producto">
    <h2>{{ producto.modelo }}</h2>
    <img :src="producto.imagen" class="img-fluid" :alt="producto.modelo">
    <p>{{ producto.descripcion }}</p>
    <p>Marca: {{ producto.marca }}</p>
    <p>Categoría: {{ producto.categoria }}</p>
    <p>Precio: {{ producto.precio }}</p>
    <p>Cantidad: {{ producto.cantidad }}</p>
    <router-link to="/productos">
      <button class="btn btn-success">Ir a inicio</button>
    </router-link>
  </div>
</template>

<script>
import { mapState } from 'vuex';

export default {
  computed: {
    ...mapState('productos', ['productosFiltrados'])
  },
  data() {
    return {
      producto: null
    };
  },
  created() {
    const productId = parseInt(this.$route.params.id);
    this.producto = this.productosFiltrados.find(producto => producto.id === productId);
  }
}
</script>

<style scoped>
/*Al poner el style scoped, los estilos solo se aplican a este componente*/
.card{
  margin: 1em;
}
p, h2{
  margin-left: 1em;
}
</style>