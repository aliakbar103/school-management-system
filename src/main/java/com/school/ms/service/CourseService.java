package com.school.ms.service;

import com.school.ms.dto.CourseDTO;
import com.school.ms.dto.CourseWithStudentsDTO;
import com.school.ms.entities.Course;

import java.util.List;

public interface CourseService {
     Course saveCourse(Course course);
     List<CourseDTO> getAllCourses();
     Course getCourseById(Long id);
     void deleteCourse(Long id);
     public CourseWithStudentsDTO getCourseWithStudents(Long id);
     CourseDTO updateCourse(Long id, CourseDTO courseDTO);

}
