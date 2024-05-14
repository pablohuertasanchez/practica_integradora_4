<template>
  <NavBar/>
  <MongoComponent/>
  <router-link to="/loginUsuario">
    <button class="btn btn-success">Ir a login de usuario</button>
  </router-link>
  <router-link to="/productos">
    <button class="btn btn-success">Ir a productos</button>
  </router-link>
  <router-view></router-view>
</template>

<script>
import axios from 'axios'
import NavBar from "@/components/NavBarComponent.vue";
import MongoComponent from "@/components/MongoComponent.vue";

export default {
  name: 'App',
  components: {
    NavBar,
    MongoComponent,
  },
  data() {
    return {
      message: '',
    };
  },
  created() {
    this.fetchData();
  },
  methods: {
    fetchData() {
      axios.get('/api/data').then(response => {
        this.message = response.data;
      })
          .catch(error => {
            console.error(error);
          });
    }
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

.fade-enter-active, .fade-leave-active {
  transition: opacity .5s;
}

.fade-enter, fade-leave-to {
  opacity: 0
}
</style>
