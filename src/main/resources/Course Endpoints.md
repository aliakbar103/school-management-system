# 📚 School Management System - API Endpoints

🔸 COURSE API
➕ Add Course
POST /api/courses

Request Body:
{
"title": "Mathematics",
"description": "Basic Math Course",
"capacity": 30
}
📋 Get All Courses
GET /api/courses

🔍 Get Course By ID
GET /api/courses/{id}

📋 Get Course With Enrolled Students
GET /api/courses/{id}/with-students

✏️ Update Course
PUT /api/courses/{id}

Request Body:
{
"title": "Advanced Java",
"description": "Java for Engineers",
"capacity": 50
}
❌ Delete Course
DELETE /api/courses/{id}
