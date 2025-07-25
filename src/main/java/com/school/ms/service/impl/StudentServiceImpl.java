package com.school.ms.service.impl;

import com.school.ms.dto.CourseDTO;
import com.school.ms.dto.StudentDTO;
import com.school.ms.dto.StudentWithEnrollmentsDTO;
import com.school.ms.entities.Enrollment;
import com.school.ms.entities.Student;
import com.school.ms.mapper.CourseMapper;
import com.school.ms.mapper.StudentMapper;
import com.school.ms.repositories.EnrollmentRepository;
import com.school.ms.repositories.StudentRepository;
import com.school.ms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll().stream().map(student -> StudentMapper.entityToDto(student)).collect(Collectors.toList());
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public StudentWithEnrollmentsDTO getStudentWithEnrollments(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        List<Enrollment> enrollments = enrollmentRepository.findByStudentId(id);

        List<CourseDTO> enrolledCourses = enrollments.stream()
                .map(enrollment -> CourseMapper.entityToDto(enrollment.getCourse()))
                .collect(Collectors.toList());

        StudentWithEnrollmentsDTO dto = new StudentWithEnrollmentsDTO();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setEmail(student.getEmail());
        dto.setDob(student.getDob());
        dto.setEnrolledCourses(enrolledCourses);

        return dto;
    }

    @Override
    public StudentDTO updateStudent(Long id, StudentDTO studentDTO) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        // Update fields
        existingStudent.setName(studentDTO.getName());
        existingStudent.setEmail(studentDTO.getEmail());
        existingStudent.setDob(studentDTO.getDob());
        existingStudent.setFathersName(studentDTO.getFathersName());

        // Save and return updated DTO
        Student updatedStudent = studentRepository.save(existingStudent);
        return StudentMapper.entityToDto(updatedStudent);
    }

}

