# 🚀 Primer Proyecto Full-Stack con Spring Boot y React

Este es mi primer proyecto Full-Stack, desarrollado con **React** para el Front-End y **Spring Boot** para el Back-End. El objetivo de este proyecto es aprender a integrar ambas tecnologías en una sola aplicación web. En este proyecto veras que haciendo iniciando el proyecto mediante el Front-End ves el nombre y email de los usuarios de la lista que hay en la base de datos mediante docker.

---

## 🛠️ Tecnologías Utilizadas

- **Front-End:** React, Vite, Axios
- **Back-End:** Spring Boot
- **Base de Datos:** MySQL

---

## 📂 Estructura del Proyecto

### **1. Front-End (React)**

Para el Front-End, utilicé **React** con **Vite** como bundler para crear la aplicación.

#### **Creación del Proyecto con Vite**

Primero, creé el proyecto con el siguiente comando:

```bash
npm create vite@latest
```

### **1. Back-End (Spring Boot)**

Lo he inicializado mediante Visual Studio Code.

#### Spring Security


He probado integrar spring security por el cual al iniciar el backen nos pide un usuario y contraseña en la cual es =>

---
```txt
User : user

Password: (contraseña muy larga que encontrare en la terminal)
```
---

Datos para introducir en la base de datos:
```sql
SET NAMES utf8mb4;

INSERT INTO `user` (`id`, `email`, `name`) VALUES
(1,	'alexcopado2006@mgapw',	'ByAlex'),
(2,	'marco@miguelon.com',	'Marco'),
(3,	'daninoestacornejo@gmail.com',	'Dani');
```



# PROBLEMAS

## 🔌 Comunicación entre Front-End y Back-End

La comunicación entre el **Front-End (React)** y el **Back-End (Spring Boot)** se realiza a través de solicitudes HTTP. Sin embargo, al principio me encontré con problemas relacionados con **CORS** (Cross-Origin Resource Sharing), lo cual bloqueaba las solicitudes del navegador debido a la política de seguridad del mismo origen.

### **Error de CORS**

El error común que encontré al realizar las solicitudes era:

Para resolver este problema, se debe configurar correctamente el manejo de CORS en el **Back-End**. Hay varias maneras de hacerlo en **Spring Boot**.

### **Solución para CORS en Spring Boot**

1. **A nivel global (configuración global para todas las rutas):**

   Para permitir solicitudes desde cualquier origen, se puede añadir la siguiente configuración global en una clase de configuración de **Spring Boot**:

   ```java
   @Configuration
   public class WebConfig implements WebMvcConfigurer {
       @Override
       public void addCorsMappings(CorsRegistry registry) {
           registry.addMapping("/**")
                   .allowedOrigins("http://localhost:3000")  // Aquí se puede especificar el origen del Front-End
                   .allowedMethods("GET", "POST", "PUT", "DELETE")
                   .allowedHeaders("*")
                   .allowCredentials(true);
       }
   }
