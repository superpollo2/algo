FROM gradle:7.4.1-jdk21 as build
LABEL authors="Laura"
WORKDIR /app

# Copiar todos los archivos de configuración de Gradle
COPY build.gradle settings.gradle main.gradle ./

# Copiar el código fuente
COPY src ./src

# Ejecutar la construcción con Gradle (sin ejecutar pruebas)
RUN gradle clean build -x test --no-daemon

# Etapa de ejecución
FROM openjdk:21-jdk-slim
WORKDIR /app

# Copiar el archivo JAR generado por Gradle
COPY --from=build /app/build/libs/*.jar app.jar

# Exponer el puerto y definir el comando de ejecución
EXPOSE 8092
CMD ["java", "-jar", "app.jar"]