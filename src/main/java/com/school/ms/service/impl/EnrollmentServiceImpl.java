package com.school.ms.service.impl;


import com.school.ms.dto.EnrollmentDTO;
import com.school.ms.dto.EnrollmentResponseDTO;
import com.school.ms.entities.Course;
import com.school.ms.entities.Enrollment;
import com.school.ms.entities.Student;
import com.school.ms.mapper.EnrollmentMapper;
import com.school.ms.repositories.CourseRepository;
import com.school.ms.repositories.EnrollmentRepository;
import com.school.ms.repositories.StudentRepository;
import com.school.ms.service.EnrollmentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;



    @Override
    public List<EnrollmentResponseDTO> getAllEnrollments() {
        List<Enrollment> enrollments = enrollmentRepository.findAll();
        return enrollments.stream()
                .map(EnrollmentMapper::entityToResponseDto)
                .collect(Collectors.toList());
    }


    @Override
    public List<EnrollmentResponseDTO> getEnrollmentsByStudentId(Long studentId) {
        List<Enrollment> enrollments = enrollmentRepository.findByStudentId(studentId);
        return enrollments.stream()
                .map(EnrollmentMapper::entityToResponseDto)
                .collect(Collectors.toList());
    }


    @Override
    public List<EnrollmentResponseDTO> getEnrollmentsByCourseId(Long courseId) {
        List<Enrollment> enrollments = enrollmentRepository.findByCourseId(courseId);
        return enrollments.stream()
                .map(EnrollmentMapper::entityToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteEnrollment(Long id) {
        if (!enrollmentRepository.existsById(id)) {
            throw new RuntimeException("Enrollment not found with ID: " + id);
        }
        enrollmentRepository.deleteById(id);
    }

    // Enroll a student in a course
    @Transactional
    @Override
    public EnrollmentDTO enrollStudent(EnrollmentDTO dto) {
        Long studentId = dto.getStudentId();
        Long courseId = dto.getCourseId();

        if (Boolean.FALSE.equals(dto.getPreRequisiteDone())) {
            throw new RuntimeException("Prerequisite course not completed.");
        }

        if (enrollmentRepository.existsByStudentIdAndCourseId(studentId, courseId)) {
            throw new RuntimeException("Student already enrolled in this course.");
        }

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found."));
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found."));

        if (course.getEnrollments().size() >= course.getCapacity()) {
            throw new RuntimeException("Course is already full.");
        }

        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);

        Enrollment saved = enrollmentRepository.save(enrollment);
        return EnrollmentMapper.entityToDto(saved);
    }

    // Record grade for an enrolled course
    @Transactional
    public String recordGrade(Long studentId, Long courseId, String grade,Double marks) {
        Enrollment enrollment = enrollmentRepository
                .findByStudentIdAndCourseId(studentId, courseId)
                .orElse(null);

        if (enrollment == null) {
            return "Student is not enrolled in the course.";
        }

        enrollment.setGrade(grade);
        enrollment.setMarks(marks);
        enrollmentRepository.save(enrollment);
        return "Grade recorded successfully.";
    }

    // Calculate GPA for a student
    public double calculateGPA(Long studentId) {
        List<Enrollment> enrollments = enrollmentRepository.findByStudentId(studentId);
        double total = 0;
        int count = 0;

        for (Enrollment e : enrollments) {
            if (e.getMarks() != null) {
                total += e.getMarks();
                count++;
            }
        }

        return count == 0 ? 0.0 : total / count;
    }


}
