<!-- App.vue -->
<template>
  <div id="app">
    <NavBar @search="searchProducto" />
    <router-view />
    <FooterComponent/>
  </div>
</template>

<script>
import NavBar from '@/components/NavBarComponent.vue';
import FooterComponent from "@/components/FooterComponent.vue";

export default {
  components: {
    FooterComponent,
    NavBar
  },
  methods: {
    searchProducto(query) {
      // Lógica de búsqueda
      this.$store.dispatch('productos/searchProducto', query);
    }
  }
};
</script>
