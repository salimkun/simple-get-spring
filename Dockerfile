FROM eclipse-temurin:17-jdk-jammy AS builder

WORKDIR /app

# Copy Maven wrapper and pom.xml
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Make mvnw executable
RUN chmod +x mvnw

# Copy source code
COPY src src

# Build the application
RUN ./mvnw clean package -DskipTests

# Runtime stage
FROM eclipse-temurin:17-jre-jammy

WORKDIR /app

# Copy the JAR file from builder stage
COPY --from=builder /app/target/spring-boot-oop-project-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
