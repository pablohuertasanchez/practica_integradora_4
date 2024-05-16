<template>
  <footer class="footer bg-dark text-light py-3">
    <div class="container">
      <div class="row">
        <div class="col-md-6">
          <h5>Enlaces</h5>
          <ul>
            <li><a href="/">Inicio</a></li>
            <li><a href="/productos">Productos</a></li>
            <li><a href="#">Contacto</a></li>
          </ul>
        </div>
        <div class="col-md-6">
          <h5>Contacto</h5>
          <p>Dirección: Calle Ejemplo, Ciudad, País</p>
          <p>Email: info@tuempresa.com</p>
          <p>Teléfono: +1234567890</p>
        </div>
      </div>
    </div>
  </footer>
</template>

<script>
export default {
  name: 'FooterComponent'
};
</script>

<style scoped>
/* Estilos */
.footer {
  color: white;
}
</style>
