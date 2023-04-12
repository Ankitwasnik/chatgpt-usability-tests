# Start with the latest official Java 17 image
FROM openjdk:17-jdk-alpine

# Set the working directory to /app
WORKDIR /app

# Copy the Spring Boot executable jars into the container
COPY build/*.jar /app/

# Use the official Keycloak Docker image
FROM jboss/keycloak:15.0.2

# Set the Keycloak environment variables
ENV KEYCLOAK_IMPORT /app/realm-export.json
ENV KEYCLOAK_USER admin
ENV KEYCLOAK_PASSWORD admin

# Copy the realm-export.json file into the container
COPY realm-export.json /app

# Expose port 3030
EXPOSE 3030

# Start the Spring Boot application and Keycloak together
CMD ["java", "-jar", "/app/*.jar", "--server.port=3030"]
