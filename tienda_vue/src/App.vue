<template>
  <img alt="Vue logo" src="./assets/logo.png">
  <HelloWorld msg="Welcome to Your Vue.js App"/>
  <movie-list></movie-list>
</template>

<script>
import HelloWorld from './components/HelloWorld.vue'
import MovieList from './components/MovieList.vue';
export default {
  name: 'App',
  components: {
    HelloWorld,
    MovieList
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
