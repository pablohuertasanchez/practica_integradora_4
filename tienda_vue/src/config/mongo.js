const { MongoClient } = require('mongodb');

const MONGO_URL = 'mongodb://localhost:27017/mydatabase';

let db = null;

async function connectToDatabase() {
    try {
        const client = new MongoClient(MONGO_URL, { useNewUrlParser: true, useUnifiedTopology: true });
        await client.connect();
        console.log('Conexión exitosa a MongoDB');
        db = client.db(); // Establece la conexión a la base de datos
    } catch (error) {
        console.error('Error al conectar a MongoDB:', error);
        throw error;
    }
}

function getDatabase() {
    if (!db) {
        throw new Error('No se ha establecido la conexión a la base de datos');
    }
    return db;
}

module.exports = {
    connectToDatabase,
    getDatabase
};
