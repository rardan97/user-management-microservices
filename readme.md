# User Management Simple Microservices (Spring Boot + WebFlux + PostgreSQL)

This application implements a microservice architecture with **Direct Client-to-Service Communication**.

---

## Services Description

- **service-user**: Handles basic CRUD operations related to users, built with **Spring Boot WebFlux**
- **service-department**: Handles CRUD operations and management of department data.  
- **service-address**: Handles CRUD operations and management of address data.  

Each service is independent, self-contained, and can be developed, built, and deployed separately.

---

## Communication Model

**Direct Client-to-Service Communication**  
Clients (frontend apps or external consumers) communicate **directly** with each microservice via its own REST API.  
No API Gateway is used in this architecture to route or aggregate requests.

### Advantages
- Simplicity in architecture  
- Faster development in early-stage microservices  
- Each service exposes its own API independently  

---

## Dependencies

### Service-Department

- `spring-boot-starter-web`  
- `spring-boot-starter-data-jpa`  
- `postgresql`  
- `lombok`  

### Service-Address

- `spring-boot-starter-web`  
- `spring-boot-starter-data-jpa`  
- `postgresql`  
- `lombok`  

### Service-User

- `spring-boot-starter-webflux`  
- `spring-boot-starter-data-jpa`  
- `postgresql`  
- `lombok`  

---


## configuration

### address-service (application.yml)
```yaml
server:
  port: 8083

spring:
  application:
    name: address-service

  datasource:
    url: jdbc:postgresql://localhost:5432/db_micro_001_address
    username: postgres
    password: root
    driver-class-name: org.postgresql.Driver

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        format_sql: true
        dialect: org.hibernate.dialect.PostgreSQLDialect
```

### department-service (application.yml)
```yaml
server:
  port: 8082

spring:
  application:
    name: department-service

  datasource:
    url: jdbc:postgresql://localhost:5432/db_micro_001_department
    username: postgres
    password: root
    driver-class-name: org.postgresql.Driver

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        format_sql: true
        dialect: org.hibernate.dialect.PostgreSQLDialect
```

### user-service (application.yml)

```yaml
server:
  port: 8081

spring:
  application:
    name: user-service

  datasource:
    url: jdbc:postgresql://localhost:5432/db_micro_001_user
    username: postgres
    password: root
    driver-class-name: org.postgresql.Driver

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        format_sql: true
        dialect: org.hibernate.dialect.PostgreSQLDialect

service:
  department:
    url: http://localhost:8082
  address:
    url: http://localhost:8083

```

## API Endpoints

---

### Service: Address 

Base URL: `http://localhost:8083/api/address`

| Method | Endpoint                 | Description         |
|--------|--------------------------|---------------------|
| GET    | `/getAllAddress`         | Get all addresses   |
| GET    | `/getAddressById/{id}`   | Get address by ID   |
| POST   | `/addAddress`            | Create new address  |
| PUT    | `/updateAddress/{id}`    | Update address      |
| DELETE | `/deleteAddress/{id}`    | Delete address      |

---

### Service: Department 

Base URL: `http://localhost:8082/api/department`

| Method | Endpoint                    | Description          |
|--------|-----------------------------|----------------------|
| GET    | `/getAllDepartment`         | Get all departments  |
| GET    | `/getDepartmentById/{id}`   | Get department by ID |
| POST   | `/addDepartment`            | Create new department|
| PUT    | `/updateDepartment/{id}`    | Update department    |
| DELETE | `/deleteDepartment/{id}`    | Delete department    |

---


### Service: User

Base URL: `http://localhost:8081/api/user`

| Method | Endpoint              | Description      |
|--------|-----------------------|------------------|
| GET    | `/getAllUser`         | Get all users    |
| GET    | `/getUserById/{id}`   | Get user by ID   |
| POST   | `/addUser`            | Create new user  |
| PUT    | `/updateUser/{id}`    | Update user      |
| DELETE | `/deleteUser/{id}`    | Delete user      |

---
