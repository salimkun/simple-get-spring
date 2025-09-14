# Spring Boot OOP Project - Product Catalog Service

This project demonstrates a Product Catalog Service built with Spring Boot, showcasing various modern technologies and architectural patterns.

## Features

- **Product Management:** RESTful API for creating, reading, updating, and deleting product information.
- **Data Persistence:** Utilizes MongoDB as the primary data store for product data.
- **Caching:** Implements a caching strategy using Redis to enhance performance for frequently accessed product data.
- **Event-Driven Architecture:** Leverages Apache Kafka for publishing product-related events (e.g., product created, updated, deleted), enabling other services to react to changes.
- **Containerization:** The entire application stack (Spring Boot service, MongoDB, Redis, Kafka, Zookeeper) is containerized using Docker Compose for easy setup and deployment.
- **Spring IoC (Inversion of Control):** Core of the application, managing dependencies and object lifecycle.
- **Java Stream API:** Used for efficient data processing within the service layer.

## Technologies Used

- **Spring Boot**
- **Spring Data MongoDB**
- **MongoDB**
- **Redis**
- **Apache Kafka**
- **Docker & Docker Compose**
- **Java 17+**

## Project Structure

```
springBoot/
  - spring-boot-oop-project/
    - pom.xml
    - README.md
    - src/
      - main/
        - java/
          - com/
            - example/
              - springbootoopproject/
                - controller/
                - model/
                - repository/
                - service/
                - SpringBootOopProjectApplication.java
        - resources/
          - application.properties
    - docker-compose.yml (To be created)
```

## Getting Started

### Prerequisites

- Docker Desktop installed and running.
- Java 17 or higher.

### Running the Application Locally with Docker Compose

1.  **Clone the repository:**
    ```bash
    git clone <your-repository-url>
    cd spring-boot-oop-project
    ```
2.  **Build the Spring Boot application:**
    ```bash
    ./mvnw clean package -DskipTests
    ```
3.  **Start the services using Docker Compose:**
    ```bash
    docker-compose up --build
    ```
    This will start MongoDB, Redis, Kafka, Zookeeper, and your Spring Boot application.

4.  **Access the API:**
    The Spring Boot application will be available at `http://localhost:8080`.

## API Endpoints (To be implemented)

- `POST /api/products`: Create a new product.
- `GET /api/products/{id}`: Get product by ID (with caching).
- `GET /api/products`: Get all products.
- `PUT /api/products/{id}`: Update an existing product.
- `DELETE /api/products/{id}`: Delete a product.

## Future Enhancements

- Implement ElasticSearch for advanced product searching.
- Integrate a distributed data grid for more sophisticated caching and data distribution.
- Implement authentication and authorization for API endpoints.
- Add comprehensive unit and integration tests.
- Introduce circuit breakers and retry mechanisms for microservices resilience.
- Monitoring and logging.