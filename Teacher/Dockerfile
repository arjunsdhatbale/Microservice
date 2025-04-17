# Use OpenJDK 8 base image
FROM openjdk:17

# Set working directory in container
WORKDIR /app

# Copy jar file from target to container
COPY target/*.jar app.jar

# Expose port (use the same as your application.properties/server.port)
EXPOSE 8080

# Command to run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]
