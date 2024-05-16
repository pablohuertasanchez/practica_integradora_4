<template>
  <form @submit.prevent="search">
    <input v-model="query" class="form-control mr-sm-2" type="search" placeholder="Buscar por marca" aria-label="Search">
    <button class="btn btn-success my-2 my-sm-0" type="submit">Buscar por marca</button>
  </form>
</template>

<script>
export default {
  data() {
    return {
      query: ''
    };
  },
  methods: {
    search() {
      this.$emit('search', this.query);
    }
  }
};
</script>

<style scoped>

form{
  display: flex;
}
</style>