

document.addEventListener('DOMContentLoaded', function() {
    const urlParams = new URLSearchParams(window.location.search);
    const modelo = urlParams.get('modelo');
    const productoEncontrado = listaProductos.find(producto => producto.modelo.toLowerCase() === modelo.toLowerCase());

    if (productoEncontrado) {
        mostrarDetalleProducto(productoEncontrado);
    } else {
        document.getElementById('detalleProducto').innerText = 'Producto no encontrado.';
    }
});

function mostrarDetalleProducto(producto) {
    const detalleProductoElem = document.getElementById('detalleProducto');
    detalleProductoElem.innerHTML = `
        <p><strong>Modelo:</strong> ${producto.modelo}</p>
        <p><strong>Marca:</strong> ${producto.marca}</p>
        <p><strong>Categoría:</strong> ${producto.categoria}</p>
        <p><strong>Precio:</strong> ${producto.precio.toFixed(2)} USD</p>
        <p><strong>Cantidad:</strong> ${producto.cantidad}</p>
    `;
}