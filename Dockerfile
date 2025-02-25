# Use OpenJDK as the base image
FROM openjdk:17

# Set the working directory inside the container
WORKDIR /app

# Copy the built Java application (JAR file) into the container
COPY target/your-app.jar /app/app.jar

# Expose port 8080 (or the port your app runs on)
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "/app/app.jar"]
