# Práctica grupo 4. Andrés, Ángel y Pablo

Este proyecto es una aplicación web para la gestión de usuarios y productos, desarrollado con Spring Boot, Thymeleaf, Vue, MongoDB y MySQL.

## Rutas Principales

- `/loginAdmin`: Página de inicio de sesión para administradores.
- `/loginUsuario/email`: Página de inicio de sesión para usuarios/clientes.

## Funcionalidades

- **Vue en la Tienda**: Accede a una tienda visualmente atractiva con productos presentados en el estilo de la página web.
- **Registro de Cliente y Usuario**: Registra usuarios y clientes en la base de datos MySQL.
- **Login de Usuario**: Los usuarios (clientes) pueden acceder a la tienda, ver productos y obtener detalles de los mismos.
- **Login de Administrador**: Solo los usuarios administradores pueden acceder a la página de administración. Desde allí, pueden administrar la base de datos, incluyendo la gestión de productos, clientes y usuarios.

## Tecnologías Utilizadas

- Spring Boot
- Thymeleaf
- MongoDB
- MySQL
- Vue.js
- Docker

## Requisitos Previos

- Java JDK 8 o superior
- MongoDB
- MySQL

## Instalación

1. Clona este repositorio: `git clone https://github.com/pablohuertasanchez/practica_integradora_4.git`
2. Configura MongoDB y MySQL. 
  De momento en wsl
  docker run -d --name mi-mongo-container -p 27017:27017 mongo
  docker run --name contiene_mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=admin -d mysql
3. Importa el proyecto en tu IDE favorito.
4. Ejecuta la aplicación.
  http://localhost:8080/loginAdmin
  http://localhost:8080/loginUsuario/email

## Configuración

- Configura las credenciales de MongoDB y MySQL en el archivo `application.properties`.
spring.datasource.url=jdbc:mysql://tu_ip_de_wsl:3306/Practica4?createDatabaseIfNotExist=true
spring.data.mongodb.host=tu_ip_de_wsl

## Estructura del Proyecto

