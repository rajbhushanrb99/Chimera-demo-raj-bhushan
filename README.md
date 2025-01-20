# Chimera-demo-raj-bhushan
# Student Course Management API

This is a simple Spring Boot application to manage student course enrollments, demonstrating the use of a **Many-to-Many** relationship with a `Student`, `Course`, and a `StudentCourseEnrollment` entity to store the enrollment date.

## Features

- **CRUD API** for `Student` and `Course`.
- **Many-to-Many Relationship** between `Student` and `Course`.
- Retrieve students who enrolled in courses **before** or **after** a specific date.

## Technologies Used

- **Spring Boot 3.x**
- **JPA** (for database interaction)
- **MySQL Database** (for persistence)
- **Java 17**

## Important Endpoints

### 1. Get Students Enrolled Before a Specific Date
- **URL**: `/api/v1/enrollment/students/enrolled-before`
- **Method**: `GET`
- **Request Param**: `date` (format: `yyyy-MM-dd`)

### 2. Get Students Enrolled After a Specific Date
- **URL**: `/api/v1/enrollment/students/enrolled-after`
- **Method**: `GET`
- **Request Param**: `date` (format: `yyyy-MM-dd`)

  ### 2. Enroll student in course along with date
- **URL**: `/api/v1/enrollment/{studentId}/enroll/{courseId}`
- **Method**: `POST`


