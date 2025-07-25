# 📚 School Management System - API Endpoints

🔹 ENROLLMENT API
➕ Enroll Student
POST /api/enrollments

Request Body:
{
"studentId": 1,
"courseId": 2,
"enrollmentDate": "2025-07-24",
"grade": null,
"marks": null,
"preRequisiteDone": true
}
✅ / ❌ Conditions & Validations
✅ If all fields are valid and conditions pass, enrollment is created successfully.

❌ If preRequisiteDone is false, enrollment will fail with message: "Pre-requisites not completed."

❌ If student is already enrolled in the course, enrollment will fail with message: "Student already enrolled in this course."

❌ If course capacity is full, enrollment will fail with message: "Course capacity is full."

❌ If studentId does not exist, enrollment will fail with message: "Student not found."

❌ If courseId does not exist, enrollment will fail with message: "Course not found."



📋 Get All Enrollments
GET /api/enrollments

Sample Response:
[
{
"id": 1,
"student": {
"id": 1,
"name": "Ali"
},
"course": {
"id": 2,
"title": "Mathematics"
},
"enrollmentDate": "2025-07-24",
"grade": null,
"marks": null
}
]
🔍 Get Enrollment By ID
GET /api/enrollments/{id}

✏️ Update Enrollment
PUT /api/enrollments/{id}

Request Body:
{
"studentId": 1,
"courseId": 2,
"enrollmentDate": "2025-07-25",
"grade": "A",
"marks": 85.5,
}

❌ Delete Enrollment
DELETE /api/enrollments/{id}
