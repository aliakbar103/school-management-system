package com.school.ms.service;

import com.school.ms.dto.EnrollmentDTO;
import com.school.ms.dto.EnrollmentResponseDTO;
import com.school.ms.entities.Enrollment;

import java.util.List;

public interface EnrollmentService {
    EnrollmentDTO enrollStudent(EnrollmentDTO dto);
    List<EnrollmentResponseDTO> getAllEnrollments();
    List<EnrollmentResponseDTO> getEnrollmentsByStudentId(Long studentId);
    List<EnrollmentResponseDTO> getEnrollmentsByCourseId(Long courseId);
    void deleteEnrollment(Long id);
    public Enrollment recordGrade(EnrollmentDTO enrollmentDTO);

}
