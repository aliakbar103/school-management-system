package com.school.ms.mapper;

import com.school.ms.dto.CourseDTO;
import com.school.ms.entities.Course;

public class CourseMapper {
    public static CourseDTO entityToDto(Course course) {
        CourseDTO dto = new CourseDTO();
        dto.setId(course.getId());
        dto.setTitle(course.getTitle());
        dto.setDescription(course.getDescription());
        dto.setCapacity(course.getCapacity());
        return dto;
    }

    public static Course dtoToEntity(CourseDTO dto) {
        Course course = new Course();
        course.setId(dto.getId());
        course.setTitle(dto.getTitle());
        course.setDescription(dto.getDescription());
        course.setCapacity(dto.getCapacity());
        return course;
    }

}
