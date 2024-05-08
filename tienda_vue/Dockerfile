# Usa una imagen de Node.js como base
FROM node:latest

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

## Copia los archivos necesarios al directorio de trabajo
#COPY package*.json ./

# Instala las dependencias
RUN npm install

# Compila la aplicacion Vue.js
RUN npm run build

# Copia todos los archivos del directorio actual al directorio de trabajo
COPY . .

# Expone el puerto 8080 para que la aplicacion Vue.js sea accesible desde fuera del contenedor
EXPOSE 8080

# Ejecuta la aplicacion Vue.js
CMD ["npm", "run", "serve"]