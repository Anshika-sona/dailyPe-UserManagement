
```
# Spring Boot Application

## Overview
This is a Spring Boot application for managing users and managers. It provides RESTful endpoints to perform CRUD operations on users and retrieve users based on manager_id.

## Requirements
- Java 11
- Maven
- Spring Boot 2.5.3
- H2 Database (for development)

## Setup
1. Clone the repository:

```
git clone <repository-url>
```

2. Navigate to the project directory:

```
cd spring-boot-application
```

3. Build the project using Maven:

```
mvn clean install
```

4. Run the application:

```
mvn spring-boot:run
```

## Usage
Once the application is running, you can access the following endpoints:

1. `/api/create_user` - POST method to create a new user. Provide a JSON body with user details (full_name, mob_num, pan_num, manager_id).
2. `/api/get_users` - POST method to retrieve user records. You can pass mob_num, user_id, or manager_id in the request body to filter users.
3. `/api/delete_user` - POST method to delete a user. Provide either user_id or mob_num in the request body.
4. `/api/update_user` - POST method to update user details. Provide user_ids and update_data in the request body.

## Database
The application uses an H2 in-memory database for development. You can access the H2 console at `http://localhost:8080/h2-console` (default JDBC URL: `jdbc:h2:mem:testdb`). 

## Dependencies
- Spring Boot Starter Web
- Spring Boot Starter Data JPA
- H2 Database
- Spring Boot Starter Test

