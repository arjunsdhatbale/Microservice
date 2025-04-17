# Use OpenJDK 8 base image
FROM openjdk:17

# Set working directory in container
WORKDIR /app

# Copy jar file from target to container
COPY target/*.jar app.jar
#COPY target/student-service-0.0.1-SNAPSHOT.jar student-service.jar

# Expose port (use the same as your application.properties/server.port)
EXPOSE 8082

# Command to run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]
