package com.school.ms.service;

import com.school.ms.dto.StudentDTO;
import com.school.ms.dto.StudentWithEnrollmentsDTO;
import com.school.ms.entities.Student;

import java.util.List;

public interface StudentService {


    public Student saveStudent(Student student);
    public List<StudentDTO> getAllStudents();
    public Student getStudentById(Long id);
    public void deleteStudent(Long id);
    StudentDTO updateStudent(Long id, StudentDTO studentDTO);
    StudentWithEnrollmentsDTO getStudentWithEnrollments(Long id);
}
