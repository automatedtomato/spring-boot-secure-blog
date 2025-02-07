# Spring Boot Secure Blog

A secure blog platform built with Spring Boot, following the DevTiro Builder Blog Platform tutorial series. 
This project demonstrates fundamental Spring Boot concepts, security implementations, and testing practices.

## Features

- User authentication and authorization
- Post creation and management
- Data persistence with JPA
- RESTful API endpoints
- Security implementation with Spring Security

## Technologies

- Java 17
- Spring Boot
- Spring Security
- Spring Data JPA
- H2 Database (for development)
- Maven for dependency management

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── devtiro/
│   │           ├── controllers/    # REST controllers
│   │           ├── domain/         # Entity classes
│   │           ├── repositories/   # JPA repositories
│   │           ├── services/       # Business logic
│   │           └── security/       # Security config
│   └── resources/
│       └── application.properties  # App configuration
└── test/
    └── java/                      # Test classes
```

## Prerequisites

- JDK 17 or later
- Maven 3.8+
- Your favorite IDE (IntelliJ IDEA recommended)

## Getting Started

1. Clone the repository:
```bash
git clone https://github.com/automatedtomato/spring-boot-secure-blog.git
cd spring-boot-secure-blog
```

2. Build the project:
```bash
mvn clean install
```

3. Run the application:
```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## API Endpoints

### Posts
- `GET /posts` - Get all posts
- `GET /posts/{id}` - Get a specific post
- `POST /posts` - Create a new post
- `PUT /posts/{id}` - Update a post
- `DELETE /posts/{id}` - Delete a post

### Comments
- `GET /posts/{postId}/comments` - Get comments for a post
- `POST /posts/{postId}/comments` - Add a comment to a post
- `DELETE /posts/{postId}/comments/{commentId}` - Delete a comment

## Security

The application implements security using Spring Security with:
- Basic authentication
- Role-based access control
- Password encoding with BCrypt
- Secured endpoints

## Configuration

The main application configuration is in `application.properties`:

```properties
# Server configuration
server.port=8080

# H2 Database configuration
spring.datasource.url=jdbc:h2:mem:blogdb
spring.datasource.driverClassName=org.h2.Driver
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

# JPA/Hibernate configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## Acknowledgments

- [DevTiro Builder Blog Platform Tutorial Series](https://community.devtiro.com/c/builder-blog-platform/)
- Spring Boot and Spring Security documentation
- Java community best practices
