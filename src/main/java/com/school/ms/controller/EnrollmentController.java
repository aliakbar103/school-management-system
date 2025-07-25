package com.school.ms.controller;

import com.school.ms.dto.EnrollmentDTO;
import com.school.ms.dto.EnrollmentResponseDTO;
import com.school.ms.mapper.EnrollmentMapper;
import com.school.ms.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")

public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    // 🔹 Get all enrollments
    @GetMapping
    public ResponseEntity<List<EnrollmentResponseDTO>> getAllEnrollments() {
        List<EnrollmentResponseDTO> enrollments = enrollmentService.getAllEnrollments();
        return ResponseEntity.ok(enrollments);
    }

    // 🔹 Get enrollments by student ID
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<EnrollmentResponseDTO>> getEnrollmentsByStudentId(@PathVariable Long studentId) {
        List<EnrollmentResponseDTO> enrollments = enrollmentService.getEnrollmentsByStudentId(studentId);
        return ResponseEntity.ok(enrollments);
    }

    // 🔹 Get enrollments by course ID
    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<EnrollmentResponseDTO>> getEnrollmentsByCourseId(@PathVariable Long courseId) {
        List<EnrollmentResponseDTO> enrollments = enrollmentService.getEnrollmentsByCourseId(courseId);
        return ResponseEntity.ok(enrollments);
    }

    // 🔹 Enroll a student in a course
    @PostMapping
    public ResponseEntity<?> enrollStudent(@RequestBody EnrollmentDTO enrollmentDTO) {
        try {
            enrollmentService.enrollStudent(enrollmentDTO);
            return ResponseEntity.ok("Student enrolled successfully.");
        } catch (RuntimeException ex) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Enrollment failed: " + ex.getMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateEnrollment(@RequestBody EnrollmentDTO enrollmentDTO) {
        try {
            EnrollmentDTO updatedEnrollment = EnrollmentMapper.entityToDto(enrollmentService.recordGrade(enrollmentDTO));
            return ResponseEntity.ok(updatedEnrollment);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while updating enrollment.");
        }
    }

    // 🔹 Delete an enrollment by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEnrollment(@PathVariable Long id) {
        try {
            enrollmentService.deleteEnrollment(id);
            return ResponseEntity.ok("Enrollment deleted successfully.");
        } catch (RuntimeException ex) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Deletion failed: " + ex.getMessage());
        }
    }

}
