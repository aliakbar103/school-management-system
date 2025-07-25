package com.school.ms.mapper;

import com.school.ms.dto.EnrollmentDTO;
import com.school.ms.dto.EnrollmentResponseDTO;
import com.school.ms.entities.Course;
import com.school.ms.entities.Enrollment;
import com.school.ms.entities.Student;

public class EnrollmentMapper {

    public static EnrollmentDTO entityToDto(Enrollment enrollment) {
        EnrollmentDTO dto = new EnrollmentDTO();
        dto.setId(enrollment.getId());
        dto.setMarks(enrollment.getMarks());
        dto.setGrade(enrollment.getGrade());
        dto.setStudentId(enrollment.getStudent().getId());
        dto.setCourseId(enrollment.getCourse().getId());
        dto.setEnrollmentDate(enrollment.getEnrollmentDate());
        return dto;
    }

    public static EnrollmentResponseDTO entityToResponseDto(Enrollment enrollment) {
        EnrollmentResponseDTO dto = new EnrollmentResponseDTO();
        dto.setId(enrollment.getId());
        dto.setMarks(enrollment.getMarks());
        dto.setGrade(enrollment.getGrade());
        dto.setStudent(StudentMapper.entityToDto(enrollment.getStudent()));
        dto.setCourse(CourseMapper.entityToDto(enrollment.getCourse()));
        dto.setEnrollmentDate(enrollment.getEnrollmentDate());
        return dto;
    }

    public static Enrollment dtoToEntity(EnrollmentDTO dto, Student student, Course course) {
        Enrollment enrollment = new Enrollment();
        enrollment.setId(dto.getId());
        enrollment.setMarks(dto.getMarks());
        enrollment.setGrade(dto.getGrade());
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        enrollment.setEnrollmentDate(dto.getEnrollmentDate());
        return enrollment;
    }
}
