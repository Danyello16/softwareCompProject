# Start with a base image containing Java runtime
FROM openjdk:11-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the necessary files from the build context to the container
COPY software-comp-project-master/target/openapi-spring-*.jar /app/app.jar

# Expose the port that the application listens on
EXPOSE 8080

# Set any necessary environment variables
ENV SPRING_PROFILES_ACTIVE=prod

# Start the application
ENTRYPOINT ["java","-jar","/app/app.jar"]
