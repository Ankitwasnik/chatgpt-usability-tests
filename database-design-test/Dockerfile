
# Use a base image with Java 17 installed
FROM azul/zulu-openjdk-alpine:17

WORKDIR /app
COPY build/libs/*.jar app.jar
EXPOSE 3007
ENTRYPOINT ["java", "-jar", "app.jar"]
