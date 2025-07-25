package com.school.ms.mapper;

import com.school.ms.dto.StudentDTO;
import com.school.ms.entities.Student;

public class StudentMapper {

    public static StudentDTO entityToDto(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setFathersName(student.getFathersName());
        dto.setEmail(student.getEmail());
        dto.setDob(student.getDob());
        return dto;
    }

    public static Student dtoToEntity(StudentDTO dto) {
        Student student = new Student();
        student.setId(dto.getId());
        student.setName(dto.getName());
        student.setFathersName(dto.getFathersName());
        student.setEmail(dto.getEmail());
        student.setDob(dto.getDob());
        return student;
    }

}
