# Spring Boot OOP Project

This is a Spring Boot project that demonstrates the use of Object-Oriented Programming (OOP) principles to implement a RESTful API for retrieving data from a database. The project is structured to separate concerns, making it easy to maintain and extend.

## Project Structure

```
spring-boot-oop-project
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           └── springbootoopproject
│   │   │               ├── SpringBootOopProjectApplication.java
│   │   │               ├── controller
│   │   │               │   └── DataController.java
│   │   │               ├── service
│   │   │               │   └── DataService.java
│   │   │               ├── model
│   │   │               │   └── DataModel.java
│   │   │               └── repository
│   │   │                   └── DataRepository.java
│   │   └── resources
│   │       ├── application.properties
│   │       └── application.yml
│   └── test
│       └── java
│           └── com
│               └── example
│                   └── springbootoopproject
│                       └── SpringBootOopProjectApplicationTests.java
├── pom.xml
└── README.md
```

## Setup Instructions

1. **Clone the Repository**
   ```bash
   git clone <repository-url>
   cd spring-boot-oop-project
   ```

2. **Configure Environment Variables**
   Set up your database connection settings using environment variables. You can define these in your `application.properties` or `application.yml` file.

3. **Build the Project**
   Use Maven to build the project:
   ```bash
   mvn clean install
   ```

4. **Run the Application**
   Start the Spring Boot application:
   ```bash
   mvn spring-boot:run
   ```

5. **Access the API**
   You can access the GET API at the following endpoint:
   ```
   http://localhost:8080/api/data
   ```

## Usage

This project provides a simple API to retrieve data from a database. The data is fetched using the `DataService` class, which interacts with the `DataRepository` to perform database operations. The `DataController` handles incoming requests and returns the appropriate responses.

## Dependencies

This project uses the following dependencies:
- Spring Boot Starter Web
- Spring Boot Starter Data JPA
- Database connector (e.g., H2, MySQL, PostgreSQL)

## Testing

Unit tests are included in the `src/test/java` directory to ensure that the application behaves as expected. You can run the tests using:
```bash
mvn test
```

## License

This project is licensed under the MIT License. See the LICENSE file for more details.