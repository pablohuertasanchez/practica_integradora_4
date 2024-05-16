document.addEventListener('DOMContentLoaded', function() {
    const listaProductos = [
        {
            modelo: "clase b",
            marca: "MERCEDES-BENZ",
            categoria: "Familiar",
            precio: 120.52,
            cantidad: 50,
        },
        {
            modelo: "serie 1",
            marca: "BMW",
            categoria: "Compacto",
            precio: 140.71,
            cantidad: 50,
        },
        {
            modelo: "qashqai",
            marca: "NISSAN",
            categoria: "familiar",
            precio: 194.16,
            cantidad: 50,
        },
        {
            modelo: "gulietta",
            marca: "ALFA ROMEO",
            categoria: "Deportivo",
            precio: 167.47,
            cantidad: 50,
        },
        {
            modelo: "e-tron",
            marca: "AUDI",
            categoria: "Lujo",
            precio: 373.34,
            cantidad: 50,
        },
        {
            modelo: "clase s",
            marca: "MERCEDES-BENZ",
            categoria: "Lujo",
            precio: 457.72,
            cantidad: 50,
        },
        {
            modelo: "Focus",
            marca: "Ford",
            categoria: "Compacto",
            precio: 155.99,
            cantidad: 30,
        },
        {
            modelo: "Civic",
            marca: "Honda",
            categoria: "Compacto",
            precio: 170.25,
            cantidad: 40,
        },
        {
            modelo: "Corolla",
            marca: "Toyota",
            categoria: "Compacto",
            precio: 180.50,
            cantidad: 25,
        },
        {
            modelo: "Camry",
            marca: "Toyota",
            categoria: "Sedan",
            precio: 210.75,
            cantidad: 35,
        },
        {
            modelo: "Accord",
            marca: "Honda",
            categoria: "Sedan",
            precio: 200.00,
            cantidad: 45,
        },
        {
            modelo: "X5",
            marca: "BMW",
            categoria: "SUV",
            precio: 350.80,
            cantidad: 20,
        },
        {
            modelo: "Tucson",
            marca: "Hyundai",
            categoria: "SUV",
            precio: 190.30,
            cantidad: 30,
        },
        {
            modelo: "CR-V",
            marca: "Honda",
            categoria: "SUV",
            precio: 220.45,
            cantidad: 35,
        },
        {
            modelo: "CX-5",
            marca: "Mazda",
            categoria: "SUV",
            precio: 205.60,
            cantidad: 25,
        },
        {
            modelo: "Model S",
            marca: "Tesla",
            categoria: "Electrico",
            precio: 500.00,
            cantidad: 15,
        }
    ];
    
        const listaProductosElem = document.getElementById('listaProductos');
        const filtroCategoria = document.getElementById('filtroCategoria');
        const btnOrdenarPrecio = document.getElementById('btnOrdenarPrecio');
        const inputBusqueda = document.getElementById('inputBusqueda');
    
        // Función para mostrar los productos en la página
        function mostrarProductos(productos) {
            listaProductosElem.innerHTML = '';
            productos.forEach(producto => {
                const productoElem = document.createElement('div');
                productoElem.classList.add('producto');
                productoElem.innerHTML = `
                    <h3>${producto.modelo} (${producto.marca})</h3>
                    <p>Categoría: ${producto.categoria}</p>
                    <p>Precio: <span>${producto.precio.toFixed(2)}</span> USD</p>
                    <p>Cantidad: ${producto.cantidad}</p>
                    <button class="btnVerDetalle" data-modelo="${producto.modelo}">Ver Detalle</button>
                    <button class="btnAgregarCarrito" data-modelo="${producto.modelo}">Agregar al Carrito</button>
                `;
                listaProductosElem.appendChild(productoElem);
            });
    
            // Agregar evento al botón "Ver Detalle"
            const btnsVerDetalle = document.querySelectorAll('.btnVerDetalle');
            btnsVerDetalle.forEach(btn => {
                btn.addEventListener('click', function() {
                    const modelo = btn.getAttribute('data-modelo');
                    mostrarDetalleProducto(modelo);
                });
            });
            
        }

        // Mostrar todos los productos al cargar la página
        mostrarProductos(listaProductos);
    
        // Función para filtrar productos por categoría
        filtroCategoria.addEventListener('change', function() {
            const categoriaSeleccionada = filtroCategoria.value;
            if (categoriaSeleccionada === 'todos') {
                mostrarProductos(listaProductos);
            } else {
                const productosFiltrados = listaProductos.filter(producto => producto.categoria.toLowerCase() === categoriaSeleccionada.toLowerCase());
                mostrarProductos(productosFiltrados);
            }
        });
    
        // Función para ordenar productos por precio
        btnOrdenarPrecio.addEventListener('click', function() {
            const productosOrdenados = listaProductos.slice().sort((a, b) => a.precio - b.precio);
            mostrarProductos(productosOrdenados);
        });
    
        // Función para mostrar los detalles del producto en una página diferente
        function mostrarDetalleProducto(modelo) {
            const productoEncontrado = listaProductos.find(producto => producto.modelo.toLowerCase() === modelo.toLowerCase());
            if (productoEncontrado) {
                // Redireccionar a la página de detalles del producto
                window.location.href = `detalle_producto.html?modelo=${encodeURIComponent(modelo)}`;
            } else {
                alert('Producto no encontrado.');
            }
        }
    
        // Manejar la búsqueda de producto
        document.getElementById('btnBuscar').addEventListener('click', function() {
            const modeloBuscado = inputBusqueda.value.trim().toLowerCase();
            const productoEncontrado = listaProductos.find(producto => producto.modelo.toLowerCase() === modeloBuscado);
            if (productoEncontrado) {
                mostrarDetalleProducto(productoEncontrado.modelo);
            } else {
                alert('Producto no encontrado.');
            }
        });


    });
    