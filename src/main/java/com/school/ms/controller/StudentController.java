package com.school.ms.controller;

import com.school.ms.dto.StudentDTO;
import com.school.ms.dto.StudentWithEnrollmentsDTO;
import com.school.ms.mapper.StudentMapper;
import com.school.ms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentDTO studentDTO) {
        StudentDTO savedStudent = StudentMapper.entityToDto(
                studentService.saveStudent(StudentMapper.dtoToEntity(studentDTO)));

        return ResponseEntity
                .created(URI.create("/api/students/" + savedStudent.getId())) // 201 Created
                .body(savedStudent);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudent(@PathVariable Long id) {
        StudentDTO student = StudentMapper.entityToDto(studentService.getStudentById(id));
        return ResponseEntity.ok(student); // 200 OK
    }

    @GetMapping("/{id}/with-enrollments")
    public ResponseEntity<StudentWithEnrollmentsDTO> getStudentWithEnrollments(@PathVariable Long id) {
        StudentWithEnrollmentsDTO dto = studentService.getStudentWithEnrollments(id);
        return ResponseEntity.ok(dto); // 200 OK
    }

    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        List<StudentDTO> students = studentService.getAllStudents();
        return ResponseEntity.ok(students); // 200 OK
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable Long id, @RequestBody StudentDTO studentDTO) {
        StudentDTO updated = studentService.updateStudent(id, studentDTO);
        return ResponseEntity.ok(updated); // 200 OK
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }
}
