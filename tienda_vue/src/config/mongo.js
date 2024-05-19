const { MongoClient } = require('mongodb');

const uri = "mongodb://localhost:27017/mydatabase";
const client = new MongoClient(uri, { useNewUrlParser: true, useUnifiedTopology: true });

async function connectToDatabase() {
    try {
        await client.connect();
        console.log("Connected to MongoDB");
        return client.db("mydatabase"); // Cambia "mydatabase" al nombre de la base de datos
    } catch (error) {
        console.error("Error connecting to MongoDB", error);
        throw error;
    }
}

module.exports = connectToDatabase;
