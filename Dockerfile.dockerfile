# Imagen base con Java 21
FROM eclipse-temurin:21-jdk-alpine

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiamos archivos de Maven primero (mejor cache)
COPY pom.xml .
COPY mvnw .
COPY mvnw.cmd .
COPY .mvn .mvn

# Damos permisos al wrapper
RUN chmod +x mvnw

# Descargamos dependencias (optimiza build)
RUN ./mvnw dependency:go-offline

# Copiamos el código fuente
COPY src src

# Construimos el JAR
RUN ./mvnw clean package -DskipTests

# Puerto que usa Spring Boot
EXPOSE 8080

# Comando para ejecutar la app
CMD ["java", "-jar", "target/*.jar"]
