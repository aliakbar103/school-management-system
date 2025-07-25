package com.school.ms.dto;

import java.util.List;

public class CourseWithStudentsDTO {
    private Long id;
    private String title;
    private String description;
    private Integer capacity;
    private List<StudentDTO> enrolledStudents;

    public CourseWithStudentsDTO() {
    }

    public CourseWithStudentsDTO(Long id, String title, String description, Integer capacity, List<StudentDTO> enrolledStudents) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.enrolledStudents = enrolledStudents;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public List<StudentDTO> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(List<StudentDTO> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    @Override
    public String toString() {
        return "CourseWithStudentsDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", capacity=" + capacity +
                ", enrolledStudents=" + enrolledStudents +
                '}';
    }
}
