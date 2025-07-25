# Student Course Enrollment System (Spring Boot)

This is a simple CRUD-based Student Course Enrollment system built using Spring Boot.

## Features

- Manage Students (Create, Read, Update, Delete)
- Manage Courses
- Enroll Students in Courses
- View Enrollments with Student & Course details

## Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA (Hibernate)
- SQL SERVER DataBase
- Maven

## How to Run

1. Clone or download ZIP
2. Configure DB in `application.properties`
3. Create SMS_DB 
4. Run SQL scripts:
- [`schema.sql`](src/main/resources/schema.sql)
- [`data.sql`](src/main/resources/data.sql)

3. Run `StudentCourseApplication.java` as Spring Boot app
4. Visit Postman to test

## API Endpoints

See 
-[`src/main/resources/Student Endpoints.md`]
-[`src/main/resources/Course Endpoints.md`]
-[`src/main/resources/Enrollment Endpoints.md`]


