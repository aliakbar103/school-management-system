# 📚 School Management System - API Endpoints

---

## 🔹 STUDENT API

### ➕ Add Student
- **POST** `/api/students`
#### Request Body:
```json
{
  "name": "Ali",
  "fathersName": "Akbar",
  "email": "ali@example.com",
  "dob": "2000-01-01"
}

📋 Get All Students
GET /api/students

🔍 Get Student By ID
GET /api/students/{id}

🔍 Get Student By ID With Its Enrolled Courses
GET /api/students/{id}/with-enrollments


✏️ Update Student
PUT /api/students/{id}

Request Body: 
{
  "name": "Ali Akbar",
  "fathersName": "Muhammad Afzal",
  "email": "aliakbar@example.com",
  "dob": "2000-01-01"
}


❌ Delete Student
DELETE /api/students/{id}



