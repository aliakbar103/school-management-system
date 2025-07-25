package com.school.ms.service.impl;


import com.school.ms.dto.CourseDTO;
import com.school.ms.dto.CourseWithStudentsDTO;
import com.school.ms.dto.StudentDTO;
import com.school.ms.entities.Course;
import com.school.ms.entities.Enrollment;
import com.school.ms.mapper.CourseMapper;
import com.school.ms.mapper.StudentMapper;
import com.school.ms.repositories.EnrollmentRepository;
import com.school.ms.service.CourseService;
import com.school.ms.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public List<CourseDTO> getAllCourses() {
        return courseRepository.findAll().stream().map(CourseMapper::entityToDto).collect(Collectors.toList());
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public CourseWithStudentsDTO getCourseWithStudents(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        List<Enrollment> enrollments = enrollmentRepository.findByCourseId(id);

        List<StudentDTO> enrolledStudents = enrollments.stream()
                .map(enrollment -> StudentMapper.entityToDto(enrollment.getStudent()))
                .collect(Collectors.toList());

        CourseWithStudentsDTO dto = new CourseWithStudentsDTO();
        dto.setId(course.getId());
        dto.setTitle(course.getTitle());
        dto.setEnrolledStudents(enrolledStudents);

        return dto;
    }

    @Override
    public CourseDTO updateCourse(Long id, CourseDTO courseDTO) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        course.setTitle(courseDTO.getTitle());
        course.setCapacity(courseDTO.getCapacity());
        course.setDescription(courseDTO.getDescription());

        Course updatedCourse = courseRepository.save(course);
        return CourseMapper.entityToDto(updatedCourse);
    }


}

