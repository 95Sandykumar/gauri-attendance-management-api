# Attendance Management API

## Overview
A RESTful API for managing student attendance records, built with Spring Boot.
Supports real-time updates via WebSocket and secure access through JWT authentication.

## Author
Gauri Sharma

## Features
- JWT Authentication for secure API access
- WebSocket support for real-time attendance updates
- Student, Section, Grade Level, and RFID credential management
- Attendance statistics and reporting endpoints

## Tech Stack
- Java 21
- Spring Boot 3.3.4
- PostgreSQL
- WebSocket
- JWT (JSON Web Tokens)
- Caffeine Cache
- Gradle

## Getting Started

### Prerequisites
- Java 21+
- PostgreSQL database

### Configuration
Set these environment variables:
```
DB_HOST=localhost
DB_PORT=5432
DB_NAME=attendance_db
DB_USERNAME=postgres
DB_PASSWORD=yourpassword
JWT_SECRET=your_jwt_secret_here
```

### Run
```bash
./gradlew bootRun
```

### API Documentation
After running, visit: `http://localhost:8080/swagger-ui.html`
