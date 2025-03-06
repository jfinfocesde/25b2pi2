# Guía de Configuración Docker y Despliegue

## Configuración de Docker

### Estructura del Dockerfile
El proyecto utiliza un Dockerfile optimizado para aplicaciones Spring Boot con Java 21:

```dockerfile
# Use official OpenJDK image as the base image
FROM eclipse-temurin:21-jdk-alpine

# Set working directory
WORKDIR /app

# Copy the Maven wrapper files
COPY .mvn/ .mvn/
COPY mvnw pom.xml ./

# Download dependencies
RUN ./mvnw dependency:go-offline

# Copy the source code
COPY src ./src

# Build the application
RUN ./mvnw clean package -DskipTests

# Expose the port the app runs on
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "target/proyecto-integrador-0.0.1-SNAPSHOT.jar"]
```

### Explicación del Dockerfile
1. **Imagen Base**: Utilizamos `eclipse-temurin:21-jdk-alpine` como imagen base, que proporciona Java 21 en una imagen Alpine Linux ligera.
2. **Directorio de Trabajo**: Se establece `/app` como el directorio de trabajo.
3. **Dependencias Maven**: Se copian los archivos del wrapper de Maven y el `pom.xml` para descargar las dependencias.
4. **Código Fuente**: Se copia el código fuente de la aplicación.
5. **Construcción**: Se ejecuta Maven para construir la aplicación.
6. **Puerto**: Se expone el puerto 8080 para acceder a la aplicación.
7. **Comando de Inicio**: Se configura el comando para ejecutar el JAR de la aplicación.

## Pruebas Locales

### Requisitos Previos
- Docker instalado en tu sistema
- Git para clonar el repositorio

### Pasos para Ejecutar Localmente

1. **Clonar el Repositorio**
   ```bash
   git clone [URL_DEL_REPOSITORIO]
   cd proyecto-integrador
   ```

2. **Construir la Imagen Docker**
   ```bash
   docker build -t proyecto-integrador .
   ```

3. **Ejecutar el Contenedor**
   ```bash
   # Usando variables de entorno desde archivo .env
   docker run -p 8080:8080 --env-file .env proyecto-integrador

   # Alternativamente, especificar variables individuales
   docker run -p 8080:8080 -e DB_URL=your_db_url -e DB_USERNAME=your_username -e DB_PASSWORD=your_password proyecto-integrador
   ```

4. **Verificar la Aplicación**
   - Abre tu navegador y visita `http://localhost:8080`
   - Utiliza herramientas como Postman para probar los endpoints

## Despliegue en Render.com

### Preparación
1. Crear una cuenta en [Render.com](https://render.com)
2. Conectar tu repositorio de GitHub

### Pasos para el Despliegue

1. **Crear Nuevo Servicio Web**
   - En el Dashboard de Render, haz clic en "New +" y selecciona "Web Service"
   - Conecta con el repositorio de GitHub

2. **Configuración del Servicio**
   - **Nombre**: Elige un nombre para tu servicio
   - **Runtime**: Docker
   - **Region**: Selecciona la más cercana a tus usuarios
   - **Branch**: main (o la que uses para producción)
   - **Plan**: Selecciona el plan gratuito para pruebas

3. **Variables de Entorno**
   - Configura las variables de entorno necesarias en la sección "Environment"
   - Ejemplo:
     ```
     SPRING_PROFILES_ACTIVE=prod
     DATABASE_URL=tu_url_de_base_de_datos
     ```

4. **Despliegue**
   - Haz clic en "Create Web Service"
   - Render construirá y desplegará automáticamente tu aplicación

### Monitoreo y Mantenimiento
- Render proporciona logs en tiempo real
- Configuración de despliegue automático al hacer push a la rama principal
- Métricas básicas de rendimiento y uso

## Solución de Problemas

### Problemas Comunes en Docker
1. **Error de Permisos**
   ```bash
   # Solución
   chmod +x mvnw
   ```

2. **Puerto en Uso**
   ```bash
   # Verificar puertos en uso
   netstat -ano | findstr :8080
   # Cambiar puerto en docker run
   docker run -p 8081:8080 proyecto-integrador
   ```

### Problemas en Render.com
1. **Fallo en el Build**
   - Verificar logs de construcción
   - Asegurar que el Dockerfile está en la raíz del proyecto
   - Validar variables de entorno

2. **Aplicación no Responde**
   - Revisar logs en tiempo real
   - Verificar configuración de puertos
   - Comprobar variables de entorno

## Recursos Adicionales
- [Documentación Docker](https://docs.docker.com/)
- [Documentación Render](https://render.com/docs)
- [Spring Boot con Docker](https://spring.io/guides/topicals/spring-boot-docker/)