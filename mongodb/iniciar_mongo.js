// Cargar el módulo fs (File System) para leer archivos
const fs = require('fs');

// Ruta al archivo productos.json en el mismo directorio que este script
const productosJsonPath = '/docker-entrypoint-initdb.d/productos.json';

// Leer los datos del archivo productos.json
const productosData = fs.readFileSync(productosJsonPath, 'utf-8');

// Convertir los datos leídos a un objeto JavaScript
const productos = JSON.parse(productosData);

// Seleccionar la base de datos
db = db.getSiblingDB('mydatabase');

// Insertar los datos de productos.json en la colección productos
db.productos.insertMany(productos);