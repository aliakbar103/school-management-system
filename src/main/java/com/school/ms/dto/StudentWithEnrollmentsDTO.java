package com.school.ms.dto;

import java.time.LocalDate;
import java.util.List;

public class StudentWithEnrollmentsDTO {
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    private List<CourseDTO> enrolledCourses;

    public StudentWithEnrollmentsDTO() {
    }

    public StudentWithEnrollmentsDTO(Long id, String name, String email, LocalDate dob, List<CourseDTO> enrolledCourses) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.enrolledCourses = enrolledCourses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public List<CourseDTO> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(List<CourseDTO> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    @Override
    public String toString() {
        return "StudentWithEnrollmentsDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dob +
                ", enrolledCourses=" + enrolledCourses +
                '}';
    }
}