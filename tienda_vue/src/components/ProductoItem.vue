<template>
  <div class="producto">
    <img :src="producto.imagen" :alt="producto.nombre" />
    <h3>{{ producto.nombre }}</h3>
    <p>{{ producto.precio }}</p>
  </div>
</template>

<script>
export default {
  props: {
    producto: Object
  }
};
</script>

<style scoped>
.producto {
  border: 1px solid #ccc;
  padding: 10px;
  margin: 10px;
}
</style>
