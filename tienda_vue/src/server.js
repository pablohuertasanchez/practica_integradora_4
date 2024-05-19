// const express = require('express');
// const cors = require('cors');
// const { MongoClient } = require('mongodb');
//
// const app = express();
// const port = 8081; // Puerto para el servidor backend
//
// // Configuración de CORS
// app.use(cors({
//     origin: 'http://localhost:8081',
// }));
//
// // Conexión a la base de datos MongoDB
// const uri = "mongodb://localhost:27017/mydatabase"; // Cambia el nombre de la base de datos si es necesario
// const client = new MongoClient(uri, { useNewUrlParser: true, useUnifiedTopology: true });
//
// async function connectToDatabase() {
//     await client.connect();
//     console.log("Connected to MongoDB");
//     return client.db("mydatabase");
// }
//
// // Ruta para obtener productos
// app.get('/api/productos', async (req, res) => {
//     console.log('Recibida solicitud GET en /api/productos');
//     try {
//         const db = await connectToDatabase();
//         const collection = db.collection('productos');
//         const productos = await collection.find({}).toArray();
//         console.log('Productos obtenidos:', productos);
//         res.json(productos);
//     } catch (error) {
//         console.error("Error fetching productos:", error);
//         res.status(500).json({ error: "Error fetching productos" });
//     }
// });
//
//
// // Iniciar el servidor
// app.listen(port, () => {
//     console.log(`Server running on port ${port}`);
// });

const express = require('express');
const cors = require('cors');
const { MongoClient } = require('mongodb');

const app = express();
const port = 8081;

// Middleware
app.use(cors());
app.use(express.json());

// Connection URL
const uri = "mongodb://localhost:27017/mydatabase";
const client = new MongoClient(uri, { useNewUrlParser: true, useUnifiedTopology: true });

// Connect to MongoDB
async function connectToDatabase() {
    await client.connect();
    console.log("Connected to MongoDB");
    return client.db("mydatabase");
}

// Route to fetch data from MongoDB
app.get('/api/products', async (req, res) => {
    try {
        const db = await connectToDatabase();
        const collection = db.collection('products');
        const products = await collection.find({}).toArray();
        res.json(products);
    } catch (error) {
        console.error("Error fetching products:", error);
        res.status(500).json({ error: "Error fetching products" });
    }
});

// Start the server
app.listen(port, () => {
    console.log(`Server running on port ${port}`);
});

