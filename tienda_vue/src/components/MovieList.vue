<script setup>

</script>

<template>
  <div>
    <h1>Lista de Películas</h1>
    <ul>
      <li v-for="movie in movies" :key="movie._id">
        <h2>{{ movie.title }}</h2>
        <p>{{ movie.rating }}</p>
        <img :src="movie.image" :alt="movie.title">
      </li>
    </ul>
  </div>
</template>

<script>

import { obtenerPeliculas } from '@/services/movieService';

export default {
  data() {
    return {
      movies: []
    };
  },
  async mounted() {
    try {
      const movies = await obtenerPeliculas();
      this.movies = movies;
    } catch (error) {
      console.error(error);
    }
  }
};
</script>