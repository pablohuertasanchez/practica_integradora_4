<template>
  <form @submit.prevent="search">
    <input v-model="query" class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
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

<style>

form{
  display: flex;
}
</style>