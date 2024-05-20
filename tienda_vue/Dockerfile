# Usa una imagen oficial de Node.js como imagen base
FROM node:latest

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /myapp

# Copia los archivos package.json y package-lock.json al contenedor
COPY package*.json ./

# Instala las dependencias
RUN npm install && npm install -g @vue/cli

# Copia todos los archivos de la aplicación al contenedor
COPY . .

# Construye la aplicación Vue
RUN npm run build

# Expone el puerto 8081 para que la aplicación Vue.js sea accesible desde fuera del contenedor
EXPOSE 8081

# Ejecuta la aplicación Vue.js
# Si no buscas esta dependencia, el arranque no funciona
CMD ["./node_modules/.bin/vue-cli-service", "serve"]
