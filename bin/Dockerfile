# Build stage
FROM maven:3.8.5-openjdk-17 AS build
COPY . /app
WORKDIR /app
RUN mvn clean package -DskipTests

# Final stage
FROM openjdk:17-jdk-alpine
COPY --from=build /app/target/Jwt-Auth-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
