package com.school.ms.controller;

import com.school.ms.dto.CourseDTO;
import com.school.ms.dto.CourseWithStudentsDTO;
import com.school.ms.entities.Course;
import com.school.ms.mapper.CourseMapper;
import com.school.ms.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseDTO courseDTO) {
        Course savedCourse = courseService.saveCourse(CourseMapper.dtoToEntity(courseDTO));
        return ResponseEntity.status(201).body(CourseMapper.entityToDto(savedCourse));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> getCourse(@PathVariable Long id) {
        CourseDTO dto = CourseMapper.entityToDto(courseService.getCourseById(id));
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<CourseDTO>> getAllCourses() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @GetMapping("/{id}/with-students")
    public ResponseEntity<CourseWithStudentsDTO> getCourseWithStudents(@PathVariable Long id) {
        return ResponseEntity.ok(courseService.getCourseWithStudents(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseDTO> updateCourse(@PathVariable Long id, @RequestBody CourseDTO courseDTO) {
        return ResponseEntity.ok(courseService.updateCourse(id, courseDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }
}
