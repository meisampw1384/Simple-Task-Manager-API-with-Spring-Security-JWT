# Simple Task Manager API with Spring Security & JWT

This project is a hands-on training exercise to build a secure RESTful API for a simple Task Management system using Spring Boot 3. It covers fundamental and advanced concepts of Spring Boot, focusing on building a robust, secure, and well-structured application from scratch.

The main goal of this project is to serve as a comprehensive, real-world example for personal learning, demonstrating best practices in API development and security.

---

## Features

- **Full CRUD Operations:** Create, Read, Update, and Delete tasks.
- **Stateless JWT Authentication:** Secure endpoints using JSON Web Tokens.
- **Role-Based Access Control (RBAC):** Differentiated access for `USER` and `ADMIN` roles.
- **User Registration & Login:** Endpoints for new user registration and authentication.
- **Centralized Exception Handling:** Graceful error handling for a better user experience.
- **Input Validation:** Server-side validation for incoming DTOs.
- **In-Memory Database:** Uses H2 Database for easy setup and testing.
- **Clean Architecture:** Follows a layered architecture (Controller, Service, Repository, DTO).

---

## Technologies & Concepts Covered

### Backend & Framework
- **Java 17**
- **Spring Boot 3.x**
- **Maven** for dependency management

### Core Concepts
- **Spring Core:** Dependency Injection (DI), Inversion of Control (IoC).
- **Spring Web:** Building RESTful APIs (`@RestController`, `@RequestMapping`, etc.).
- **Spring Data JPA:** Interacting with the database (`@Entity`, `JpaRepository`).
- **Spring Security 6:**
  - End-to-end security configuration.
  - JWT generation, validation, and filtering.
  - `UserDetailsService`, `AuthenticationManager`, `PasswordEncoder`.
  - Role-based authorization (`.hasAuthority()`).
- **Hibernate & H2 Database:** ORM and in-memory database.

### Tools & Libraries
- **Lombok:** To reduce boilerplate code.
- **jjwt (Java JWT):** For creating and parsing JWTs.
- **Hibernate Validator:** For request validation.

---

## API Endpoints

### Authentication

| Method | Endpoint                 | Description                         | Access      |
|--------|--------------------------|-------------------------------------|-------------|
| `POST` | `/api/auth/register`     | Registers a new user (`USER` or `ADMIN`). | Public      |
| `POST` | `/api/auth/authenticate` | Authenticates a user and returns a JWT. | Public      |

### Tasks

*All task endpoints require a valid JWT in the `Authorization: Bearer <token>` header.*

| Method    | Endpoint         | Description                         | Access                |
|-----------|------------------|-------------------------------------|-----------------------|
| `GET`     | `/api/tasks`     | Retrieves all tasks.                | `USER`, `ADMIN`       |
| `GET`     | `/api/tasks/{id}`| Retrieves a single task by its ID.  | `USER`, `ADMIN`       |
| `POST`    | `/api/tasks`     | Creates a new task.                 | `USER`, `ADMIN`       |
| `PUT`     | `/api/tasks/{id}`| Updates an existing task.           | `USER`, `ADMIN`       |
| `DELETE`  | `/api/tasks/{id}`| Deletes a task.                     | `ADMIN` only          |
