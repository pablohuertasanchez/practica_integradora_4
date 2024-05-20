FROM mongo:latest

# Copia el script de inicialización
COPY iniciar_mongo.js /docker-entrypoint-initdb.d/init-mongo.js

# Copia el archivo JSON
COPY productos.json /docker-entrypoint-initdb.d/productos.json

# Comando por defecto para iniciar MongoDB
CMD ["mongod"]