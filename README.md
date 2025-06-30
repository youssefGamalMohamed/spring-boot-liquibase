# 🚀 Spring Boot Liquibase Demo

A modern backend demo project built with **Spring Boot**, **Liquibase**, and **PostgreSQL**.  
This project demonstrates robust database versioning, clean architecture, and best practices for Java backend development.

---

## 🛠️ Technologies & Tools

| Technology         | Description                                 | Icon |
|--------------------|---------------------------------------------|------|
| [Spring Boot](https://spring.io/projects/spring-boot) | Java backend framework for rapid development | ![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?logo=springboot&logoColor=white) |
| [Liquibase](https://www.liquibase.org/) | Database schema migrations/versioning         | ![Liquibase](https://img.shields.io/badge/Liquibase-2962FF?logo=liquibase&logoColor=white) |
| [PostgreSQL](https://www.postgresql.org/) | Open source relational database               | ![PostgreSQL](https://img.shields.io/badge/PostgreSQL-4169E1?logo=postgresql&logoColor=white) |
| [Docker Compose](https://docs.docker.com/compose/) | Container orchestration for local dev         | ![Docker](https://img.shields.io/badge/Docker-2496ED?logo=docker&logoColor=white) |
| [JPA/Hibernate](https://spring.io/projects/spring-data-jpa) | ORM for Java persistence                      | ![Hibernate](https://img.shields.io/badge/Hibernate-59666C?logo=hibernate&logoColor=white) |
| [MapStruct](https://mapstruct.org/) | Java bean mapping (DTOs ↔ Entities)           | ![MapStruct](https://img.shields.io/badge/MapStruct-FF6F00?logo=java&logoColor=white) |
| [Lombok](https://projectlombok.org/) | Boilerplate code reduction                    | ![Lombok](https://img.shields.io/badge/Lombok-16A085?logo=lombok&logoColor=white) |
| [Springdoc OpenAPI](https://springdoc.org/) | Swagger UI for API documentation              | ![Swagger](https://img.shields.io/badge/Swagger_UI-85EA2D?logo=swagger&logoColor=black) |
| [JUnit](https://junit.org/) | Unit testing framework                        | ![JUnit](https://img.shields.io/badge/JUnit-25A162?logo=junit5&logoColor=white) |

---

## 📂 Project Structure

```
src/
  main/
    java/com/youssef_gamal/liquibase_demo/
      controllers/   # REST controllers
      dtos/          # Data Transfer Objects
      entities/      # JPA entities
      mappers/       # MapStruct mappers
      repos/         # Spring Data JPA repositories
      services/      # Business logic
    resources/
      application.yml        # Spring Boot config
      db/changelog/          # Liquibase changelogs
  test/
    java/com/youssef_gamal/liquibase_demo/
      LiquibaseDemoApplicationTests.java
```

---

## 🐳 Local Development with Docker Compose

Spin up a local PostgreSQL database using Docker Compose:

```bash
docker compose up -d
```

- Database: `mydatabase`
- User: `myuser`
- Password: `secret`
- Port: `5432`

---

## ⚙️ Configuration

Main configuration is in `src/main/resources/application.yml`:

- Database connection
- JPA & Hibernate settings
- Liquibase integration
- Swagger UI path

---

## 📝 Database Migrations

This project uses Liquibase for managing database migrations. The migration files are located in `src/main/resources/db/changelog/`.

- `db.changelog-master.yaml`: The master file that includes all changelog files.
- Other changelog files: For creating tables, altering schema, etc.

---

## 📖 API Documentation

- Interactive API docs available at:  
  [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

## 🧪 Running Tests

To run the unit tests, use the following command:

```bash
./mvnw test
```

JUnit will execute the tests in the `src/test/java/` directory.

---

## 📦 Getting Started

1. **Clone the repository:**
   ```bash
   git clone https://github.com/yourusername/liquibase-demo.git
   cd liquibase-demo
   ```

2. **Start PostgreSQL with Docker Compose:**
   ```bash
   docker compose up -d
   ```

3. **Run the application:**
   ```bash
   ./mvnw spring-boot:run
   ```

4. **Access the API docs:**  
   [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

## 📚 References

- [Spring Boot Documentation](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
- [Liquibase Documentation](https://www.liquibase.org/documentation/index.html)
- [PostgreSQL Documentation](https://www.postgresql.org/docs/)
- [Docker Documentation](https://docs.docker.com/)
