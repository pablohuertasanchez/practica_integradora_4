# Usa una imagen de Node.js como base
FROM node:latest

# Copia los archivos de package.json y package-lock.json [si existe]
COPY package*.json ./

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

## Copia los archivos necesarios al directorio de trabajo
COPY . .

# Instala Vue CLI globalmente
RUN npm install -g @vue/cli

# Instala jQuery
RUN npm install --save jquery

# Instala Vue
RUN npm install --save vue

# Instala Vue CLI Service
RUN npm install --save @vue/cli-service

## Compila la aplicacion Vue.js
#RUN npm run build

# Instala las dependencias
RUN npm install

# Expone el puerto 8081 para que la aplicacion Vue.js sea accesible desde fuera del contenedor
EXPOSE 8081

# Ejecuta la aplicacion Vue.js
CMD ["bash", "-c", "npm run build && npm run serve"]