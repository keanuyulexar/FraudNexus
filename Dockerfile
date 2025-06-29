# ------------ STAGE 1: Build ------------
FROM maven:3.9.6-eclipse-temurin-17 AS builder

WORKDIR /app

COPY . .

RUN mvn clean package -DskipTests


# ------------ STAGE 2: Run ------------
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy and rename the JAR from builder stage to app.jar
COPY --from=builder /app/target/*.jar /app/app.jar

ENTRYPOINT ["java","-jar","/app/app.jar"]
